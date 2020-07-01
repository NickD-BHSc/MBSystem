package comp3350.mbs.presentation;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import comp3350.mbs.R;

public class TrailerActivity extends AppCompatActivity {
    private Button playVideo;
    private VideoView trailerView;
    private MediaController trailerController;
    private String movieTitle;
    //TextView trailerTitle = findViewById(R.id.trailerMovieTitle);//delete this

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        if(getIntent().hasExtra("comp3350.mbs.presentation.TITLE")){
            String videoPath = "android.resource://comp3350.mbs/";

            TextView trailerTitle = (TextView) findViewById(R.id.trailerMovieTitle);
            //movieTitle = getIntent().getExtras().getString("comp3350.mbs.presentation.TITLE");
            movieTitle = "tlk";
            //String rawPath = R.raw.{movieTitle};
            int movie = getResources().getIdentifier("raw/movieTitle", null, getPackageName());
            //String cookedPath = videoPath+number;
            String test = Integer.toString(movie);
            trailerTitle.setText(test);
        }

        playVideo = (Button) findViewById(R.id.trailerPlayBtn);
        trailerView = (VideoView) findViewById(R.id.trailerView);
        trailerController = new MediaController(this);

    }

    public void videoPlay(View v){
        String videoPath = "android.resource://comp3350.mbs/"+R.raw.tlk;
        String cookedPath = videoPath;
       // trailerTitle.setText(cookedPath);


        Uri uri = Uri.parse(cookedPath);
        trailerView.setVideoURI(uri);
        trailerView.setMediaController(trailerController);
        trailerController.setAnchorView(trailerView);

        trailerView.start();
    }

}
