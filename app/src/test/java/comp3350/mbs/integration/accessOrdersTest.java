package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.business.AccessTheatres;
import comp3350.mbs.business.AccessViewingTimes;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;


public class accessOrdersTest extends TestCase {

    public accessOrdersTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testAccessOrders() {
        AccessOrders ao;
        Order order;
        List<Order> orderList;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessOrders to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        ao = new AccessOrders();

        //order list should be empty, no orders have been added
        orderList = ao.getOrderList();
        assertTrue(orderList.isEmpty()); //must be empty

        //test addOrder()
        order = new Order("Avengers", "7:00 to 9:00PM", "Friday, August 7th", "Happy Theatre", 2);
        ao.insertNewOrder(order);
        orderList = ao.getOrderList();
        assertTrue( orderList.get(0).equals( order ) ); //order from get call should be the same as ours

        //test deleteOrder()
        ao.deleteOrder( order );
        orderList = ao.getOrderList();
        assertTrue( orderList.isEmpty() ); //our order should be removed so the list should be empty

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessOrders to persistence layer\n");
    }

//    @Test
//    public void testAccessSeats(){
//        AccessSeats as;
//        ViewingTime vt;
//        String seatString;
//
//        Services.closeDataAccess();
//
//        System.out.println("Starting Integration test for AccessSeats to persistence layer\n");
//
//        Services.createDataAccess(Main.dbName);
//
//        as = new AccessSeats();
//
//        vt = new ViewingTime("Scotiabank Theatre", "Avengers Endgame", "1:00 to 4:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
//        seatString = "10000000000000000000000000000000";
//
//        as.updateSeatList(vt, seatString);
//        //assertEquals();
//        Services.closeDataAccess();
//
//        System.out.println("\nFinished Integration test of AccessOrders to persistence layer\n");
//    }

    public void testAccessViewingTimes(){
        AccessViewingTimes avt;
        String theatreName, movieName;
        List<ViewingTime> viewingTime;

        Services.closeDataAccess();

        System.out.println("Starting Integration test for AccessViewingTimes to persistence layer\n");

        Services.createDataAccess(Main.dbName);

        theatreName = "Scotiabank Theatre";
        movieName = "Avengers Endgame";
        String showTime = "1:00 to 4:00 PM";

        avt = new AccessViewingTimes();

        viewingTime = avt.getViewingTimeList(theatreName, movieName);
        assertEquals(viewingTime.get(0).getShowTime(), showTime);
        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessViewingTimes to persistence layer\n");

        //okay, i think i get how these integration tests work now. It's all about testing the access methods with the DataAccessObject and seeing if it retrieves what you expect it to retrieve
        //from the database and compare it to a hardcoded expected value.
    }

    public void testAccessTheatres(){
        Theatre t = new Theatre("TestTheatre1", "Location1", "45km");

    }
}
