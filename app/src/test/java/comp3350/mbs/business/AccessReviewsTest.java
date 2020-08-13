package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Review;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessReviewsTest extends TestCase {
    private static String dbName = Main.dbName;
    private AccessReviews accessReviews;
    private List<Review> reviewList;
    private Review review;

    public AccessReviewsTest(String arg0){
        super(arg0);
    }

    public void setUp(){
        accessReviews = null;
        reviewList = null;
        review = null;
    }//end SetUp

    @Test
    public void testValidInsertReviews(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidInsertReviews");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("Movie1","User1","5","This movie is aight.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie1","UsEr_[123]","5","This movie is aight. =)");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(2,reviewList.size());

        review = new Review("Movie1","\t\tUsEr_[12345]","5","This movie is aight. o/");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(3,reviewList.size());

        review = new Review("      Movie1 ","   User   ","5","                    his comment    ");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("\t\tMovie1 ","   User   ","5","                    his comment    ");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidInsertReviews\n");
    }//end testValidInsertReviews

    @Test
    public void testValidInsertSameMovieAndRating(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidInsertSameMovieAndRating");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        //Movie 1 with rating 5
        review = new Review("Movie1","User1","5","This movie is aight.");
        accessReviews.insertNewReview(review);

        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie1","User2","5","This movie is ehhhhh.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie1","User3","5","This movie is good.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie1","User4","5","This movie is good good.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie1","User5","5","This movie is goooooooooood.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie1","User6","5","This movie is so gooood.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie1","User7","5","This movie is gooooooooooooooooooooooooooood.");
        accessReviews.insertNewReview(review);

        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(7,reviewList.size());


        //Movie 2 with rating 4
        review = new Review("Movie2","User1","4","This movie is aight.");
        accessReviews.insertNewReview(review);

        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie2","User2","4","This movie is ehhhhh.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie2","User3","4","This movie is good.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie2","User4","4","This movie is good good.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie2","User5","4","This movie is goooooooooood.");
        accessReviews.insertNewReview(review);

        review = new Review("Movie2","User6","4","This movie is so gooood.");
        accessReviews.insertNewReview(review);

        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(6,reviewList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidInsertSameMovieAndRating\n");

    }//end testValidInsertSameMovieAndRating

    @Test
    public void testValidInsertDifferentMovieAndRating(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidInsertDifferentMovieAndRating");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("Movie1","User1","5","This movie is lit.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie2","User1","3","This movie is aight.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie3","User1","1","This movie is bad.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie4","User1","2","This movie is bad.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());


        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidInsertDifferentMovieAndRating\n");

    }//end testValidInsertDifferentMovieAndRating

    @Test
    public void testValidInsertDifferentMovieButSameRating(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidInsertDifferentMovieButSameRating");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("Movie1","User1","5","This movie is lit.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie2","User1","5","This movie is aight.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie3","User1","5","This movie is okay.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie4","TheLegend27","5","This movie is legendary.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());


        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidInsertDifferentMovieButSameRating\n");
    }//end testValidInsertDifferentMovieButSameRating

    @Test
    public void testValidInsertSameMovieButDifferentRating(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidInsertDifferentMovieButSameRating");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("Movie1","User1","5","This movie is lit.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie1","User123","4","This movie is aight.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie1","User1111","3","This movie is okay.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        review = new Review("Movie1","TheLegend27","2","This movie is legendary.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(1,reviewList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidInsertDifferentMovieButSameRating\n");

    }//end testValidSameMovieButDifferentRating

    @Test
    public void testInsertNullReviews(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testInsertNullReviews");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review(null,null,null,null);
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie1",null,null,null);
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review(null,null,"5",null);
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());


        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testInsertNullReviews\n");

    }//end testInsertNullReviews

    @Test
    public void testInsertInvalidRatings(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testInsertInvalidRatings");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("Movie1","User1",null,"test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","100","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","-1","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","0","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","6","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","     ","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","Random Rating","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie2","User1","3.5","test comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testInsertInvalidRatings\n");

    }//end testInsertInvalidRatings

    @Test
    public void testInvalidInsertReviews(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testInsertInvalidReviews");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        review = new Review("","","","");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie","","","");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie","User1","","");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie","User1","5","");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie","","5","This is a comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("Movie","User101","55","This is a comment.");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("    ","      ","5","                        ");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("    ","      ","     ","                        ");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());

        review = new Review("\n\n\t\t\t","\t\t\t\t\t\n\n",     "5","\t\t                        ");
        accessReviews.insertNewReview(review);
        reviewList = accessReviews.getReviewList(review.getMovieName(),review.getRating());
        assertEquals(0,reviewList.size());


        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testInsertInvalidReviews\n");

    }//end testInvalidInsertReviews

    @Test
    public void testValidDeletion(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidDeletion");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        reviewList = accessReviews.getReviewList( "Avengers Endgame", "5");
        int size = reviewList.size();

        review = new Review( "Avengers Endgame", "CH", "5", "GOATED");

        accessReviews.insertNewReview( review );
        reviewList = accessReviews.getReviewList( "Avengers Endgame", "5");

        assertTrue( size == reviewList.size()-1 );//only added one review
        assertTrue( reviewList.contains( review ) );

        accessReviews.deleteReview( review );
        reviewList = accessReviews.getReviewList( "Avengers Endgame", "5");

        assertTrue( size == reviewList.size() );
        assertFalse( reviewList.contains( review ) );

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testValidDeletion\n");

    }

    @Test
    public void testInvalidDeletion(){
        Services.closeDataAccess();
        System.out.println("Starting AccessReviewsTest: testValidDeletion");
        Services.createDataAccess(new DataAccessStub(dbName));

        accessReviews = new AccessReviews();

        reviewList = accessReviews.getReviewList( "Avengers Endgame", "5" );
        int size = reviewList.size();
        assertFalse( size == 0); //size should be non-zero

        review = new Review( "Avengers Endgame", "CH", "5", "GOATED");

        accessReviews.deleteReview( review ); //can't delete this review, we didn't insert it

        assertTrue( reviewList.size() == size );//assures that didn't delete any reviews

        Services.closeDataAccess();
        System.out.println("Finished AccessReviewsTest: testInvalidDeletion\n");
    }

}//end AccessReviewsTest
