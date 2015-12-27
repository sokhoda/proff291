package session2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavel on 20.12.2015.
 */
public class AuthTest {
    private Auth module;

    @Before
    public void setUp(){
        module = new Auth();
    }

    @Test
    public void test_isAuthenticated(){
        Map<String, String> users = new HashMap<String, String>();
        users.put("l1", "2");
        module.setUsers(users);
        boolean expectedRes = true;
        boolean actualRes = module.isAuthenticated("l1");

        Assert.assertEquals(expectedRes, actualRes);
    }
}
