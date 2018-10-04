package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.czarek.carnet.business.service.CarGetService;

@Controller
public class QuickFindController {
    @Autowired
    private CarGetService carGetService;

    @RequestMapping(value = "/quickFind")
    public String getCars(@RequestParam(value = "carMake", required = false) String carMake,
                          @RequestParam(value = "carModel", required = false) String carModel,
                          Model model) {
        model.addAttribute("cars", carGetService.getCarsByMakeOrModel(carMake, carModel));
        model.addAttribute("makes", carGetService.getAllMakes());
        model.addAttribute("models", carGetService.getAllModelInMake(carMake));
        return "quickFind";
    }
}
