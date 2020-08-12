package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.AccessTheatreMoviesTest;
import comp3350.mbs.integration.AccessOrdersTest;
import comp3350.mbs.integration.AccessTheatresTest;
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
        suite.addTestSuite( accessViewingTimesTest.class);
        suite.addTestSuite( accessTicketsTest.class);
        suite.addTestSuite( AccessOrdersTest.class);
        suite.addTestSuite( AccessTheatreMoviesTest.class);
        suite.addTestSuite( AccessTheatresTest.class);


    }
}
