package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;
import comp3350.mbs.objects.Movie;

public class SnackActivity extends AppCompatActivity {
    private int seatCounts;
    private Movie movie;

    private EditText hotdogQuantityEt;
    private EditText popcornQuantityEt;
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

                     int hotdogQuantity = Integer.parseInt( hotdogQuantityEt.getText().toString() ) ;
                     int popcornQuantity = Integer.parseInt( popcornQuantityEt.getText().toString() ) ;
                     int friesQuantity = Integer.parseInt( popcornQuantityEt.getText().toString() ) ;
                     int drinkQuantity = Integer.parseInt( drinkQuantityEt.getText().toString() ) ;
                     int noodleQuantity = Integer.parseInt( noodleQuantityEt.getText().toString() ) ;
                     int chipsQuantity = Integer.parseInt( chipsQuantityEt.getText().toString() ) ;
                     int total = hotdogQuantity*hotdogPrice+popcornQuantity*popcornPrice+friesQuantity*friesPrice+drinkQuantity*drinkPrice+noodleQuantity*noodlePrice+chipsQuantity*noodlePrice;

                     seatCounts = intent.getIntExtra("seats",0);
                     movie = intent.getParcelableExtra( "movie ");

                     Intent i = new Intent(SnackActivity.this, TicketActivity.class);
                     i.putExtra("seats", seatCounts );
                     i.putExtra( "movie" , movie );
                     i.putExtra("price",total );
                     startActivity(i);
                }
        }


        );
    }
}