package session1;

/**
 * Created by Администратор on 19.12.2015.
 */
public class RealizeStudents {
    public static void main(String[] args){
        Students student1 = new Students("Vas","Petrov",true,21);
        Students student2 = new Students("Vas","Petrov");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1.equals(student1));
        System.out.println();

    }
}
