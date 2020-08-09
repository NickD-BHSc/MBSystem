package comp3350.mbs.business;

import junit.framework.TestCase;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.objects.Review;

public class AccessReviewsTest extends TestCase {
    private static String dbName = Main.dbName;
    private AccessReviews accessReviews;
    private List<Review> reviewList;
    private Review review;

    public AccessReviewsTest(String arg0){super(arg0);}

    public void setUp(){
        accessReviews = null;
        reviewList = null;
        review = null;
    }//end SetUp




}//end AccessReviewsTest
