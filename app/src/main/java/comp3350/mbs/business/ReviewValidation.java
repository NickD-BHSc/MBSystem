package comp3350.mbs.business;

public class ReviewValidation {

    /**
     * isReviewValid - a method that determines if the given review (fields) are valid.
     * @param name is the name of the user/customer that gave the review.
     * @param rating is the rating of the movie.
     * @param comment is the comment for the movie.
     * @return it will return true if all the fields are valid.
     */
    public static boolean isReviewValid(String name, String rating, String comment) {
        return isNameValid(name) && isCommentValid(comment) && isRatingValid(rating);
    }//end isReviewValid

    /**
     * isRatingValid - a method that checks if the rating is valid.
     * @param rating is the given rating.
     * @return it will return true if the rating is in between 0 to 5 inclusive.
     */
    private static boolean isRatingValid(String rating) {
        boolean checkRating = false;

        if(rating != null){

            if(rating.length() != 0) {
                int ratingValue = Integer.valueOf(rating);
                checkRating = ratingValue >= 1 && ratingValue <= 5;
            }
        }
        return checkRating;

    }//end isRatingValid

    /**
     * isCommentValid - a method that checks if the comment is valid.
     * @param comment is the given comment.
     * @return it will return true if the comment has any characters.
     */
    private static boolean isCommentValid(String comment) {
        boolean checkComment = false;

        if(comment != null){
            checkComment = comment.length() != 0;
        }
        return checkComment;
    }//end isCommentValid

    /**
     * isNameValid - a method that checks if the name is valid.
     * @param name is the given name.
     * @return it will return true if the name has any characters.
     */
    private static boolean isNameValid(String name) {
        boolean checkName = false;
        if(name != null){
            checkName = name.length() != 0;
        }
        return checkName;
    }//end isNameValid

}//end ReviewValidation
