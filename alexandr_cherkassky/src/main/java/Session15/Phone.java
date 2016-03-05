package Session15;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class Phone {
    private String name;
    private int age;

    public Phone(){}

    @Override
    public String toString() {
        return "Phone{" +
                "Name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
