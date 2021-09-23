package devops21_java_djurspelet;

public class Dog extends AnimalBase
{

	/**
	* Initializes this object
	*
	* @param pPriceAtMaxHealth  Price at 100% health
	*/
	public Dog( int pPriceAtMaxHealth )
	{
		super( "Hund", pPriceAtMaxHealth, 16 );
	}
}
