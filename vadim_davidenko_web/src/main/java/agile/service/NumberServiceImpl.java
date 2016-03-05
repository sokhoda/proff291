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

    public Double calculateSum(String str) {
        String[] numbers = str.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(numbers));


        return null;
    }

    public String reverse(String str) {

        return null;
    }

    public String shuffle(String str) {
        String[] numbers = str.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(numbers));
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder("");
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
