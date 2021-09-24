package devops21_java_djurspelet;

public class Rabbit extends AnimalBase
{
	protected static final int ATSTART_PRICE = 1000;
	protected static final String ATSTART_KIND = "kanin";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Rabbit()
	{
		super( ATSTART_KIND, ATSTART_PRICE, 10 );
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
		super( ATSTART_KIND, ATSTART_PRICE, 10, pGender );
	}
}
