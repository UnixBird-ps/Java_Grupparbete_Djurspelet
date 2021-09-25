package devops21_java_djurspelet;

public abstract class FoodBase
{
	protected String mName;
	protected FoodKind mKind;
	private int mPrice;
	private int mQuantity;
	int eatFood;


	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pKind      Food kind
	* @param pPrice     In whole SEK
	* @param pQuantity  Quantity of food held in whole kilograms
	*
	* @author P.S.
	*/
	public FoodBase( String pName, FoodKind pKind, int pPrice, int pQuantity )
	{
		this.mName = pName;
		this.mKind = pKind;
		this.mPrice = pPrice;
		this.mQuantity = pQuantity;
	}


	public String getName() { return this.mName; }
	public FoodKind getKind() { return this.mKind; }
	public int getPrice() { return this.mPrice; }

	public void addQuantity( int pQuantity ) { this.mQuantity += pQuantity; }
	public void removeQuantity( int pQuantity ) { this.mQuantity -= pQuantity; }
	public void setQuantity( int pQuantity ) { this.mQuantity = pQuantity; }
	public int getQuantity() { return this.mQuantity; }
}
