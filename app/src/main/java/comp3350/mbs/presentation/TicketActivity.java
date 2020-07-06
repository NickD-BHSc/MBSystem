package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessTickets;
import comp3350.mbs.business.Calculate;
import comp3350.mbs.objects.Ticket;

import android.widget.Button;

public class TicketActivity extends AppCompatActivity {

    private AccessTickets accessTickets;
    private TextView ticketPriceTextView;
    private TextView ticketQuantityTextView;
    private TextView ticketSubtotalTextView;
    private TextView ticketTaxTextView;
    private TextView ticketTotalTextView;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        accessTickets = new AccessTickets();
        setContentView(R.layout.activity_ticket);
        backButton = findViewById(R.id.BackButton);
        init();
        addTicketInfo();

        backButton.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v){
            Intent intent = new Intent(TicketActivity.this, SeatingActivity.class);
            startActivity(intent);
            }
        });
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

    }//end init


    /**
     * addTicketInfo - a method that gets the information from the previous activity (SeatActivity)
     * and puts the information to the assigned widgets.
     */
    private void addTicketInfo() {

        Intent intent = getIntent();  //getting the number of seats booked in the previous activity.
        int seatCount= intent.getIntExtra("seats", 0);
        Ticket ticket;
        Ticket generalTicket = accessTickets.getTicket("General");
        Ticket emptyTicket = accessTickets.getTicket("Empty");
        if(seatCount > 0) {
            ticket = new Ticket(generalTicket.getPrice(), generalTicket.getType(), seatCount);
        }else{
            ticket = emptyTicket;
        }
        ticketPriceTextView.setText(ticket.getPriceAsString());
        ticketQuantityTextView.setText(String.valueOf(ticket.getQuantity()));
        ticketSubtotalTextView.setText(Calculate.calculateSubtotal(ticket));
        ticketTaxTextView.setText(Calculate.calculateTax(ticket));
        ticketTotalTextView.setText(Calculate.calculateTotal(ticket));

    }//end addTicketInfo

}//end TicketActivity class
