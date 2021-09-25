package devops21_java_djurspelet;

public class Carrots extends FoodBase
{
	protected static final int PRICE = 20;
	protected static final String NAME = "Morötter";


	/**
	* Initializes this object
	*
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public Carrots( int pQuantity )
	{
		super( NAME, FoodKind.CARROTS, PRICE, pQuantity );
	}

}
