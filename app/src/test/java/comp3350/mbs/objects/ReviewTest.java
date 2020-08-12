package comp3350.mbs.objects;

import junit.framework.TestCase;

import org.junit.Test;

public class ReviewTest extends TestCase {
    public ReviewTest(String arg0){super(arg0);}

    @Test
    public void testOneReview(){

        System.out.println("Starting ReviewTest: testOneReview");

        Review review1 = new Review("Movie1","User1","5","This is a review from User1");
        assertNotNull(review1);
        assertEquals("Movie1",review1.getMovieName());
        assertEquals("User1", review1.getCustomerName());
        assertEquals("5",review1.getRating());
        assertEquals("This is a review from User1",review1.getComments());

        Review review2 = new Review("Movie2","User2","3","This is a review from User2");
        assertNotNull(review2);
        assertEquals("Movie2",review2.getMovieName());
        assertEquals("User2", review2.getCustomerName());
        assertEquals("3",review2.getRating());
        assertEquals("This is a review from User2",review2.getComments());

        System.out.println("Starting ReviewTest: testOneReview\n");

    }//end testOneReview

    @Test
    public void testDistinctReviews(){
        System.out.println("Starting ReviewTest: testDistinctReviews");

        Review review1 = new Review("Movie1","User1","5","This is a review from User1");
        assertNotNull(review1);
        assertEquals("Movie1",review1.getMovieName());
        assertEquals("User1", review1.getCustomerName());
        assertEquals("5",review1.getRating());
        assertEquals("This is a review from User1",review1.getComments());

        Review review2 = new Review("Movie2","User2","3","This is a review from User2");
        assertNotNull(review2);
        assertEquals("Movie2",review2.getMovieName());
        assertEquals("User2", review2.getCustomerName());
        assertEquals("3",review2.getRating());
        assertEquals("This is a review from User2",review2.getComments());

        assertFalse(review1.getMovieName().equals(review2.getMovieName()));
        assertFalse(review1.getCustomerName().equals(review2.getCustomerName()));
        assertFalse(review1.getRating().equals(review2.getRating()));
        assertFalse(review1.getComments().equals(review2.getComments()));

        System.out.println("Starting ReviewTest: testDistinctReviews\n");

    }//end testDistinctReviews

    @Test
    public void testSameReviews(){

        System.out.println("Starting ReviewTest: testSameReviews");

        Review review1 = new Review("Movie1","User1","5","This is a review from User1");
        assertNotNull(review1);
        assertEquals("Movie1",review1.getMovieName());
        assertEquals("User1", review1.getCustomerName());
        assertEquals("5",review1.getRating());
        assertEquals("This is a review from User1",review1.getComments());

        Review review2 = new Review("Movie1","User1","5","This is a review from User1");
        assertNotNull(review2);
        assertEquals("Movie1",review2.getMovieName());
        assertEquals("User1", review2.getCustomerName());
        assertEquals("5",review2.getRating());
        assertEquals("This is a review from User1",review2.getComments());

        assertTrue(review1.getMovieName().equals(review2.getMovieName()));
        assertTrue(review1.getCustomerName().equals(review2.getCustomerName()));
        assertTrue(review1.getRating().equals(review2.getRating()));
        assertTrue(review1.getComments().equals(review2.getComments()));

        System.out.println("Starting ReviewTest: testSameReviews\n");

    }//end testSameReviews

    @Test
    public void testNullReviews(){
        System.out.println("Starting ReviewTest: testNullReviews");
        Review review = new Review(null,null,null,null);
        assertNotNull(review);
        assertNull(review.getMovieName());
        assertNull(review.getCustomerName());
        assertNull(review.getRating());
        assertNull(review.getComments());

        System.out.println("Starting ReviewTest: testNullReviews\n");

    }//end testNullReviews

}//end ReviewTest
