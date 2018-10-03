package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.czarek.carnet.business.domain.CarPost;
import pl.czarek.carnet.business.service.CarDealerService;
import pl.czarek.carnet.business.service.CarPostService;

import javax.validation.Valid;

@Controller
public class AddCarController {
    @Autowired
    private CarDealerService carDealerService;
    @Autowired
    private CarPostService carPostService;

    @RequestMapping(value = "/addCar", method = RequestMethod.GET)
    public String addCar(Model model) {
        if (!model.containsAttribute("carPost")) {
            model.addAttribute("carPost", new CarPost());
        }

        model.addAttribute("carDealers", carDealerService.getCarDealers());

        return "addCar";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String processAddCar(@ModelAttribute(value = "carPost") @Valid CarPost carPost,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        long carId = 0;

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carPost", carPost);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.carPost",
                    bindingResult);
            return "redirect:/addCar";
        } else {
            carId = carPostService.saveCar(carPost);
        }

        return "redirect:/car/" + carId;
    }
}
