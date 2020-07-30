package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.AccessTheatreMoviesTest;
import comp3350.mbs.business.AccessTheatresTest;
import comp3350.mbs.business.CalculateTest;
import comp3350.mbs.business.CreditCardValidationTest;
import comp3350.mbs.business.SeatEncodingTest;
import comp3350.mbs.business.TrailerTest;
import comp3350.mbs.objects.SeatingTest;
import comp3350.mbs.objects.TheatreMoviesTest;
import comp3350.mbs.objects.TheatreTest;
import comp3350.mbs.objects.TicketTest;
import comp3350.mbs.objects.ViewingTimeTest;
import comp3350.mbs.persistence.DataAccessTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AllTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        testPersistence();
        return suite;
    }

    private static void testObjects() {
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite( SeatingTest.class);
        suite.addTestSuite(TheatreTest.class);
        suite.addTestSuite(ViewingTimeTest.class);
        suite.addTestSuite(TheatreMoviesTest.class);
    }

    private static void testBusiness() {
        suite.addTestSuite(CalculateTest.class);
        suite.addTestSuite(CreditCardValidationTest.class);
        suite.addTestSuite(TrailerTest.class);
        suite.addTestSuite(AccessTheatresTest.class);
        suite.addTestSuite(AccessTheatreMoviesTest.class);
        suite.addTestSuite(SeatEncodingTest.class);
    }

    private static void testPersistence(){
        suite.addTestSuite(DataAccessTest.class);
    }

}