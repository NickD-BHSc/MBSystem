package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Order;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessOrdersTest extends TestCase {

    private static String dbName = Main.dbName;
    private  AccessOrders accessOrders;
    private List<Order> orderList;
    private Order order;

    public AccessOrdersTest(String arg0){
        super(arg0);
    }//end AccessOrdersTest

    public void setUp(){
        accessOrders = null;
        orderList = null;
        order = null;
    }//end setUp

    @Test
    public void testValidInsert(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testValidInsert");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();

        order = new Order("testMovie","testShowTime", "testShowDate", "testTheatre", 1);
        accessOrders.insertNewOrder(order);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals( beforeSize+1, afterInsertSize);

        accessOrders.deleteOrder(order);
        orderList = accessOrders.getOrderList();
        int afterDeleteSize = orderList.size();

        assertEquals(beforeSize, afterDeleteSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testValidInsert");

    }//end testValidInsert


    @Test
    public void testInvalidInsertNull(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testInvalidInsertNull");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();
        accessOrders.insertNewOrder(null);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals(beforeSize, afterInsertSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testInvalidInsertNull");

    }//end testValidInsertNull

    @Test
    public void testInvalidInsertMovieName(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testInvalidInsertMovieName");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();
        order = new Order(null,"testShowTime", "testShowDate", "testTheatre", 1);
        accessOrders.insertNewOrder(order);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals(beforeSize, afterInsertSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testInvalidInsertMovieName");

    }//end testInvalidInsertMovieName

    @Test
    public void testInvalidInsertShowTime(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testInvalidInsertShowTime");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();
        order = new Order("testMovie",null, "testShowDate", "testTheatre", 1);
        accessOrders.insertNewOrder(order);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals(beforeSize, afterInsertSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testInvalidInsertShowTime");

    }//end testInvalidInsertShowTime

    @Test
    public void testInvalidInsertShowDate(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testInvalidInsertShowDate");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();
        order = new Order("testMovie", "testShowTime", null,  "testTheatre", 1);
        accessOrders.insertNewOrder(order);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals(beforeSize, afterInsertSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testInvalidInsertShowDate");

    }//end testInvalidInsertShowDate

    @Test
    public void testInvalidInsertTheatreName(){

        Services.closeDataAccess();
        System.out.println("Starting AccessOrderTest: testInvalidInsertTheatreName");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessOrders = new AccessOrders();
        orderList = accessOrders.getOrderList();

        int beforeSize = orderList.size();
        order = new Order("testMovie", "testShowTime", "testShowDate",  null, 1);
        accessOrders.insertNewOrder(order);

        orderList = accessOrders.getOrderList();
        int afterInsertSize = orderList.size();

        assertEquals(beforeSize, afterInsertSize);

        Services.closeDataAccess();
        System.out.println("Finished AccessOrderTest: testInvalidInsertTheatreName");

    }//end testInvalidInsertTheatreName
}
