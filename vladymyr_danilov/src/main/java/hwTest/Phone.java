package hwTest;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.02.16
 */
public class Phone {
    private String name;
    private int age;

    public Phone() {
    }

    public Phone(String name, int age) {
        this.name = name;
        this.age = age;
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
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
