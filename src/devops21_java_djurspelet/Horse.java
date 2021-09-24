package devops21_java_djurspelet;

public class Horse extends AnimalBase
{
	protected static final int ATSTART_PRICE = 20000;
	protected static final String ATSTART_KIND = "häst";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Horse()
	{
		super( ATSTART_KIND, ATSTART_PRICE, 25 );
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
		super( ATSTART_KIND, ATSTART_PRICE, 25, pGender );
	}
}
