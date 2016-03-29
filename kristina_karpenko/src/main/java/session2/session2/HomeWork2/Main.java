package session2.session2.HomeWork2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on 25.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        Freq freq = new Freq();
        List<String> text = freq.getFreq();
//================================================================

        freq.setTextFromConsole();
        System.out.println(text);
//================================================================

       // freq.setTextFromFile("C://file.txt");
        System.out.println(text);
//================================================================
        List<String> text2 = freq.getFreq();
        freq.generateRandomText(4);
        freq.generateRandomText(6);
        freq.generateRandomText(5);
        System.out.println(text2);
//================================================================
        Set<String> setWordsByFrequency = freq.getWordsByFrequency(4);
        System.out.println("Слова, встречающиеся 4 раза: " + setWordsByFrequency);
        Set<String> setWordsByFrequencyLessThan = freq.getWordsByFrequencyLessThan(4);
        System.out.println("Слова, встречающиеся меньше 4 раз: " + setWordsByFrequencyLessThan);
        Set<String> setWordsByFrequencyMoreThan = freq.getWordsByFrequencyMoreThan(4);
        System.out.println("Слова, встречающиеся больше 4 раз: " + setWordsByFrequencyMoreThan);
//=================================================================
        freq.printAcs();
        freq.printDesc();
    }
}
