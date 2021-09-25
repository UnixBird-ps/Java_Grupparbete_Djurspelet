package devops21_java_djurspelet;

public class Dog extends AnimalBase
{
	protected static final int PRICE = 1000;
	protected static final String KIND = "hund";

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Dog()
	{
		super( AnimalKind.DOG, PRICE, 16 );
		this.mRightFood.add( DogFood.NAME );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Dog( AnimalGender pGender )
	{
		super( AnimalKind.DOG, PRICE, 16, pGender );
	}


	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
}
