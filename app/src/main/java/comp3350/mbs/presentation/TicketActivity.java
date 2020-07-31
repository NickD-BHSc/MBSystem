package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.business.Calculate;
import comp3350.mbs.business.CreditCardValidation;
import comp3350.mbs.business.ParcelableFactory;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;

public class TicketActivity extends AppCompatActivity {

    private TextView ticketPriceTextView;
    private TextView ticketQuantityTextView;
    private TextView ticketSubtotalTextView;
    private TextView ticketTaxTextView;
    private TextView ticketTotalTextView;
    private TextView movieTitleTextView;
    private TextView cardInputTextView;
    private TextView cardExpiryTextView;
    private TextView cardSecurityCodeTextView;
    private TextView chosenSeatsTextView;


    private TheatreMovies theatreMovie;
    private List<Parcelable> bookedSeats;
    private ViewingTime movieDetails;
    private int seatCount;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        init();
        addTicketInfo();

        Button submitOrderBtn = findViewById(R.id.submitButton);
        submitOrderBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                cardInputTextView = findViewById(R.id.cardInput);
                cardExpiryTextView = findViewById(R.id.expiryInput);
                cardSecurityCodeTextView = findViewById(R.id.codeInput);
                String cardInput = cardInputTextView.getText().toString();
                String expiryDate = cardExpiryTextView.getText().toString();
                String securityCode = cardSecurityCodeTextView.getText().toString();


                if(!CreditCardValidation.isCardValid(cardInput, expiryDate, securityCode)){
                    Toast.makeText(TicketActivity.this,"Please enter a valid credit card.",Toast.LENGTH_SHORT).show();
                }else {
                    Intent startIntent = new Intent(TicketActivity.this, TicketStubActivity.class);
                    ParcelableViewingTime pvt = (ParcelableViewingTime) ParcelableFactory.createParcelableObject(movieDetails);
                    startIntent.putExtra("ViewingTime_Selected", pvt);
                    startIntent.putExtra("Quantity", seatCount);

                    startActivity(startIntent);
                }
            }
        });

    }//end onCreate

    /**
     * init - a method that initialize the widgets from the activity_ticket which are
     *      6 textViews.
     */
    private void init(){

        ticketPriceTextView = findViewById(R.id.ticketPriceTextView);
        ticketQuantityTextView = findViewById(R.id.ticketQuantityTextView);
        ticketSubtotalTextView = findViewById(R.id.ticketSubtotalTextView);
        ticketTaxTextView = findViewById(R.id.ticketTaxTextView);
        ticketTotalTextView = findViewById(R.id.ticketTotalTextView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);
        chosenSeatsTextView = findViewById(R.id.chosenSeatsTextView);

        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
        seatCount= intent.getIntExtra("seats", 0);
        movieDetails = intent.getParcelableExtra("ViewingTime_Selected");

    }//end init


    /**
     * addTicketInfo - a method that gets the information from the previous activity (SeatActivity)
     * and puts the information to the assigned widgets.
     */
    private void addTicketInfo(){

        Intent intent = getIntent();
        bookedSeats = intent.getParcelableArrayListExtra("Booked_Seats");
        theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected");

        if(theatreMovie == null){
            throw new Error("No chosen TheatreMovie");

        }else{
            AccessTickets accessTickets = new AccessTickets();
            ArrayList<Ticket> ticketList = new ArrayList<>();

            Ticket ticket = accessTickets.getTicket(theatreMovie.getMovieName());
            for (int i = 0; i < bookedSeats.size(); i++){
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
            int lastCommaPosition = seatNumbers.lastIndexOf(", ");
            seatNumbers = seatNumbers.substring(0, lastCommaPosition);

            movieTitleTextView.setText(theatreMovie.getTheatreName() + "\n" + theatreMovie.getMovieName() +"\nSeats: " + seatNumbers);
            movieTitleTextView.setText(theatreMovie.getTheatreName() + ", " + theatreMovie.getMovieName());
            chosenSeatsTextView.setText(seatNumbers);
        }

    }//end addTicketInfo

}//end TicketActivity class
