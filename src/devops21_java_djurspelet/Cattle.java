package devops21_java_djurspelet;

public class Cattle extends AnimalBase
{
	protected static final int ATSTART_CATTLE_PRICE = 20000;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cattle()
	{
		super( "Nötkreatur", ATSTART_CATTLE_PRICE, 20 );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Cattle( AnimalGender pGender )
	{
		super( "Nötkreatur", ATSTART_CATTLE_PRICE, 20, pGender );
	}
}
