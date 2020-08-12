package comp3350.mbs.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import comp3350.mbs.objects.Snack;

public class ParcelableSnack extends Snack implements Parcelable {

	/**
	 * ParcelableSnack Constructor
	y * @param hotdogPrice is the price of hotdog.
	 * @param hotdogQuantity is the quantity of hotdog.
	 * @param popcornPrice is the price of popcorn. 
	 * @param  popcornQuantity is the quantity of popcorn.
	 * @param friesPrice is the price of fries.
	 * @param friesQuantity is the quantity fires. 
	 * @param drinkPrice is the price of dirnk 
	 * @param drinkQuantity is the quantity of drink.
	 * @param noodlePrice is the price of noodle. 
	 * @param noodleQuantity is the quantity of noodle.
	 * @param chipsPrice is the price of chips. 
	 * @param chipsQuantity is the quantity of chips.
	 */
	public ParcelableSnack(int hotdogPrice, int hotdogQuantity, int popcornPrice, int popcornQuantity, int friesPrice, int friesQuantity, int drinkPrice,int drinkQuantity, int noodlePrice,int noodleQuantity,int chipsPrice,int chipsQuantity) {

		super(hotdogPrice,hotdogQuantity ,popcornPrice, popcornQuantity, friesPrice, friesQuantity, drinkPrice,drinkQuantity, noodlePrice,noodleQuantity,chipsPrice,chipsQuantity);	//end constructor
}


	protected ParcelableSnack(Parcel in) {
			super.setHotdogQuantity( in.readInt());
			super.setPopcornQuantity(in.readInt() );
			super.setFriesQuantity(in.readInt() );
			super.setDrinkQuantity(in.readInt());
			super.setNoodleQuantity(in.readInt() );
			super.setChipsQuantity(in.readInt());

	}


	public static final Creator<ParcelableSnack> CREATOR = new Creator<ParcelableSnack>() {


		@Override
		public ParcelableSnack createFromParcel(Parcel parcel) {
			return null;
		}

		@Override
			public ParcelableSnack[] newArray(int size) {
				return new ParcelableSnack[size];
			}
		};


		@Override
		public int describeContents() {
			return 0;
		}


		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeInt(super.getHotdogPrice());
			parcel.writeInt(super.getHotdogQuantity());
			parcel.writeInt(super.getPopcornPrice());
			parcel.writeInt(super.getPopcornQuantity());
			parcel.writeInt(super.getFriesPrice());
			parcel.writeInt(super.getFriesQuantity());
			parcel.writeInt(super.getDrinkPrice());
			parcel.writeInt(super.getDrinkQuantity());
			parcel.writeInt(super.getNoodlePrice());
			parcel.writeInt(super.getNoodleQuantity());
			parcel.writeInt(super.getChipsPrice());
			parcel.writeInt(super.getChipsQuantity());
		}

	}//end ParcelableSnackclass

