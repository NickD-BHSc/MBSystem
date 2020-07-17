package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Theatre implements Parcelable {
    private String name;
    private String address;
    private String distance;

    /**
     * Constructor of Theatre class.
     * @param name      is the name of the theatre.
     * @param address   is the address of the theatre.
     * @param distance  is the distance between the user's location.
     */
    public Theatre(String name, String address, String distance) {
        this.name = name;
        this.address = address;
        this.distance = distance;
    }//end Constructor

    //================================================================
    //Parcelable methods
    protected Theatre(Parcel in) {
        name = in.readString();
        address = in.readString();
        distance = in.readString();
    }

    public static final Creator<Theatre> CREATOR = new Creator<Theatre>() {
        @Override
        public Theatre createFromParcel(Parcel in) {
            return new Theatre(in);
        }

        @Override
        public Theatre[] newArray(int size) {
            return new Theatre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(distance);
    }

    //================================================================
    //Getter methods
    public String getName() {
        return name;
    }//end getName

    public String getAddress() {
        return address;
    }//end getAddress


    public String getDistance() {
        return distance;
    }//end getDistance

    /**
     * equals - a method that determines if the given object (Theatre) has the same theatre name as the instance name.
     * @param object is the object that will be compared to the instance's name.
     * @return it will return true if the given object's name is the same as the instance's name.
     *          Otherwise, it will return false.
     */
    public boolean equals(Object object){
        boolean result = false;

        if(object instanceof Theatre){
            Theatre theatreItem = (Theatre) object;//cast the object to Theatre

            if(((theatreItem.getName() == null) && (name == null))||
                    (theatreItem.getName().equals(name))){
                result = true;
            }//end nested if

        }//end if

        return result;

    }//end equals


    /**
     * toString - a method that represents the Theatre information in text.
     * @return it will return an information about the Theatre (fields).
     */
    @Override
    public String toString() {
        return "Theatre{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }//end toString

}//end Theatre
