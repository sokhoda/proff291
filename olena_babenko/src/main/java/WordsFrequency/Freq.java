package WordsFrequency;

import java.io.*;
import java.util.*;

/**
 * Created by lenchi on 26.12.15.
 * <p/>
 * <p/>
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
    TreeMap<Integer, Set<String>> frequencyForWordsMap = new TreeMap<>();


    public String setTextFromConsole() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter text:");
            text.append(reader.readLine());
        } catch (IOException ioexc) {
            ioexc.getLocalizedMessage();
        }
        System.out.println("Your text is the following:\n" + text.toString() + "\n-------------------");
        return text.toString();
    }

    public String setTextFromFile(String fileName) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            text.append(reader.readLine());
            while (reader.readLine() != null) {
                text.append(reader.readLine());
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.getLocalizedMessage();
        } catch (IOException ioException) {
            ioException.getLocalizedMessage();
        }
        System.out.println("Your text is the following:\n" + text.toString() + "\n-------------------");
        return text.toString();
    }

    public String generateRandomText(int textLength) {
        StringBuilder text = new StringBuilder();
        //create some alphabetic from which I'll take characters fro random text
        String alphabetic = " ABCDEF GHIJKLM NOPQRST UVWXYZabc defghi jklmnopqrstuvwxyz";

        Random randomGenerator = new Random();

        for (int i = 0; i < textLength; i++) {
            int index = randomGenerator.nextInt(alphabetic.length() - 1);
            //find substring from my alphabetic, using the randomly generated index value
            text.append(alphabetic.charAt(index));
        }
        System.out.println("Your text is the following:\n" + text.toString() + "\n-------------------");
        return text.toString();
    }

    public Set<String> getWordsByFrequency(int frequency) {
        //проверка freq на правильное значение, if <=0 => создать ошибку throw new IllegalArgumentException();
        if (frequencyForWordsMap.containsKey(frequency)) {
            System.out.println("Words by frequency " + frequency +"\n"+ frequencyForWordsMap.get(frequency) + "\n-------------------");
            return frequencyForWordsMap.get(frequency);
        } else {
            return null;
        }
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        //проверка freq на правильное значение, if <=0 => создать ошибку throw new IllegalArgumentException();
        Set<String> wordsWithLessFrequency = new TreeSet<>();

        for (int i = 0; i < frequency; i++) {
            if (frequencyForWordsMap.containsKey(i)) {
                wordsWithLessFrequency.addAll(frequencyForWordsMap.get(i));
            }
        }
        System.out.println("Words by frequency less than\n" + frequency +"\n"+ wordsWithLessFrequency + "\n-------------------");
        return wordsWithLessFrequency;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        //проверка freq на правильное значение, if <=0 => создать ошибку throw new IllegalArgumentException();
        Set<String> wordsWithMoreFrequency = new TreeSet<>();

        for (int i = frequency; i < frequencyForWordsMap.size(); i++) {
            if (frequencyForWordsMap.containsKey(i) && frequency < frequencyForWordsMap.size()) {
                wordsWithMoreFrequency.addAll(frequencyForWordsMap.get(i));
            }
        }
        System.out.println("Words by frequency more than\n" + frequency + "\n"+wordsWithMoreFrequency + "\n-------------------");
        return wordsWithMoreFrequency;
    }

    void printAcs() {
        System.out.println("Words ascendanly sorted by frequency\n" + frequencyForWordsMap + "\n-------------------");
    }

    void printDesc() {
        System.out.println("Words ascendanly sorted by frequency\n" + frequencyForWordsMap + "\n-------------------");
    }


    public List<String> splitTextBySpace(String text) {
        return Arrays.asList(text.split(" "));
    }

    public void countFrequency(String text) {
        frequencyForWordsMap.clear();

        List<String> wordsList = splitTextBySpace(text);
        Iterator<String> wordsListIterator = wordsList.iterator();

        while (wordsListIterator.hasNext()) {
            int frequency = 0;
            String word = wordsListIterator.next();

            for (int i = 0; i < wordsList.size(); i++) {
                if (word.equalsIgnoreCase(wordsList.get(i))) {
                    frequency++;
                }
            }

            if (frequencyForWordsMap.containsKey(frequency)) {
                frequencyForWordsMap.get(frequency).add(word);
            } else {
                Set<String> wordsSameFrequency = new TreeSet<>();
                wordsSameFrequency.add(word);
                frequencyForWordsMap.put(frequency, wordsSameFrequency);
            }
        }

    }

    public static void runAll(Freq readFile, String text, int frequency) {
        //System.out.println("\n========================\n");
        readFile.countFrequency(text);
        readFile.getWordsByFrequency(frequency);
        readFile.getWordsByFrequencyLessThan(frequency);
        readFile.getWordsByFrequencyMoreThan(frequency);
        readFile.printAcs();
        readFile.printDesc();
    }

    public static void main(String[] args) {
        Freq readFile = new Freq();

        runAll(readFile, readFile.setTextFromConsole(), 2);
        runAll(readFile, readFile.generateRandomText(20), 2);
        runAll(readFile, readFile.setTextFromFile("/home/lenchi/IdeaProjects/hw_prof29/src/WordsFrequency/Test.txt"), 2);
    }
}
