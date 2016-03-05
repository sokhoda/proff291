package session14;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MoneyConverter implements AttributeConverter<Long, String> {

    @Override
    public String convertToDatabaseColumn(Long o) {
        return Long.toString(o);
    }

    @Override
    public Long convertToEntityAttribute(String o) {

        return new Long(o);
    }
}
