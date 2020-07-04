package comp3350.mbs.presentation;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        if(getIntent().hasExtra("comp3350.mbs.presentation.TITLE")){
            TextView trailerTitle = (TextView) findViewById(R.id.trailerMovieTitle);
            movieTitle = getIntent().getExtras().getString("comp3350.mbs.presentation.TITLE");
            trailerTitle.setText(movieTitle);
        }

        playVideo = (Button) findViewById(R.id.trailerPlayBtn);
        trailerView = (VideoView) findViewById(R.id.trailerView);
        trailerController = new MediaController(this);

    }

    public void videoPlay(View v){
        String clean = cleanString(movieTitle);

        int movie = getResources().getIdentifier("raw/"+clean, null, getPackageName());
        String videoPath = "android.resource://comp3350.mbs/";
        String cookedPath = videoPath+movie;

        Uri uri = Uri.parse(cookedPath);
        trailerView.setVideoURI(uri);
        trailerView.setMediaController(trailerController);
        trailerController.setAnchorView(trailerView);
        trailerView.start();
    }

    /*
    * Cleaned string to call the appropriate video file
    * */
    public String cleanString(String title){
        String ns = title.replaceAll("\\s+","");
        String lc = ns.toLowerCase();
        return lc;
    }

}
