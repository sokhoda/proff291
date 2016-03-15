/**
 * Created by i.gonchar on 3/11/2016.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        LoginInvalidTest.class,
        AddClientTest.class
})
public class JunitTestSuite {
}
