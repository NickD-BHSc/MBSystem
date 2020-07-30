package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessViewingTimesTest extends TestCase {

    private static String dbName = Main.dbName;
    private AccessViewingTimes accessViewingTime;
    private List<ViewingTime>viewingTimeList;
    private ViewingTime viewingTime;

    public void setUp(){
        accessViewingTime = null;
        viewingTimeList = null;
        viewingTime = null;
    }//end setUp


    @Test
    public void testGetViewingTimeListForTheatre1Movie1(){

        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Scotiabank Theatre","Avengers Endgame");
        assertNotNull(viewingTimeList);
        assertEquals(5,viewingTimeList.size());//5 viewing times for Avengers Endgame at Scotiabank Theatre

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("1:00 to 4:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("4:30 to 7:30 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("8:00 to 11:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //fourth viewing time
        viewingTime = viewingTimeList.get(3);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("5:00 to 8:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //fifth viewing time
        viewingTime = viewingTimeList.get(4);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("9:00 to 12:00 AM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie1\n");

    }//end testGetViewingTimeListForTheatre1Movie1


    @Test
    public void testGetViewingTimeListForTheatre1Movie2(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie2");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Scotiabank Theatre","The Incredibles");
        assertNotNull(viewingTimeList);
        assertEquals(3,viewingTimeList.size());//3 viewing times for The Incredibles at Scotiabank Theatre

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("4:00 to 6:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie2\n");
    }//end testGetViewingTimeListForTheatre1Movie2


    @Test
    public void testGetViewingTimeListForTheatre1Movie3(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie3");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Scotiabank Theatre","Superman");
        assertNotNull(viewingTimeList);
        assertEquals(4,viewingTimeList.size());//4 viewing times for Superman at Scotiabank Theatre

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("5:00 to 7:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //fourth viewing time
        viewingTime = viewingTimeList.get(3);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("9:00 to 11:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie3\n");
    }//end testGetViewingTimeListForTheatre1Movie3


    @Test
    public void testGetViewingTimeListForTheatre1Movie4(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie4");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Scotiabank Theatre","The Lion King");
        assertNotNull(viewingTimeList);
        assertEquals(3,viewingTimeList.size());//3 viewing times for The Lion King at Scotiabank Theatre

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Lion King",viewingTime.getMovieName());
        assertEquals("4:00 to 6:30 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Lion King",viewingTime.getMovieName());
        assertEquals("7:00 to 9:30 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("The Lion King",viewingTime.getMovieName());
        assertEquals("4:00 to 6:30 PM",viewingTime.getShowTime());
        assertEquals("June 13, 2020, Thursday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie4\n");

    }//end testGetViewingTimeListForTheatre1Movie4


    @Test
    public void testGetViewingTimeListForTheatre1Movie5(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie5");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Scotiabank Theatre","Star Wars");
        assertNotNull(viewingTimeList);
        assertEquals(2,viewingTimeList.size());//2 viewing times for Star Wars at Scotiabank Theatre

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Star Wars",viewingTime.getMovieName());
        assertEquals("11:30 to 2:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Scotiabank Theatre",viewingTime.getTheatreName());
        assertEquals("Star Wars",viewingTime.getMovieName());
        assertEquals("5:00 to 7:30 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre1Movie5\n");

    }//end testGetViewingTimeListForTheatre1Movie5


    @Test
    public void testGetViewingTimeListForTheatre2Movie1(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre2Movie1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Cinema City Northgate","Avengers Endgame");
        assertNotNull(viewingTimeList);
        assertEquals(2,viewingTimeList.size());//2 viewing times for Avengers Endgame at Cinema City Northgate

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Cinema City Northgate",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("5:00 to 8:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Cinema City Northgate",viewingTime.getTheatreName());
        assertEquals("Avengers Endgame",viewingTime.getMovieName());
        assertEquals("7:00 to 10:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre2Movie1\n");

    }//end testGetViewingTimeListForTheatre2Movie1


    @Test
    public void testGetViewingTimeListForTheatre2Movie2(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre2Movie1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Cinema City Northgate","The Incredibles");
        assertNotNull(viewingTimeList);
        assertEquals(3,viewingTimeList.size());//3 viewing times for The Incredibles at Cinema City Northgate

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Cinema City Northgate",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Cinema City Northgate",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("4:00 to 6:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Cinema City Northgate",viewingTime.getTheatreName());
        assertEquals("The Incredibles",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());


        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre2Movie1\n");

    }//end testGetViewingTimeListForTheatre2Movie2

    @Test
    public void testGetViewingTimeListForTheatre3Movie1(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Silver City St.Vital Cinemas","Superman");
        assertNotNull(viewingTimeList);
        assertEquals(4,viewingTimeList.size());//4 viewing times for Superman at Silver City St.Vital Cinemas

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("8:00 to 10:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //third viewing time
        viewingTime = viewingTimeList.get(2);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("1:00 to 3:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //fourth viewing time
        viewingTime = viewingTimeList.get(3);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("Superman",viewingTime.getMovieName());
        assertEquals("5:00 to 7:00 PM",viewingTime.getShowTime());
        assertEquals("June 12, 2020, Wednesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());


        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie1\n");
    }//end testGetViewingTimeListForTheatre3Movie1


    @Test
    public void testGetViewingTimeListForTheatre3Movie2(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie2");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Silver City St.Vital Cinemas","The Lion King");
        assertNotNull(viewingTimeList);
        assertEquals(2,viewingTimeList.size());//2 viewing times for The Lion King at Silver City St.Vital Cinemas


        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("The Lion King",viewingTime.getMovieName());
        assertEquals("12:00 to 2:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        //second viewing time
        viewingTime = viewingTimeList.get(1);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("The Lion King",viewingTime.getMovieName());
        assertEquals("7:00 to 9:00 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie2\n");
    }//end testGetViewingTimeListForTheatre3Movie2


    @Test
    public void testGetViewingTimeListForTheatre3Movie3() {
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie3");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();
        viewingTimeList = accessViewingTime.getViewingTimeList("Silver City St.Vital Cinemas","Star Wars");
        assertNotNull(viewingTimeList);
        assertEquals(1,viewingTimeList.size());//2 viewing times for Star Wars at Silver City St.Vital Cinemas

        //first viewing time
        viewingTime = viewingTimeList.get(0);
        assertNotNull(viewingTime);
        assertEquals("Silver City St.Vital Cinemas",viewingTime.getTheatreName());
        assertEquals("Star Wars",viewingTime.getMovieName());
        assertEquals("7:00 to 9:30 PM",viewingTime.getShowTime());
        assertEquals("June 11, 2020, Tuesday",viewingTime.getShowDate());
        assertEquals("00000000000000000000000000000000",viewingTime.getSeatString());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForTheatre3Movie3\n");

    }//end testGetViewingTimeListForTheatre3Movie3


    @Test
    public void testGetViewingTimeListForInvalidTheatreMovies(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForInvalidTheatreMovies");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessViewingTime = new AccessViewingTimes();

        viewingTimeList = accessViewingTime.getViewingTimeList("XTheatre","XMovie");
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());

        viewingTimeList = accessViewingTime.getViewingTimeList("","");
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());

        viewingTimeList = accessViewingTime.getViewingTimeList("testTheatre","testMovie");
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());

        viewingTimeList = accessViewingTime.getViewingTimeList("SiLvEr CITy St.Vital CiNeMas","Star Wars");
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());

        viewingTimeList = accessViewingTime.getViewingTimeList("Silver City St.Vital Cinemas","Avengers Endgame");
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForInvalidTheatreMovies\n");
    }//end testGetViewingTimeListForInvalidTheatreMovies


    @Test
    public void testGetViewingTimeListForNull(){
        Services.closeDataAccess();
        System.out.println("Starting AccessViewingTimesTest: testGetViewingTimeListForNull");
        Services.createDataAccess(new DataAccessStub(dbName));
        accessViewingTime = new AccessViewingTimes();

        viewingTimeList = accessViewingTime.getViewingTimeList(null,null);
        assertNotNull(viewingTimeList);
        assertEquals(0,viewingTimeList.size());


        Services.closeDataAccess();
        System.out.println("Finished AccessViewingTimesTest: testGetViewingTimeListForNull\n");
    }//end testGetViewingTimeListForNull

}//end AccessViewingTimeTests
