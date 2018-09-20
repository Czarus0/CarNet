package pl.czarek.carnet.contraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankLongValidator implements ConstraintValidator<NotBlankLong, Long> {
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return !value.getClass().toString().equals(String.class.toString());
    }

    @Override
    public void initialize(NotBlankLong constraintAnnotation) {

    }
}
