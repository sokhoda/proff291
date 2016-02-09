package JAXB.User;

import javax.xml.bind.annotation.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Юра on 21.01.2016.
 */
@XmlRootElement(name="ofUser")
@XmlAccessorType(XmlAccessType.NONE)

public class UserList {
    @XmlElementWrapper(name = "elems")
    @XmlElement(name = "user_object")
    List<User> users;

//    public UserList(List hw5.users) {
//        this.hw5.users = hw5.users;
//    }


    public UserList(List<User> users) {
        this.users = users;
    }


    public UserList() {
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void printMe() {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User next = iterator.next();

            System.out.println( next.toString());
        }
    }
}
