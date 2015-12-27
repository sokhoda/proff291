package session1;

/**
 * Created by Home on 19.12.2015.
 */
public class Mthods {
    public static void main(String[] args) {
        int x = 10;

        System.out.println("Before method: " + x);
        aaa(x);
        // Method can't change the outer value of simple type
        System.out.println("After method: " + x);

        // Method can't change links of the objects
        Employee anna = new Employee("Anna", 2000);
        Employee tom = new Employee("Tom", 3000);
        System.out.println("Name before swap: " + anna.getName());
        System.out.println("Name before swap: " + tom.getName());
        Employee.swapEmployee(anna, tom);
        System.out.println("Name after swap: " + anna.getName());
        System.out.println("Name after swap: " + tom.getName());

        //Method can change state of the objects
        System.out.println("Salary before raise: " + anna.getSalary());
        raiseSalary(anna);
        System.out.println("Salary after raise: " + anna.getSalary());

    }

    public static void aaa(int a) {
        a = a * 3;
        System.out.println("In the method: " + a);
    }

    public static void raiseSalary(Employee x) {
        x.doubleSalary();
    }
}
