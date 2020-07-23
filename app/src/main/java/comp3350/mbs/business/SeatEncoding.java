package comp3350.mbs.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.Seat;

public class SeatEncoding {

    /**
     * decodeSeatList - Takes the seatList string from a ViewingTime object, and turns it into a List of seat objects
     * @param str - The string to decode
     * @return - The new list of Seat objects
     */
    public List<Seat> decodeSeatList(String str ){
        ArrayList<Seat> out = new ArrayList<Seat>();

        for( int i = 0; i < str.length(); i++ ){
            Seat s;

            if( str.charAt( i ) == '0' ){
                s = new Seat( i, false, R.drawable.seat);
            }
            else{
                s = new Seat( i, true, R.drawable.seat_taken);
            }

            out.add( s );
        }

        return out;
    }

    /**
     * encodeSeatList - creates a String representation of a list of Seat objects for storing in the database
     * @param seatingList - The list of all seats for the current viewing
     * @param bookedSeats - The list of seats that have just been booked, and need to be changed
     * @return - A string representation of the seating lists. You'll need to update the corresponding ViewingTime object somewhere else
     */
    public String encodeSeatList( List<Seat>seatingList, List<Seat> bookedSeats){
        String s = "";

        for(int i = 0; i < seatingList.size(); i++ ){
            if( bookedSeats.contains( seatingList.get(i)) || seatingList.get(i).isBooked() ){
                s = s + "1";
            }
            else{
                s = s + "0";
            }
        }

        return s;

    }
}
