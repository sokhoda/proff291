package scrum.service;

import java.util.List;

public interface ScrumService {
    List<Integer> StringToArray(String string);
    String arrayToString(List<Integer> array);
    Integer sum(List<Integer> array);
    List<String> reverse(List<Integer> array);
    List<String> random(List<Integer> array);
}
