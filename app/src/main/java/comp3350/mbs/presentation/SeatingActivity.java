package comp3350.mbs.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.adapter.CustomAdapter;
import comp3350.mbs.objects.Movie;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.objects.Seating;



public class SeatingActivity extends AppCompatActivity {

    List<Integer> mapping = new ArrayList<Integer>(32); //Test Data

    //both of these are used for comparisons of ImageButtons
    ImageButton compare;
    ImageButton select;

    Seating storeObj = new Seating( mapping ); //replace this with database input later

    ArrayList<ImageButton> seats = new ArrayList( 32 ); //Array of Seat Image Buttons

    Button cntinueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Initializing Test Data
        for( int i = 0; i < 32; i++ ){
            if( i%3 != 0)
                mapping.add(new Integer(1));
            else
                mapping.add(new Integer(0));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seating);

        seats = init( mapping );

        cntinueBtn = findViewById(R.id.buttonContinue);

        compare =  findViewById(R.id.compare);
        final Bitmap bitmap = ((BitmapDrawable)compare.getDrawable()).getBitmap();

        select = findViewById(R.id.select);
        final Bitmap selmap = ((BitmapDrawable)select.getDrawable()).getBitmap();

        for( int i = 0; i < seats.size(); i++) {
            final int j = i;
            seats.get(j).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (bitmap.sameAs(((BitmapDrawable) seats.get(j).getDrawable()).getBitmap())) {
                        seats.get(j).setImageResource(R.drawable.seat_selected);
                        storeObj.incrementBooked(1);
                        storeObj.addSeat( j );
                    }
                    else if( selmap.sameAs(((BitmapDrawable) seats.get(j).getDrawable()).getBitmap())) {
                        seats.get(j).setImageResource(R.drawable.seat);
                        storeObj.incrementBooked( -1 );
                        storeObj.removeSeat( j );
                    }
                }
            });
        }

        cntinueBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick( View v){
                System.out.println( storeObj.getBookedSeats().toString());
                Intent intent = new Intent(SeatingActivity.this, MovieActivity.class);
                intent.putExtra("item",storeObj);


            }
        });

    }

    private ArrayList<ImageButton> init ( List<Integer> mapping) {
        //Takes a list of 1's and 0's from mapping, and maps it to a new seats array.

        ArrayList<ImageButton> seats = new ArrayList<ImageButton>( 32 );
        //Initializing Seat Array - (Yes I need to do it this way)
        //Integer seat = (Integer)getResources().getIdentifier( "layout/seat1", null, getPackageName() );
        //Log.i( "Number: ", seat.toString() );
        seats.add( (ImageButton)(findViewById( R.id.seat1)));
        seats.add( (ImageButton)(findViewById( R.id.seat2)));
        seats.add( (ImageButton)(findViewById( R.id.seat3)));
        seats.add( (ImageButton)(findViewById( R.id.seat4)));
        seats.add( (ImageButton)(findViewById( R.id.seat5)));
        seats.add( (ImageButton)(findViewById( R.id.seat6)));
        seats.add( (ImageButton)(findViewById( R.id.seat7)));
        seats.add( (ImageButton)(findViewById( R.id.seat8)));
        seats.add( (ImageButton)(findViewById( R.id.seat9)));
        seats.add( (ImageButton)(findViewById( R.id.seat10)));
        seats.add( (ImageButton)(findViewById( R.id.seat11)));
        seats.add( (ImageButton)(findViewById( R.id.seat12)));
        seats.add( (ImageButton)(findViewById( R.id.seat13)));
        seats.add( (ImageButton)(findViewById( R.id.seat14)));
        seats.add( (ImageButton)(findViewById( R.id.seat15)));
        seats.add( (ImageButton)(findViewById( R.id.seat16)));
        seats.add( (ImageButton)(findViewById( R.id.seat17)));
        seats.add( (ImageButton)(findViewById( R.id.seat18)));
        seats.add( (ImageButton)(findViewById( R.id.seat19)));
        seats.add( (ImageButton)(findViewById( R.id.seat20)));
        seats.add( (ImageButton)(findViewById( R.id.seat21)));
        seats.add( (ImageButton)(findViewById( R.id.seat22)));
        seats.add( (ImageButton)(findViewById( R.id.seat23)));
        seats.add( (ImageButton)(findViewById( R.id.seat24)));
        seats.add( (ImageButton)(findViewById( R.id.seat25)));
        seats.add( (ImageButton)(findViewById( R.id.seat26)));
        seats.add( (ImageButton)(findViewById( R.id.seat27)));
        seats.add( (ImageButton)(findViewById( R.id.seat28)));
        seats.add( (ImageButton)(findViewById( R.id.seat29)));
        seats.add( (ImageButton)(findViewById( R.id.seat30)));
        seats.add( (ImageButton)(findViewById( R.id.seat31)));
        seats.add( (ImageButton)(findViewById( R.id.seat32)));
        while( mapping.size() < seats.size() ){
            mapping.add( (Integer)(0));
        }

        for( int i = 0; i < seats.size(); i++ ){
            final int j = i;

            if( (mapping.get(j)).equals((Integer)1) )
                seats.get(j).setImageResource(R.drawable.seat);
            else
                seats.get(j).setImageResource(R.drawable.seat_taken);
        }

        return seats;
    }
}