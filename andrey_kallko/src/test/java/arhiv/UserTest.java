package arhiv;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import java.util.GregorianCalendar;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import arhiv.User;

public class UserTest {
    private User module;

    public UserTest() {
    }

    @Before
    public void setUp() {
        this.module = new User();
    }

    @Test
    public void test() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        User eve = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        this.module = adam;
        boolean expectedResult = true;
        boolean actualResult = this.module.equals(eve);
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Test 1 complete");
    }

    @Test
    public void test2() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        User eve = new User("eve", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        this.module = adam;
        boolean expectedResult = false;
        boolean actualResult = this.module.equals(eve);
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Test 2 complete");
    }

    @Test
    public void test3() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        User eve = new User();
        this.module = adam;
        boolean expectedResult = false;
        boolean actualResult = this.module.equals(eve);
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Test 3 complete");
    }

    @Test
    public void test4() {
        new User();
        User adam = new User();
        this.module = adam;
        boolean expectedResult = false;
        boolean actualResult = this.module.equals((Object)null);
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("Test 4 complete");
    }

    @Test
    public void test5() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        User eve = new User("eve", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        this.module = adam;
        int code1 = this.module.hashCode();
        int code2 = eve.hashCode();
        boolean expected = false;
        boolean actual = code1 == code2;
        Assert.assertEquals(expected, actual);
        System.out.println("Test 5 complete");
    }

    @Test
    public void test6() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        User eve = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        this.module = adam;
        int code1 = this.module.hashCode();
        int code2 = eve.hashCode();
        boolean expected = true;
        boolean actual = code1 == code2;
        Assert.assertEquals(expected, actual);
        System.out.println("Test 6 complete");
    }

    @Test
    public void test7() {
        User adam = new User("adam", "pass", new GregorianCalendar(2013, 11, 25), 11.3D, true);
        this.module = adam;
        int code1 = this.module.hashCode();
        int code2 = adam.hashCode();
        boolean expected = true;
        boolean actual = code1 == code2;
        Assert.assertEquals(expected, actual);
        System.out.println("Test 7 complete");
    }
}
