package devops21_java_djurspelet;

public class Dog extends AnimalBase
{
	protected static final int ATSTART_PRICE = 1000;
	protected static final String ATSTART_KIND = "hund";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Dog()
	{
		super( ATSTART_KIND, ATSTART_PRICE, 16 );
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
		super( ATSTART_KIND, ATSTART_PRICE, 16, pGender );
	}
}
