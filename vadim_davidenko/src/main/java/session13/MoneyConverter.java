package session13;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Вадим on 14.02.2016.
 */

@Converter
public class MoneyConverter implements AttributeConverter<Double, String> {

    @Override
    public String convertToDatabaseColumn(Double o) {
        if (o != null) {
            return String.valueOf(o);
        }
        return null;
    }

    @Override
    public Double convertToEntityAttribute(String o) {
        if (o != null ) {
            return Double.valueOf(o);
        }
        return null;
    }

}
