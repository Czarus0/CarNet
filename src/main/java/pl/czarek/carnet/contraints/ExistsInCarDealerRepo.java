package pl.czarek.carnet.contraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNoneValidator.class)
public @interface ExistsInRepo {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Nie może być wartość \'none\'";
}
