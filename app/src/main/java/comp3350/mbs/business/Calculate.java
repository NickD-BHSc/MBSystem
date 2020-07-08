package comp3350.mbs.business;

import java.text.DecimalFormat;

import comp3350.mbs.objects.Ticket;

public class Calculate {

    private static final double TAX_RATE = 0.15;
    static DecimalFormat moneyFormat = new DecimalFormat("0.00");

    public static String calculateSubtotal(Ticket ticket)
    {
        double subtotal = ticket.getPrice() * ticket.getQuantity();
        if(subtotal != 0.0)
        {
            return moneyFormat.format(subtotal); // might not need this either
        }
        else
        {
            return moneyFormat.format(0.00);
        }
    }

    public static String calculateTax(Ticket ticket) {
        double subtotal = Double.valueOf(calculateSubtotal(ticket));
        double taxTotal = TAX_RATE * subtotal;
        if(taxTotal != 0.0)
        {
            return moneyFormat.format(taxTotal); // I don't think this if else is necessary
        }
        else
        {
            return moneyFormat.format(0);
        }

    }

    public static String calculateTotal(Ticket ticket) {
        double subtotal = Double.valueOf(calculateSubtotal(ticket));
        double taxTotal = Double.valueOf(calculateTax(ticket));
        double total = subtotal + taxTotal;
        return moneyFormat.format(total);
    }

}
