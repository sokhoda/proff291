package session1;

import java.util.Objects;

/**
 * Created by Home on 19.12.2015.
 */
public class Student {
    private String name;
    private String surname;
    private int age;
    private boolean sex;
    private int balance;

    public Student() {
        this.name = "Unknown";
        this.surname = "Unknown";
        this.age = 18;
    }

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = true;
    }

    public Student(String name, String surname, int age, boolean sex, int balance) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.balance = balance;
    }

    public String getName(){
        return  name;
    }

    public String getSurname(){
        return  surname;
    }

    public int getAge() {
        return age;
    }

    public boolean getSex(){
        return sex;
    }

    public int getBalance(){
        return balance;
    }

    @Override
    public String toString() {
        String sexDefinition = "man";
        if (sex == false) {
            sexDefinition = "woman";
        }
        String result = "Name: " + name + "\nSurname: " + surname + "\nSex: " + sexDefinition + "\nAge: " + age + "\nBalance: " + balance;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Student stud = (Student) obj;

        if (this.age == stud.getAge() && this.name.equals(stud.getName()) && this.surname.equals(stud.getSurname()) &&
                this.sex == stud.getSex() && this.balance == stud.getBalance()) {
            return true;
        }

        return false;

        // Double.compare(this.getBalance(), obj.getBalance())
    }
}
