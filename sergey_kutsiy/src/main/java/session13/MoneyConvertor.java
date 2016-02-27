package session13;

import javax.persistence.AttributeConverter;

/**
 * Created by Сергей on 14.02.2016.
 */
public class MoneyConvertor implements AttributeConverter  <Integer, String> {


    @Override
    public String convertToDatabaseColumn(Integer i) {
        return String.valueOf(i);
    }

    @Override
    public Integer convertToEntityAttribute(String s) {
        return Integer.parseInt(s);
    }
}
