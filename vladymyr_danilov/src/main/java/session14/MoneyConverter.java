package session14;

import javax.persistence.AttributeConverter;

public class MoneyConverter implements AttributeConverter<Long, String> {

    @Override
    public String convertToDatabaseColumn(Long aLong) {
        return String.valueOf(aLong);
    }

    @Override
    public Long convertToEntityAttribute(String s) {
        return Long.parseLong(s);
    }
}
