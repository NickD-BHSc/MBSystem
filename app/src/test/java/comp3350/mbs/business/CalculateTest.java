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

    public CalculateTest(String arg0){
        super(arg0);
    }//end CalculateTest

    public void setUp(){
        resultTotal = "";
        list = null;
        ticket = null;
    }//end setUp

    @Test
    public void testNullListTotal(){

        System.out.println("Starting CalculateTest: testNullListTotal");

        resultTotal = Calculate.calculateTotal(null);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullListTotal\n");

    }//end testNullListTotal

    @Test
    public void testNullListSubtotal(){

        System.out.println("Starting CalculateTest: testNullListSubtotal");

        resultTotal = Calculate.calculateSubtotal(null);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullListSubtotal\n");

    }//end testNullListSubtotal

    @Test
    public void testNullListTax(){

        System.out.println("Starting CalculateTest: testNullListTax");

        resultTotal = Calculate.calculateTax(null);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullListTax\n");

    }//end testNullListTax

    @Test
    public void testEmptyListTotal(){

        System.out.println("Starting CalculateTest: testEmptyListTotal");

        resultTotal = " ";
        list = new ArrayList<>();
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testEmptyListTotal\n");

    }//end testEmptyListTotal

    @Test
    public void testEmptyListSubtotal(){

        System.out.println("Starting CalculateTest: testEmptyListSubtotal");

        resultTotal = " ";
        list = new ArrayList<>();
        resultTotal = Calculate.calculateSubtotal(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testEmptyListSubtotal\n");

    }//end testEmptyListSubtotal

    @Test
    public void testEmptyListTax(){

        System.out.println("Starting CalculateTest: testEmptyListTax");

        resultTotal = " ";
        list = new ArrayList<>();
        resultTotal = Calculate.calculateTax(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testEmptyListTax\n");

    }//end testEmptyListTax

    @Test
    public void testNullObjectTotal(){

        System.out.println("Starting CalculateTest: testNullObjectTotal");

        list = new ArrayList<>();
        list.add(null);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullObjectTotal\n");

    }//end testNullObjectTotal

    @Test
    public void testNullObjectSubtotal(){

        System.out.println("Starting CalculateTest: testNullObjectSubtotal");

        resultTotal = " ";
        list = new ArrayList<>();
        list.add(null);
        resultTotal = Calculate.calculateSubtotal(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullObjectSubtotal\n");

    }//end testNullObjectSubtotal

    @Test
    public void testNullObjectTax(){

        System.out.println("Starting CalculateTest: testNullObjectTax");

        resultTotal = " ";
        list = new ArrayList<>();
        list.add(null);
        resultTotal = Calculate.calculateTax(list);
        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testNullObjectTax\n");

    }//end testNullObjectTax

    @Test
    public void testValidTotalOneTicket(){

        System.out.println("Starting CalculateTest: testValidTotalOneTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalOneTicket\n");

    }//end testValidTotalOneTicket

    @Test
    public void testValidSubtotalOneTicket(){

        System.out.println("Starting CalculateTest: testValidSubtotalOneTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateSubtotal(list);
        assertNotNull(resultTotal);
        assertTrue("10.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidSubtotalOneTicket\n");

    }//end testValidSubtotalOneTicket

    @Test
    public void testValidTaxOneTicket(){

        System.out.println("Starting CalculateTest: testValidTotalOneTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateTax(list);
        assertNotNull(resultTotal);
        assertTrue("1.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalOneTicket\n");

    }//end testValidTotalOneTicket


    @Test
    public void testValidTotalMultipleTickets(){

        System.out.println("Starting CalculateTest: testValidTotalMultipleTickets");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        list.add(ticket);
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("34.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalMultipleTickets\n");

    }//end testValidTotalMultipleTickets

    @Test
    public void testValidSubtotalMultipleTickets(){

        System.out.println("Starting CalculateTest: testValidSubtotalMultipleTickets");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        list.add(ticket);
        list.add(ticket);
        resultTotal = Calculate.calculateSubtotal(list);
        assertNotNull(resultTotal);
        assertTrue("30.00".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTotalMultipleTickets\n");

    }//end testValidTotalMultipleTickets

    @Test
    public void testValidTaxMultipleTickets(){

        System.out.println("Starting CalculateTest: testValidTaxMultipleTickets");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "Avengers Endgame");
        list.add(ticket);
        list.add(ticket);
        list.add(ticket);
        resultTotal = Calculate.calculateTax(list);
        assertNotNull(resultTotal);
        assertTrue("4.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTaxMultipleTickets\n");

    }//end testValidTotalMultipleTickets

    @Test
    public void testInvalidTicket(){

        System.out.println("Starting CalculateTest: testInvalidTicket");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(-10.00, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished CalculateTest: testInvalidTicket\n");

    }//end testInvalidTicket

    @Test
    public void testValidTicketTotalDecimalPlaces(){

        System.out.println("Starting CalculateTest: testValidTicketDecimalPlaces");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(8.99, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        assertNotNull(resultTotal);
        assertTrue("10.34".equals(resultTotal));
        System.out.println("Finished CalculateTest: testValidTicketDecimalPlaces\n");

    }//end testInvalidTicket

    @Test
    public void testValidTicketSubtotalDecimalPlaces(){

        System.out.println("Starting CalculateTest: testValidTicketSubtotalDecimalPlaces");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(8.99, "Avengers Endgame");
        list.add(ticket);
        resultTotal = Calculate.calculateTax(list);
        assertNotNull(resultTotal);
        assertTrue("1.35".equals(resultTotal));

        System.out.println("Finished CalculateTest: testValidTicketSubtotalDecimalPlaces\n");

    }//end testValidTicketSubtotalDecimalPlaces

}//end CalculateTest
