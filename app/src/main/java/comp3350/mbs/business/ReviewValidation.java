package comp3350.mbs.business;

public class ReviewValidation {

    public static boolean isReviewValid(String name, String rating, String comment)
    {
        if(isNameValid(name) && isCommentValid(comment) && isRatingValid(rating))
            return true;

        return false;
    }

    private static boolean isRatingValid(String rating) {

        if(rating.length() != 0)
        {
            int ratingValue = Integer.valueOf(rating);
            return ratingValue >= 1 && ratingValue <= 5;
        }
        return false;
    }

    private static boolean isCommentValid(String comment) {
        return comment.length() != 0;
    }

    private static boolean isNameValid(String name) {
        return name.length() != 0;
    }
}
