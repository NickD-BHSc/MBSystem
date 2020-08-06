package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.integration.accessOrdersTest;

public class RunIntegrationTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {

        suite = new TestSuite("All tests");
        testIntegration();
        return suite;

    }

    private static void testIntegration(){
        suite.addTestSuite( accessOrdersTest.class);

    }
}
