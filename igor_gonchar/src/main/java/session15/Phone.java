package session15;

/**
 * Created by Home on 20.02.2016.
 */
public class Phone {
    private String name;
    private int age;

    public Phone(){

    }

    public Phone(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
