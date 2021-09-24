package devops21_java_djurspelet;

public class Cattle extends AnimalBase
{
	protected static final int ATSTART_PRICE = 20000;
	protected static final String ATSTART_KIND = "nötkreatur";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cattle()
	{
		super( ATSTART_KIND, ATSTART_PRICE, 20 );
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
		super( ATSTART_KIND, ATSTART_PRICE, 20, pGender );
	}
}
