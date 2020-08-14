package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.application.Main;
import comp3350.mbs.application.Services;
import comp3350.mbs.objects.Review;
import comp3350.mbs.persistence.DataAccess;

public class AccessReviews {

    private DataAccess dataAccess;

    /**
     * AccessReviews Constructor - gets the data/service stored in the database Main.dbName.
     */
    public AccessReviews(){
        dataAccess = Services.getDataAccessService(Main.dbName);
    }//end constructor

    /**
     * getReviewList -a getter method that returns a list of reviews.
     * @return it will return the reviewList from the dataAccess.
     */
    public List<Review> getReviewList(String movieName, String rating){
        return dataAccess.getReviewList(movieName, rating);
    }//end getReviewList

    /**
     * insertNewReview - Inserts an entry into the Reviews table.
     */
    public void insertNewReview(Review review){
        dataAccess.insertNewReview(review);
    }

    /**
     * deleteReview - Deletes an entry in the Reviews table.
     */
    public void deleteReview(Review review) { dataAccess.deleteReview( review ); }

}
