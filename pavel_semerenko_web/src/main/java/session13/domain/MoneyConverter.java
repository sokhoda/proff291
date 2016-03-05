package session13.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Pavel on 14.02.2016.
 */
@Converter
public class MoneyConverter implements AttributeConverter<Double, String>{
    @Override
    public String convertToDatabaseColumn(Double o) {
        return o.toString();
    }

    @Override
    public Double convertToEntityAttribute(String o) {
        return Double.parseDouble(o);
    }
}
