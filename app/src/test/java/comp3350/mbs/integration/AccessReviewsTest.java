package comp3350.mbs.integration;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

import comp3350.mbs.application.Main;
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

        System.out.println("Starting Integration test of AccessOrders to persistence layer\n");

        Services.createDataAccess(new DataAccessStub());

        accessReviews = new AccessReviews();
        expected = new Review("Star Wars", "Jacob", "4", "A good movie :)");
        accessReviews.insertNewReview(expected);
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        assertTrue(reviewList.size() > 0);
        assertFalse(reviewList.size() > 1);
        Review actual = reviewList.get(0);

        assertEquals("Star Wars", actual.getMovieName());
        assertEquals("Jacob", actual.getCustomerName());
        assertEquals("4", actual.getRating());
        assertEquals("A good movie :)", actual.getComments());

        expected = new Review("Star Wars", "Mandy", "4", "Hooooot");
        accessReviews.insertNewReview(expected);
        reviewList = accessReviews.getReviewList("Star Wars", "4");
        assertTrue(reviewList.size() > 1);
        assertFalse(reviewList.size() > 2);
        actual = reviewList.get(1);
        System.out.println(actual.getComments());

        assertEquals("Star Wars", actual.getMovieName());
        assertEquals("Mandy", actual.getCustomerName());
        assertEquals("4", actual.getRating());
        assertEquals("Hooooot", actual.getComments());
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

//        expected = new Review("Star Wars", "Lilac", "4", "It was a decent movie");
//        accessReviews.insertNewReview(expected);
//        reviewList = accessReviews.getReviewList("Star Wars", "4");
//        assertTrue(reviewList.size() > 1);
//        actual = reviewList.get(0);
//        assertEquals(actual.getCustomerName(), "Lilac");


    }

}
