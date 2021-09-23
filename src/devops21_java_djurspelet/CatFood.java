package devops21_java_djurspelet;

public class CatFood extends FoodBase{

	/**
	* Initializes this object
	*
	* @param pName      Food name
	* @param pPrice     In whole SEK
	* @param pQuantity  Quantity of food held in whole kilograms
	*/
	public CatFood( String pName, int pPrice, int pQuantity )
	{
		super( pName, pPrice, pQuantity );
	}
}
