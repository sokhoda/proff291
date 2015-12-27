package session1;

/**
 * Created by Pavel on 19.12.2015.
 */
public class Student {
    private String name;
    private String surname;
    private boolean sex;
    private int age;
    private double balance;

    public Student(String name, String surname, boolean sex, int age, float balance) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.balance = balance;
    }

    public Student(String name, String surname, boolean sex, int age) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public Student() {}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", account=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;

        if(obj.getClass() != this.getClass())
            return false;

        Student o = (Student) obj;
        return this.name.equals(o.getName())
                && this.surname.equals(o.getSurname())
                && this.age == o.getAge()
                && Double.compare(this.getBalance(), o.getBalance()) == 0;
    }
}
