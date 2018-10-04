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

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        if(imageFile.isEmpty()) {
            redirectAttributes.addFlashAttribute("message",
                    "Proszę wybrać zdjęcie samochodu");
            System.out.println("brak wybranego zdjęcia");
            return "redirect:/car/" + carId;
        }

        if(!imageFile.getOriginalFilename().endsWith(".jpg")) {
            redirectAttributes.addFlashAttribute("message",
                    "Plik musi mieć rozszerzenie .jpg");
            System.out.println("złe rozszerzenie: " + imageFile.getOriginalFilename());
            return "redirect:/car/" + carId;
        }
        //Zrobić walidację, aby przyjmować tylko pliki .jpg i o formacie 1920x1080, nie większe niż 2MB

        try {
            BufferedImage image = ImageIO.read(imageFile.getInputStream());

            if(image.getHeight() != 1080 || image.getWidth() != 1920) {
                redirectAttributes.addFlashAttribute("message",
                        "Zdjęcie musi być wymiarów 1920x1080");
                System.out.println("złe wymiary");
                return "redirect:/car/" + carId;
            }

            byte[] bytes = imageFile.getBytes();
            String pathToUploadedImage = System.getProperty("user.dir") +
                    "/out/production/resources/static/img/cars/" + carId;
            File newDirectory = new File(pathToUploadedImage);

            String pathToImage = pathToUploadedImage + "/car-main.jpg";

            if(!newDirectory.mkdir()) {
                new File(pathToImage).delete();
                System.out.println("Podmiana zdjęcia");
            }

            //Musi usuwać cache!

            Path path = Paths.get(pathToImage);
            Files.write(path, bytes);

            carPostService.updateImageCar(carId, "/img/cars/" + carId + "/car-main.jpg");

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + imageFile.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/car/" + carId;
    }

}
