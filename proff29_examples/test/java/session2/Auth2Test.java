package session2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import java.util.Map;

/**
 * Created by Юлия on 20.12.2015.
 */
public class Auth2Test {
    private Auth2 module;

    @Before
    public void setUp() {
        module = new Auth2();

    }

    @Test(expected=Exception.class)
    public void testIsAuthentification() {
        Map<String, String> users = new HashMap<>();
        users.put("1", "1");
        module.setUser(users);
        boolean actualResult = module.isAuthentification("1", "1");
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
