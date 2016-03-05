package hibernate.Convert;

import javassist.compiler.ast.Variable;
import org.apache.log4j.Logger;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * Created by lenchi on 14.02.16.
 */
@Converter
public class ConverterClass implements AttributeConverter<String, Double> {

    @Override
    public Double convertToDatabaseColumn(String money) {
        Double moneyDouble = Double.parseDouble(money);
        return moneyDouble;
    }

    @Override
    public String convertToEntityAttribute(Double money) {
        String moneyString = Double.toString(money);
        return moneyString;
    }
}
