package session2HomeTask;

import java.io.*;
import java.util.*;

/**
 * Created by i.gonchar on 12/21/2015.
 */


public class TextGenerator {
    private BufferedReader brFromConsole;
    private BufferedReader brFromFile;

    private String testForParsing;
    private Map<Integer, List<String>> sortedMap;
    private Set<String> frequncySet;


    // Print Sets

    public void printAcs() {
        Map<Integer, List<String>> sortedMap = finalSort(testForParsing);

        for (int tempKey : sortedMap.keySet()) {
            List<String> tempList = new ArrayList<>();
            tempList = sortedMap.get(tempKey);
            for (String temp : tempList) {
                System.out.println(temp);
            }
        }
    }

    public void printDesc() {
        Map<Integer, List<String>> sortedMap = finalSort(testForParsing);
        List<String> list = new ArrayList<>();

        for (int tempKey : sortedMap.keySet()) {
            List<String> tempList = new ArrayList<>();
            tempList = sortedMap.get(tempKey);
            for (String temp : tempList) {
                list.add(temp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.size() -i -1;
            System.out.println(list.get(temp));
        }
    }


    // return sorted Set

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Map<Integer, List<String>> sortedMap = finalSort(testForParsing);
        Set<String> frequncySet = new LinkedHashSet<>();

        for (int tempKey : sortedMap.keySet()) {
            List<String> tempList = new ArrayList<>();
            if (tempKey > frequency) {
                tempList = sortedMap.get(tempKey);
                for (String temp : tempList) {
                    frequncySet.add(temp);
                }
            }
        }
        return frequncySet;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        Map<Integer, List<String>> sortedMap = finalSort(testForParsing);
        Set<String> frequncySet = new LinkedHashSet<>();

        for (int tempKey : sortedMap.keySet()) {
            List<String> tempList = new ArrayList<>();
            if (tempKey < frequency) {
                tempList = sortedMap.get(tempKey);
                for (String temp : tempList) {
                    frequncySet.add(temp);
                }
            }
        }
        return frequncySet;
    }

    public Set<String> getWordsByFrequency(int frequency) {
        Map<Integer, List<String>> sortedMap = finalSort(testForParsing);
        Set<String> frequncySet = new LinkedHashSet<>();

        for (int tempKey : sortedMap.keySet()) {
            List<String> tempList = new ArrayList<>();
            if (tempKey == frequency) {
                tempList = sortedMap.get(tempKey);
                for (String temp : tempList) {
                    frequncySet.add(temp);
                }
            }
        }
        return frequncySet;
    }

    // String sorting

    public Map<Integer, List<String>> finalSort(String textToSort) {
        Map<String, Integer> unsortedMap = putWordsFromStringToMap(textToSort);
        Map<Integer, List<String>> sortedMap = sortWords(unsortedMap);

        this.setSortedMap(sortedMap);
        return sortedMap;
    }

    private Map<Integer, List<String>> sortWords(Map<String, Integer> map) {
        Map<Integer, List<String>> list = new HashMap<>();

        for (String word : map.keySet())
            addToMapValue(list, map.get(word), word);

        return list;
    }

    private void addToMapValue(Map<Integer, List<String>> map, Integer key, String value) {
        List<String> temp = new LinkedList<>();
        if (map.containsKey(key))
            temp = map.get(key);
        temp.add(value);
        map.put(key, temp);
    }

    private Map<String, Integer> putWordsFromStringToMap(String input) {
        Map<String, Integer> list = new HashMap<>();
        List<String> listOfWords = parseWordsFromString(input);

        for (String temp : listOfWords) {
            int count = 1;
            if (list.containsKey(temp)) {
                count += list.get(temp);
            }
            list.put(temp, count);
        }

        return list;
    }

    private List<String> parseWordsFromString(String input) {
        List<String> listOfWords = new ArrayList<>();
        Scanner sc = new Scanner(input);

        while (sc.hasNext()) {
            String temp = sc.next();
            listOfWords.add(temp);
        }
        return listOfWords;
    }


    //String generators

    public String setTextFromConsole() throws IOException {
        System.out.println("Enter String:");
        brFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String userInput = brFromConsole.readLine();
        return userInput;
    }

    public String setTextFromFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        String result;

        try {
            brFromFile = new BufferedReader(new FileReader(file));
            String line;
            fileEmptyCheck(file);

            while ((line = brFromFile.readLine()) != null) {
                sb.append(line + " ");
            }
        } catch (IOException e) {
            System.out.println("Nothing to read");
        } finally {
            result = sb.toString();
            result = result.substring(0, result.length() - 1);
            brFromFile.close();
        }
        return result;
    }

    public static void fileEmptyCheck(File file) {
        if (file.length() == 0) {
            System.out.println("File is empty");
        }
    }

    public String generateRandomText(int textLength) {
        String characters;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        Random random = new Random();


        for (char ch = 'a'; ch < 'z'; ch++) {
            sb.append(ch);
        }
        for (char ch = '1'; ch < '9'; ch++) {
            sb.append(ch);
        }
        characters = sb.toString();

        for (int j = 0; j < textLength; j++) {
            int wordLength = random.nextInt(5) + 3;
            char[] text = new char[wordLength];
            for (int i = 0; i < wordLength; i++) {
                text[i] = characters.charAt(random.nextInt(characters.length()));
            }
            String temp = new String(text);
            sbResult.append(temp + " ");
        }
        return sbResult.toString().substring(0, sbResult.length() - 1);
    }


    // Setters and getters

    public void setTestForParsing(String testForParsing) {
        this.testForParsing = testForParsing;
    }

    public String getTestForParsing() {
        return testForParsing;
    }

    public Map<Integer, List<String>> getSortedMap() {
        return sortedMap;
    }

    public void setSortedMap(Map<Integer, List<String>> sortedMap) {
        this.sortedMap = sortedMap;
    }

    public Set<String> getFrequncySet() {
        return frequncySet;
    }

    public void setFrequncySet(Set<String> frequncySet) {
        this.frequncySet = frequncySet;
    }
}
