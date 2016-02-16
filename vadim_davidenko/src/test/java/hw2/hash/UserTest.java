package hw2.hash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by v.davidenko on 21.12.2015.
 */
public class UserTest {

    private User user;

    private final String PASSWORD = "test_password";
    private final String LOGIN = "test_login";
    private final Date REG_DATE = new Date();
    private final Double RATE = 1.0;
    private final boolean SEX = true;

    @Before
    public void setUp() throws Exception {
        user = new User(LOGIN, PASSWORD, REG_DATE, RATE, SEX);
    }

    // Tests for method "equals"
    /////////////////////////////////////////////////////////////

    @Test
    public void testEqualsByVal() throws Exception {
        User testUser = new User(LOGIN, PASSWORD, REG_DATE, RATE, SEX);
        boolean actualResult = user.equals(testUser);
        Assert.assertTrue(actualResult);
        System.out.println("Test Equals by values - OK");
    }

    @Test
    public void testEqualsByRef() throws Exception {
        User testUser = user;
        boolean actualResult = user.equals(testUser);
        Assert.assertTrue(actualResult);
        System.out.println("Test Equals by references - OK");
    }

    @Test
    public void testNotEqualsByLogin() throws Exception {
        User testUser = new User(LOGIN + "*", PASSWORD, REG_DATE, RATE, SEX);
        boolean actualResult = user.equals(testUser);
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by login - OK");
    }

    @Test
    public void testNotEqualsByPassword() throws Exception {
        User testUser = new User(LOGIN, PASSWORD + "*", REG_DATE, RATE, SEX);
        boolean actualResult = user.equals(testUser);
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by password - OK");
    }

    @Test
    public void testNotEqualsByRegDate() throws Exception {
        User testUser = new User(LOGIN, PASSWORD, new Date(System.currentTimeMillis() + 1), RATE, SEX);
        boolean actualResult = user.equals(testUser);
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by registration date - OK");
    }

    @Test
    public void testNotEqualsByRate() throws Exception {
        User testUser = new User(LOGIN, PASSWORD, REG_DATE, RATE + 0.1, SEX);
        boolean actualResult = user.equals(testUser);
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by rate - OK");
    }

    @Test
    public void testNotEqualsBySex() throws Exception {
        User testUser = new User(LOGIN, PASSWORD, REG_DATE, RATE, false);
        boolean actualResult = user.equals(testUser);
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by sex - OK");
    }

    @Test
    public void testNotEqualsByObject() throws Exception {
        boolean actualResult = user.equals(new Object());
        Assert.assertFalse(actualResult);
        System.out.println("Test Not Equals by incompatible type - OK");
    }

    // Tests for method "hashCode"
    /////////////////////////////////////////////////////////////

    @Test
    public void testHashCodeCompare() throws Exception {
        Integer hashCodeUser = user.hashCode();

        User testUser = new User(LOGIN, PASSWORD, REG_DATE, RATE, SEX);
        Integer hashCodeTestUser = testUser.hashCode();

        if (user.equals(testUser)) {
            Assert.assertEquals(hashCodeUser, hashCodeTestUser);
        }
        System.out.println("Test HashCode comparing - OK, hashCode = " + hashCodeUser.toString());
    }

    @Test
    public void testHashCodeRepeat() throws Exception {
        Integer hashCode1 = user.hashCode();
        Thread.sleep(100);
        Integer hashCode2 = user.hashCode();

        Assert.assertEquals(hashCode1, hashCode2);
        System.out.println("Test HashCode repeating - OK, hashCode = " + hashCode2.toString());
    }

}
