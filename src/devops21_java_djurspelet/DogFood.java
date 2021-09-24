package devops21_java_djurspelet;

public class DogFood extends FoodBase
{
	protected static final int ATSTART_DOGFOOD_PRICE = 20;

	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public DogFood( String pName, int pQuantity )
	{
		super( pName, ATSTART_DOGFOOD_PRICE, pQuantity );
	}
}
