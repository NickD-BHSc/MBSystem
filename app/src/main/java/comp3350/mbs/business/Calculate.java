package comp3350.mbs.business;

import java.text.DecimalFormat;
import java.util.List;

import comp3350.mbs.objects.Ticket;

public class Calculate {

    private static final double TAX_RATE = 0.15;
    static DecimalFormat moneyFormat = new DecimalFormat("0.00");

    /**
     * calculateSubTotal - a method that calculates the subtotal of the given tickets.
     * @param tickets is the given list of tickets.
     * @return it will return a subtotal of the given tickets in string.
     */
    public static String calculateSubtotal(List<Ticket> tickets, int totalSnackPrice){
        Ticket ticket;
        double subtotal = 0.0;
        if(tickets != null) {
            for (int i = 0; i < tickets.size(); i++) {
                ticket = tickets.get(i);
                if(ticket != null) {
                    subtotal += Math.abs(ticket.getPrice())+ totalSnackPrice;
                }
            }
        }

        return moneyFormat.format(subtotal);
    }//end calculateSubtotal

    /**
     * calculateTax - a method that calculates the tax of the given tickets.
     * @param tickets is the given list of tickets.
     * @return it will return the tax total of the given tickets in string.
     */
    public static String calculateTax(List<Ticket> tickets, int totalSnackPrice){

       double subtotal = Double.valueOf(calculateSubtotal(tickets,totalSnackPrice));
        double taxTotal = TAX_RATE * subtotal;
        return moneyFormat.format(taxTotal);
    }//end calculateTax

    /**
     * calculateTotal - a method that calculates the total cost of the given tickets.
     * @param tickets is the given list of tickets.
     * @return it will return the total cost of the given tickets in string.
     */
    public static String calculateTotal(List<Ticket> tickets, int totalSnackPrice){
        double subtotal = Double.valueOf(calculateSubtotal(tickets, totalSnackPrice));
        double taxTotal = Double.valueOf(calculateTax(tickets,totalSnackPrice));
        double total = subtotal + taxTotal;
        return moneyFormat.format(total);
    }//end calculateTotal

}//end Calculate class
