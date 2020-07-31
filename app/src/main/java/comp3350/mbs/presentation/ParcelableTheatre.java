package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Theatre;

public class ParcelableTheatre extends Theatre implements Parcelable {
    /**
     * ParcelableTheatre Constructor
     * @param name is the name of the theatre.
     * @param address is the address of the theatre.
     */
    public ParcelableTheatre(String name, String address) {
        super(name, address);
    }

    protected ParcelableTheatre(Parcel in) {
        super.setName(in.readString());
        super.setAddress(in.readString());
    }


    public static final Creator<ParcelableTheatre> CREATOR = new Creator<ParcelableTheatre>() {
        @Override
        public ParcelableTheatre createFromParcel(Parcel in) {
            return new ParcelableTheatre(in);
        }

        @Override
        public ParcelableTheatre[] newArray(int size) {
            return new ParcelableTheatre[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getName());
        parcel.writeString(super.getAddress());
    }

}//end ParcelableTheatre class
