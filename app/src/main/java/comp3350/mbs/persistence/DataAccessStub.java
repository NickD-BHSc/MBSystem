package comp3350.mbs.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessStub {
    //TODO Add Consistency in this file

    private String dbName;
    private String dbType = "stub";

    private List<Theatre> theatreList;
    private List<Ticket> ticketList;
    private List<Seat> seatList;

    //Constructors
    public DataAccessStub(){
        this.dbName = Main.dbName;
    }//end null constructor

    public DataAccessStub(String dbName) {
        this.dbName = dbName;
    }//end constructor


    /**
     * open - a method that opens the data from the database.
     * @param databaseName is the name of the database.
     */
    public void open(String databaseName){

        List<ViewingTime> viewingTimes = new ArrayList<>();//list of viewing time for a specific movie

        ViewingTime vt1 = new ViewingTime("7:00 to 10:00 PM", "June 11, 2020, Tuesday");
        ViewingTime vt2 = new ViewingTime("1:00 to 2:00 PM", "March 25, 2020, Wednesday");
        ViewingTime vt3 = new ViewingTime("5:00 to 6:30 PM", "August 19, 2020, Monday");
        ViewingTime vt4 = new ViewingTime("7:00 to 9:00 PM", "May 11, 2020, Friday");
        ViewingTime vt5 = new ViewingTime("4:30 to 7:00 PM", "July 2, 2020, Sunday");

        //data for viewingTimes.
        viewingTimes.add(vt1);
        viewingTimes.add(vt2);
        viewingTimes.add(vt3);
        viewingTimes.add(vt4);
        viewingTimes.add(vt5);


        List<Movie> movieListOne = new ArrayList<>();//list of movies available for theatre1
        List<Movie> movieListTwo = new ArrayList<>();//list of movies available for theatre2
        List<Movie> movieListThree = new ArrayList<>();//list of movies available for theatre3

        String movieDescription;

        movieDescription= "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        Movie m1 = new Movie("Avengers Endgame", R.drawable.avengers_endgame, movieDescription, viewingTimes);

        movieDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        Movie m2 = new Movie("The Incredibles", R.drawable.incredibles, movieDescription, viewingTimes);

        movieDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        Movie m3 = new Movie("The Lion King", R.drawable.lion_king, movieDescription, viewingTimes);

        movieDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        Movie m4 = new Movie("Star Wars", R.drawable.starwars, movieDescription, viewingTimes);

        movieDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
        Movie m5 = new Movie("Superman", R.drawable.superman, movieDescription, viewingTimes);

        //adding movies for movieListOne
        movieListOne.add(m1);
        movieListOne.add(m2);
        movieListOne.add(m3);

        //adding movies for movieListTwo
        movieListTwo.add(m4);
        movieListTwo.add(m5);

        //adding movies for movieListThree

        movieListThree.add(m5);
        movieListThree.add(m3);
        movieListThree.add(m1);

        theatreList = new ArrayList<>();
        Theatre theatre1 = new Theatre("Scotiabank Theatre", "817 St.James", movieListOne, "15.7km");
        Theatre theatre2 = new Theatre("Cinema City Northgate", "1399 McPhillips St.", movieListTwo, "10km");
        Theatre theatre3 = new Theatre("Silver City St.Vital Cinemas", "160-1225 St Mary's Rd", movieListThree, "19.8km");

        //adding theatres to the theatreList.
        theatreList.add(theatre1);
        theatreList.add(theatre2);
        theatreList.add(theatre3);


        //adding tickets to ticketList.
        ticketList = new ArrayList<>();

        Ticket ticketGeneral = new Ticket(10.00, "General");
        Ticket ticketChild = new Ticket(5.00, "Child");
        Ticket ticketSenior = new Ticket(20.00, "Senior");
        Ticket ticketStudent = new Ticket(5.00, "Student");
        Ticket ticketEmpty = new Ticket(0.00, "Empty");

        ticketList.add(ticketGeneral);
        ticketList.add(ticketChild);
        ticketList.add(ticketSenior);
        ticketList.add(ticketStudent);
        ticketList.add(ticketEmpty);


        //adding seats to the seatList.
        seatList = new ArrayList<>();
        for(int i = 0; i < 32; i++) {
            Seat seat;
            if( i%5 != 0){
                seat = new Seat(i,false, R.drawable.seat);
            }else{
                seat = new Seat(i,true, R.drawable.seat_taken);
            }//end if-else
            seatList.add(seat);
        }//end for loop

        System.out.println("Opened " + dbType + " database " + dbName + ".");

    }//end open

    /**
     * close - a method that closes the database.
     */
    public void close(){
        System.out.println("Closed " + dbType + " database " + dbName + ".");
    }//end close


    /**
     * getTheatreList -a getter method for the theatreList field.
     * @return it will return the field theatreList.
     */
    public List<Theatre> getTheatreList(){
        return theatreList;
    }//end getTheatreList


    /**
     * getTicket -a getter method for a ticket from the list.
     * @return it will return the ticket.
     */
    public Ticket getTicket(String ticketType){
        Ticket ticket = null;
        for(int i = 0; i <ticketList.size(); i++){

            if(ticketList.get(i).getType().equals(ticketType)){
                ticket = ticketList.get(i);
            }//end if

        }//end for
        return ticket;
    }//end getTicket


    /**
     * getTicketList -a getter method for a the complete list of tickets.
     * @return it will return the ticketList.
     */
    public List<Ticket> getTicketList(){
        return ticketList;
    }//end getTicketList


    /**
     * getMovieList - a getter method for the movieList for the given theatre.
     * @param whichTheatre is the theatre that contains the list of movies.
     * @return it will return the movieList for the given theatre if it exists.
     *          Otherwise it will return null.
     */
    public List<Movie> getMovieList(Theatre whichTheatre){

        List<Movie> movieList = null;
        for(int i = 0; i <theatreList.size(); i++){

            if(theatreList.get(i).equals(whichTheatre)){
                movieList = theatreList.get(i).getMovieList();
            }//end if

        }//end for
        return movieList;

    }//end getMovieList


    /**
     * getViewingTimeList - a getter method for the viewingTimeList for the given movie
     *          assuming that the user has chosen the theatre already.
     * @param whichTheatre is thea theatre that the user has chosen.
     * @param whichMovie is the movie that contains the list of viewing time.
     * @return it will return the viewingTimeList for the given movie if it exists.
     *          Otherwise it will return null.
     */
    public List<ViewingTime> getViewingTimeList(Theatre whichTheatre, Movie whichMovie){
        List<ViewingTime> viewingTimeList = null;

        int posTheatre = theatreList.indexOf(whichTheatre); //position of the theatre in the list if it exists.

        if( posTheatre != -1){
            //given theatre is found.
            List<Movie> movies = theatreList.get(posTheatre).getMovieList();

            int posMovie = movies.indexOf(whichMovie);// position of the movie from the list if it exists.
            if(posMovie != -1){
                //given movie is found.
                viewingTimeList = movies.get(posMovie).getShowingTime();
            }//end nested if
        }//end if

        return viewingTimeList;
    }//end getViewingTimeList

    /**
     * getSeatList - a getter method for the seatList.
     * @return it will return the seatList field.
     */
    public List<Seat> getSeatList(){
        return seatList;
    }//end getSeatList


}//end DataAccessStub