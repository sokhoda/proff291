package UnitTests_equals_hashCode;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by lenchi on 23.12.15.
 * TestRunner runs Positive and Negative UnitTests_equals_hashCode suites
 * for Equals and HashCode functions
 */
public class UserTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(testSuitUserEquals.class, testUserHashCode.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
