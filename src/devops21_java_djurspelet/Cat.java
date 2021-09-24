package devops21_java_djurspelet;

public class Cat extends AnimalBase
{
	protected static final int ATSTART_PRICE = 1000;
	protected static final String ATSTART_KIND = "katt";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cat()
	{
		super( ATSTART_KIND, ATSTART_PRICE, 15 );
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
		super( ATSTART_KIND, ATSTART_PRICE, 15, pGender );
	}
}
