package session1;

/**
 * Created by Home on 19.12.2015.
 */
public class HelloWorld {
    public static void main(String[] args) {
       // System.out.println("Hello Idea");

        Student unknown = new Student();
        Student bobMarley = new Student("Bob", "Marley", 18);
        Student bobMarleyClone = new Student("Bob", "Marley", 18);
        Student tomKruz = new Student("Tom", "Kruz", 21);
        Student tomHardie = new Student("Tom", "Hardie", 25, true, 1000);

        System.out.println(tomKruz.toString());

        System.out.println(tomHardie.equals(tomKruz));
        System.out.println(bobMarley.equals(bobMarleyClone));
    }
}
