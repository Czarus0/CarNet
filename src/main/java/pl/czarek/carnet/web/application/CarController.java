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
import pl.czarek.carnet.business.service.CarGetService;
import pl.czarek.carnet.business.service.CarPostService;
import pl.czarek.carnet.tools.ImageSaver;
import pl.czarek.carnet.tools.ImageValidation;

@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private CarGetService carGetService;
    @Autowired
    private CarPostService carPostService;

    @RequestMapping(value = "/{carId}")
    public String getCarInfo(@PathVariable(value = "carId") Long carId, Model model) {
        model.addAttribute("car", carGetService.getCar(carId));
        return "carDetails";
    }

    @RequestMapping(value = "/{carId}", method = RequestMethod.POST)
    public String singleImageUpload(@PathVariable(value = "carId") Long carId,
                                    @RequestParam("imageFile") MultipartFile imageFile,
                                    RedirectAttributes redirectAttributes) {
        ImageValidation imageValidation = new ImageValidation(imageFile);
        ImageSaver saver = new ImageSaver(imageFile);

        if(!imageValidation.validImage()) {
            redirectAttributes.addFlashAttribute("message", imageValidation.getMessage());
            return "redirect:/car/" + carId;
        } else {
            if(!saver.writeFile(carId)) {
                redirectAttributes.addFlashAttribute("message", imageValidation.getMessage());
                return "redirect:/car/" + carId;
            }
        }

        String newCarImage = saver.getNewNameOfFile();
        carPostService.updateImageCar(carId, "/img/cars/" + carId + "/" + newCarImage);

        redirectAttributes.addFlashAttribute("message",
                "Udało się wgrać nowe zdjęcie Twojego samochodu");

        return "redirect:/car/" + carId;
    }
}
