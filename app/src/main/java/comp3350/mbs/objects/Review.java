package comp3350.mbs.objects;

public class Review {
    private String movieName;
    private String customerName;
    private String rating;
    private String comments;


    /**
     * Constructor of Review class.
     *
     * @param movieName is the type of the ticket.
     * @param customerName is the person who left the review
     * @param rating is a 1-5 rating of the movie
     * @param comments are the comments left by te reviewer
     */
    public Review(String movieName, String customerName, String rating, String comments){
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

    public String getRating(){
        return rating;
    }//end getRating

    public String getComments(){
        return comments;
    }//end getComments

}//end Review Class
