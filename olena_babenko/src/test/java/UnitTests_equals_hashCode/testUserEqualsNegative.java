package UnitTests_equals_hashCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lenchi on 23.12.15.
 */
public class testUserEqualsNegative {
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    //created constructor with all existing class parameters on entry
    public void userCreation(User user, String login, String password, Double regdate, int rating, boolean sex) {
        user.setLogin(login);
        user.setPassword(password);
        user.setRegdate(regdate);
        user.setRating(rating);
        user.setSex(sex);
    }

    /*@BeforeClass
    public static void beforeClass(){
        System.out.println("Equals method results:");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Equals method testing is finished");
    }*/

    @Before
    public void before(){
        //user1 = user2 != user3
        userCreation(user1, "Test1", "TestTest", 10.02, 3, true);
        userCreation(user2, "Test1", "TestTest", 10.02, 3, true);
        userCreation(user3, "Test3", "TestTestTest", 30.03, 5, false);
    }

   /* @After
    public void after(){
        System.out.println("Test Case stopped running");
    }*/

    //verify non-equality for hw5.users
    @Test
    public void isNotEqualUsers(){
        Assert.assertFalse(user1.equals(user3));
    }

    //For any non-null reference value x, x.equals(null) should return false
    @Test
    public void isNullObject(){
        Assert.assertFalse(user1.equals(null));
    }

    //verify on the same classes of obj in equals
    @Test
    public void isNotSameClasses(){
        //create object of not User class
        Integer num = new Integer(10);
        Assert.assertFalse(user1.equals(num));
    }
}
