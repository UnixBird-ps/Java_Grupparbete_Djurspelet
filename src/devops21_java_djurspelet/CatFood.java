package devops21_java_djurspelet;

public class CatFood extends FoodBase
{
	protected static final int ATSTART_CATFOOD_PRICE = 20;

	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public CatFood( String pName, int pQuantity )
	{
		super( pName, ATSTART_CATFOOD_PRICE, pQuantity );
	}
}
