import java.io.*;
import java.util.*;

public class WordCalc {

    public String currentText;
    private String[] words;
    Map<String, Integer> wordFrequency;

    public WordCalc() {
        wordFrequency = new TreeMap<String, Integer>();
        words = new String[]{"Крики", "слезы", "туман",
                "Боль", "обида", "обман",
                "Тучи", "гром" ,  "ложь", "вокруг",
                "опять", "предатель", "друг",
                "Серость", "падаль", "беда",
                "Грех", "печаль",  "жизнь", "игра",
                "Зависть", "ужас", "плач",  "страх",
                "Осень", "стон", "крик", "и", "прах",
                "Жадность", "тоска", "ужас", "и", "горе",
                "Смерть", "холодное", "море",
                "Трясина", "отчаянье", "блеф",
                "Болезнь", "порок", "и", "гнев",
                "Любовь", "удача", "чистота",
                "Весна", "полет", "и", "свет", "всегда",
                "Жизнь", "тепло", "в", "небе", "луна",
                "Путь", "надежда", "доброта",
                "Рассвет", "сияние", "сила",
                "Крылья", "и", "свет", "мира",
                "Ясность", "надежда", "звезда",
                "Солнце", "земля", "небеса",
                "Ангел", "радость", "и", "душа",
                "Смех", "и", "правда", "чудеса",
                "Мама", "счастье", "и", "семья",
                "Жизнь", "гармония", "всегда"};
    }

    public String setTextFromConsole(){
        String text = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            text = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentText = text;
        recalcFreqvency();
        return currentText;
    }

    String setTextFromFile(String fileName){
        StringBuilder newString = new StringBuilder();
        String line;
        File f = new File(fileName);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
            while ((line = br.readLine()) != null)
                newString.append(line.trim() + " ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        currentText = newString.toString().trim();
        recalcFreqvency();
        return currentText;
    }

    String generateRandomText(int textLength){
        StringBuilder newString = new StringBuilder();

        for(int i = 0; i < textLength; i++) {
            newString.append(words[(int) (Math.random() * words.length)] + " ");
        }
        currentText = newString.toString().trim();
        recalcFreqvency();
        return currentText;
    }

    Set<String> getWordsByFrequency(int frequency){
        Set<String> result = new HashSet<String>();
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()){
            if (entry.getValue() == frequency)
            result.add(entry.getKey());
        }
        return result;
    }

    Set<String> getWordsByFrequencyLessThan(int frequency){
        Set<String> result = new HashSet<String>();
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()){
            if (entry.getValue() < frequency)
                result.add(entry.getKey());
        }
        return result;
    }

    Set<String> getWordsByFrequencyMoreThan(int frequency){
        Set<String> result = new HashSet<String>();
        for(Map.Entry<String, Integer> entry: wordFrequency.entrySet()){
            if (entry.getValue() > frequency)
                result.add(entry.getKey());
        }
        return result;
    }

    // - вывести все слова + частота по возрастанию частоты
    void printAcs(){
        Iterator iterator;
        TreeMap<String, Integer> newMap = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int compare = Integer.compare(wordFrequency.get(word2), wordFrequency.get(word1));
                if (compare == 0)
                    return 1;
                else
                    return - compare;
            }});
        newMap.putAll(wordFrequency);
        System.out.println(newMap);
    }

    //- вывести все слова + частота по убыванию частоты
    void printDesc(){
        Iterator iterator;
        TreeMap<String, Integer> newMap = new TreeMap<String, Integer>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                int compare = Integer.compare(wordFrequency.get(word2), wordFrequency.get(word1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
        }});
        newMap.putAll(wordFrequency);
        System.out.println(newMap);
    }

    private void recalcFreqvency(){
        currentText = currentText.replace("?", "").replace("!", "").replace(",", "").replace(".", "")
                .replace("-", "").replace("(", " ").replace(")", " ").replace("  ", " ");
        wordFrequency = new TreeMap<String, Integer>();
        for(String word: currentText.split(" ")){
            int frequency = 0;
            word = word.toLowerCase();
            if(wordFrequency.containsKey(word))
                frequency = wordFrequency.get(word);
            if(!isNumber(word))
                wordFrequency.put(word, frequency + 1);
        }
    }

    private boolean isNumber(String s){
        try
        {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException er){
            return false;
        }
    }
}
