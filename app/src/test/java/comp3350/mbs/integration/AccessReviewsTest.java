package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Services;
import comp3350.mbs.business.AccessReviews;
import comp3350.mbs.objects.Review;
import comp3350.mbs.persistence.DataAccessStub;

public class AccessReviewsTest extends TestCase {

    public AccessReviewsTest(String arg0) { super (arg0); }

    @Test
    public void testAccessReviews() {
        Review expected;
        List<Review> reviewList;
        AccessReviews accessReviews;

        Services.closeDataAccess();

        System.out.println("Starting Integration test of AccessReviews to persistence layer\n");

        Services.createDataAccess(new DataAccessStub());

        //create new AccessReview object and Review object
        accessReviews = new AccessReviews();
        expected = new Review("Star Wars", "Jacob", "4", "A good movie :)");
        //insert new review into table
        accessReviews.insertNewReview(expected);
        //retrieve list of reviews
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        //assert reviewList characteristics
        assertTrue(reviewList.size() > 0);
        assertFalse(reviewList.size() > 1);
        Review actual = reviewList.get(0);

        assertEquals("Star Wars", actual.getMovieName());
        assertEquals("Jacob", actual.getCustomerName());
        assertEquals("4", actual.getRating());
        assertEquals("A good movie :)", actual.getComments());

        //create another new review and insert into table
        expected = new Review("Star Wars", "Mandy", "4", "Hooooot");
        accessReviews.insertNewReview(expected);
        expected = new Review("Star Wars", "Trina", "4", "Preeee good film.");
        accessReviews.insertNewReview(expected);
        expected = new Review("Star Wars", "Albert", "4", "I would watch it again");
        accessReviews.insertNewReview(expected);
        //retrieve list of reviews
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        //assert reviewList characteristics
        assertTrue(reviewList.size() > 3);
        assertFalse(reviewList.size() > 4);
        assertTrue(reviewList.size() < 5);
        Review actual2 = reviewList.get(1);

        assertEquals("Star Wars", actual.getMovieName());
        assertEquals("Jacob", actual.getCustomerName());
        assertEquals("4", actual.getRating());
        assertEquals("A good movie :)", actual.getComments());

        assertEquals("Star Wars", actual2.getMovieName());
        assertEquals("Mandy", actual2.getCustomerName());
        assertEquals("4", actual2.getRating());
        assertEquals("Hooooot", actual2.getComments());
        //remove current Review(s) from list to make sure invalid case does not get added
        while(!reviewList.isEmpty()){
            reviewList.remove(0);
        }
        //make sure list is empty
        assertTrue(reviewList.isEmpty());
        //assert that invalid theatre name does not add anything to the list of theatre movies
        Review invalid = new Review("", "", "", "");
        accessReviews.insertNewReview(invalid);
        assertTrue(reviewList.isEmpty());

        //Delete inserted reviews from table
        Review first = new Review("Star Wars", "Jacob", "4", "A good movie :)");
        accessReviews.deleteReview(first);
        Review second = new Review("Star Wars", "Mandy", "4", "Hooooot");
        accessReviews.deleteReview(second);
        Review third = new Review("Star Wars", "Albert", "4", "I would watch it again");
        accessReviews.deleteReview(third);
        Review fourth = new Review("Star Wars", "Trina", "4", "Preeee good film.");
        accessReviews.deleteReview(fourth);


        //confirm that reviews for previously inserted movies do not exist
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        assertTrue(reviewList.isEmpty());

        //add 2 different ratings into table
        expected = new Review("Star Wars", "Lilac", "3", "It was a decent movie");
        accessReviews.insertNewReview(first);
        accessReviews.insertNewReview(second);
        accessReviews.insertNewReview(expected);

        //retrieve only reviews with a 3 rating (
        reviewList = accessReviews.getReviewList("Star Wars", "3");
        assertTrue(reviewList.size() > 0);
        assertFalse(reviewList.size() > 1);
        actual = reviewList.get(0);
        assertEquals("Star Wars", actual.getMovieName());
        assertEquals("Lilac", actual.getCustomerName());
        assertEquals("3", actual.getRating());
        assertEquals("It was a decent movie", actual.getComments());

        //clean up table
        accessReviews.deleteReview(first);
        accessReviews.deleteReview(second);
        accessReviews.deleteReview(expected);

        //confirm reviews no longer exist
        reviewList = accessReviews.getReviewList("Star Wars", "3");
        assertTrue(reviewList.isEmpty());
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        assertTrue(reviewList.isEmpty());

        Services.closeDataAccess();

        System.out.println("\nFinished Integration test of AccessReviews to persistence layer\n");
    }

}
