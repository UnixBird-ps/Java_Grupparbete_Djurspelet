package devops21_java_djurspelet;

public class Cattle extends AnimalBase
{

	/**
	* Initializes this object
	*
	* @param pPriceAtMaxHealth  Price at 100% health
	*/
	public Cattle( int pPriceAtMaxHealth )
	{
		super( "Nötkreatur", pPriceAtMaxHealth, 20 );
	}


	public Cattle( int pPriceAtMaxHealth, AnimalGender pAnimalGender )
	{
		super( "Nötkreatur", pPriceAtMaxHealth, 10, pAnimalGender );
	}
}
