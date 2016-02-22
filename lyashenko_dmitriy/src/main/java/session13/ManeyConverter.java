package session13;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Solyk on 14.02.2016.
 */
@Converter
public class ManeyConverter implements AttributeConverter<Double, String> {

    @Override
    public String convertToDatabaseColumn(Double aDouble) {
                return String.valueOf(aDouble);
    }

    @Override
    public Double convertToEntityAttribute(String s) {
                return Double.valueOf(s);
    }


}
