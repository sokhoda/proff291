package UnitTests_equals_hashCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lenchi on 25.12.15.
 */
public class testUserHashCode {

    User user1 = new User();
    User user2 = new User();

    public void userCreation(User user, String login, String password, Double regdate, int rating, boolean sex) {
        user.setLogin(login);
        user.setPassword(password);
        user.setRegdate(regdate);
        user.setRating(rating);
        user.setSex(sex);
    }

    @Before
    public void before(){
        userCreation(user1, "Test", "Test", 20.05, 5, false);
    }

    //Whenever it is invoked on the same object more than once during an execution of a Java application,
    //the hashCode method must consistently return the same integer
    @Test
    public void isEqualHashCodeForSameObj(){
        Assert.assertEquals(user1.hashCode(), user1.hashCode());
    }

    //If two objects are equal according to the equals(Object) method,
    //then calling the hashCode method on each of the two objects must produce the same integer result.
    @Test
    public void isEqualHashCodeForEqualObjs() {
        userCreation(user2, "Test", "Test", 20.05, 5, false);
        Assert.assertTrue(user1.equals(user2));
        Assert.assertEquals(user1.hashCode(), user2.hashCode());
    }
}
