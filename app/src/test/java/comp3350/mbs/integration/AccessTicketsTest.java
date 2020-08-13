package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTicketsTest extends TestCase {

    public AccessTicketsTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testAccessTickets(){
        AccessTickets at;
        Ticket ticket = null;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessTickets to persistence layer\n");

        Services.createDataAccess(new DataAccessStub());

        at = new AccessTickets();

        ticket = at.getTicket("Avengers Endgame");
        assertNotNull( ticket );

        assertTrue( ticket.getMovieName().equals( "Avengers Endgame") );
        assertTrue( ticket.getPrice() == 10.0);
        assertTrue( ticket.getPriceAsString().equals( "10.00") );

        ticket = at.getTicket( "Garfield"); //the movie "Garfield" doesn't exist
        assertNull( ticket );

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessTickets to persistence layer\n");
    }
}