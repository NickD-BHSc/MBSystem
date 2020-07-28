package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.business.Calculate;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;

public class TicketActivity extends AppCompatActivity {

    private TextView ticketPriceTextView;
    private TextView ticketQuantityTextView;
    private TextView ticketSubtotalTextView;
    private TextView ticketTaxTextView;
    private TextView ticketTotalTextView;
    private TextView movieTitleTextView;

    private TheatreMovies theatreMovie;
    private List<Parcelable> bookedSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        init();
        addTicketInfo();

        Button submitOrderBtn = findViewById(R.id.submitButton);
        submitOrderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent startIntent = new Intent(getApplicationContext(), TicketStubActivity.class);
                startActivity(startIntent);
            }
        });



    }//end onCreate


    /**
     * init - a method that initialize the widgets from the activity_ticket which are
     *      6 textViews.
     */
    private void init() {

        ticketPriceTextView = findViewById(R.id.ticketPriceTextView);
        ticketQuantityTextView = findViewById(R.id.ticketQuantityTextView);
        ticketSubtotalTextView = findViewById(R.id.ticketSubtotalTextView);
        ticketTaxTextView = findViewById(R.id.ticketTaxTextView);
        ticketTotalTextView = findViewById(R.id.ticketTotalTextView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);


    }//end init


    /**
     * addTicketInfo - a method that gets the information from the previous activity (SeatActivity)
     * and puts the information to the assigned widgets.
     */
    private void addTicketInfo() {

        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
        //seatCount= intent.getIntExtra("seats", 0);
        bookedSeats = intent.getParcelableArrayListExtra("Booked_Seats");
        theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected"); //get the theatreMovie so we know the theatre, movie, and price

        if(theatreMovie == null){
            throw new Error("no chosen TheatreMovie");

        }else {
            AccessTickets accessTickets = new AccessTickets();
            ArrayList<Ticket> ticketList = new ArrayList<>();

            Ticket ticket = accessTickets.getTicket(theatreMovie.getMovieName());
            for (int i = 0; i < bookedSeats.size(); i++) {
                ticketList.add(ticket);
            }

            ticketPriceTextView.setText(ticket.getPriceAsString());
            ticketQuantityTextView.setText(String.valueOf(ticketList.size()));
            ticketSubtotalTextView.setText(Calculate.calculateSubtotal(ticketList));
            ticketTaxTextView.setText(Calculate.calculateTax(ticketList));
            ticketTotalTextView.setText(Calculate.calculateTotal(ticketList));

            //Displays the chosen seats (not in sorted order)
            String seatNumbers = "";
            for(int i = 0; i < bookedSeats.size(); i++){
                if(bookedSeats.get(i) instanceof ParcelableSeat){
                    ParcelableSeat seat = (ParcelableSeat)bookedSeats.get(i);
                    seatNumbers += seat.getSeatNumber() + ", ";
                }
            }

            movieTitleTextView.setText(theatreMovie.getTheatreName() + "\n" + theatreMovie.getMovieName() +"\nSeats: " + seatNumbers);
        }

    }//end addTicketInfo

}//end TicketActivity class
