package pl.czarek.carnet.contraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNoneValidator implements ConstraintValidator<NotNone, String> {
    @Override
    public void initialize(NotNone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !value.equals("none");
    }
}
