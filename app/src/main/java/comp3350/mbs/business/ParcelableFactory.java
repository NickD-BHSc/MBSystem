package comp3350.mbs.business;

import android.os.Parcelable;

import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.presentation.ParcelableTheatre;
import comp3350.mbs.presentation.ParcelableTheatreMovies;
import comp3350.mbs.presentation.ParcelableViewingTime;

public class ParcelableFactory {

    public static Parcelable createParcelableObject(Object object){
        Parcelable parcObject = null;

        if(object instanceof Theatre){
            Theatre theatre = (Theatre)object;
            parcObject = new ParcelableTheatre(theatre.getName(),theatre.getAddress(),theatre.getDistance());
        }else if(object instanceof TheatreMovies){
            TheatreMovies theatreMovie = (TheatreMovies)object;
            parcObject = new ParcelableTheatreMovies(theatreMovie.getTheatreName(),theatreMovie.getMovieName(),theatreMovie.getMoviePoster(),theatreMovie.getMovieDescription());
        }else if(object instanceof ViewingTime){
            ViewingTime viewingTime = (ViewingTime)object;
            parcObject = new ParcelableViewingTime(viewingTime.getTheatreName(),viewingTime.getMovieName(),viewingTime.getShowTime(),viewingTime.getShowDate());
        }else if(object instanceof Seat){

        }else if(object instanceof Ticket){

        }//end if-elses

        return parcObject;

    }//end createParcelableObject
}
