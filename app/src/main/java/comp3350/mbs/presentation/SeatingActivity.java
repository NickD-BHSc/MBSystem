package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import comp3350.mbs.business.ParcelableFactory;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.business.SeatEncoding;

public class SeatingActivity extends AppCompatActivity {

    private static final int SEAT_COLUMN = 8;
    private RecyclerView seatRecyclerView;
    private CustomAdapter customAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private AccessSeats accessSeats;
    private SeatEncoding se;

    private List<Seat> seatingList;
    private List<Seat> bookedSeats;

    private Button seatConfirmButton;
    private TheatreMovies theatreMovie;
    private ViewingTime vt;
    private String seatString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                }else {
                    Intent intent = new Intent(SeatingActivity.this, TicketActivity.class);
                    //passing the whole list.
                    intent.putExtra("seats", bookedSeats.size());
                    ParcelableTheatreMovies ptm = (ParcelableTheatreMovies) ParcelableFactory.createParcelableObject(theatreMovie);
                    intent.putExtra("TheatreMovie_Selected", ptm);

                    accessSeats = new AccessSeats();
                    se = new SeatEncoding();
                    ParcelableViewingTime pvt = (ParcelableViewingTime) ParcelableFactory.createParcelableObject(vt);
                    //Intent vtIntent = new Intent(SeatingActivity.this, TicketActivity.class);
                    intent.putExtra("ViewingTime_Selected", pvt);

                    seatString = se.encodeSeatList(seatingList, bookedSeats);
                    System.out.println("Updated Seat String:"+seatString);
                    accessSeats.updateSeatList( vt, seatString );
                    //accessSeats.setTicketTheatre(vt);
                    startActivity(intent);
                }//end if-else
            }
        });

    }//end onCreate

    /**
     * init - a method that initializes the widgets and the lists. It also creates a sample data for the seats.
     */
    private void init(){
        Intent intent = getIntent();
        theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected");
        vt = intent.getParcelableExtra( "VT");

        seatConfirmButton = (Button)findViewById(R.id.seatConfirmButton);
        accessSeats = new AccessSeats();
        se = new SeatEncoding();

        //initialize the lists.
        System.out.println("Encoded Seatlist: "+vt.getSeatString() );
        seatString = vt.getSeatString();
        seatingList = se.decodeSeatList( vt.getSeatString() );//data that will be passed to the CustomAdapter.

        bookedSeats = new ArrayList<>();//list that contains the booked seats.

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

    /*
    //TODO: These decode and encode functions really shouldn't be here. Move them to 'AccessSeats' and adjust the functionc calls here.
    private List<Seat> decodeSeatList( String str ){
        ArrayList<Seat> out = new ArrayList<Seat>();

        for( int i = 0; i < str.length(); i++ ){
            Seat s;

            if( str.charAt( i ) == '0' ){
                s = new Seat( i, false, R.drawable.seat);
            }
            else{
                s = new Seat( i, true, R.drawable.seat_taken);
            }

            out.add( s );
        }

        return out;
    }

    private String encodeSeatList(){
        String s = "";

        for(int i = 0; i < seatingList.size(); i++ ){
            if( bookedSeats.contains( seatingList.get(i)) || seatingList.get(i).isBooked() ){
                s = s + "1";
            }
            else{
                s = s + "0";
            }
        }

        return s;

    }

     */


}//end SeatActivity class