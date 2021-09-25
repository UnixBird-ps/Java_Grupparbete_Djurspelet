package devops21_java_djurspelet;


import java.util.Random;
import java.util.ArrayList;

public abstract class AnimalBase // Enforce creation of subclasses
{
	Random rand = new Random();

	protected static final int ATSTART_HEALTH = 100;

	private String mName;
	private AnimalKind mKind;
	private AnimalGender mGender;
	protected int mPriceAtMaxHealth;
	private int mHealth;
	private int mLastHealth;
	private int mAge;
	private int mExpectedLifeLength;
	protected ArrayList<String> mRightFood;
	int mBirthRate = rand.nextInt(2);


	/**
	* Initializes Animal object.
	* Sets kind, price at 100% health, expected life length
	* Randomizes gender
	*
	* @param pKind                What animal
	* @param pPriceAtMaxHealth    Original price
	* @param pExpectedLifeLength  Dies at end
	*
	* @author P.S.
	*/
	protected AnimalBase( AnimalKind pKind, int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Namnlös";
		mKind = pKind;
		mGender = ( (int)( Math.random() * 2 ) + 1 ) > 1 ? AnimalGender.MALE : AnimalGender.FEMALE;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mLastHealth = mHealth;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
		mRightFood = new ArrayList<>();
	}


	/**
	* Initializes Animal object.
	* Sets kind, price at 100% health, expected life length and gender
	*
	* @param pKind                What animal
	* @param pPriceAtMaxHealth    Original price
	* @param pExpectedLifeLength  Dies at end
	* @param pGender              GENDER_MALE or GENDER_FEMALE
	*
	* @author P.S.
	*/
	protected AnimalBase( AnimalKind pKind, int pPriceAtMaxHealth, int pExpectedLifeLength, AnimalGender pGender )
	{
		mName = "Namnlös";
		mKind = pKind;
		mGender = pGender;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
		mRightFood = new ArrayList<>();
	}


	/**
	* @return  This animal's kind
	*
	* @author P.S.
	*/
	public AnimalKind getKind() { return mKind; }


	abstract public String getKindStr();


	/**
	* @return   AnimalGender.MALE or AnimalGender.FEMALE
	*
	* @author P.S.
	*/
	public AnimalGender getGender() { return mGender; }


	/**
	* @return   A string "hona" or "hane"
	*
	* @author P.S.
	*/
	public String getGenderStr()
	{
		String lGenderStr = "";
		switch ( mGender )
		{
			case MALE :
				lGenderStr = "hane";
				break;
			case FEMALE :
				lGenderStr = "hona";
				break;
		}
		return lGenderStr;
	}


	/**
	* @return  Animal's health as int
	*
	* @author P.S.
	*/
	public int getHealth() { return mHealth; }


	/**
	 * @return  Animal's health as String
	 *
	 * @author P.S.
	 */
	public String getHealthStr() { return String.valueOf( getHealth() ); }


	/**
	 * @return  Animal's health change as int
	 *
	 * @author P.S.
	 */
	public int getHealthDelta() { return mHealth - mLastHealth; }


	/**
	 * @return  Animal's health change as text
	 *
	 * @author P.S.
	 */
	public String getHealthDeltaStr() { return String.valueOf( getHealthDelta() ); }


	/**
	* @return  Computed price, from health and original price
	*
	* @author P.S.
	*/
	public int getPrice() { return mHealth * mPriceAtMaxHealth / 100; }


	/**
	* @return  Animal's age
	*
	* @author P.S.
	*/
	public int getAge() { return mAge; }


	public void growOlder() {
		mAge++;
		mLastHealth = mHealth;
		mHealth -= (int) (Math.random() * 20) + 10;
		if ( mHealth < 0 ) mHealth = 0;
	}


	// Hint: in Player.tryAnimalBreeding()

	public AnimalGender tryMateWith(AnimalBase a, AnimalBase b){

		if (a.mKind.equals(b.mKind) && a.mGender != b.mGender && (mBirthRate == 1));
        return mGender;
	}


	/**
	* Tests if this animal can eat certain type of food
	*
	* @param pWhatFoodStr  A food object
	* @return              True if same
	*
	* @author P.S.
	*/
	public boolean canEatThis( String pWhatFoodStr )
	{
		for ( String fStr : mRightFood )
		{
			if ( fStr.equalsIgnoreCase( pWhatFoodStr ) ) return true;;
		}
		return false;
	}


	/**
	* Tests if this animal can eat certain type of food
	*
	* @param pWhatFood  A food String
	* @return           True if same
	*
	* @author P.S.
	*/
	public boolean canEatThis( FoodBase pWhatFood )
	{
		for ( String fStr : mRightFood )
		{
			if ( fStr.equalsIgnoreCase( pWhatFood.getName() ) ) return true;
		}
		return false;
	}


	public boolean tryEat( FoodBase pWichFoodBacket, int pQuantity )
	{
		if ( this.canEatThis( pWichFoodBacket ) )
		{
			int lDiff = pWichFoodBacket.getQuantity() - pQuantity;
			if ( lDiff < 0 ) pQuantity += lDiff;

			pWichFoodBacket.removeQuantity( pQuantity );

			this.mHealth += 10 * pQuantity;
			if ( this.mHealth > 100 ) this.mHealth = 100;

			return true;
		}
		else
			System.out.println( this.mName + "(" + this.getKindStr() + ") kan inte äta " + pWichFoodBacket.getName() );

		return false;
	}


	/**
	* Writes to screen a list of what this animal can eat
	*
	* @author P.S.
	*/
	public void printRightFoodList()
	{
		System.out.println( this.getKind() + " kan äta:" );

		for ( String fStr : mRightFood )
		{
			System.out.println( fStr );
		}
	}


	/**
	*
	* @param mName  Animal's name
	*
	* @author P.S.
	*/
	public void setName( String mName ) { this.mName = mName; }


	/**
	* @return  Animal's name, preset if not set
	*
	* @author P.S.
	*/
	public String getName() { return mName; }
}
