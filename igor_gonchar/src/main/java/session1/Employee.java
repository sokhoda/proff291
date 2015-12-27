package session1;

/**
 * Created by Home on 19.12.2015.
 */
public class Employee {
    private int salary;
    private String name;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void doubleSalary(){
        salary *= 2;
    }

    public static void swapEmployee(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("In the method x name: " + x.getName());
        System.out.println("In the method y name: " + y.getName());
    }
}
