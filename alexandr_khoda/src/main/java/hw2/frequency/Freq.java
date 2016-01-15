package hw2.frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by s_okhoda on 24.12.2015.
 */
public class Freq {
    private String text;
    private static final String endDelimiter = "/end";
    private Map<String, Integer> map = new TreeMap<String, Integer>();
    private final int MaxWordLength = 15;

    public String setTextFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст:");
        scan.useDelimiter(endDelimiter);
        return scan.next();
    }

    public String setTextFromFile(String fileName) {
        File file = new File(fileName);
        FileReader fr = null;
        String text = "";
        try {
            fr = new FileReader(file);
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                text += scan.nextLine() + '\n';
            }
            scan.close();
            return text;
        }
        catch (FileNotFoundException e3) {
            System.out.println("Файл " + fileName + " не найден.");
            e3.printStackTrace();
            return null;
        }
        finally {
            try {
                fr.close();
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    public Map<String, Integer> getSortMap(int ascend) {
        Map<String, Integer> mapA = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String k1, String k2) {
                int i1;
                if (ascend > 0)
                    i1 = map.get(k1).compareTo(map.get(k2));
                else
                    i1 = map.get(k2).compareTo(map.get(k1));

                if (i1 == 0) return 1;
                else return i1;
            }
        });
        mapA.putAll(map);
        return mapA;
    }

    public int calcWordsNum(String text) {
        map.clear();

        if (text == null) return map.size();
        String text1 = text.replaceAll("[.,:;\n]", " ");
//        System.out.println(text1);

        String[] s1 = text1.split(" ");
        for (String s : s1) {
            String word = s.trim();
            if (word.length() > 0) {

                if (map.containsKey(word))
                    map.put(word, map.get(word) + 1);
                else
                    map.put(word, 1);
            }
        }

        return map.size();
    }


    public String generateRandomText(int textLength) {
        String text = "";
        final int startAlphabeticCode = (int) ('А');
        final int alphabeticSize = 32;

        int symbNumLeft = textLength - text.length();
        int curWordLen = (int) (Math.random() * MaxWordLength) + 1;
        curWordLen = curWordLen > symbNumLeft ? symbNumLeft : curWordLen;

        while (symbNumLeft > 0) {
            String word = "";
            for (int i = 0; i < curWordLen; i++) {
                word += Character.toString((char) (startAlphabeticCode + Math.random() * alphabeticSize));
            }
            text += word + " ";
            symbNumLeft = textLength - text.length();
            curWordLen = (int) (Math.random() * MaxWordLength) + 1;
            curWordLen = curWordLen > symbNumLeft ? symbNumLeft : curWordLen;

        }
        return text;
    }

    Set<String> getWordsByFrequency(int frequency) {
        Set<String> set = new HashSet<String>();
        if (calcWordsNum(getText()) > 0) {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue().equals(frequency)) {
                    set.add(entry.getKey());
                }
            }
            return set;
        } else return null;

    }

    Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new HashSet<String>();
        if (calcWordsNum(getText()) > 0) {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue().compareTo(frequency) < 0) {
                    set.add(entry.getKey());
                }
            }
            return set;
        } else return null;
    }

    Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> set = new HashSet<String>();
        if (calcWordsNum(getText()) > 0) {
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry.getValue().compareTo(frequency) > 0) {
                    set.add(entry.getKey());
                }
            }
            return set;
        } else return null;
    }
    void printAcs(){
        calcWordsNum(getText());
        System.out.println(getSortMap(1));
    }
    void printDesc(){
        calcWordsNum(getText());
        System.out.println(getSortMap(0));
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public static void main(String[] args) {
        Freq f = new Freq();
//        f.text = f.setTextFromConsole();
//        f.setText(f.setTextFromFile("E:\\1\\Freq.txt"));
        f.setText(f.generateRandomText(1500));

        System.out.println(f.getText());
        System.out.println(f.calcWordsNum(f.getText()));
//        System.out.println(((TreeMap<String, Integer>) f.getMap()).descendingMap());
//        System.out.println(f.getMap());
        f.printAcs();
        f.printDesc();

        System.out.println("size = " + f.getWordsByFrequencyLessThan(2).size() + ": " +f.getWordsByFrequencyLessThan(2) );

    }
}
