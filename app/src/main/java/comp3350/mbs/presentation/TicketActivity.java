package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.business.Calculate;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Ticket;

public class TicketActivity extends AppCompatActivity {

    private AccessTickets accessTickets;
    private TextView ticketPriceTextView;
    private TextView ticketQuantityTextView;
    private TextView ticketSubtotalTextView;
    private TextView ticketTaxTextView;
    private TextView ticketTotalTextView;
    private TextView movieTitleTextView;

    private Movie movie;
    private int seatCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        accessTickets = new AccessTickets();
        setContentView(R.layout.activity_ticket);
        init();
        addTicketInfo();

    }//end onCreate


    /**
     * init - a method that initialize the widgets from the activity_ticket which are
     * 5 textViews
     */
    private void init() {

        ticketPriceTextView = findViewById(R.id.ticketPriceTextView);
        ticketQuantityTextView = findViewById(R.id.ticketQuantityTextView);
        ticketSubtotalTextView = findViewById(R.id.ticketSubtotalTextView);
        ticketTaxTextView = findViewById(R.id.ticketTaxTextView);
        ticketTotalTextView = findViewById(R.id.ticketTotalTextView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);

        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
        seatCount= intent.getIntExtra("seats", 0);
        movie = intent.getParcelableExtra("movie"); //get the movie so we know the price
    }//end init


    /**
     * addTicketInfo - a method that gets the information from the previous activity (SeatActivity)
     * and puts the information to the assigned widgets.
     */
    private void addTicketInfo() {

        ArrayList<Ticket> ticketList= new ArrayList<>();
        Ticket ticket = accessTickets.getTicket(movie.getTitle());
        for(int i = 0; i < seatCount; i++)
        {
            ticketList.add(ticket);
        }//end for

        ticketPriceTextView.setText(ticket.getPriceAsString());
        ticketQuantityTextView.setText(String.valueOf(ticketList.size()));
        ticketSubtotalTextView.setText(Calculate.calculateSubtotal(ticketList));
        ticketTaxTextView.setText(Calculate.calculateTax(ticketList));
        ticketTotalTextView.setText(Calculate.calculateTotal(ticketList));
        movieTitleTextView.setText("Order Summary - " + ticket.getType());

    }//end addTicketInfo

}//end TicketActivity class
