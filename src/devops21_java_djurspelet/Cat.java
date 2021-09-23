package devops21_java_djurspelet;

public class Cat extends AnimalBase
{

	/**
	* Initializes this object
	*
	* @param pPriceAtMaxHealth  Price at 100% health
	*/
	public Cat( int pPriceAtMaxHealth )
	{
		super( "Katt", pPriceAtMaxHealth, 15 );
	}
}
