package comp3350.mbs.objects;

public class Review {


    private String movieName;
    private String customerName;
    private int rating;
    private String comments;

    /**
     * Review constructor for implementing Parcelable interface in the ParcelableReview class.
     */
    public Review(){}

    /**
     * Constructor of Review class.
     *
     * @param movieName is the type of the ticket.
     * @param customerName is the person who left the review
     * @param rating is a 1-5 rating of the movie
     * @param comments are the comments left by te reviewer
     */
    public Review(String movieName, String customerName, int rating, String comments){
        this.movieName = movieName;
        this.customerName = customerName;
        this.rating = rating;
        this.comments = comments;
    }//end Constructor


    //Getter methods
    public String getMovieName(){
        return movieName;
    }//end getType

    public String getCustomerName(){
        return customerName;
    }//end getCustomerName

    public int getRating(){
        return rating;
    }//end getRating

    public String getComments(){
        return comments;
    }//end getComments

    //Setter methods
    public void setMovieName(String movieName){
        this.movieName = movieName;
    }//end setMovieName

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }//end setCustomerName

    public void setRating(int rating){
        this.rating = rating;
    }//end setRating

    public void setComments(String comments){
        this.comments = comments;
    }//end setComments

}//end Review Class
