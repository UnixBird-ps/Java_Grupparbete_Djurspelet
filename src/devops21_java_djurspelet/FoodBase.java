package devops21_java_djurspelet;

public abstract class FoodBase
{
	private String mName;
	private int mPrice;
	private int mQuantity;


	/**
	* Initializes this object
	*
	* @param pName
	* @param pPrice  In kilograms
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
}
