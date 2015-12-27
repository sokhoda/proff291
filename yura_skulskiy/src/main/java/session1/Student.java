package session1;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 19.12.15
 */
public class Student {
    private String name;
    private String surname;
    private boolean sex;
    private double balance;

    public Student() {
    }

    public Student(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Student(String name, String surname, boolean sex, double balance) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getBalance() {
        return balance;
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
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Student stud = (Student) obj;
        if (this.getName() != null && this.getSurname() != null
                && this.getName().equals(stud.getName())
                && this.getSurname().equals(stud.getSurname())
                && this.isSex() == stud.isSex()
                && Double.compare(this.getBalance(), stud.getBalance()) == 0) {
            return true;
        }
        return false;
    }
}
