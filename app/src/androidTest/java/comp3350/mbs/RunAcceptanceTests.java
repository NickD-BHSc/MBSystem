package comp3350.mbs;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import comp3350.mbs.acceptance.CreateOrderTest;
import comp3350.mbs.acceptance.ViewTicketTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({ViewTicketTest.class,CreateOrderTest.class})
public class RunAcceptanceTests {
    public RunAcceptanceTests() {
        System.out.println("Acceptance tests for ViewTicketTest, CreateOrderTest, CreateReviewTest.");
    }
}
