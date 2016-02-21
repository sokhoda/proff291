package session13.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;

/**
 * Created by Юлия on 14.02.2016.
 */
@Converter
public class MoneyConvertor implements AttributeConverter<Long, String> {


    @Override
    public String convertToDatabaseColumn(Long aLong) {
        String str = Long.toString(aLong);
        return str;
    }

    @Override
    public Long convertToEntityAttribute(String s) {
        Long i = Long.valueOf(s);
        return i;
    }


}
