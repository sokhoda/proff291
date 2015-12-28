package UnitTests_equals_hashCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lenchi on 23.12.15.
 */
public class testUserEqualsPositive {
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();

    //method for user creation
    private void setUsr(User user){
        user.setLogin("Test1");
        user.setPassword("TestTest");
        user.setRegdate(10.02);
        user.setRating(3);
        user.setSex(true);
    }

    @Before
    public void before() {
        //user1 = user2
        setUsr(user1);
        setUsr(user2);

    }

    //verify equality for users (not null login, pass and reg data; all fields are equal)
    @Test
    public void isEqualUsers(){
        Assert.assertTrue(user1.equals(user2));
    }

    //verify reflection of equals method, i.e.
    //condition in overriden method 'if (this==o) return true;'
    @Test
    public void isReflective(){
        Assert.assertTrue(user1.equals(user1));
    }

    //symmetric: for any non-null reference values x and y, x.equals(y)
    // should return true if and only if y.equals(x) returns true.
    @Test
    public void isSymmetrical() {
        Assert.assertEquals(user1.equals(user2), user2.equals(user1));
    }

    // transitive: for any non-null reference values x, y, and z,
    // if x.equals(y) returns true and y.equals(z) returns true,
    // then x.equals(z) should return true.
    @Test
    public void isTransitiveUsr123Equal(){
        //User user3 = new User("Test1", "TestTest",10.02,3,true);
        setUsr(user3);
        Assert.assertTrue(user1.equals(user2));
        Assert.assertTrue(user2.equals(user3));
        Assert.assertTrue(user1.equals(user3));
    }

}
