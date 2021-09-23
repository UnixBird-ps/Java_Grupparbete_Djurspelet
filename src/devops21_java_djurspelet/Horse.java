package devops21_java_djurspelet;

public class Horse extends AnimalBase
{

	/**
	* Initializes this object
	*
	* @param pPriceAtMaxHealth  Price at 100% health
	*/
	public Horse( int pPriceAtMaxHealth )
	{
		super( "Häst", pPriceAtMaxHealth, 25 );
	}


	public Horse( int pPriceAtMaxHealth, AnimalGender pAnimalGender )
	{
		super( "Häst", pPriceAtMaxHealth, 10, pAnimalGender );
	}
}
