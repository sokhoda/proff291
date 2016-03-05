package scrum.service;

import java.util.List;

public interface ScrumService {
    List<Integer> StringToArray(String string);
    String arrayToString(List<Integer> array);
    Integer sum(List<Integer> array);
    List<String> reverse(String text);
    List<String> random(String text);
}
