package scrum.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class ScrumServiceImpl implements ScrumService {
    @Override
    public List<Integer> stringToArray(String string) {
        List<Integer> array = new ArrayList<>();
        String[] items = string.split(" ");

        for ( int i = 0; i < items.length; i++ ) {
           try {
               array.add(Integer.parseInt(items[i]));
           } catch (Exception e) {
               return null;
           }
        }

        return array;
    }

    public Integer sum (List<Integer> array) {
        int sum = 0;

        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }


}
