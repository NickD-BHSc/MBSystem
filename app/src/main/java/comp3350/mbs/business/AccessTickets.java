package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.persistence.DataAccess;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTickets {

    private DataAccess dataAccess;

    public AccessTickets()
    {
        dataAccess =  Services.getDataAccessService(Main.dbName);
    }

    public Ticket getTicket(String ticketType)
    {
        return dataAccess.getTicket(ticketType);
    }

    public List<Ticket> getAllTicketTypes(){return dataAccess.getTicketList();}
}
