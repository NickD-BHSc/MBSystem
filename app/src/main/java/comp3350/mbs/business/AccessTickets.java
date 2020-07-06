package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTickets {

    private DataAccessStub dataAccess;
    private List<Ticket> tickets;
    private Ticket ticket;
    private String currentTicket;

    public AccessTickets()
    {
        dataAccess = (DataAccessStub) Services.getDataAccessService(Main.dbName);
        tickets = null;
        ticket = null;
        currentTicket = " ";
    }

    public Ticket getTicket(String ticketType)
    {
        return dataAccess.getTicket(ticketType);
    }

}
