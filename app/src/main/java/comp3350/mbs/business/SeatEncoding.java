package comp3350.mbs.business;


import java.util.ArrayList;
import java.util.List;

import comp3350.mbs.R;
import comp3350.mbs.objects.Seat;

public class SeatEncoding {

    /**
     * decodeSeatList - Takes the seatList string from a ViewingTime object, and turns it into a List of seat objects
     * @param seatList - The string to decode
     * @return - The new list of Seat objects
     */
    public List<Seat> decodeSeatList(String seatList){
        List<Seat> decodedList = new ArrayList<>();

        if(seatList != null) {
            for (int i = 0; i < seatList.length(); i++) {
                Seat s;

                if (seatList.charAt(i) == '0') {
                    s = new Seat(i, false, R.drawable.seat);
                } else {
                    s = new Seat(i, true, R.drawable.seat_taken);
                }
                decodedList.add(s);
            }
        }

        return decodedList;
    }//end decodeSeatList

    /**
     * encodeSeatList - creates a String representation of a list of Seat objects for storing in the database
     * @param seatingList - The list of all seats for the current viewing
     * @param bookedSeats - The list of seats that have just been booked, and need to be changed
     * @return - A string representation of the seating lists. You'll need to update the corresponding ViewingTime object somewhere else
     */
    public String encodeSeatList(List<Seat> seatingList, List<Seat> bookedSeats){
        String encodedList = "";

        if(seatingList != null & bookedSeats != null){

            for (int i = 0; i < seatingList.size(); i++){

                if( seatingList.get(i) != null ) {

                    if (bookedSeats.contains(seatingList.get(i)) || seatingList.get(i).isBooked()){
                        encodedList = encodedList + "1";
                    }else{
                        encodedList = encodedList + "0";
                    }
                }
            }
        }

        return encodedList;
    }//end encodeSeatList

}//end SeatEncoding class
