package devops21_java_djurspelet;

public class Forage extends FoodBase
{
	protected static final int ATSTART_FORAGE_PRICE = 20;

	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public Forage( String pName, int pQuantity )
	{
		super( pName, ATSTART_FORAGE_PRICE, pQuantity );
	}
}
