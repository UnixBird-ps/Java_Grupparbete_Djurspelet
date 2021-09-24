package devops21_java_djurspelet;

public class Cat extends AnimalBase
{
	protected static final int ATSTART_CAT_PRICE = 1000;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cat()
	{
		super( "Katt", ATSTART_CAT_PRICE, 15 );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Cat( AnimalGender pGender )
	{
		super( "Katt", ATSTART_CAT_PRICE, 15, pGender );
	}
}
