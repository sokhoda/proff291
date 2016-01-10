package homework1.frequency;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Юлия on 23.12.2015.
 */
public class Frequency {

    private String fileName;
    private int textLength;
    private int frequency;
    private String text;
    private String[] base = {"Крики", "слезы", "туман",
            "Боль", "обида", "обман",
            "Тучи", "гром", "ложь", "вокруг",
            "опять", "предатель", "друг",
            "Серость", "падаль", "беда",
            "Грех", "печаль", "жизнь", "игра",
            "Зависть", "ужас", "плач", "страх",
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
    private String setTextFromConsole() {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        while (scan.hasNext()) {
            text = scan.next().toLowerCase();
        }
        return text;

    }

    private String setTextFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        FileInputStream in=null;
        Path path = Paths.get("D:\\file.txt");
        fileName = path.getFileName().toString();
        return fileName;
    }


    private String generateRandomText(int textLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
      int wordlength=random.nextInt(5)+2;
        int length = base.length;
        for (int i = 0; i < textLength; i++) {
            sb.append(random.nextInt(length));
        }
        return sb.toString();

    }

    //
    private Set<String> getWordsByFrequency(int frequency) {
        Set<String> set = new HashSet<>();
        String search="и";
        frequency=0;
        for(int i=0; i<base.length-1;i++){
            if(base[i].equals(search)){
                frequency++;
            }
        }

        return getWordsByFrequency(frequency);
    }

    //
    private Set<String> getWordsByFrequencyLessThan(int frequency) {
        Set<String> set = new HashSet<>();
        String search="и";
        frequency=0;
        for(int i=0; i<base.length-1;i++){
            if(base[i].equals(base)){
                frequency++;
            }
        }

        return getWordsByFrequency(frequency);
    }

    //
    private Set<String> getWordsByFrequencyMoreThan(int frequency) {
        Set<String> set = new HashSet<>();
        return null;
    }

    //
    private void printAcs() {
        System.out.println("Words" + "Frequencies" );
    }

    //
    private void printDesc() {
        System.out.println("Words" + "Frequencies");
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Frequency() {

    }

    public Frequency(String fileName, int textLength, int frequency) {
        this.fileName = fileName;
        this.textLength = textLength;
        this.frequency = frequency;
    }


    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTextLength() {
        return textLength;
    }

    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }




}