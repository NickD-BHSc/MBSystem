package comp3350.mbs.objects;


public class Snack {
	private int hotdogPrice ;
	private int popcornPrice ;
	private int friesPrice ;
	private int drinkPrice ;
	private int noodlePrice ;
	private int chipsPrice ;


	public Snack(){}

	public Snack( int hotdogPrice,  int popcornPrice,  int friesPrice,  int drinkPrice,int noodlePrice, int chipsPrice)
	{
		this.hotdogPrice = hotdogPrice;
		this.popcornPrice = popcornPrice;
		this.friesPrice = friesPrice;
		this.drinkPrice = drinkPrice;
		this.noodlePrice = noodlePrice;
		this.chipsPrice = chipsPrice;
	}

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




//
//	//setter
//	public void setHotdogQuantity( int hotgotQuantity){
//		this.hotgotQuantity = hotgotQuantity;
//	}
//
//	public void setPopcornQuantity(int popconQuantity){
//		this.popconQuantity = popconQuantity;
//	}
//
//	public void setFriesQuantity( int friesQuantity){
//		this.friesQuantity = friesQuantity;
//	}
//
//	public void setDrinkQuantity(int drinkQuantity){
//		this.drinkQuantity = drinkQuantity;
//	}
//
//	public void setNoodleQuantity( int noodleQuantity){
//		this.noodleQuantity = noodleQuantity;
//	}
//
//	public void setChipsQuantity(int chipsQuantity){
//		this.chipsQuantity = chipsQuantity;
//	}

	//
	//    public boolean equals(Seat object){
	//        return seatNumber == object.getSeatNumber();
	//    }//end equals

}
