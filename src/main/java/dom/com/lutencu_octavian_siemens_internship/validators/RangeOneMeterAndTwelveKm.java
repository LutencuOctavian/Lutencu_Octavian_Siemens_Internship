package dom.com.lutencu_octavian_siemens_internship.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = RangeValidator.class)
@Documented
public @interface RangeOneMeterAndTwelveKm {
    String message() default "{radius.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
