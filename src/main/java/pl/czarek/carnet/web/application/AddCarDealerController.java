package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.czarek.carnet.business.domain.CarPost;
import pl.czarek.carnet.business.service.CarDealerGetService;
import pl.czarek.carnet.business.service.CarPostService;

import javax.validation.Valid;

public class AddCarDealerController {
    @Autowired
    private CarDealerGetService carDealerGetService;
    @Autowired
    private CarPostService carPostService;

    @RequestMapping(value = "/addCarDealer", method = RequestMethod.GET)
    public String addCarDealer(Model model) {
        if (!model.containsAttribute("carDealerPost")) {
            model.addAttribute("carDealerPost", new CarPost());
        }

        model.addAttribute("carDealers", carDealerGetService.getCarDealers());

        return "addCar";
    }

    @RequestMapping(value = "/addCarDealer", method = RequestMethod.POST)
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
