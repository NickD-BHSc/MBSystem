package comp3350.mbs.business;

import junit.framework.TestCase;

import org.junit.Test;

import comp3350.mbs.objects.Review;

public class ReviewValidationTest extends TestCase {

    public ReviewValidationTest(String arg0)
    {
        super(arg0);
    }

    @Test
    public void testEmptyFields(){
        System.out.println("Starting ReviewValidationTest: testEmptyFields");

        Review review = new Review("","","","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testEmptyFields\n");

    }//end testEmptyFields

    @Test
    public void testInvalidCustomerName(){
        System.out.println("Starting ReviewValidationTest: testInvalidCustomerName");
        Review review;

        review = new Review("Movie1","","5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","\t\t\t\t","5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","\t\t\t \t                  ","5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","                              ","5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1",null,"5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testInvalidCustomerName\n");

    }//end testInvalidCustomerName

    @Test
    public void testInvalidRating(){
        System.out.println("Starting ReviewValidationTest: testInvalidRating");
        Review review;

        review = new Review("Movie1","User1","","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1",null,"This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","-1","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","hi","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","1.1.1.1.1","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","3.5","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","1000","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","6","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","0","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","    ","This is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testInvalidRating\n");
    }//end testInvalidRating

    @Test
    public void testInvalidComment(){
        System.out.println("Starting ReviewValidationTest: testInvalidComment");
        Review review;

        review = new Review("Movie1","User1","5","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","5",null);
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","5","                      ");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","5","\t\t\t\t");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","5","\t\t\t \t             ");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testInvalidComment\n");
    }//end testEmptyComment

    @Test
    public void testInvalidReviews(){
        System.out.println("Starting ReviewValidationTest: testInvalidReviews");
        Review review;

        review = new Review(null,null,null,null);
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review(null,"","","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("",null,"","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("","",null,"");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("","","",null);
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("",null,"",null);
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("","",null,null);
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("",null,null,"");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","5","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","0","");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","1999","this is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","-1","this is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","User1","6","this is a review");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review(" "," ","3","    ");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review(" ","            ","                 ",  "            ");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review(" ","\t\t\t\t\t\t\t","                 ",  "\t\t\t\t\t\t\t\t");
        assertNotNull(review);
        assertFalse(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testInvalidReviews\n");
    }//end testInvalidReviews

    @Test
    public void testValidReviews(){
        System.out.println("Starting ReviewValidationTest: testValidReviews");
        Review review;

        review = new Review("Movie1","User1","5","This is a review");
        assertNotNull(review);
        assertTrue(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review(null,"User1","4","This is a review");
        assertNotNull(review);
        assertTrue(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));


        review = new Review("Movie1","__User1","2","COmmEnnnnnnnt");
        assertNotNull(review);
        assertTrue(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","TheLegend_27","1","Legendary");
        assertNotNull(review);
        assertTrue(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        review = new Review("Movie1","U_S3*R","1","This is a comment");
        assertNotNull(review);
        assertTrue(ReviewValidation.isReviewValid(review.getCustomerName(),review.getRating(),review.getComments()));

        System.out.println("Starting ReviewValidationTest: testValidReviews\n");
    }//end testValidReviews

}//end ReviewValidationTest
