package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.czarek.carnet.business.service.CarDealerService;
import pl.czarek.carnet.business.service.CarService;

@Controller
public class MainController {
    @Autowired
    private CarDealerService carDealerService;
    @Autowired
    private CarService carService;

    @RequestMapping(value = {"/home", "/homepage"})
    public String goToHomePage() {
        return "redirect:/";
    }

    @RequestMapping(value = "/main")
    public String goToMainPage(Model model) {
        model.addAttribute("shortInfoCarDealers", carDealerService.getShortenInfoAboutCarDealers());
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
    public String addCar() {
        return "addCar";
    }
}
