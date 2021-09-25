package devops21_java_djurspelet;


import java.util.Random;


public abstract class AnimalBase // Enforce creation of subclasses
{
	Random rand = new Random();

	protected static final int ATSTART_HEALTH = 100;

	private String mName;
	private String mKind;
	private AnimalGender mGender;
	protected int mPriceAtMaxHealth;
	private int mHealth;
	private int mLastHealth;
	private int mAge;
	private int mExpectedLifeLength;

	private FoodBase mRightFood;
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
	protected AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Namnlös";
		mKind = pKind;
		mGender = ( (int)( Math.random() * 2 ) + 1 ) > 1 ? AnimalGender.MALE : AnimalGender.FEMALE;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mLastHealth = mHealth;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
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
	protected AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength, AnimalGender pGender )
	{
		mName = "Unnamed";
		mKind = pKind;
		mGender = pGender;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
	}


	/**
	* @return  This animal's kind
	*
	* @author P.S.
	*/
	public String getKind() { return mKind; }


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
	* @return  Animal's name, if set
	*
	* @author P.S.
	*/
	public String getName() { return mName; }


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
	public String getHealthStr() { return String.valueOf( mHealth ); }


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
	public String getHealthDeltaStr() { return String.valueOf( mHealth - mLastHealth ); }


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
	* Tests if food is of the same type
	*
	* @param pWhatFood  A food object
	* @return           True if same
	*
	* @author P.S.
	*/
	public boolean canEatThis( FoodBase pWhatFood )
	{
		return mRightFood.getName().equalsIgnoreCase( pWhatFood.getName() );
	}

	public void setmName(String mName) {
		this.mName = mName;
	}
}
