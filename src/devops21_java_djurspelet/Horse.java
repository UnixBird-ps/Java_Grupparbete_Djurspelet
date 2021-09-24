package devops21_java_djurspelet;

public class Horse extends AnimalBase
{
	protected static final int ATSTART_HORSE_PRICE = 20000;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Horse()
	{
		super( "Häst", ATSTART_HORSE_PRICE, 25 );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Horse( AnimalGender pGender )
	{
		super( "Häst", ATSTART_HORSE_PRICE, 25, pGender );
	}
}
