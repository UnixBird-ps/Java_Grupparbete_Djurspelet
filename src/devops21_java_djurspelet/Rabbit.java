package devops21_java_djurspelet;

public class Rabbit extends AnimalBase
{
	protected static final int PRICE = 1000;
	protected static final String KIND = "kanin";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Rabbit()
	{
		super( AnimalKind.RABBIT, PRICE, 10 );
		this.mRightFood.add( Carrots.NAME );
		this.mRightFood.add( Forage.NAME );
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
		super( AnimalKind.RABBIT, PRICE, 10, pGender );
	}


	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
}
