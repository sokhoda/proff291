package scrum.service;

import java.util.List;

public interface ScrumService {
    List<Integer> StringToArray(String string);
    String arrayToString(List<Integer> array);
    Integer sum(List<Integer> array);
    List<Integer> reverse(List<Integer> array);
    List<Integer> random(List<Integer> array);
}
