package comp3350.mbs.persistence;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class DataAccessStub implements DataAccess{

    private String dbName;
    private String dbType = "stub";

    private List<Theatre> theatreList;
    private List<Ticket> ticketList;
    private List<TheatreMovies> theatreMoviesList;
    private List<ViewingTime> viewingTimeList;

    /**
     * DataAccessStub Constructor - assign its field dbName to the Main.dbName.
     */
    public DataAccessStub(){
        this.dbName = Main.dbName;
    }//end constructor

    /**
     * DatAccessStub Constructor - assign its field dbName to the given dbName.
     * @param dbName is the given database name.
     */
    public DataAccessStub(String dbName){
        this.dbName = dbName;
    }//end constructor

    /**
     * open - a method that opens the data from the database.
     * @param databaseName is the name of the database.
     */
    @Override
    public void open(String databaseName){

        //Theatres to be displayed in the TheatreActivity
        theatreList = new ArrayList<>();
        createTheatres();

        //Movies to be displayed when a specific theatre is selected. Movies to be displayed in the MovieActivity.
        theatreMoviesList = new ArrayList<>();
        createTheatreMovies(theatreList.get(0),theatreList.get(1),theatreList.get(2));

        //show times to be displayed in the MovieInfoActivity
        viewingTimeList = new ArrayList<>();
        createViewingTimes();

        //adding tickets to ticketList.
        ticketList = new ArrayList<>();
        createTickets();

        System.out.println("Opened " + dbType + " database " + dbName + ".");

    }//end open

    /**
     * createTheatres - a method that creates a list of theatres and add it to the theatreList.
     */
    private void createTheatres(){
        Theatre theatre;
        theatre = new Theatre("Scotiabank Theatre", "817 St.James", "15.7km");
        theatreList.add(theatre);//theatre1

        theatre = new Theatre("Cinema City Northgate", "1399 McPhillips St.","10km");
        theatreList.add(theatre);//theatre2

        theatre = new Theatre("Silver City St.Vital Cinemas", "160-1225 St Mary's Rd","19.8km");
        theatreList.add(theatre);//theatre3

    }//end createTheatres

    /**
     * createTheatreMovies - a method that creates a list of movies for each theatre.
     * @param theatre1 is the first theatre from the theatreList.
     * @param theatre2 is the second theatre from the theatreList.
     * @param theatre3 is the third theatre from the theatreList.
     */
    private void createTheatreMovies(Theatre theatre1, Theatre theatre2, Theatre theatre3){

        TheatreMovies theatreMovie;
        String movieDescription;

        //Theatre1
        movieDescription= "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        theatreMovie = new TheatreMovies(theatre1.getName(),"Avengers Endgame",R.drawable.avengers_endgame,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        theatreMovie = new TheatreMovies(theatre1.getName(),"The Incredibles",R.drawable.incredibles,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
        theatreMovie = new TheatreMovies(theatre1.getName(),"Superman",R.drawable.superman,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        theatreMovie = new TheatreMovies(theatre1.getName(),"The Lion King",R.drawable.lion_king,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        theatreMovie = new TheatreMovies(theatre1.getName(),"Star Wars",R.drawable.starwars,movieDescription);
        theatreMoviesList.add(theatreMovie);

        //Theatre2
        movieDescription= "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        theatreMovie = new TheatreMovies(theatre2.getName(),"Avengers Endgame",R.drawable.avengers_endgame,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        theatreMovie = new TheatreMovies(theatre2.getName(),"The Incredibles",R.drawable.incredibles,movieDescription);
        theatreMoviesList.add(theatreMovie);

        //Theatre3
        movieDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
        theatreMovie = new TheatreMovies(theatre3.getName(),"Superman",R.drawable.superman,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        theatreMovie = new TheatreMovies(theatre3.getName(),"The Lion King",R.drawable.lion_king,movieDescription);
        theatreMoviesList.add(theatreMovie);

        movieDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        theatreMovie = new TheatreMovies(theatre3.getName(),"Star Wars",R.drawable.starwars,movieDescription);
        theatreMoviesList.add(theatreMovie);

    }//end createTheatreMovies

    /**
     * createViewingTimes - a method that create viewing times for each movie in each theatre.
     * NOTE: there are 10 items from the theatreMoviesList.
     */
    private void createViewingTimes(){

        viewingTimeList = new ArrayList<>();
        TheatreMovies theatreMovie;
        ViewingTime viewingTime;

        //For first movie (avengers) in theatre1
        theatreMovie = theatreMoviesList.get(0);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 4:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"4:30 to 7:30 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"8:00 to 11:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"5:00 to 8:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"9:00 to 12:00 AM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For second movie (The Incredibles) in theatre1
        theatreMovie = theatreMoviesList.get(1);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"4:00 to 6:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For third movie (Superman) in theatre1
        theatreMovie = theatreMoviesList.get(2);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"5:00 to 7:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"9:00 to 11:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For fourth movie (The Lion King) in theatre1
        theatreMovie = theatreMoviesList.get(3);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"4:00 to 6:30 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"7:00 to 9:30 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"4:00 to 6:30 PM", "June 13, 2020, Thursday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For fifth movie (Star wars) in theatre1
        theatreMovie = theatreMoviesList.get(4);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"11:30 to 2:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"5:00 to 7:30 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For first movie (Avengers) in theatre2
        theatreMovie = theatreMoviesList.get(5);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"5:00 to 8:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"7:00 to 10:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For second movie (The Incredibles) in theatre2
        theatreMovie = theatreMoviesList.get(6);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"4:00 to 6:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For first movie (Superman) in theatre3
        theatreMovie = theatreMoviesList.get(7);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"8:00 to 10:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"1:00 to 3:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"5:00 to 7:00 PM", "June 12, 2020, Wednesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For second movie (The Lion King) in theatre3
        theatreMovie = theatreMoviesList.get(8);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"12:00 to 2:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"7:00 to 9:00 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);

        //For second movie (Star Wars) in theatre3
        theatreMovie = theatreMoviesList.get(9);
        viewingTime = new ViewingTime(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),"7:00 to 9:30 PM", "June 11, 2020, Tuesday", "00000000000000000000000000000000");
        viewingTimeList.add(viewingTime);
    }//end createViewingTimes

    /**
     * createTickets - a method that creates a list of tickets and add them to the ticketList field.
     */
    private void createTickets(){

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

    }//end createTickets

    /**
     * close - a method that closes the database.
     */
    @Override
    public void close(){
        System.out.println("Closed " + dbType + " database " + dbName + ".");
    }//end close

    /**
     * getTheatreList -a getter method for the theatreList field.
     * @return it will return the field theatreList.
     */
    @Override
    public List<Theatre> getTheatreList(){
        return theatreList;
    }//end getTheatreList

    /**
     * getMoviesFromTheatre - a getter method that returns a list of movies from the given theatre.
     * @param theatreName is the given theatre.
     * @return it will return a list of movies that is contained in the given theatre.
     */
    @Override
    public List<TheatreMovies> getMoviesFromTheatre(TheatreMovies theatreName){
        List<TheatreMovies> theatreMoviesList = new ArrayList<>();
        TheatreMovies theatreMovie;

        for(int i = 0; i < this.theatreMoviesList.size(); i++){
            theatreMovie = this.theatreMoviesList.get(i);

            if(theatreMovie.getTheatreName().equals(theatreName.getTheatreName())){
                theatreMoviesList.add(theatreMovie);
            }
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

        List<ViewingTime> viewingTimeList = new ArrayList<>();
        ViewingTime viewingTime;

        for(int i = 0; i < this.viewingTimeList.size(); i++){
            viewingTime = this.viewingTimeList.get(i);

            if(viewingTime.getTheatreName().equals(theatreMovie.getTheatreName()) && viewingTime.getMovieName().equals(theatreMovie.getMovieName())){
                viewingTimeList.add(viewingTime);
            }
        }

        return viewingTimeList;
    }//end getViewingTimeList

    /**
     * getTicket -a getter method for a ticket with the movie provided from the list.
     * @param movieName is the movie associated with the ticket.
     * @return it will return the ticket.
     */
    @Override
    public Ticket getTicket(String movieName){

        Ticket ticket = null;
        for(int i = 0; i <ticketList.size(); i++){

            if(ticketList.get(i).getMovieName().equals(movieName)){
                ticket = ticketList.get(i);
            }
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

        for( int i = 0; i < viewingTimeList.size(); i++ ){
            ViewingTime v = viewingTimeList.get(i);

            if( v.getTheatreName().equals( viewingTime.getTheatreName()) && v.getMovieName().equals( viewingTime.getMovieName() )
                && v.getShowDate().equals( viewingTime.getShowDate() ) && v.getShowTime().equals( viewingTime.getShowTime())) {

                v.setSeatString(seatList);
                return "Success";
            }
        }

        return "Failure";
    }//end updateSeatList

}//end DataAccessStub