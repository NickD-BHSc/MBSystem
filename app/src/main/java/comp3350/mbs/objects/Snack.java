package comp3350.mbs.objects;


public class Snack {
	private int hotdogPrice ;
	private int hotgotQuantity;
	private int popcornPrice ;
	private int popconQuantity;
	private int friesPrice ;
	private int friesQuantity;
	private int drinkPrice ;
	private int drinkQuantity;
	private int noodlePrice ;
	private int noodleQuantity;
	private int chipsPrice ;
	private int chipsQuantity;

	public Snack(){}

	public Snack( int hotdogPrice, int hotgotQuantity, int popcornPrice, int popconQuantity, int friesPrice, int friesQuantity, int drinkPrice,int drinkQuantity, int noodlePrice,int noodleQuantity,int chipsPrice,int chipsQuantity)
	{
		this.hotdogPrice = hotdogPrice;
		this.hotgotQuantity = hotgotQuantity;
		this.popcornPrice = popcornPrice;
		this.popconQuantity = popconQuantity;
		this.friesPrice = friesPrice;
		this.friesQuantity= friesQuantity;
		this.drinkPrice = drinkPrice;
		this.drinkQuantity = drinkQuantity;
		this.noodlePrice = noodlePrice;
		this.noodleQuantity = noodleQuantity;
		this.chipsPrice = chipsPrice;
		this.chipsQuantity = chipsQuantity;
	}

	public int getHotdogPrice(){
		return hotdogPrice;
	}

	public int getHotdogQuantity(){
		return hotgotQuantity;
	}

	public int getPopcornPrice(){
		return popcornPrice;
	}

	public int getPopcornQuantity(){
		return popconQuantity;
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
	public void setHotdogQuantity( int hotgotQuantity){
		this.hotgotQuantity = hotgotQuantity;
	}

	public void setPopcornQuantity(int popconQuantity){
		this.popconQuantity = popconQuantity;
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
