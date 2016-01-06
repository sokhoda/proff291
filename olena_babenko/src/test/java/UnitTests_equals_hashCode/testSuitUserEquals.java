package UnitTests_equals_hashCode;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by lenchi on 23.12.15.
 *
 * This UnitTests_equals_hashCode suit contains positive (returned true)
 * and negative (returned false) testing of equals method
 */

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            testUserEqualsPositive.class,
            testUserEqualsNegative.class,
            //testUserEqualsConsistency.class
    })
    public class testSuitUserEquals {

    }

