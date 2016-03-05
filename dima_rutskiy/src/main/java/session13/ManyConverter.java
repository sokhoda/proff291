package session13;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Rrr on 14.02.2016.
 */
@Converter
public class ManyConverter implements AttributeConverter <Integer,String> {

    @Override
    public String convertToDatabaseColumn(Integer o) {
        if(o!=null) {
            return String.valueOf(o);
        }
        return null;
    }


    @Override
    public Integer convertToEntityAttribute(String o) {
        if(o!=null) {
            return Integer.valueOf( o);
        }
        return null;
    }
}
