package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessTheatreMoviesTest extends TestCase {
    private static String dbName = Main.dbName;
    private AccessTheatreMovies accessTheatreMovie;
    private List<TheatreMovies> theatreMoviesList;
    private TheatreMovies theatreMovie;
    private String theatre1,theatre2,theatre3;
    private String avengersDescription, lionKingDescription, incrediblesDescription, starWarsDescription, supermanDescription;

    public AccessTheatreMoviesTest(String arg0){super(arg0);}

    public void setUp(){
        accessTheatreMovie = null;
        theatreMoviesList = null;
        theatreMovie = null;
        theatre1 = "Scotiabank Theatre";
        theatre2 = "Cinema City Northgate";
        theatre3 = "Silver City St.Vital Cinemas";
        avengersDescription = "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.";
        lionKingDescription = "This Disney animated feature follows the adventures of the young lion Simba (Jonathan Taylor Thomas), the heir of his father, Mufasa (James Earl Jones). Simba's wicked uncle, Scar (Jeremy Irons), plots to usurp Mufasa's throne by luring father and son into a stampede of wildebeests. But Simba escapes, and only Mufasa is killed. Simba returns as an adult (Matthew Broderick) to take back his homeland from Scar with the help of his friends Timon (Nathan Lane) and Pumbaa (Ernie Sabella).";
        incrediblesDescription = "In this lauded Pixar animated film, married superheroes Mr. Incredible (Craig T. Nelson) and Elastigirl (Holly Hunter) are forced to assume mundane lives as Bob and Helen Parr after all super-powered activities have been banned by the government. While Mr. Incredible loves his wife and kids, he longs to return to a life of adventure, and he gets a chance when summoned to an island to battle an out-of-control robot. Soon, Mr. Incredible is in trouble, and it's up to his family to save him.";
        starWarsDescription = "The Imperial Forces -- under orders from cruel Darth Vader (David Prowse) -- hold Princess Leia (Carrie Fisher) hostage, in their efforts to quell the rebellion against the Galactic Empire. Luke Skywalker (Mark Hamill) and Han Solo (Harrison Ford), captain of the Millennium Falcon, work together with the companionable droid duo R2-D2 (Kenny Baker) and C-3PO (Anthony Daniels) to rescue the beautiful princess, help the Rebel Alliance, and restore freedom and justice to the Galaxy.";
        supermanDescription = "Just before the destruction of the planet Krypton, scientist Jor-El (Marlon Brando) sends his infant son Kal-El on a spaceship to Earth. Raised by kindly farmers Jonathan (Glenn Ford) and Martha Kent (Phyllis Thaxter), young Clark (Christopher Reeve) discovers the source of his superhuman powers and moves to Metropolis to fight evil. As Superman, he battles the villainous Lex Luthor (Gene Hackman), while, as novice reporter Clark Kent, he attempts to woo co-worker Lois Lane (Margot Kidder).";
    }//end setUp


    @Test
    public void testMoviesFromTheatre1(){

        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testMoviesFromTheatre1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre1); //Scotiabank Theatre
        assertNotNull(theatreMoviesList);

        assertEquals(5, theatreMoviesList.size());//5 movies in Scotiabank Theatre.

        //Movie 1 (Avengers Endgame)
        theatreMovie = theatreMoviesList.get(0);//Avengers endgame at Scotiabank Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre1,theatreMovie.getTheatreName());
        assertEquals("Avengers Endgame",theatreMovie.getMovieName());
        assertEquals(R.drawable.avengers_endgame,theatreMovie.getMoviePoster());
        assertEquals(avengersDescription,theatreMovie.getMovieDescription());

        //Movie 2 (The Incredibles)
        theatreMovie = theatreMoviesList.get(1);//The Incredibles at Scotiabank Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre1,theatreMovie.getTheatreName());
        assertEquals("The Incredibles",theatreMovie.getMovieName());
        assertEquals(R.drawable.incredibles,theatreMovie.getMoviePoster());
        assertEquals(incrediblesDescription,theatreMovie.getMovieDescription());

        //Movie 3 (Superman)
        theatreMovie = theatreMoviesList.get(2);//Superman at Scotiabank Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre1,theatreMovie.getTheatreName());
        assertEquals("Superman",theatreMovie.getMovieName());
        assertEquals(R.drawable.superman,theatreMovie.getMoviePoster());
        assertEquals(supermanDescription,theatreMovie.getMovieDescription());

        //Movie 4 (Lion King)
        theatreMovie = theatreMoviesList.get(3);//Lion King at Scotiabank Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre1,theatreMovie.getTheatreName());
        assertEquals("Lion King",theatreMovie.getMovieName());
        assertEquals(R.drawable.lion_king,theatreMovie.getMoviePoster());
        assertEquals(lionKingDescription,theatreMovie.getMovieDescription());

        //Movie 5 (Star Wars)
        theatreMovie = theatreMoviesList.get(4);//Star Wars at Scotiabank Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre1,theatreMovie.getTheatreName());
        assertEquals("Star Wars",theatreMovie.getMovieName());
        assertEquals(R.drawable.starwars,theatreMovie.getMoviePoster());
        assertEquals(starWarsDescription,theatreMovie.getMovieDescription());

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreMoviesTest: testMoviesFromTheatre1\n");

    }//end testMoviesFromTheatre1

    @Test
    public void testMoviesFromTheatre2(){

        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testMoviesFromTheatre2");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre2); //Cinema City Northgate Theatre
        assertNotNull(theatreMoviesList);

        assertEquals(2,theatreMoviesList.size()); //2 movies in Cinema City Northgate

        //Movie 1 (Avengers Endgame)
        theatreMovie = theatreMoviesList.get(0); //Avengers Endgame  at Cinema City Northgate
        assertNotNull(theatreMovie);
        assertEquals(theatre2,theatreMovie.getTheatreName());
        assertEquals("Avengers Endgame",theatreMovie.getMovieName());
        assertEquals(R.drawable.avengers_endgame,theatreMovie.getMoviePoster());
        assertEquals(avengersDescription,theatreMovie.getMovieDescription());

        //Movie 2 (The Incredibles)
        theatreMovie = theatreMoviesList.get(1);//The Incredibles at Cinema City Northgate
        assertNotNull(theatreMovie);
        assertEquals(theatre2,theatreMovie.getTheatreName());
        assertEquals("The Incredibles",theatreMovie.getMovieName());
        assertEquals(R.drawable.incredibles,theatreMovie.getMoviePoster());
        assertEquals(incrediblesDescription,theatreMovie.getMovieDescription());

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreMoviesTest: testMoviesFromTheatre2\n");

    }//end testMoviesFromTheatre2

    @Test
    public void testMoviesFromTheatre3(){
        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testMoviesFromTheatre3");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre3); //Silver City St.Vital Cinemas
        assertNotNull(theatreMoviesList);

        assertEquals(3,theatreMoviesList.size()); //3 movies in Silver City St.Vital Cinemas

        //Movie 1 (Superman)
        theatreMovie = theatreMoviesList.get(0);//Superman at Silver City St.Vital Cinemas Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre3,theatreMovie.getTheatreName());
        assertEquals("Superman",theatreMovie.getMovieName());
        assertEquals(R.drawable.superman,theatreMovie.getMoviePoster());
        assertEquals(supermanDescription,theatreMovie.getMovieDescription());

        //Movie 2 (Lion King)
        theatreMovie = theatreMoviesList.get(1);//Lion King at Silver City St.Vital Cinemas Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre3,theatreMovie.getTheatreName());
        assertEquals("Lion King",theatreMovie.getMovieName());
        assertEquals(R.drawable.lion_king,theatreMovie.getMoviePoster());
        assertEquals(lionKingDescription,theatreMovie.getMovieDescription());

        //Movie 3 (Star Wars)
        theatreMovie = theatreMoviesList.get(2);//Star Wars at Silver City St.Vital Cinemas Theatre
        assertNotNull(theatreMovie);
        assertEquals(theatre3,theatreMovie.getTheatreName());
        assertEquals("Star Wars",theatreMovie.getMovieName());
        assertEquals(R.drawable.starwars,theatreMovie.getMoviePoster());
        assertEquals(starWarsDescription,theatreMovie.getMovieDescription());

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreMoviesTest: testMoviesFromTheatre3\n");
    }//end testMoviesFromTheatre3

    @Test
    public void testInvalidMoviesFromTheatre1(){
        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testInvalidMoviesFromTheatre1");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre1); //Scotiabank theatre
        assertNotNull(theatreMoviesList);

        assertEquals(5,theatreMoviesList.size());

        try{
            theatreMovie = theatreMoviesList.get(5);//getting the non-existing 6th movie
            fail("IOBE expected");
        }catch(IndexOutOfBoundsException iobe){
        }//end try-catch

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreMoviesTest: testInvalidMoviesFromTheatre1\n");

    }//end testInvalidMoviesFromTheatre1

    @Test
    public void testInvalidMoviesFromTheatre2(){
        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testInvalidMoviesFromTheatre2");
        Services.createDataAccess(new DataAccessStub(dbName));
        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre2); //Cinema City Northgate Theatre
        assertNotNull(theatreMoviesList);
        assertEquals(2,theatreMoviesList.size());

        //add the movies that are not in theatre2 to the movieNotInTheatre2 list.
        List<TheatreMovies> moviesNotInTheatre2 = new ArrayList<>();
        moviesNotInTheatre2.add(new TheatreMovies(theatre2,"Superman",R.drawable.superman,supermanDescription));
        moviesNotInTheatre2.add(new TheatreMovies(theatre2,"Lion King",R.drawable.lion_king,lionKingDescription));
        moviesNotInTheatre2.add(new TheatreMovies(theatre2,"Star Wars",R.drawable.starwars,starWarsDescription));

        assertFalse(theatreMoviesList.containsAll(moviesNotInTheatre2));

        try{
            theatreMovie = theatreMoviesList.get(2);//getting the non-existing 3rd movie
            fail("IOBE expected");
        }catch(IndexOutOfBoundsException iobe){
        }//end try-catch

        Services.closeDataAccess();
        System.out.println("Finished AccessTheatreMoviesTest: testInvalidMoviesFromTheatre2\n");
    }//end testInvalidMoviesFromTheatre2

    @Test
    public void testInvalidMoviesFromTheatre3(){
        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testInvalidMoviesFromTheatre3");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessTheatreMovie = new AccessTheatreMovies();
        theatreMoviesList = accessTheatreMovie.getMoviesFromTheatre(theatre3); //Silver City St.Vital Cinemas
        assertNotNull(theatreMoviesList);
        assertEquals(3,theatreMoviesList.size()); //3 movies in Silver City St.Vital Cinemas

        //add the movies that are not in theatre3 to the movieNotInTheatre3 list.
        List<TheatreMovies> moviesNotInTheatre3 = new ArrayList<>();
        moviesNotInTheatre3.add(new TheatreMovies(theatre2,"Avengers Endgame",R.drawable.avengers_endgame,avengersDescription));
        moviesNotInTheatre3.add(new TheatreMovies(theatre2,"The Incredibles",R.drawable.incredibles,incrediblesDescription));

        assertFalse(theatreMoviesList.containsAll(moviesNotInTheatre3));

        try{
            theatreMovie = theatreMoviesList.get(3);//getting the non-existing 4th movie
            fail("IOBE expected");
        }catch(IndexOutOfBoundsException iobe){
        }//end try-catch

        Services.closeDataAccess();
        System.out.println("Starting AccessTheatreMoviesTest: testInvalidMoviesFromTheatre3\n");
    }//end testInvalidMoviesFromTheatre3


}//end AccessTheatreMoviesTest
