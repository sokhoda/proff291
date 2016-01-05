package arhiv;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Freq {
    private static String text = "";

    public Freq() {
    }

    public void printAcs() {
        new TreeSet();
        String[] sizeTest = text.split(" ");
        int wordsQ = sizeTest.length;
        String[] temp = new String[wordsQ];
        temp = text.split(" ");
        int size = temp.length;
        System.out.println("Количество слов = " + size);
        HashMap words = new HashMap();

        for(int i = 0; i < size; ++i) {
            String word = temp[i].toLowerCase();
            if(words.containsKey(word)) {
                int fre = ((Integer)words.get(word)).intValue();
                ++fre;
                words.put(word, Integer.valueOf(fre));
            } else {
                words.put(word, Integer.valueOf(1));
            }
        }

        System.out.println(words.toString());
    }

    public void textCleaner() {
        String temp = "";
        char[] letters = text.toCharArray();
        int i = 0;

        for(int size = letters.length; i < size; ++i) {
            if(letters[i] != 44 && letters[i] != 34 && letters[i] != 40 && letters[i] != 41 && letters[i] != 171 && letters[i] != 187 && letters[i] != 46 && letters[i] != 8211 && letters[i] != 63 && letters[i] != 33) {
                temp = temp + letters[i];
            }
        }

        text = temp;
        System.out.println(text);
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency) {
        TreeSet result = new TreeSet();
        String[] sizeTest = text.split(" ");
        int wordsQ = sizeTest.length;
        String[] temp = new String[wordsQ];
        temp = text.split(" ");
        int size = temp.length;
        System.out.println("Количество слов = " + size);
        HashMap words = new HashMap();

        for(int i = 0; i < size; ++i) {
            String word = temp[i].toLowerCase();
            if(words.containsKey(word)) {
                int entry = ((Integer)words.get(word)).intValue();
                ++entry;
                words.put(word, Integer.valueOf(entry));
            } else {
                words.put(word, Integer.valueOf(1));
            }
        }

        Iterator var12 = words.entrySet().iterator();

        while(var12.hasNext()) {
            Entry var11 = (Entry)var12.next();
            if(((Integer)var11.getValue()).intValue() >= frequency) {
                result.add(var11.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency) {
        TreeSet result = new TreeSet();
        String[] sizeTest = text.split(" ");
        int wordsQ = sizeTest.length;
        String[] temp = new String[wordsQ];
        temp = text.split(" ");
        int size = temp.length;
        System.out.println("Количество слов = " + size);
        HashMap words = new HashMap();

        for(int i = 0; i < size; ++i) {
            String word = temp[i].toLowerCase();
            if(words.containsKey(word)) {
                int entry = ((Integer)words.get(word)).intValue();
                ++entry;
                words.put(word, Integer.valueOf(entry));
            } else {
                words.put(word, Integer.valueOf(1));
            }
        }

        Iterator var12 = words.entrySet().iterator();

        while(var12.hasNext()) {
            Entry var11 = (Entry)var12.next();
            if(((Integer)var11.getValue()).intValue() <= frequency) {
                result.add(var11.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequency(int frequency) {
        TreeSet result = new TreeSet();
        String[] sizeTest = text.split(" ");
        int wordsQ = sizeTest.length;
        String[] temp = new String[wordsQ];
        temp = text.split(" ");
        int size = temp.length;
        System.out.println("Количество слов = " + size);
        HashMap words = new HashMap();

        for(int i = 0; i < size; ++i) {
            String word = temp[i].toLowerCase();
            if(words.containsKey(word)) {
                int entry = ((Integer)words.get(word)).intValue();
                ++entry;
                words.put(word, Integer.valueOf(entry));
            } else {
                words.put(word, Integer.valueOf(1));
            }
        }

        Iterator var12 = words.entrySet().iterator();

        while(var12.hasNext()) {
            Entry var11 = (Entry)var12.next();
            if(((Integer)var11.getValue()).intValue() == frequency) {
                result.add(var11.getKey());
            }
        }

        return result;
    }

    public String setTextFromFile(String fileName) throws FileNotFoundException {
        String temp = "";
        File source = new File(fileName);
        if(!source.isFile()) {
            System.out.println("Указанный источник не является файлом");
            return temp;
        } else {
            FileReader fr = new FileReader(source);

            Scanner scfr;
            for(scfr = new Scanner(fr); scfr.hasNext(); temp = temp + scfr.nextLine()) {
                ;
            }

            scfr.close();
            return temp;
        }
    }

    public String setTextFromConsole() {
        System.out.println("Введите текст, пожалуйста.");
        Scanner key = new Scanner(System.in);
        String temp = key.nextLine();
        return temp;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Freq example = new Freq();
        System.out.println("Let\'s go!");
        boolean repeat = true;

        while(repeat) {
            System.out.println("Меню");
            System.out.println("1. Ввести текст с консоли.");
            System.out.println("2. Взять текст из файла.");
            System.out.println("3. Сгенерировать случайный текст.");
            System.out.println("4. Вывести слова, использованные х раз.");
            System.out.println("5. Вывести слова использованные чаще, чем х раз.");
            System.out.println("6. Вывести слова использованные реже, чем х раз.");
            System.out.println("7. Напечатать все слова и количество их употребления.");
            System.out.println("Сделайте свой выбор");
            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();
            int freq;
            Set words;
            switch(choice) {
                case 1:
                    System.out.println("choice 1");
                    text = example.setTextFromConsole();
                    break;
                case 2:
                    System.out.println("choice 2");
                    String temp = "/Users/elenabugercuk/IdeaProjects/prof29/src/prof29/hw2/frequency/testText.txt";
                    text = example.setTextFromFile(temp);
                    example.textCleaner();
                    break;
                case 3:
                    System.out.println("choice 3");
                    System.out.println("Введите размер текста.");
                    int tSize = keyboard.nextInt();
                    text = example.generateRandomText(tSize);
                    System.out.println(text);
                    break;
                case 4:
                    System.out.println("choice 4");
                    System.out.println("Введите частоту употребления слова");
                    freq = keyboard.nextInt();
                    words = example.getWordsByFrequency(freq);
                    System.out.println(words);
                    break;
                case 5:
                    System.out.println("choice 5");
                    System.out.println("Введите минимальную частоту употребления слова");
                    freq = keyboard.nextInt();
                    words = example.getWordsByFrequencyMoreThan(freq);
                    System.out.println(words);
                    break;
                case 6:
                    System.out.println("choice 6");
                    System.out.println("Введите максимальную частоту употребления слова");
                    freq = keyboard.nextInt();
                    words = example.getWordsByFrequencyLessThan(freq);
                    System.out.println(words);
                    break;
                case 7:
                    System.out.println("choise 7");
                    example.printAcs();
                    break;
                default:
                    System.out.println("exit");
                    repeat = false;
            }
        }

    }

    public String generateRandomText(int textLength) {
        String[] base = new String[]{"Крики", "слезы", "туман", "Боль", "обида", "обман", "Тучи", "гром", "ложь", "вокруг", "опять", "предатель", "друг", "Серость", "падаль", "беда", "Грех", "печаль", "жизнь", "игра", "Зависть", "ужас", "плач", "страх", "Осень", "стон", "крик", "и", "прах", "Жадность", "тоска", "ужас", "и", "горе", "Смерть", "холодное", "море", "Трясина", "отчаянье", "блеф", "Болезнь", "порок", "и", "гнев", "Любовь", "удача", "чистота", "Весна", "полет", "и", "свет", "всегда", "Жизнь", "тепло", "в", "небе", "луна", "Путь", "надежда", "доброта", "Рассвет", "сияние", "сила", "Крылья", "и", "свет", "мира", "Ясность", "надежда", "звезда", "Солнце", "земля", "небеса", "Ангел", "радость", "и", "душа", "Смех", "и", "правда", "чудеса", "Мама", "счастье", "и", "семья", "Жизнь", "гармония", "всегда"};
        int size = base.length;
        String temp = "";

        for(int i = 0; i < textLength; ++i) {
            int index = (int)(Math.random() * (double)size);
            temp = temp + base[index] + " ";
        }

        return temp;
    }
}
