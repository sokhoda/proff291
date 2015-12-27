
public class MainClass {
    public static void main(String[] args) {
        WordCalc wc = new WordCalc();
        wc.generateRandomText(1000);
        //System.out.println(wc.setTextFromFile("input.txt"));
        wc.printAcs();
        wc.printDesc();
        System.out.println(wc.getWordsByFrequency(4).size());
        System.out.println(wc.getWordsByFrequencyLessThan(10).size());
        System.out.println(wc.getWordsByFrequencyMoreThan(10).size());
    }
}
