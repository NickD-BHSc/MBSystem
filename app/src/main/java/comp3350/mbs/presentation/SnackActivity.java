package comp3350.mbs.presentation;

// addig comment 
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.business.AccessSeats;
import comp3350.mbs.business.SeatEncoding;
import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.ViewingTime;

//import comp3350.mbs.business.ParcelableFactory;
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

	private List<Seat> bookedSeats;

	private ViewingTime movieDetails;

	private TheatreMovies theatreMovie;
	private ViewingTime vt;


	private AccessSeats accessSeats;
	private SeatEncoding seatEncoding;
	private List<Seat> seatingList;
	//    private List<Seat> bookedSeats;
	private ViewingTime viewingTime;
	private String seatString;
	private String chosenSeats;
	private int numBookedSeats;


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

					int hotdogQuantity = 0;
					String hStr = null;
					if( hotdogQuantityEt.getText() != null) 
						hStr = hotdogQuantityEt.getText().toString();
					if (hStr != null)
					hotdogQuantity = Integer.parseInt( hStr ) ;

					int popcornQuantity = 0;
					String pStr = null;
					if( popcornQuantityEt.getText() != null) 
						pStr = popcornQuantityEt.getText().toString();
					if (pStr != null)
						popcornQuantity = Integer.parseInt( pStr) ;

					int friesQuantity = 0;
					String fStr = null;
					if( friesQuantityEt.getText() != null) 
						fStr = friesQuantityEt.getText().toString();
					if (fStr != null)
						friesQuantity = Integer.parseInt( fStr ) ;

					int drinkQuantity = 0;
					String dStr = null ;
					if( drinkQuantityEt.getText() != null) 
						dStr = drinkQuantityEt.getText().toString();
					if (dStr != null)
						drinkQuantity = Integer.parseInt( dStr ) ;

					int noodleQuantity =0;
					String nStr = null; 
					if( noodleQuantityEt.getText() != null) 
						nStr = noodleQuantityEt.getText().toString();
					if (nStr != null)
						noodleQuantity = Integer.parseInt( nStr ) ;

					int chipsQuantity = 0;
					String cStr = null;
					if( chipsQuantityEt.getText() != null) 
						cStr = chipsQuantityEt.getText().toString();
					if (cStr != null)
						chipsQuantity = Integer.parseInt( cStr ) ;

					int total =hotdogQuantity*hotdogPrice+popcornQuantity*popcornPrice+friesQuantity*friesPrice+drinkQuantity*drinkPrice+noodleQuantity*noodlePrice+chipsQuantity*noodlePrice;

					Intent intent = getIntent();
					String getTheatreName = intent.getStringExtra("Chosen_Theatre_Name");
					String getMovieName = intent.getStringExtra("Chosen_Movie_Name");
					String getShowTime = intent.getStringExtra("Show_Time");
					String getShowDate = intent.getStringExtra("Show_Date");
					numBookedSeats = intent.getIntExtra("Chosen_Num_Seats", 0);
					chosenSeats = intent.getStringExtra("Chosen_Seats");

					Intent i = new Intent(SnackActivity.this, TicketActivity.class);
					i.putExtra("Chosen_Seats",chosenSeats);
					i.putExtra("Chosen_Num_Seats",numBookedSeats);
					i.putExtra("Chosen_Theatre_Name",getTheatreName);
					i.putExtra("Chosen_Movie_Name",getMovieName);
					i.putExtra("Show_Time",getShowTime);
					i.putExtra("Show_Date",getShowDate);
					startActivity(i);

					}

					private String bookedSeatsInfo(){

						String chosenSeats = "";
						for(int i =0; i < bookedSeats.size(); i++){
							chosenSeats += bookedSeats.get(i).getSeatNumber() + ", ";
						}
						int lastCommaPosition = chosenSeats.lastIndexOf(", "); //removes the last comma
						chosenSeats = chosenSeats.substring(0, lastCommaPosition);

						return chosenSeats;

					}//end bookedSeatsInfo
			}
			);
		}
}
