package devops21_java_djurspelet;

public class Cat extends AnimalBase
{
	protected static final int PRICE = 1000;
	protected static final String KIND = "katt";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Cat()
	{
		super( AnimalKind.CAT, PRICE, 15 );
		this.mRightFood.add( CatFood.NAME );
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
		super( AnimalKind.CAT, PRICE, 15, pGender );
	}


	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
}
