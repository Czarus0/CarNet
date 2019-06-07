package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.czarek.carnet.business.domain.CarDealerPost;
import pl.czarek.carnet.business.service.CarDealerPostService;
import pl.czarek.carnet.data.entity.CarDealer;

import javax.validation.Valid;

@Controller
public class AddCarDealerController {
    @Autowired
    private CarDealerPostService carDealerPostService;

    @RequestMapping(value = "/addCarDealer", method = RequestMethod.GET)
    public String addCarDealer(Model model) {
        if (!model.containsAttribute("carDealerPost")) {
            model.addAttribute("carDealerPost", new CarDealerPost());
        }

        return "addCarDealer";
    }

    @RequestMapping(value = "/addCarDealer", method = RequestMethod.POST)
    public String processAddCarDealer(@ModelAttribute(value = "carDealerPost") @Valid CarDealerPost carDealerPost,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        long carDealarId = 0;

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carDealerPost", carDealerPost);
            redirectAttributes.
                    addFlashAttribute("org.springframework.validation.BindingResult.carDealerPost",
                    bindingResult);
            return "redirect:/addCarDealer";
        } else {
            carDealarId = carDealerPostService.saveCarDealer(carDealerPost);
        }

        return "redirect:/cardealers/" + carDealarId;
    }
}
