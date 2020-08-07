package comp3350.mbs;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import comp3350.mbs.acceptance.CreateOrderTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({CreateOrderTest.class})
public class RunAcceptanceTests
{
    public RunAcceptanceTests()
    {
        System.out.println("Sample Acceptance tests");
    }
}
