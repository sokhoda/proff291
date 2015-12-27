package hw2.frequency;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Created by Solyk on 21.12.2015.
 */

/**
 * Написать класс для вычисления частоты слов в тексте с методами:
 - String setTextFromConsole()
 - String setTextFromFile(String fileName)
 - String generateRandomText(int textLength)
 - Set<String> getWordsByFrequency(int frequency)
 - Set<String> getWordsByFrequencyLessThan(int frequency)
 - Set<String> getWordsByFrequencyMoreThan(int frequency)
 - void printAcs() - вывести все слова + частота по возрастанию частоты
 - void printDesc() - вывести все слова + частота по убыванию частоты

 Класс задания hw2.frequency.Freq
 */
public class Freq{

    private String text = "";
    private Set<String> textSetString;

    public Freq(){    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String setTextFromConsole(){

        if(text == null){
            text = "";
        }
        boolean tt = true;

        Scanner key = new Scanner(System.in);
        while (tt == true) {
            if(text.equals("") == true && key.hasNextLine() == true) {
                text += key.nextLine();
            }
            if(text.equals("") != true && key.hasNextLine() == true){

                String tmp = key.nextLine();

                if(tmp.equals("") == true ){
                tt = false;
                    break;
                }
                text += "\n" + tmp;
            }
        }

        return text;
    }
    public String setTextFromFile(String fileName){

        if(text == null){
            text = "";
        }

        try {
            FileReader textFromFile = new FileReader(fileName);
            Scanner keyboard  = new Scanner(textFromFile);
            while (keyboard.hasNextLine()){
                if(text.equals("") == true){
                    text +=   keyboard.nextLine();
                }else {
                    text += "\n" + keyboard.nextLine();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return text;
    }
    public String generateRandomText(int textLength){
        if(text == null){
            text = "";
        }

        int iWords = 0;
        int isimbols  = 0;
        String simbolsList = ",.";
        String newString = "\n";

        String[]  wordsList  = {"крики", "слезы", "туман",
                "боль", "обида", "обман",
                "тучи", "гром" ,  "ложь", "вокруг",
                "опять", "предатель", "друг",
                "серость", "падаль", "беда",
                "грех", "печаль",  "жизнь", "игра",
                "зависть", "ужас", "плач",  "страх",
                "осень", "стон", "крик", "и", "прах",
                "жадность", "тоска", "ужас", "и", "горе",
                "смерть", "холодное", "море",
                "трясина", "отчаянье", "блеф",
                "болезнь", "порок", "и", "гнев",
                "любовь", "удача", "чистота",
                "весна", "полет", "и", "свет", "всегда",
                "жизнь", "тепло", "в", "небе", "луна",
                "путь", "надежда", "доброта",
                "рассвет", "сияние", "сила",
                "крылья", "и", "свет", "мира",
                "ясность", "надежда", "звезда",
                "солнце", "земля", "небеса",
                "ангел", "радость", "и", "душа",
                "смех", "и", "правда", "чудеса",
                "мама", "счастье", "и", "семья",
                "жизнь", "гармония", "всегда",
                "Сергей", "Ирина", "Нилолай"};

        if(text.equals("") == true){

            String tempSimbol = "";
            Random randomWords = new Random();
            Random randomSimbols = new Random();
            int tmpRandomSimbols = 0;
            int tmpRandomWords = 0;

            while(iWords != textLength){

                tmpRandomSimbols = randomSimbols.nextInt(5);
                tmpRandomWords = randomWords.nextInt(wordsList.length);
                if(iWords % 5 == 0){
                    newString = "\n";
                } else{
                    newString = "";
                }
                if(tmpRandomSimbols > 1){
                    tempSimbol = "";
                } else {
                    tempSimbol = "";
                    tempSimbol += simbolsList.charAt(tmpRandomSimbols);
                }

                if(text.equals("") == true || text.endsWith(". ")) {
                    text += newString + wordsList[tmpRandomWords].substring(0, 1).toUpperCase() +
                            wordsList[tmpRandomWords].substring(1) + tempSimbol + " ";
                    iWords++;
                } else if(iWords == (textLength - 1)){
                    text += newString + wordsList[tmpRandomWords] + "."  ;
                    iWords++;
                } else {
                    text += newString + wordsList[tmpRandomWords] + tempSimbol + " ";
                    iWords++;
                }
            }
        }
        return text;
    }
    public Set<String> getWordsByFrequency(int frequency){

        Set<String> textSetString = new HashSet<String>();
        String [] wordsUseDelimetr = text.split("[\\s.,;:]+");
        for (String d: wordsUseDelimetr){
            if(d.length() == frequency){
                textSetString.add(d);
            }
        }

        return textSetString;
    }
    public Set<String> getWordsByFrequencyLessThan(int frequency){

        Set<String> textSetString = new HashSet<String>();
        String [] wordsUseDelimetr = text.split("[\\s.,;:]+");
        for (String d: wordsUseDelimetr){
            if(d.length() < frequency && d.equals("") == false){
                textSetString.add(d);
            }
        }

        return textSetString;

    }
    public Set<String> getWordsByFrequencyMoreThan(int frequency){

        Set<String> textSetString = new HashSet<String>();
        String [] wordsUseDelimetr = text.split("[\\s.,;:]+");
        for (String d: wordsUseDelimetr){
            if(d.length() > frequency){
                textSetString.add(d);
            }
        }

        return textSetString;
    }
    public void printAcs(){

        Map<String, Integer> delimetrText = this.asc();

        List<Map.Entry<String, Integer>> sorterIng = new ArrayList<Map.Entry<String, Integer>>(delimetrText.entrySet());
        Collections.sort(sorterIng, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int compareResult = o2.getValue().compareTo(o1.getValue());

                if (compareResult != 0) {
                    return -compareResult;
                }
                return o2.getKey().compareTo(o1.getKey());
            }
        });

        for (Map.Entry<String, Integer> word : sorterIng) {
            System.out.println(word.getKey() + " " + word.getValue());
        }
    }


    public void printDesc(){

        Map<String, Integer> delimetrText = this.asc();

        List<Map.Entry<String, Integer>> sorterIngDesc = new ArrayList<Map.Entry<String, Integer>>(delimetrText.entrySet());
        Collections.sort(sorterIngDesc, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o11, Map.Entry<String, Integer> o22) {
                int compareResult = o22.getValue().compareTo(o11.getValue());
                if (compareResult != 0) {
                    return compareResult;
                }
                return o22.getKey().compareTo(o11.getKey());
            }
        });

        for (Map.Entry<String, Integer> word : sorterIngDesc) {
            System.out.println(word.getKey() + " " + word.getValue());
        }
    }

    public Map<String, Integer> asc(){
        if (text == null) {
            throw new IllegalStateException("Text is null");
        }

        String[] strArray = text.split("[\\s.,;:!?*%)(]+");
        Map<String, Integer> result = new HashMap<String, Integer>(strArray.length);

        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = strArray[i].toLowerCase();
        }
        for (String s : strArray) {
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else  if (!s.equals("")) {
                result.put(s, 1);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Freq freq = new Freq();
       // freq.setTextFromConsole();
        freq.setTextFromFile("C:\\Users\\Solyk\\IdiaProjects\\Proff29\\proff29\\lyashenko_dmitriy\\src\\main\\resources\\FileTestText.txt");
      //  System.out.println(freq.getText());
       // freq.setText("");
        //freq.generateRandomText(53);
       // System.out.println(freq.getText());
       // System.out.println(freq.getWordsByFrequency(1));
        //System.out.println(freq.getWordsByFrequencyLessThan(5));
        //System.out.println(freq.getWordsByFrequencyMoreThan(10));
        freq.printAcs();
        //freq.printDesc();
    }
}
