package devops21_java_djurspelet;

public class Carrots extends FoodBase
{
	protected static final int ATSTART_CARROTS_PRICE = 20;

	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public Carrots( String pName, int pQuantity )
	{
		super( pName, ATSTART_CARROTS_PRICE, pQuantity );
	}

}
