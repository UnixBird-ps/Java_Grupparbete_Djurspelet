package devops21_java_djurspelet;

public class Horse extends AnimalBase
{
	protected static final int PRICE = 20000;
	protected static final String KIND = "häst";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Horse()
	{
		super( AnimalKind.HORSE, PRICE, 25 );
		this.mRightFood.add( Forage.NAME );
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
		super( AnimalKind.HORSE, PRICE, 25, pGender );
	}


	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
 }
