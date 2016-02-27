package Session13;

import javax.persistence.AttributeConverter;

/**
 * Created by Пк2 on 14.02.2016.
 */
public class MoneyConvereter  implements AttributeConverter<Double,String> {

    @Override
    public String convertToDatabaseColumn(Double aDouble) {
        return String.valueOf(aDouble);
    }

    @Override
    public Double convertToEntityAttribute(String s) {
        Double budggetDouble=Double.parseDouble(s);
        return budggetDouble;
    }
}
