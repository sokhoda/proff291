package homework1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Юлия on 22.12.2015.
 */
public class UserTest {
    private User module;

    @Before
    public void setUp() {
        module = new User();
    }

    @Test
    public void testEquals1() {
        Set<User> users = new HashSet<>();
        users.add(new User("hjk", "hjk", 12, 12, "ddd"));
        Set<User> user = new HashSet<>();
        user.add(new User("hjk", "hjk", 12, 12, "ddd"));
        boolean expectedResult = users.equals(user);
        boolean actualResult = true;
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testEquals2() {
        Set<User> users = new HashSet<>();
        users.add(new User("dee", 0, 0, "ee", "ee"));
        Set<User> user = new HashSet<>();
        user.add(new User("hjk", "hjk", 12, 12, "ddd"));
        boolean expectedResult = users.equals(user);
        boolean actualResult = false;
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(expected = Exception.class)
    public void testEquals3() {
        Set<User> users = null;
        Set<User> user = new HashSet<>();
        user.add(new User("hjk", "hjk", 12, 12, "ddd"));
        boolean expectedResult = users.equals(user);
        boolean actualResult = false;
        Assert.assertEquals(expectedResult, actualResult);

    }


@Test
public void testEquals4() {
    Set<User> users = new HashSet<>();
     users.add(new User("qqq", "qwe", 1, 13, "22d"));
    Set<User> user = new HashSet<>();
    user.add(new User("hjk", "dfgh", 12, 12, "ddd"));
    boolean expectedResult = users.equals(user);
    boolean actualResult = false;
    Assert.assertEquals(expectedResult, actualResult);

}
     @Test
    public void testHashcode1(){
        Set<User> users = new HashSet<>();
        users.add(new User("qqq", "qwe", 1, 13, "22d"));
        Set<User> user = new HashSet<>();
        Set<User> user1 = new HashSet<>();
        user.add(new User("hjk", "dfgh", 12, 12, "ddd"));
        user1.add(new User("hjk", "dfgh", 12, 12, "ddd"));
        Assert.assertTrue(user1.hashCode()==user.hashCode());


    }
    @Test
    public void testHashcode2(){
        Set<User> users = new HashSet<>();
        users.add(new User("qqq", "qwe", 1, 13, "22d"));
        Set<User> user = new HashSet<>();
        Set<User> user1 = new HashSet<>();
        user.add(new User("hjk", "dfgh", 12, 12, "ddd"));
        user1.add(new User("hjk", "dfgh", 12, 12, "ddd"));
        Assert.assertFalse(user1.hashCode()!=user.hashCode());


    }

}