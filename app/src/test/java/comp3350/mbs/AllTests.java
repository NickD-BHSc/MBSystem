package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.CalculateTotalsTest;
import comp3350.mbs.objects.TicketTest;

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
    }

    private static void testBusiness()
    {
        suite.addTestSuite(CalculateTotalsTest.class);
    }

}