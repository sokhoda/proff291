package JAXB.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Юра on 21.01.2016.
 */
//@XmlRootElement(name="ofUser")
@XmlAccessorType(XmlAccessType.NONE)
public class User {
    @XmlElement(name="age")
    int age;
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "surname")
    String surname;
    @XmlElement(name = "password")
    String password;
    @XmlElement(name = "login")
    String login;

    public User( String login, String password,int age, String surname, String name) {
        this.age = age;
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
    }
    public User(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+" "+ age+""+name+" "+password+" "+login;
    }
}
