package comp3350.mbs.objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Snack implements Parcelable {
    private int hotDogPrice ;
    private int hotDotQuantity;
    private int porcornPrice ;
    private int porconQuantity;
    private int friesPrice ;
    private int friesQuantity;
    private int drinkPrice ;
    private int drinkQuantity;
    private int noodlePrice ;
    private int noodleQuantity;
    private int chipsPrice ;
    private int chipsQuantity;


    public Snack( int hotDogPrice, int hotDotQuantity, int porcornPrice, int porconQuantity, int friesPrice, int friesQuantity, int drinkPrice,int drinkQuantity, int noodlePrice,int noodleQuantity,int chipsPrice,int chipsQuantity)
    {
        this.hotDogPrice = hotDogPrice;
        this.hotDotQuantity = hotDotQuantity;
        this.porcornPrice = porcornPrice;
        this.porconQuantity = porconQuantity;
        this.friesPrice = friesPrice;
        this.friesQuantity= friesQuantity;
        this.drinkPrice = drinkPrice;
        this.drinkQuantity = drinkQuantity;
        this.noodlePrice = noodlePrice;
        this.noodleQuantity = noodleQuantity;
        this.chipsPrice = chipsPrice;
        this.chipsQuantity = chipsQuantity;
    }

    public Snack(Parcel in){
        this.hotDogPrice = in.readInt();
        this.hotDotQuantity = in.readInt();
        this.porcornPrice = in.readInt();
        this.porconQuantity = in.readInt();
        this.friesPrice = in.readInt();
        this.friesQuantity= in.readInt();
        this.drinkPrice = in.readInt();
        this.drinkQuantity = in.readInt();
        this.noodlePrice = in.readInt();
        this.noodleQuantity = in.readInt();
        this.chipsPrice = in.readInt();
        this.chipsQuantity = in.readInt();
    }
    public static final Creator<Snack> CREATOR = new Creator<Snack>() {
        @Override
        public Snack createFromParcel(Parcel in) {
            return new Snack(in);
        }

        @Override
        public Snack[] newArray(int size) {
            return new Snack[size];
        }
    };
         @Override
         public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(hotDogPrice);
        parcel.writeInt(hotDotQuantity);
        parcel.writeInt(porcornPrice);
        parcel.writeInt(porconQuantity);
        parcel.writeInt(friesPrice);
        parcel.writeInt(friesQuantity);
        parcel.writeInt(drinkPrice);
        parcel.writeInt(drinkQuantity);
        parcel.writeInt(noodlePrice);
        parcel.writeInt(noodleQuantity);
        parcel.writeInt(chipsPrice);
        parcel.writeInt(chipsQuantity);
    }

    public int getHotDogPrice(){
             return hotDogPrice;
    }

    public int getHotDotQuantity(){
            return hotDotQuantity;
    }

    public int getPorcornPrice(){
            return porcornPrice;
    }

    public int getPorconQuantity(){
            return porconQuantity;
    }

    public int getFriesPrice(){
            return friesPrice;
    }

    public int getFriesQuantity(){
            return friesQuantity;
    }

    public int getDrinkPrice(){
            return drinkPrice;
    }

    public int getDrinkQuantity(){
            return drinkQuantity;
    }

    public int getNoodlePrice(){
            return noodlePrice;
    }

    public int getNoodleQuantity(){
            return noodleQuantity;
    }

    public int getChipsPrice(){
            return chipsPrice;
    }

    public int getChipsQuantity(){
             return chipsQuantity;
    }




    //setter
    public void setHotDotQuantity( int hotDotQuantity){
             this.hotDotQuantity = hotDotQuantity;
    }

    public void setPorconQuantity(int porconQuantity){
             this.porconQuantity = porconQuantity;
    }

    public void setFriesQuantity( int friesQuantity){
        this.friesQuantity = friesQuantity;
    }

    public void setDrinkQuantity(int drinkQuantity){
        this.drinkQuantity = drinkQuantity;
    }

    public void setNoodleQuantity( int noodleQuantity){
        this.noodleQuantity = noodleQuantity;
    }

    public void setChipsQuantity(int chipsQuantity){
        this.chipsQuantity = chipsQuantity;
    }

//
//    public boolean equals(Seat object){
//        return seatNumber == object.getSeatNumber();
//    }//end equals

}
