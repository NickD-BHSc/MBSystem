package comp3350.mbs.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import comp3350.mbs.R;

public class SnackActivity extends AppCompatActivity {


    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);


        confirmBtn =( Button) findViewById(R.id.snackConfirm);
        confirmBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view)
            {
                Intent intent = new Intent( SnackActivity.this, TicketActivity.class);
                startActivity( intent );
            }
        }
        );
    }
}