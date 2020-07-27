package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class TicketTest extends TestCase {

    public TicketTest(String arg0)
    {
        super(arg0);
    }



    @Test
    public void testTicket1()
    {
        Ticket ticket;

        System.out.println("\nStarting testTicket1");

        ticket = new Ticket(0, "General Admission", 10);
        assertNotNull(ticket);
        assertEquals(0.0, ticket.getPrice());
        assertTrue("0.00".equals(ticket.getPriceAsString()));
        assertTrue("General Admission".equals(ticket.getMovieName()));
        assertEquals(10, ticket.getQuantity());

        System.out.println("Finished testTicket1");
    }

    @Test
    public void testTicket2()
    {
        Ticket ticket;

        System.out.println("\nStarting testTicket2");

        ticket = new Ticket(5.00, "General Admission");
        assertNotNull(ticket);
        assertEquals(5.0, ticket.getPrice());
        assertTrue("5.00".equals(ticket.getPriceAsString()));
        assertTrue("General Admission".equals(ticket.getMovieName()));
        assertEquals(1, ticket.getQuantity());

        System.out.println("Finished testTicket2");
    }

}
