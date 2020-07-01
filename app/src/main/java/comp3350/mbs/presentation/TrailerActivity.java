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
    private String hashedTitle;
    //TextView trailerTitle = findViewById(R.id.trailerMovieTitle);//delete this

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        if(getIntent().hasExtra("comp3350.mbs.presentation.TITLE")){
            String videoPath = "android.resource://comp3350.mbs/";

            TextView trailerTitle = (TextView) findViewById(R.id.trailerMovieTitle);
            movieTitle = getIntent().getExtras().getString("comp3350.mbs.presentation.TITLE");
            //String rawPath = R.raw.{movieTitle};
            int movie = getResources().getIdentifier("raw/"+movieTitle, null, getPackageName());
            trailerTitle.setText(movieTitle);
        }

        playVideo = (Button) findViewById(R.id.trailerPlayBtn);
        trailerView = (VideoView) findViewById(R.id.trailerView);
        trailerController = new MediaController(this);

    }

    public void videoPlay(View v){
        //get pieces of the path
        //int movieHash = hashMovieTitle(movieTitle);
        String clean = cleanString(movieTitle);
/*
        Log.i("movie hash: ", rev);
        String ph = "tlk";
        String movieID = Integer.toString(movieHash); //the movie ID (end of path)
        char beg = movieTitle.charAt(movieTitle.length()-1); //last letter of movie

        Log.i("string of hash ", movieID);
        //assemble entire path
        String moviePath = beg+movieID;*/
        //int movie = getResources().getIdentifier("raw/"+moviePath, null, getPackageName());
        Log.i("string of hash ", clean);
        int movie = getResources().getIdentifier("raw/"+clean, null, getPackageName());
        Log.i("myTag", "movie integer: "+movie);
        String videoPath = "android.resource://comp3350.mbs/";


        Log.i("myTag", "path: "+videoPath);
        String cookedPath = videoPath+movie;

        Log.i("myTag", "final path: "+cookedPath);

        Uri uri = Uri.parse(cookedPath);
        trailerView.setVideoURI(uri);
        trailerView.setMediaController(trailerController);
        trailerController.setAnchorView(trailerView);
        trailerView.start();
    }

    /*
    * hash the movie title to an integer to call the correct video file
    * */
    public int hashMovieTitle(String title){
        int hash = title.charAt(0);
        for (int i = 0; i < title.length(); i++) {
            hash += (hash + title.charAt(i));
        }
        return hash;
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
