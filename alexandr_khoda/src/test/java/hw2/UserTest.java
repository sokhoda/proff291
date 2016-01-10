package hw2;

import hw2.hash.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Created by s_okhoda on 28.12.2015.
 */
public class UserTest {
    private User module;
    private User user1;

   @Before
    public void setUp(){
       module = new User("pastorial","1",new GregorianCalendar(2015,1,22));
        user1 = new User("pastorial","1",new GregorianCalendar(2015,1,22),0,false);
//       System.out.println(module.getRate() + " " + user1.getRate());
    }
    @Test
    public void testEquals(){
        System.out.println("testEquals");
        boolean actualResult = module.equals(user1);
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testHashCode(){
        System.out.println("testHashCode");
        boolean actualResult = module.hashCode()==user1.hashCode();
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }

}
