package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.czarek.carnet.business.service.CarService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(value = "/car")
public class CarController {
//    private static String UPLOAD_DIRECTORY = "C://img//";
// tak działa!
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/{carId}")
    public String getCarInfo(@PathVariable(value = "carId") Long carId, Model model) {
        model.addAttribute("car", carService.getCar(carId));
        return "carDetails";
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.POST)
    public String singleImageUpload(@PathVariable(value = "carId") Long carId,
                                    @RequestParam("imageFile") MultipartFile imageFile,
                                    RedirectAttributes redirectAttributes) {
        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message",
                    "Please select an image to upload");
            return "redirect:/car/" + carId;
        }

        try {
            byte[] bytes = imageFile.getBytes();
            Path path = Paths.get(UPLOAD_DIRECTORY + imageFile.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + imageFile.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/car/" + carId;
    }

}
