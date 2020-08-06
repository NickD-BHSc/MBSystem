package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.business.SeatEncoding;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button seatConfirmButton;

    private AccessSeats accessSeats;
    private SeatEncoding seatEncoding;

    private List<Seat> seatingList;
    private List<Seat> bookedSeats;
    private String chosenSeats;
    private int chosenNumSeats;

    private ViewingTime viewingTime;
    private String seatString;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_list);
        init();
        buildRecyclerView();

        seatConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make sure that the user has chosen at least one seat to be able to move to the next page.
                if(bookedSeats.size() == 0){
                    Toast.makeText(SeatingActivity.this,"Please select a seat.",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);

                    addBookedSeats();
                    accessSeats = new AccessSeats();
                    seatEncoding = new SeatEncoding();
                    seatString = seatEncoding.encodeSeatList(seatingList, bookedSeats);
                    System.out.println("Updated Seat String:"+seatString);
                    accessSeats.updateSeatList(viewingTime, seatString );

                    //New changes
                    intent.putExtra("Chosen_Seats",chosenSeats);
                    intent.putExtra("Chosen_Num_Seats",chosenNumSeats);
                    intent.putExtra("Chosen_Theatre_Name",viewingTime.getTheatreName());
                    intent.putExtra("Chosen_Movie_Name",viewingTime.getMovieName());
                    intent.putExtra("Show_Time",viewingTime.getShowTime());
                    intent.putExtra("Show_Date",viewingTime.getShowDate());
                    intent.putExtra("Seats",viewingTime.getSeatString());

                    startActivity(intent);

                }
            }
        });

    }//end onCreate

    /**
     * init - a method that initializes the widgets and the lists. It also creates a sample data for the seats.
     */
    private void init(){

        seatConfirmButton = (Button)findViewById(R.id.seatConfirmButton);

        Intent intent = getIntent();

        //get the information from the previous activity. (which viewing time was selected for the chosen movie)
        String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
        String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
        String getShowTime = intent.getStringExtra("Show_Time");
        String getShowDate = intent.getStringExtra("Show_Date");
        String getSeats = intent.getStringExtra("Seats");

        viewingTime = new ViewingTime(getTheatreName,getMovieName,getShowTime,getShowDate,getSeats);

        bookedSeats = new ArrayList<>();//list that contains the booked seats.
        accessSeats = new AccessSeats();
        seatEncoding = new SeatEncoding();

        seatString = viewingTime.getSeatString();
        seatingList = seatEncoding.decodeSeatList(viewingTime.getSeatString());//data that will be passed to the CustomAdapter.



    }//end init

    /**
     * buildRecyclerView - a method that builds the layout for the list of seats.
     */
    private void buildRecyclerView(){

        seatRecyclerView = findViewById(R.id.seatRecyclerView);
        customAdapter = new CustomAdapter(SeatingActivity.this,seatingList);
        seatRecyclerView.setAdapter(customAdapter);

        layoutManager = new GridLayoutManager(this,SEAT_COLUMN);
        seatRecyclerView.setLayoutManager(layoutManager);
    }//end buildRecyclerView

    /**
     * addBookedSeats - a method that adds the booked seat numbers into a string to display.
     *             The result string is needed for the next activity (in Summary page/TicketActivity)
     */
    private void addBookedSeats(){

        chosenSeats = "";
        chosenNumSeats = bookedSeats.size();
        for(int i =0; i < bookedSeats.size(); i++){
            chosenSeats += bookedSeats.get(i).getSeatNumber() + ", ";
        }

        int lastCommaPosition = chosenSeats.lastIndexOf(", ");
        chosenSeats = chosenSeats.substring(0, lastCommaPosition);


    }//end addBookedSeats

    /**
     * addSeat - a method that adds the chosen seat in the bookedSeats.
     * @param seat is the object that is going to be added.
     */
    public void addSeat( Seat seat ){
        bookedSeats.add( seat );
    }//end addSeat

    /**
     * removeSeat - a method that removes the chosen seat in the bookedList.
     * @param seat is the object that is going to be removed.
     */
    public void removeSeat( Seat seat ){
        bookedSeats.remove(seat);
    }//end removeSeat

}//end SeatActivity class