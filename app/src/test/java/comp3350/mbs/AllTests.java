package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.CalculateTotalsTest;
import comp3350.mbs.objects.MovieTest;
import comp3350.mbs.objects.SeatingTest;
import comp3350.mbs.objects.TheatreTest;
import comp3350.mbs.objects.TicketTest;
import comp3350.mbs.objects.ViewingTimeTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AllTests {

    public static TestSuite suite;

    public static junit.framework.Test suite()
    {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        return suite;
    }

    private static void testObjects()
    {
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite( SeatingTest.class);
        suite.addTestSuite(TheatreTest.class);
        suite.addTestSuite(MovieTest.class);
        suite.addTestSuite(ViewingTimeTest.class);
    }

    private static void testBusiness()
    {
        suite.addTestSuite(CalculateTotalsTest.class);
    }

}