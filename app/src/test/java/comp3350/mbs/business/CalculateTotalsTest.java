package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;

import comp3350.mbs.objects.Ticket;

public class CalculateTotalsTest extends TestCase {

    public CalculateTotalsTest(String arg0)
    {
        super(arg0);
    }

    String resultTotal;
    ArrayList<Ticket> list;
    Ticket ticket;

    @Test
    public void testNullListTotal()
    {
        System.out.println("\nStarting testCalculateTotals: null list");

        resultTotal = " ";
        resultTotal = Calculate.calculateTotal(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: null list");
    }

    @Test
    public void testNullListSubtotal()
    {
        System.out.println("\nStarting testCalculateTotals:subtotal with null list");

        resultTotal = " ";
        resultTotal = Calculate.calculateSubtotal(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: subtotal null list");
    }

    @Test
    public void testNullListTaxTotal()
    {
        System.out.println("\nStarting testCalculateTotals:tax with null list");

        resultTotal = " ";
        resultTotal = Calculate.calculateTax(null);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: tax with null list");
    }

    @Test
    public void testEmptyListTotal()
    {
        System.out.println("\nStarting testCalculateTotals: empty list");

        resultTotal = " ";
        list = new ArrayList<>();
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: empty list");
    }

    @Test
    public void testNullObjectTotal()
    {
        System.out.println("\nStarting testCalculateTotals: list with a null object");

        resultTotal = " ";
        list = new ArrayList<>();
        list.add(null);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("0.00".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: list with a null object");
    }

    @Test
    public void testValidTotalOneTicket()
    {
        System.out.println("\nStarting testCalculateTotals: list with one valid object");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "General Admission");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: list with one valid object");
    }

    @Test
    public void testValidTotalMultipleTickets()
    {
        System.out.println("\nStarting testCalculateTotals: list with multiple valid objects");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(10.00, "General Admission");
        list.add(ticket);
        list.add(ticket);
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);

        assertNotNull(resultTotal);
        assertTrue("34.50".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: list with multiple valid objects");
    }

    @Test
    public void testInvalidTicket()
    {
        System.out.println("\nStarting testCalculateTotals: list with invalid objects");

        resultTotal = " ";
        list = new ArrayList<>();
        ticket = new Ticket(-10.00, "General Admission");
        list.add(ticket);
        resultTotal = Calculate.calculateTotal(list);
        System.out.println(resultTotal);
        assertNotNull(resultTotal);
        assertTrue("11.50".equals(resultTotal));

        System.out.println("Finished testCalculateTotals: list with invalid objects");
    }

}
