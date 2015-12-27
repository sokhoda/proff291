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

    public String setTextFromConsole() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст:");
        scan.useDelimiter(endDelimiter);
        return scan.next();
    }

    public String setTextFromFile(String fileName) {
        File file1 = new File(fileName);
        FileReader fr = null;
        String text = "";
        try {
            fr = new FileReader(file1);
            Scanner scan = new Scanner(fr);

            while (scan.hasNextLine()) {
                text += scan.nextLine() + '\n';
            }
            scan.close();

            try {
                fr.close();
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            return text;
        }
        catch (FileNotFoundException e3) {
            System.out.println("Файл " + fileName + " не найден.");
            e3.printStackTrace();
            return null;
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

    public Map<String, Integer> getMap() {
        return map;
    }


    public static void main(String[] args) {
        Freq f = new Freq();
//        f.text = f.setTextFromConsole();
        f.text = f.setTextFromFile("E:\\1\\Freq.txt");
        System.out.println(f.text);
        System.out.println(f.calcWordsNum(f.text));
//        System.out.println(((TreeMap<String, Integer>) f.getMap()).descendingMap());
//        System.out.println(f.getMap());
        System.out.println(f.getSortMap(0));
    }
}
