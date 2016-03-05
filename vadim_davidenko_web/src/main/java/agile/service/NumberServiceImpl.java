package agile.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Вадим on 05.03.2016.
 */

@Service
public class NumberServiceImpl implements NumberService {

    NumberServiceImpl() {}

    public Double calculateSum(String str) throws NumberFormatException {
        List<String> list = stringToList(str);
        Double sum = 0.0;
        for (String s : list) {
            sum += Double.parseDouble(s);
        }
        return sum;
    }

    public String reverse(String str) {
        List<String> list = stringToList(str);
        Collections.reverse(list);
        return listToString(list);
    }

    public String shuffle(String str) {
        List<String> list = stringToList(str);
        Collections.shuffle(list);
        return listToString(list);
    }

    private List<String> stringToList(String str) {
        String[] numbers = str.split(" ");
        return new ArrayList<String>(Arrays.asList(numbers));
    }

    private String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder("");
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
