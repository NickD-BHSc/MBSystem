package comp3350.mbs.business;

import java.util.List;

import comp3350.mbs.objects.Movie;

public class Calculate {

    private final static double TAX = 1.12;

    public static double calculateOrder(List<Movie> movies){
        double totalOrder = 0;

        if(movies != null) {

            //TODO may also include the Snacks  (add another parameter which is a list of snacks.)
            for (int i = 0; i < movies.size(); i++) {
                totalOrder += movies.get(i).getPrice();
            }//end for

            totalOrder *=  TAX;

        }//end if

        return totalOrder;

    }//end calculateOrder


}//end CalculateOrder
