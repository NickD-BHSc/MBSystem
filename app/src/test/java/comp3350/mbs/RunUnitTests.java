package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.AccessOrdersTest;
import comp3350.mbs.business.AccessReviewsTest;
import comp3350.mbs.business.AccessTheatreMoviesTest;
import comp3350.mbs.business.AccessTheatresTest;
import comp3350.mbs.business.AccessTicketsTest;
import comp3350.mbs.business.AccessTrailerTest;
import comp3350.mbs.business.AccessViewingTimesTest;
import comp3350.mbs.business.CalculateTest;
import comp3350.mbs.business.CreditCardValidationTest;
import comp3350.mbs.business.ReviewValidationTest;
import comp3350.mbs.business.SeatEncodingTest;
import comp3350.mbs.objects.OrderTest;
import comp3350.mbs.objects.ReviewTest;
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
public class RunUnitTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {

        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        testPersistence();
        return suite;

    }

    private static void testObjects(){

        suite.addTestSuite(SeatingTest.class);
        suite.addTestSuite(TheatreMoviesTest.class);
        suite.addTestSuite(TheatreTest.class);
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite(ViewingTimeTest.class);
        suite.addTestSuite(OrderTest.class);
        suite.addTestSuite(ReviewTest.class);

    }

    private static void testBusiness() {

        suite.addTestSuite(CalculateTest.class);
        suite.addTestSuite(CreditCardValidationTest.class);
        suite.addTestSuite(ReviewValidationTest.class);
        suite.addTestSuite(AccessTheatreMoviesTest.class);
        suite.addTestSuite(AccessTheatresTest.class);
        suite.addTestSuite(AccessTicketsTest.class);
        suite.addTestSuite(AccessTrailerTest.class);
        suite.addTestSuite(AccessViewingTimesTest.class);
        suite.addTestSuite(AccessOrdersTest.class);
        suite.addTestSuite(SeatEncodingTest.class);
        suite.addTestSuite(AccessReviewsTest.class);

    }

    private static void testPersistence(){
        suite.addTestSuite(DataAccessTest.class);
    }

}