package devops21_java_djurspelet;

public class Forage extends FoodBase
{
	protected static final int PRICE = 20;
	protected static final String NAME = "Grovfoder";


	/**
	* Initializes this object
	*
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public Forage( int pQuantity )
	{
		super( NAME, FoodKind.FORAGE, PRICE, pQuantity );
	}
}
