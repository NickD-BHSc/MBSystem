package comp3350.mbs.objects;


public class Snack {
	private int hotdogPrice ;
	private int popcornPrice ;
	private int friesPrice ;
	private int drinkPrice ;
	private int noodlePrice ;
	private int chipsPrice ;


	public Snack(){}
	/**
	 * Seat constructor
	 *
	 * @param hotdogPrice is the number of the seat.
	 * @param popcornPrice determines if the seat object is booked or not.
	 * @param friesPrice is the image of the seat.
	 * @param drinkPrice is the number of the seat.
	 * @param noodlePrice determines if the seat object is booked or not.
	 * @param chipsPrice is the image of the seat.
	 *
	 */
	public Snack( int hotdogPrice,  int popcornPrice,  int friesPrice,  int drinkPrice,int noodlePrice, int chipsPrice)
	{
		this.hotdogPrice = hotdogPrice;
		this.popcornPrice = popcornPrice;
		this.friesPrice = friesPrice;
		this.drinkPrice = drinkPrice;
		this.noodlePrice = noodlePrice;
		this.chipsPrice = chipsPrice;
	}


// getter method
	public int getHotdogPrice(){
		return hotdogPrice;
	}


	public int getPopcornPrice(){
		return popcornPrice;
	}


	public int getFriesPrice(){
		return friesPrice;
	}



	public int getDrinkPrice(){
		return drinkPrice;
	}

	public int getNoodlePrice(){
		return noodlePrice;
	}



	public int getChipsPrice(){
		return chipsPrice;
	}


}
