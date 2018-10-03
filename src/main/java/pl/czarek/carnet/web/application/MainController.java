package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.czarek.carnet.business.service.CarDealerService;

@Controller
public class MainController {
    @Autowired
    private CarDealerService carDealerService;

    @RequestMapping(value = {"/home", "/homepage"})
    public String goToHomePage() {
        return "redirect:/";
    }

    @RequestMapping(value = "/main")
    public String goToMainPage(Model model) {
        model.addAttribute("listOfCarDealer", carDealerService.getCarDealers());
        return "main";
    }
}