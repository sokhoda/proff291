package session2.session2.HomeWork2;


import java.io.*;
import java.util.*;


/**
 * Написать класс для вычисления частоты слов в тексте с методами:
 * - String setTextFromConsole()
 * - String setTextFromFile(String fileName)
 * - String generateRandomText(int textLength)
 * - Set<String> getWordsByFrequency(int frequency)
 * - Set<String> getWordsByFrequencyLessThan(int frequency)
 * - Set<String> getWordsByFrequencyMoreThan(int frequency)
 * - void printAcs() - вывести все слова + частота по возрастанию частоты
 * - void printDesc() - вывести все слова + частота по убыванию частоты
 */
public class Freq {
    List<String> text = new ArrayList<>();

    public List<String> getFreq() {//вернуть весь текст
        return text;
    }

    public String setTextFromConsole() {
        String str = "";
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (!str.equals("end")) {
                str = reader.readLine();
                text.add(str);
            }
        } catch (IOException e) {
            System.out.println("Error in method setTextFromConsole");
        }
        return str;
    }

    public String setTextFromFile(String fileName) throws IOException {
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "CP1251"));
        try {
               while ((str = br.readLine()) != null) {
                text.add(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in method setTextFromFile: FileNotFoundException");
        } catch (IOException e) {
            System.out.println("Error in method setTextFromFile: IOException");
        } finally {
            br.close();
        }
        return str;
    }


    public String generateRandomText(int textLength) {
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(textLength);

        for (int i = 0; i < textLength; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        }
        text.add(sb.toString());
        return sb.toString();
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Set<String> set = new HashSet<>();
        int repeat;
        for (int i = 0; i < text.size(); i++) {
            repeat = 0;
            String world1 = text.get(i);
            for (int j = 0; j < text.size(); j++) {
                if (world1.equals(text.get(j))) {
                    repeat++;
                }
            }
            if (repeat == frequency) {
                set.add(world1);
            }
        }
        return set;
    }

    Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new HashSet<>();
        int repeat;
        for (int i = 0; i < text.size(); i++) {
            repeat = 0;
            String world1 = text.get(i);
            for (int j = 0; j < text.size(); j++) {
                if (world1.equals(text.get(j))) {
                    repeat++;
                }
            }
            if (repeat < frequency) {
                set.add(world1);
            }
        }
        return set;
    }


    Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> set = new HashSet<>();
        int repeat;
        for (int i = 0; i < text.size(); i++) {
            repeat = 0;
            String world1 = text.get(i);
            for (int j = 0; j < text.size(); j++) {
                if (world1.equals(text.get(j))) {
                    repeat++;
                }
            }
            if (repeat > frequency) {
                set.add(world1);
            }
        }
        return set;
    }


    //- вывести все слова + частота по возрастанию частоты
    public void printAcs() {
        System.out.println("Возрастание частоты: ");
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < i; j++) {
                list.addAll(getWordsByFrequency(i));
            }
        }
        System.out.println(list);
    }

    // - вывести все слова + частота по убыванию частоты
    public void printDesc() {
        System.out.println("Убывание частоты: ");
        List<String> list = new ArrayList<>();
        for (int i = 6; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                list.addAll(getWordsByFrequency(i));
            }
        }
        System.out.println(list);
    }

}