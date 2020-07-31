package comp3350.mbs.presentation;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import comp3350.mbs.R;
import comp3350.mbs.business.AccessTrailer;

public class TrailerActivity extends AppCompatActivity {
    private Button playVideo;
    private VideoView trailerView;
    private MediaController trailerController;
    private String movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        if(getIntent().hasExtra("comp3350.mbs.presentation.TITLE")){
            TextView trailerTitle = findViewById(R.id.trailerMovieTitle);
            movieTitle = getIntent().getExtras().getString("comp3350.mbs.presentation.TITLE");
            trailerTitle.setText(movieTitle);
        }

        playVideo = findViewById(R.id.trailerPlayBtn);
        trailerView = findViewById(R.id.trailerView);
        trailerController = new MediaController(this);

    }

    /**
     * videoPlay - calls resources to display the movie title and trailer video in trailerView
     * @param v built-in android parameter that allows videoPlay to be called from view
     */
    public void videoPlay(View v){
        String clean = AccessTrailer.cleanString(movieTitle);
        int movie = getResources().getIdentifier("raw/"+clean, null, getPackageName());
        String videoPath = "android.resource://comp3350.mbs/";
        String cookedPath = videoPath+movie;

        Uri uri = Uri.parse(cookedPath);
        trailerView.setVideoURI(uri);
        trailerView.setMediaController(trailerController);
        trailerController.setAnchorView(trailerView);
        trailerView.start();

    }//end videoPlay

}//end TrailerActivity class
