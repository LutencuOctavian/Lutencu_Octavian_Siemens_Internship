package dom.com.lutencu_octavian_siemens_internship.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<RangeOneMeterAndTwelveKm, Double> {
    private static final double MAX_RANGE = 12.7D;
    private static final double MIN_RANGE = 0.001D;
    private static final double EPSILON =0.0001D;
    @Override
    public boolean isValid(Double radius, ConstraintValidatorContext constraintValidatorContext) {

        return (radius-MIN_RANGE) > EPSILON &&
                (MAX_RANGE - radius) > EPSILON;
    }
}
