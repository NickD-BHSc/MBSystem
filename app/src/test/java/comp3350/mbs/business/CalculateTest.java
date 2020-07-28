package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.objects.Ticket;

public class CalculateTest extends TestCase {

    private String resultTotal;
    private List<Ticket> list;
    private Ticket ticket;

    public CalculateTest(String arg0) {
        super(arg0);
    }


    public void setUp(){
        resultTotal = "";
        list = null;
        ticket = null;
    }//end setUp


    @Test
    public void testNullListTotal() {
        System.out.println("Starting CalculateTest: testNullListTotal");

        resultTotal = Calculate.calculateTotal(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullListTotal\n");
    }//end testNullListTotal


    @Test
    public void testNullListSubtotal() {
        System.out.println("Starting CalculateTest: testNullListSubtotal");

        resultTotal = " ";
        resultTotal = Calculate.calculateSubtotal(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullListSubtotal\n");
    }//end testNullListSubtotal


    @Test
    public void testNullListTaxTotal() {
        System.out.println("Starting CalculateTest: testNullLisTaxTotal");

        resultTotal = " ";
        resultTotal = Calculate.calculateTax(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullLisTaxTotal\n");
    }//end testNullListTaxTotal


    @Test
    public void testEmptyListTotal() {
        System.out.println("Starting CalculateTest: testEmptyListTotal");

        resultTotal = " ";
        list = new ArrayList<>();
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testEmptyListTotal\n");
    }//end testEmptyListTotal


    @Test
    public void testNullObjectTotal() {
        System.out.println("Starting CalculateTest: testNullObjectTotal");

        resultTotal = " ";
        list = new ArrayList<>();
        list.add(null);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullObjectTotal\n");
    }//end testNullObjectTotal


    @Test
    public void testValidTotalOneTicket() {
        System.out.println("Starting CalculateTest: testValidTotalOneTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "General Admission");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalOneTicket\n");
    }//end testValidTotalOneTicket


    @Test
    public void testValidTotalMultipleTickets() {
        System.out.println("Starting CalculateTest: testValidTotalMultipleTickets");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "General Admission");
        list.add(ticket);
        list.add(ticket);
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("34.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalMultipleTickets\n");
    }//end testValidTotalMultipleTickets


    @Test
    public void testInvalidTicket() {
        System.out.println("Starting CalculateTest: testInvalidTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(-10.00, "General Admission");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testInvalidTicket\n");
    }//end testValidTicket


}//end CalculateTest
