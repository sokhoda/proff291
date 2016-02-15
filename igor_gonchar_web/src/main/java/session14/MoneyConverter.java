package session14;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Home on 14.02.2016.
 */
@Converter
public class MoneyConverter implements AttributeConverter<Integer, String> {
    @Override
    public String convertToDatabaseColumn(Integer o) {
    //return Integer.valueOf(o);
        return Integer.toString(o);
    }

    @Override
    public Integer convertToEntityAttribute(String o) {
        Integer res = Integer.parseInt(o.toString());
        return res;
    }
}
