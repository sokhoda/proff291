package session15;

public class Phone {
    private int age;
    private String name;

    public Phone() {
    }

    public Phone(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Phone(int age) {
        this.age = age;
    }

    public Phone(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
