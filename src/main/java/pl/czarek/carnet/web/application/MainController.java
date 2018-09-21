package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.czarek.carnet.business.domain.CarPost;
import pl.czarek.carnet.business.domain.ShortInfoCarDealer;
import pl.czarek.carnet.business.domain.SmallInfoCar;
import pl.czarek.carnet.business.service.CarDealerService;
import pl.czarek.carnet.business.service.CarPostService;
import pl.czarek.carnet.business.service.CarService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class MainController {
    @Autowired
    private CarDealerService carDealerService;
    @Autowired
    private CarService carService;
    @Autowired
    private CarPostService carPostService;

    @RequestMapping(value = {"/home", "/homepage"})
    public String goToHomePage() {
        return "redirect:/";
    }

    @RequestMapping(value = "/main")
    public String goToMainPage(Model model) {
        model.addAttribute("shortInfoCarDealers", carDealerService.getShortenInfoAboutCarDealers());
        model.addAttribute("messageAddition", null);
        return "main";
    }

    @RequestMapping(value = "/quickFind")
    public String getCars(@RequestParam(value = "carMake", required = false) String carMake,
                          @RequestParam(value = "carModel", required = false) String carModel,
                          Model model) {
        model.addAttribute("cars", carService.getSmallInfoCars(carMake, carModel));
        model.addAttribute("makes", carService.getAllMakes());
        model.addAttribute("models", carService.getAllModelInMake(carMake));
        return "quickFind";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String addCar(Model model) {
        if (!model.containsAttribute("carPost")) {
            model.addAttribute("carPost", new CarPost());
        }

        model.addAttribute("carDealers", carDealerService.getShortenInfoAboutCarDealers());

        return "addCar";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String processAddCar(@ModelAttribute(value = "carPost") @Valid CarPost carPost,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carPost", carPost);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.carPost",
                    bindingResult);
            return "redirect:/addCar";
        } else {
            carPostService.saveCar(carPost);
        }

        return "redirect:/main";
    }
}
