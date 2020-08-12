package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.integration.AccessTheatreMovies;
import comp3350.mbs.integration.AccessTheatresTest;
import comp3350.mbs.integration.DataAccessHSQLDBTest;
import comp3350.mbs.integration.AccessTicketsTest;
import comp3350.mbs.integration.AccessViewingTimesTest;

public class RunIntegrationTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {

        suite = new TestSuite("Integration tests");
        testIntegration();
        return suite;

    }

    private static void testIntegration(){
        suite.addTestSuite( AccessViewingTimesTest.class);
        suite.addTestSuite( AccessTicketsTest.class);
        suite.addTestSuite( AccessTheatreMovies.class);
        suite.addTestSuite( AccessTheatresTest.class);
        suite.addTestSuite(DataAccessHSQLDBTest.class);

    }
}
