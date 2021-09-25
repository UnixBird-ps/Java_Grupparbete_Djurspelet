package devops21_java_djurspelet;

public class Cattle extends AnimalBase
{
	protected static final int PRICE = 20000;
	protected static final String KIND = "nötkreatur";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cattle()
	{
		super( AnimalKind.CATTLE, PRICE, 20 );
		this.mRightFood.add( Forage.NAME );
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
		super( AnimalKind.CATTLE, PRICE, 20, pGender );
	}


	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
}
