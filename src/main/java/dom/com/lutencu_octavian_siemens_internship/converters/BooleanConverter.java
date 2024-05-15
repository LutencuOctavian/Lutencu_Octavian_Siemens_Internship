package dom.com.lutencu_octavian_siemens_internship.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "true" : "false";
    }

    @Override
    public Boolean convertToEntityAttribute(String stringBoolean) {
        return "true".equals(stringBoolean);
    }
}
