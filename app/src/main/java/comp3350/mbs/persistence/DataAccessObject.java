package comp3350.mbs.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.Review;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessObject implements DataAccess {

    //for database
    private Statement st1, st2, st3, st4, st5;
    private Connection c1;
    private ResultSet rs2, rs3;

    private String dbName;
    private String dbType;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF = "  ";

    //for objects
    private List<Theatre> theatreList;
    private List<TheatreMovies> theatreMoviesList;
    private List<ViewingTime> viewingTimeList;
    private List<Order> orderList;
    private List<Review> reviewList;

    /**
     * DatAccessObject Constructor - assign its field dbName to the given dbName.
     * @param dbName is the given database name.
     */
    public DataAccessObject(String dbName){
        this.dbName = dbName;
    }//end DataAccessObject

    /**
     * open - a method that opens the data from the database.
     * @param dbPath is the name of the database.
     */
    @Override
    public void open(String dbPath){

        String url;
        try{
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();//THEATRES TABLE
            st2 = c1.createStatement();//MOVIES TABLE
            st3 = c1.createStatement();//VIEWINGTIMES TABLE
            st4 = c1.createStatement();//TICKETS TABLE
            st5 = c1.createStatement();//REVIEWS TABLE

        }catch (Exception exception){
            processSQLError(exception);
        }

        System.out.println("Opened " +dbType +" database " +dbPath);
    }//end open

    /**
     * close - a method that closes the database.
     */
    @Override
    public void close(){
        try{
            cmdString = "shutdown compact";
            rs2 = st1.executeQuery(cmdString);
            c1.close();
        }catch (Exception exception){
            processSQLError(exception);
        }

        System.out.println("Closed " +dbType +" database " +dbName);
    }//end close

    /**
     * getTheatreList -a getter method for the theatreList field. Gets alls theatres from the theatres table
     * @return it will return the field theatreList.
     */
    @Override
    public List<Theatre> getTheatreList(){

        theatreList = new ArrayList<>();
        String name;
        String address;
        String distance;

        try{
            cmdString = "SELECT * FROM THEATRES";
            rs2 =st1.executeQuery(cmdString);

            while(rs2.next()){
                name =rs2.getString("NAME");
                address = rs2.getString("ADDRESS");
                distance = rs2.getString("DISTANCE");
                Theatre theatre = new Theatre(name,address,distance);
                theatreList.add(theatre);
            }

        }catch(Exception exception){
            processSQLError(exception);
        }
        return theatreList;
    }//end getTheatreList

    /**
     * getMoviesFromTheatre - a getter method that returns a list of movies from the given theatre.
     * @param theatreMovie is the given theatreMovie, that contains the theatre name.
     * @return it will return a list of movies that is contained in the given theatre.
     */
    @Override
    public List<TheatreMovies> getMoviesFromTheatre(TheatreMovies theatreMovie){

        theatreMoviesList = new ArrayList<>();

        TheatreMovies theatreMovies;
        String theatreName;
        String movieName;
        int moviePoster;
        String movieDescription;

        try{
            cmdString = "SELECT * FROM MOVIES WHERE THEATRENAME = " + "'" +theatreMovie.getTheatreName() + "'";
            rs2 = st2.executeQuery(cmdString);

            while(rs2.next()){
                theatreName = rs2.getString("THEATRENAME");
                movieName = rs2.getString("TITLE");
                moviePoster = rs2.getInt("POSTER");
                movieDescription = rs2.getString("DESCRIPTION");

                if(moviePoster == 0){
                    moviePoster = R.drawable.avengers_endgame;

                }else if(moviePoster == 1){
                    moviePoster = R.drawable.incredibles;

                }else if(moviePoster == 2){
                    moviePoster = R.drawable.lion_king;

                }else if(moviePoster == 3){
                    moviePoster = R.drawable.starwars;

                }else if(moviePoster == 4){
                    moviePoster = R.drawable.superman;

                }else{
                    moviePoster = R.drawable.ic_launcher_foreground;//show this to represent that the movie has no specific image.

                }

                theatreMovies = new TheatreMovies(theatreName,movieName,moviePoster,movieDescription);
                theatreMoviesList.add(theatreMovies);
            }
        }catch(Exception exception){
            processSQLError(exception);
        }

        return theatreMoviesList;
    }//end getMoviesFromTheatre

    /**
     * getViewingTimeList - a getter method that returns a list of movie show times for a given theatre and movie.
     * @param theatreMovie contains the name of the theatre and movie.
     * @return it will return a list of viewing time for the given theatre and movie.
     */
    @Override
    public List<ViewingTime> getViewingTimeList(TheatreMovies theatreMovie){

        viewingTimeList = new ArrayList<>();

        ViewingTime viewingTime;
        String theatreName;
        String movieName;
        String showDate;
        String showTime;
        String seatString;

        try{
            cmdString = "SELECT * FROM VIEWINGTIMES WHERE THEATRENAME = " + "'" + theatreMovie.getTheatreName() + "'" + " AND MOVIENAME = " + "'" + theatreMovie.getMovieName() + "'" + " ORDER BY DATE, TIME ASC";
            rs2 = st3.executeQuery(cmdString);

            while(rs2.next()){
                theatreName = rs2.getString("THEATRENAME");
                movieName = rs2.getString("MOVIENAME");
                showTime = rs2.getString("TIME");
                showDate = rs2.getString("DATE");
                seatString = rs2.getString( "SEATLIST");
                viewingTime = new ViewingTime(theatreName,movieName,showTime,showDate,seatString);
                viewingTimeList.add(viewingTime);

            }
        }catch (Exception exception){
            processSQLError(exception);
        }

        return viewingTimeList;
    }//end getViewingTimeList

    /**
     * getTicket -a getter method for a ticket with the movie provided from the list.
     * @param movie is the movie associated with the ticket.
     * @return it will return the ticket.
     */
    @Override
    public Ticket getTicket(String movie){

        Ticket ticket = null;
        String movieName;
        double price;

        try{
            cmdString = "SELECT * FROM TICKETS WHERE MOVIENAME = '"+ movie +"'";
            rs2 = st3.executeQuery(cmdString);
            while(rs2.next()){
                movieName = rs2.getString("MOVIENAME");
                price = rs2.getDouble("PRICE");
                ticket = new Ticket(price, movieName);

            }
        }catch (Exception exception){
            processSQLError(exception);
        }

        return ticket;
    }//end getTicket

    /**
     * updateSeatList - a method that updates the seat string of the given viewing time object.
     * @param viewingTime is the viewing time object that needs to be updated.
     * @param seatList - Seat string to change for the viewing time object's seat.
     * @return it will return "Success" if the seat in the ViewingTime got updated.
     *          Otherwise, it will return Failure.
     */
    @Override
    public String updateSeatList(ViewingTime viewingTime, String seatList){

        String values;
        String where;

        result = null;

        try{
            values = "SEATLIST='"+ seatList +"'";
            where = "where THEATRENAME='"+ viewingTime.getTheatreName()
                    +"' and MOVIENAME='" + viewingTime.getMovieName()
                    +"' and TIME='" + viewingTime.getShowTime()
                    +"' and DATE='" + viewingTime.getShowDate()
                    +"'";

            cmdString = "Update VIEWINGTIMES " +" Set " +values +" " +where;
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);

        }
        catch(Exception exception){
            result = processSQLError(exception);
        }

        if(result == null){
            return "Success";
        }
        else{
            return "Failure";
        }

    }//end updateSeatList

    /**
     * getOrderList -a getter method for the orderList field. Gets alls order from the orders table
     * @return it will return the field orderList.
     */
    @Override
    public List<Order> getOrderList(){

        orderList = new ArrayList<>();
        String movieName;
        String theatreName;
        String showTime;
        String showDate;
        int quantity;

        try{
            cmdString = "SELECT * FROM ORDERS";
            rs2 =st1.executeQuery(cmdString);

            while(rs2.next()){
                movieName =rs2.getString("MOVIENAME");
                theatreName= rs2.getString("THEATRENAME");
                showTime = rs2.getString("SHOWTIME");
                showDate = rs2.getString("SHOWDATE");
                quantity = rs2.getInt("QUANTITY");
                Order order = new Order(movieName, showTime, showDate, theatreName, quantity);
                orderList.add(order);
            }

        }catch(Exception exception){
            processSQLError(exception);
        }
        return orderList;
    }//end getOrderList

    /**
     * insertNewOrder - a method that adds an order to the ORDER table
     * @param order - the order object we want to insert into ORDERS
     */
    @Override
    public void insertNewOrder(Order order){

        try{
            if(order != null)
            {
                if(order.getMovieName() != null && order.getShowTime() != null && order.getShowDate() != null && order.getTheatreName() != null) {
                    cmdString = "INSERT INTO ORDERS VALUES('" + order.getMovieName() + "', '" + order.getTheatreName() + "' , '" + order.getTicketQuantity() + "', '" + order.getShowTime() + "' , '" + order.getShowDate() + "') ";
                    st1.executeUpdate(cmdString);
                }
            }
        }
        catch(Exception exception){
            result = processSQLError(exception);
        }

    }//end insertNewOrder

    /**
     * deleteOrder - a method that removes an order from the ORDER table (for testing purposes)
     * @param order - the order object we want to remove from ORDERS
     */
    @Override
    public void deleteOrder(Order order){

        String where;

        try{

            where = "where THEATRENAME='"+ order.getTheatreName()
                    +"' and MOVIENAME='" + order.getMovieName()
                    +"' and SHOWTIME='" + order.getShowTime()
                    +"' and SHOWDATE='" + order.getShowDate()
                    +"' and QUANTITY='" + order.getTicketQuantity()
                    +"'";

            cmdString = "DELETE FROM ORDERS " + where;
            st1.executeUpdate(cmdString);

        }
        catch(Exception exception){
            result = processSQLError(exception);
        }

    }//end deleteOrder

    /**
     * getReviewList -a getter method for the reviewList field. Gets all review from the reviews table
     * @return it will return the field reviewList.
     */
    @Override
    public List<Review> getReviewList(String movieNameSelected, String ratingSelected){

        reviewList = new ArrayList<>();
        String movieName;
        String customerName;
        String rating;
        String comments;

        String whereClause = "";

        if(!movieNameSelected.equals("All Movies"))
        {
            if(!ratingSelected.equals("All Ratings"))
            {
                whereClause += "WHERE MOVIENAME = '"+ movieNameSelected +"' AND RATING = " + ratingSelected;
            }
            else
            {
                whereClause += "WHERE MOVIENAME = '"+ movieNameSelected +"' ";
            }
        }
        else if(!ratingSelected.equals("All Ratings"))
        {
            whereClause += "WHERE RATING = " + ratingSelected;
        }

        try{
            cmdString = "SELECT * FROM REVIEWS " + whereClause;
            rs3 = st5.executeQuery(cmdString);

            while(rs3.next()){
                movieName =rs3.getString("MOVIENAME");
                customerName= rs3.getString("CUSTOMERNAME");
                rating = rs3.getString("RATING");
                comments = rs3.getString("COMMENTS");
                Review review = new Review(movieName, customerName, rating, comments);
                reviewList.add(review);
            }

        }catch(Exception exception){
            processSQLError(exception);
        }
        return reviewList;
    }//end getReviewList

    /**
     * insertNewReview - a method that adds an order to the REVIEWS table
     * @param review - the review object we want to insert
     */
    @Override
    public void insertNewReview(Review review){

        try{

            cmdString = "INSERT INTO REVIEWS VALUES('" + review.getMovieName() + "', '" + review.getCustomerName() + "' , '" + review.getRating() + "', '" + review.getComments() +  "') ";
            st1.executeUpdate(cmdString);

        }
        catch(Exception exception){
            result = processSQLError(exception);
        }

    }//end insertNewReview

    /**
     * processSQLError - a method that processes the error when dealing with the database SQL.
     * @param exception is the given exception.
     * @return it will return an SQL error from the exception in string.
     */
    public String processSQLError(Exception exception){
        String result = "*** SQL Error: " + exception.getMessage();
        exception.printStackTrace();
        return result;
    }//end processSqError


    /**
     * checkWarning - a method that checks the warning when dealing with the database SQL.
     * @param statement is the given statement.
     * @param updateCount is the given count.
     * @return it will return a warning error.
     */
    private String checkWarning(Statement statement, int updateCount){
        String result;
        result = null;
        try{
            SQLWarning warning = statement.getWarnings();
            if (warning != null){
                result = warning.getMessage();
            }

        } catch (Exception exception){
            result = processSQLError(exception);
        }

        if (updateCount != 1){
            result = "Tuple not inserted correctly.";
        }
        return result;
    }//end checkWarning

}//end DataAccessObject class
