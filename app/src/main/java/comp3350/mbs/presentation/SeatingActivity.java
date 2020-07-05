package comp3350.mbs.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.objects.Seat;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private List<Seat> seatingList;
    private List<Integer> bookedSeats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_list);
        init();
        buildRecyclerView();
        Button ctnueButton = (Button)findViewById(R.id.seatConfirmButton);
        final TextView result = (TextView)findViewById(R.id.showResult);

        ctnueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText( bookedSeats.toString() );


            }
        });

    }//end onCreate




    private void init(){
        seatingList = new ArrayList<>();
        bookedSeats = new ArrayList<Integer>();

        //some sample data
        for(int i = 0; i < 32; i++) {
            Seat seat;
            if( i%5 != 0){
                seat = new Seat(i,false, R.drawable.seat);
            }else{
                seat = new Seat(i,true, R.drawable.seat_taken);
            }//end if-else
            seatingList.add(seat);
        }//end for loop

        //Simply checks the sample data in the text for debugging.
        /*
        TextView txtVw = findViewById(R.id.seatPromptTextView);
        String result = "";
        for(int i = 0; i < seatingList.size(); i ++){
            result += "seat " + i + ": booked? " + seatingList.get(i).isBooked() + "\n";
        }//end for

        txtVw.setText(result);
        */

    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of seats.
     */
    private void buildRecyclerView(){
        seatRecyclerView = findViewById(R.id.seatRecyclerView);

        customAdapter = new CustomAdapter(SeatingActivity.this,seatingList);
        seatRecyclerView.setAdapter(customAdapter);

        //5 column
        layoutManager = new GridLayoutManager(this,SEAT_COLUMN);
        seatRecyclerView.setLayoutManager(layoutManager);
    }//end buildRecyclerView

    public void addSeat( Seat seat ){
        bookedSeats.add( seat.getSeatNumber() );
    }

    public void removeSeat( Seat seat ){
        bookedSeats.remove( bookedSeats.indexOf( seat.getSeatNumber() ));
    }


}//end SeatActivity class