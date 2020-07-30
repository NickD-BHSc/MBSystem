package comp3350.mbs.objects;


public class Seat{

    private int seatNumber;
    private boolean isBooked;
    private int seatImage;

    /**
     * Seat constructor for implementing Parcelable interface in the ParcelableSeat class.
     */
    public Seat(){}

    /**
     * Seat constructor
     *
     * @param seatNumber is the number of the seat.
     * @param isBooked determines if the seat object is booked or not.
     * @param seatImage is the image of the seat.
     */
    public Seat(int seatNumber,boolean isBooked, int seatImage){
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
        this.seatImage = seatImage;
    }//end constructor

    //================================================================
    //Getter methods
    public int getSeatNumber(){
        return seatNumber;
    }//end getSeatNumber

    public boolean isBooked(){
        return isBooked;
    }//end isBooked

    public int getSeatImage(){
        return seatImage;
    }//end getSeatImage

    //================================================================
    //Setter methods
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }//end setSeatNumber

    public void setBooked(boolean booked){
        isBooked = booked;
    }//end setBooked

    public void setSeatImage(int seatImage){
        this.seatImage = seatImage;
    }//end setSeatImage

    /**
     * equals - a method that determines if the seat is equal to the given seat by checking its seat number.
     * @param object is the seat that will be compared to.
     * @return it will return true if the given seat object has the same seat number as the field seatNumber.
     *          Otherwise, it will return false.
     */
    public boolean equals(Seat object){
        return seatNumber == object.getSeatNumber();
    }//end equals

}//end Seat class
