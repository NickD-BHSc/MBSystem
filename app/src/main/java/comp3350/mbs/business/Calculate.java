package comp3350.mbs.business;

import java.text.DecimalFormat;
import java.util.ArrayList;

import comp3350.mbs.objects.Ticket;

public class Calculate {

    private static final double TAX_RATE = 0.15;
    static DecimalFormat moneyFormat = new DecimalFormat("0.00");

    public static String calculateSubtotal(ArrayList<Ticket> tickets)
    {
        Ticket ticket;
        double subtotal = 0.0;
        if(tickets != null)
        {
            for (int i = 0; i < tickets.size(); i++)
            {
                ticket = tickets.get(i);
                if(ticket != null)
                {
                    subtotal += Math.abs(ticket.getPrice()) * ticket.getQuantity();
                }
            }
        }
        return moneyFormat.format(subtotal);
    }

    public static String calculateTax(ArrayList<Ticket> tickets) {

        double subtotal = Double.valueOf(calculateSubtotal(tickets));
        double taxTotal = TAX_RATE * subtotal;
        return moneyFormat.format(taxTotal);
    }

    public static String calculateTotal(ArrayList<Ticket> tickets) {
        double subtotal = Double.valueOf(calculateSubtotal(tickets));
        double taxTotal = Double.valueOf(calculateTax(tickets));
        double total = subtotal + taxTotal;
        return moneyFormat.format(total);
    }

}
