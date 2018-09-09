package pl.czarek.carnet.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.czarek.carnet.business.service.CarDealerService;
import pl.czarek.carnet.data.repository.CarRepository;

@Controller
@RequestMapping(value = "/cardealers")
public class CarDealersController {
    @Autowired
    private CarDealerService carDealerService;
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/{id}")
    public String getCarDealer(@PathVariable(value = "id") Long carDealerId, Model model) {
        model.addAttribute("carDealer",
                carDealerService.getShortenInfoAboutCarDealer(carDealerId));
        model.addAttribute("cars", carDealerService.getCarsBelongingToShortInfoCarDealer(carDealerId));
        return "carDealer";
    }

    @RequestMapping(value = "/{id}/cars/{carId}")
    public String getCar(@PathVariable(value = "carId") Long carId, Model model) {
        model.addAttribute("car", carRepository.findByCarId(carId));
        return "carDetails";
    }
}
