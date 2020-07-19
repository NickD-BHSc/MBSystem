package comp3350.mbs.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.MovieViewingTime;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessStub implements DataAccess{

    private String dbName;
    private String dbType = "stub";

    private List<Theatre> theatreList;
    private List<Ticket> ticketList;
    private List<Seat> seatList;
    private List<TheatreMovies> theatreMoviesList;

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

        //==========================================================================================
        //Theatres to be displayed in the TheatreActivity
        theatreList = new ArrayList<>();
        Theatre theatre1 = new Theatre("Scotiabank Theatre", "817 St.James", "15.7km");
        Theatre theatre2 = new Theatre("Cinema City Northgate", "1399 McPhillips St.","10km");
        Theatre theatre3 = new Theatre("Silver City St.Vital Cinemas", "160-1225 St Mary's Rd","19.8km");

        //adding theatres to the theatreList.
        theatreList.add(theatre1);
        theatreList.add(theatre2);
        theatreList.add(theatre3);

        //==========================================================================================
        //Movies to be displayed when a specific theatre is selected.
        //Movies to be displayed in the MovieActivity.
        theatreMoviesList = new ArrayList<>();
        TheatreMovies tm;
        String movieDescription;

        //================================
        //Theatre1
        movieDescription= "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        tm = new TheatreMovies(theatre1.getName(),"Avengers Endgame",R.drawable.avengers_endgame,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        tm = new TheatreMovies(theatre1.getName(),"The Incredibles",R.drawable.incredibles,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
        tm = new TheatreMovies(theatre1.getName(),"Superman",R.drawable.superman,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        tm = new TheatreMovies(theatre1.getName(),"Lion King",R.drawable.lion_king,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        tm = new TheatreMovies(theatre1.getName(),"Star Wars",R.drawable.starwars,movieDescription);
        theatreMoviesList.add(tm);

        //================================
        //Theatre2
        movieDescription= "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        tm = new TheatreMovies(theatre2.getName(),"Avengers Endgame",R.drawable.avengers_endgame,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        tm = new TheatreMovies(theatre2.getName(),"The Incredibles",R.drawable.incredibles,movieDescription);
        theatreMoviesList.add(tm);

        //================================
        //Theatre3
        movieDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
        tm = new TheatreMovies(theatre3.getName(),"Superman",R.drawable.superman,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        tm = new TheatreMovies(theatre3.getName(),"Lion King",R.drawable.lion_king,movieDescription);
        theatreMoviesList.add(tm);

        movieDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        tm = new TheatreMovies(theatre3.getName(),"Star Wars",R.drawable.starwars,movieDescription);
        theatreMoviesList.add(tm);



        //==========================================================================================
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

        //==========================================================================================
        //adding tickets to ticketList.
        ticketList = new ArrayList<>();

        Ticket ticket1 = new Ticket(10.00, "Avengers Endgame");
        Ticket ticket2 = new Ticket(5.00, "The Incredibles");
        Ticket ticket3 = new Ticket(20.00, "The Lion King");
        Ticket ticket4 = new Ticket(15.00, "Star Wars");
        Ticket ticket5 = new Ticket(3.00, "Superman");

        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        ticketList.add(ticket4);
        ticketList.add(ticket5);

        //==========================================================================================
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
     * getMoviesFromTheatre - a getter method that returns a list of movies from the given theatre.
     * @param whichTheatre is the given theatre.
     * @return it will return a list of movies that is contained in the given theatre.
     */
    public List<TheatreMovies> getMoviesFromTheatre(TheatreMovies whichTheatre) {
        List<TheatreMovies> newTMList = new ArrayList<>();
        TheatreMovies tm;

        //find the given theatre from the list.
        for(int i = 0; i < theatreMoviesList.size(); i++){
            tm = theatreMoviesList.get(i);

            if(tm.getTheatreName().equals(whichTheatre.getTheatreName())){
                newTMList.add(tm);
            }//end if
        }//end for

        return newTMList;
    }//end getMoviesFromTheatre

    /**
     * getTheatresFromMovie - a getter method that returns a list of theatres from the given movie.
     * @param whichMovie is the given movie name.
     * @return it will return a list of theatres that has the given movie.
     */
    public List<TheatreMovies> getTheatresFromMovie(TheatreMovies whichMovie) {
        List<TheatreMovies> newTMList = new ArrayList<>();
        TheatreMovies tm;

        //find the given movie from the list.
        for(int i = 0; i < theatreMoviesList.size(); i++){
            tm = theatreMoviesList.get(i);
            if(tm.getMovieName().equals(whichMovie.getMovieName())){
                newTMList.add(tm);
            }//end if
        }//end for

        return newTMList;
    }//end getTheatresFromMovie

    @Override
    public List<MovieViewingTime> getViewingTimeList(TheatreMovies theatreMovie) {
        return null;
    }


    /**
     * getTicketList -a getter method for a the complete list of tickets.
     * @return it will return the ticketList.
     */
    public List<Ticket> getTicketList(){
        return ticketList;
    }//end getTicketList




    /**
     * getSeatList - a getter method for the seatList.
     * @return it will return the seatList field.
     */
    public List<Seat> getSeatList(){
        return seatList;
    }//end getSeatList


}//end DataAccessStub