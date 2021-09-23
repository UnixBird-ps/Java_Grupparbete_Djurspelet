package devops21_java_djurspelet;

public class Rabbit extends AnimalBase
{

	/**
	* Initializes this object
	*
	* @param pPriceAtMaxHealth  Price at 100% health
	*/
	public Rabbit( int pPriceAtMaxHealth )
	{
		super( "Kanin", pPriceAtMaxHealth, 10 );
	}


	public Rabbit( int pPriceAtMaxHealth, AnimalGender pAnimalGender )
	{
		super( "Kanin", pPriceAtMaxHealth, 10, pAnimalGender );
	}
}
