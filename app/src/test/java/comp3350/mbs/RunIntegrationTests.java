package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.integration.accessOrdersTest;
import comp3350.mbs.integration.accessTicketsTest;
import comp3350.mbs.integration.accessViewingTimesTest;

public class RunIntegrationTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {

        suite = new TestSuite("Integration tests");
        testIntegration();
        return suite;

    }

    private static void testIntegration(){
        suite.addTestSuite( accessOrdersTest.class);
        suite.addTestSuite( accessViewingTimesTest.class);
        suite.addTestSuite( accessTicketsTest.class);

    }
}
