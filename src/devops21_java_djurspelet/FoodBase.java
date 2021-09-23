package devops21_java_djurspelet;

public abstract class FoodBase
{
	private String mName;
	private int mPrice;
	private int mQuantity;


	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pPrice     In whole SEK
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public FoodBase( String pName, int pPrice, int pQuantity )
	{
		mName = pName;
		mPrice = pPrice;
		mQuantity = pQuantity;
	}

	public String getName() { return mName; }
	public int getPrice() { return mPrice; }
	public int getQuantity() { return mQuantity; }

	public void setQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	public void addQuantity(int addQuantity){
		this.mQuantity += addQuantity;
	}
	public void removeQuantity(int toRemove){
		this.mQuantity -=toRemove;
	}
}
