package comp3350.mbs.business;

import android.os.Parcelable;

import comp3350.mbs.objects.Seat;
import comp3350.mbs.objects.Theatre;
import comp3350.mbs.objects.TheatreMovies;
import comp3350.mbs.objects.Ticket;
import comp3350.mbs.objects.ViewingTime;
import comp3350.mbs.presentation.ParcelableSeat;
import comp3350.mbs.presentation.ParcelableTheatre;
import comp3350.mbs.presentation.ParcelableTheatreMovies;
import comp3350.mbs.presentation.ParcelableTicket;
import comp3350.mbs.presentation.ParcelableViewingTime;

public class ParcelableFactory {

    /**
     * createParcelableObject - a method that creates a Parcelable object (either ParcelableTheatre, ParcelableTheatreMovies, ParcelableViewingTime
     *                          ParcelableSeat or ParcelableTicket) when given an object that is either Theatre, TheatreMovies, ViewingTime, Seat or Ticket.
     * @param object is the given "regular" object that needs to be changed to a Parcelable.
     * @return it will return a Parcelable object of that "regular" object. Otherwise, it will return null.
     */
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
            parcObject = new ParcelableViewingTime(viewingTime.getTheatreName(),viewingTime.getMovieName(),viewingTime.getShowTime(),viewingTime.getShowDate(), viewingTime.getSeatString());

        }else if(object instanceof Seat){
            Seat seat = (Seat)object;
            parcObject = new ParcelableSeat(seat.getSeatNumber(),seat.isBooked(),seat.getSeatImage());

        }else if(object instanceof Ticket){
            Ticket ticket = (Ticket)object;
            parcObject = new ParcelableTicket(ticket.getPrice(),ticket.getMovieName(),ticket.getQuantity());

        }

        return parcObject;

    }//end createParcelableObject

}//end ParcelableFactory
