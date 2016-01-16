package session1;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import session2.MapAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.12.15
 */
public class MapAuthTest {
    private MapAuth module;

    @Before
    public void setUp() {
       module = new MapAuth();
    }

    @Test(expected = Exception.class)
    public void testIsAuthenticatedExists() {
        Map<String, String> users = new HashMap<>();
        users.put("1", "1");
        module.setUsers(users);

        boolean actualResult = module.isAuthenticated("1", "1");
        boolean expectedResult = false;
        Assert.assertEquals(expectedResult, actualResult);
    }
}
