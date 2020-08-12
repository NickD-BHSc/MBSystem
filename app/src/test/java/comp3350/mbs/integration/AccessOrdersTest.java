package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;
import comp3350.mbs.application.Services;
import comp3350.mbs.application.Main;
import comp3350.mbs.business.AccessOrders;
import comp3350.mbs.objects.Order;
import comp3350.mbs.persistence.DataAccessObject;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessOrdersTest extends TestCase {

    public AccessOrdersTest(String arg0){
        super( arg0 );
    }

    @Test
    public void testAccessOrders() {
        AccessOrders ao;
        Order order;
        List<Order> orderList;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessOrders to persistence layer\n");

        if( true )
            Services.createDataAccess(new DataAccessStub() );
        else
            Services.createDataAccess(new DataAccessObject( Main.dbName) );

        ao = new AccessOrders();

        //order list should be empty, no orders have been added
        orderList = ao.getOrderList();
        assertTrue(orderList.isEmpty()); //must be empty

        //test addOrder()
        order = new Order("Avengers", "7:00 to 9:00PM", "Friday, August 7th", "Happy Theatre", 2);
        ao.insertNewOrder(order);
        orderList = ao.getOrderList();
        assertTrue( orderList.get(0).equals( order ) ); //order from get call should be the same as ours

        //test invalid order deletion
        Order order2 = new Order( "Superman", "1:00 to 3:00PM", "Saturday, August 15th", "Happy Theatre", 3 );
        ao.deleteOrder( order2 );
        orderList = ao.getOrderList();
        assertTrue( orderList.size() == 1); //order list shouldn't have changed
        assertTrue( orderList.get(0).equals( order ) ); //order in the list should be the same

        //test valid order deletion
        ao.deleteOrder( order );
        orderList = ao.getOrderList();
        assertTrue( orderList.isEmpty() ); //our order should be removed so the list should be empty

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessOrders to persistence layer\n");
    }
}