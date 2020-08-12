package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.ParcelableFactory;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;
//import comp3350.mbs.objects.Movie;

public class SnackActivity extends AppCompatActivity {
    private int seatCounts;
//    private Movie movie;
private List<Parcelable> parcBookedSeats;

    private EditText hotdogQuantityEt ;
    private EditText popcornQuantityEt ;
    private EditText friesQuantityEt;
    private EditText drinkQuantityEt;
    private EditText noodleQuantityEt;
    private EditText chipsQuantityEt;

    final private int hotdogPrice = 2;
    final private int popcornPrice =3;
    final private int friesPrice = 3;
    final private int drinkPrice = 1;
    final private int noodlePrice = 5;
    final private int chipsPrice = 4;

    private List<Parcelable> bookedSeats;

    private ViewingTime movieDetails;

    private TheatreMovies theatreMovie;
    private ViewingTime vt;



    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        hotdogQuantityEt = findViewById(R.id.hotdog_eidt);
        popcornQuantityEt = findViewById(R.id.popcorn_edit);
        friesQuantityEt = findViewById(R.id.fries_edit);
        drinkQuantityEt = findViewById(R.id.drink_edit);
        noodleQuantityEt = findViewById(R.id.noodle_edit);
        chipsQuantityEt = findViewById(R.id.chips_edit);

        confirmBtn =( Button) findViewById(R.id.snackConfirm);
        confirmBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v)
                 {

                     Intent intent = getIntent();
                     int hotdogQuantity = 0;
                     String hStr = hotdogQuantityEt.getText().toString();
                     if (hStr != null)
                          hotdogQuantity = Integer.parseInt( hStr ) ;

                     int popcornQuantity = 0;
                     String pStr = popcornQuantityEt.getText().toString();
                     if (pStr != null)
                         popcornQuantity = Integer.parseInt( pStr) ;

                     int friesQuantity = 0;
                     String fStr = popcornQuantityEt.getText().toString();
                     if (fStr != null)
                         friesQuantity = Integer.parseInt( fStr ) ;

                     int drinkQuantity = 0;
                     String dStr = drinkQuantityEt.getText().toString();
                     if (dStr != null)
                         drinkQuantity = Integer.parseInt( dStr ) ;

                     int noodleQuantity =0;
                     String nStr = drinkQuantityEt.getText().toString();
                     if (nStr != null)
                         noodleQuantity = Integer.parseInt( nStr ) ;

                     int chipsQuantity = 0;
                     String cStr = chipsQuantityEt.getText().toString();
                     if (cStr != null)
                         chipsQuantity = Integer.parseInt( cStr ) ;

                     int total =hotdogQuantity*hotdogPrice+popcornQuantity*popcornPrice+friesQuantity*friesPrice+drinkQuantity*drinkPrice+noodleQuantity*noodlePrice+chipsQuantity*noodlePrice;

                     seatCounts = intent.getIntExtra("seats",0);
//                     movie = intent.getParcelableExtra( "movie ");
                     movieDetails = intent.getParcelableExtra("ViewingTime_Selected");
                     bookedSeats = intent.getParcelableArrayListExtra("Booked_Seats");
                     theatreMovie = intent.getParcelableExtra("TheatreMovie_Selected"); //get the theatreMovie so we know the theatre, movie, and price
                     Parcelable parcTheatreMovie = ParcelableFactory.createParcelableObject(theatreMovie);
                     ParcelableViewingTime pvt = (ParcelableViewingTime) ParcelableFactory.createParcelableObject(vt);



                     intent.putExtra("ViewingTime_Selected", pvt);
                     Intent i = new Intent(SnackActivity.this, TicketActivity.class);
                     i.putExtra("TheatreMovie_Selected", parcTheatreMovie);
                     i.putExtra("ViewingTime_Selected", pvt);
                     i.putParcelableArrayListExtra("Booked_Seats", (ArrayList<? extends Parcelable>) bookedSeats);
                     i.putExtra("seats", seatCounts );
//                     i.putExtra( "movie" , movie );
                     i.putExtra("price",total );
                     startActivity(i);
                }
        }
        );
    }
}
