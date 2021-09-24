package devops21_java_djurspelet;

public class Dog extends AnimalBase
{
	protected static final int ATSTART_DOG_PRICE = 1000;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Dog()
	{
		super( "Hund", ATSTART_DOG_PRICE, 16 );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Dog( AnimalGender pGender )
	{
		super( "Hund", ATSTART_DOG_PRICE, 16, pGender );
	}
}
