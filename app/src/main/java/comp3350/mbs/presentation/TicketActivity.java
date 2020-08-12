package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
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
import comp3350.mbs.objects.Order;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;

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
    private Order order;
    private String chosenSeats;
    private int numBookedSeats;

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
                    startIntent.putExtra("Order_Theatre",order.getTheatreName());
                    startIntent.putExtra("Order_Movie",order.getMovieName());
                    startIntent.putExtra("Order_Show_Time",order.getShowTime());
                    startIntent.putExtra("Order_Show_Date",order.getShowDate());
                    startIntent.putExtra("Order_Num_Tickets",order.getTicketQuantity());
                    startActivity(startIntent);
                }
            }
        });

    }//end onCreate

    /**
     * init - a method that initialize the widgets from the activity_ticket xml.
     *         Also gets the information from the preceding Activity.
     */
    private void init(){

        ticketPriceTextView = findViewById(R.id.ticketPriceTextView);
        ticketQuantityTextView = findViewById(R.id.ticketQuantityTextView);
        ticketSubtotalTextView = findViewById(R.id.ticketSubtotalTextView);
        ticketTaxTextView = findViewById(R.id.ticketTaxTextView);
        ticketTotalTextView = findViewById(R.id.ticketTotalTextView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);
        chosenSeatsTextView = findViewById(R.id.chosenSeatsTextView);

        Intent intent = getIntent();
        String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
        String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
        String getShowTime = intent.getStringExtra("Show_Time");
        String getShowDate = intent.getStringExtra("Show_Date");
        numBookedSeats = intent.getIntExtra("Chosen_Num_Seats", 0);
        chosenSeats = intent.getStringExtra("Chosen_Seats");

        theatreMovie = new TheatreMovies(getTheatreName,getMovieName);
        order = new Order(getMovieName,getShowTime, getShowDate,getTheatreName,numBookedSeats);

    }//end init


    /**
     * addTicketInfo - a method that gets the information from the previous activity (SeatActivity)
     * and puts the information to the assigned widgets.
     */
    private void addTicketInfo(){

        AccessTickets accessTickets = new AccessTickets();
        List<Ticket> ticketList = new ArrayList<>();

        Ticket ticket = accessTickets.getTicket(theatreMovie.getMovieName());
        for (int i = 0; i < numBookedSeats; i++){
            ticketList.add(ticket);
        }
        ticketPriceTextView.setText(ticket.getPriceAsString());
        ticketQuantityTextView.setText(String.valueOf(ticketList.size()));
        ticketSubtotalTextView.setText(Calculate.calculateSubtotal(ticketList));
        ticketTaxTextView.setText(Calculate.calculateTax(ticketList));
        ticketTotalTextView.setText(Calculate.calculateTotal(ticketList));

        movieTitleTextView.setText(theatreMovie.getTheatreName() + ", " + theatreMovie.getMovieName());
        chosenSeatsTextView.setText(chosenSeats);

    }//end addTicketInfo

}//end TicketActivity class
