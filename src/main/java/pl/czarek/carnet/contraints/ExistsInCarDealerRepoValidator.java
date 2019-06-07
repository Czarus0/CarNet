package pl.czarek.carnet.contraints;

import org.springframework.beans.factory.annotation.Autowired;
import pl.czarek.carnet.business.service.CarDealerPostService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsInCarDealerRepoValidator implements ConstraintValidator<ExistsInCarDealerRepo, String> {
    @Autowired
    CarDealerPostService carDealerPostService;

    @Override
    public void initialize(ExistsInCarDealerRepo constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return carDealerPostService.getCarDealerByNameOfFirm(value) == null;
    }
}
