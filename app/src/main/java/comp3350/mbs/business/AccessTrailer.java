package comp3350.mbs.business;

public class AccessTrailer {

    /**
     * cleanString - a helper method to convert movie title into lower case string with no spaces
     * @return string with lower case and zero space formatting.
     */
    public static String cleanString(String title){
        String clean = "";
        if(title.length() < 1){
            throw new IllegalArgumentException("movie title is empty: " + title);
        }
        else{
            clean = title.replaceAll("\\s+","");
            clean = clean.toLowerCase();
        }

        return clean;
    }

}
