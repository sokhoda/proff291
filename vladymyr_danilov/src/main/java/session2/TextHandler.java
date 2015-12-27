package session2;

import java.io.*;
import java.util.*;

public class TextHandler {

    //    private Set<String> words;
    private Map<String, Integer> wordStatistic;

    public TextHandler() {
//        words = new HashSet<>();
        wordStatistic = new HashMap<>();
        System.out.println("new class");
    }

    private void insert(String word) {
//        words.add(word);
        if ( wordStatistic.containsKey(word) ) {
            Integer frequancy = wordStatistic.get(word);
            frequancy++;
            wordStatistic.put(word, frequancy);
        }
        wordStatistic.put(word, 0);
    }

    public void setStringFromConsole() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String word = null;
        for ( ; (word = buffer.readLine().toLowerCase()) != null; ) {
            insert(word);
        }
    }

    public void setStringFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String word = null;
        for ( ; (word = buffer.readLine().toLowerCase()) != null; ) {
            insert(word);
        }
        System.out.println("have read the file");
    }

//    public void generateRandomText(int textLength) {
//
//    }

    public Set<String> getWordsByFrequancy(Integer frequancy) {
        Set<String> result = new HashSet<>();

        for ( Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() == frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequancyLessThen(Integer frequancy) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() < frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequancyMoreThan(int frequancy) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() > frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public void printAsc() {
        StringBuffer buffer = new StringBuffer();

        final Map<String, Integer> ascSortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordStatistic.get(o1).compareTo(wordStatistic.get(o2));
            }
        });

        ascSortedMap.putAll(wordStatistic);
        for ( final Map.Entry<String, Integer> entry : ascSortedMap.entrySet() ) {
            buffer.append(entry.getKey() + " + " + entry.getValue());
        }
        System.out.println("Test");

    }

//    public void printDesc() {
//
//    }

    public static void main(String[] args) throws IOException {
        TextHandler textHandler = new TextHandler();
        textHandler.setStringFromFile("Users/danilov/IdeaProjects/proff29/vladymyr_danilov/src/main/java/session2/text.txt");
//        textHandler.setStringFromConsole();
        textHandler.printAsc();
    }
}
