package devops21_java_djurspelet;

public class Rabbit extends AnimalBase
{
	protected static final int ATSTART_RABBIT_PRICE = 1000;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Rabbit()
	{
		super( "Kanin", ATSTART_RABBIT_PRICE, 10 );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Rabbit( AnimalGender pGender )
	{
		super( "Kanin", ATSTART_RABBIT_PRICE, 10, pGender );
	}
}
