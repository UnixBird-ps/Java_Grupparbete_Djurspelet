package devops21_java_djurspelet;


import java.util.Random;

public abstract class AnimalBase // Enforce creation of subclasses
{
	Random rand = new Random();

	static final int ATSTART_HEALTH = 100;
	static final int GENDER_MALE    = 1;
	static final int GENDER_FEMALE  = 2;

	private String mName;
	private String mKind;
	private int mGender;
	private int mPriceAtMaxHealth;
	private int mHealth;
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
	*/
	protected AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Unnamed";
		mKind = pKind;
		mGender = ( (int)( Math.random() * 2 ) + 1 ) > 1 ? GENDER_MALE : GENDER_FEMALE;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
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
	*/
	protected AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength, int pGender )
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
	*/
	public String getKind() { return mKind; }


	/**
	* @return   GENDER_MALE or GENDER_FEMALE
	*/
	public int getGender() { return mGender; }


	/**
	* @return   A string "hona" or "hane"
	*/
	public String getGenderStr()
	{
		String lGenderStr = "";
		switch ( mGender )
		{
			case GENDER_MALE :
				lGenderStr = "hane";
				break;
			case GENDER_FEMALE :
				lGenderStr = "hona";
				break;
		};
		return lGenderStr;
	}


	/**
	* @return  Animal's name, if set
	*/
	public String getName() { return mName; }


	/**
	* @return  Animal's health
	*/
	public int getHealth() { return mHealth; }


	/**
	* @return  Computed price, from health and original price
	*/
	public int getPrice() { return mHealth * mPriceAtMaxHealth / 100; }


	/**
	* @return  Animal's age
	*/
	public int getAge() { return mAge; }


	public void growOlder() {
		mAge++;
		mHealth -= (int) (Math.random() * 20) + 10;
		if ( mHealth < 0 ) mHealth = 0;
	}


	public int tryMate(AnimalBase a, AnimalBase b){

		if (a.mKind.equals(b.mKind) && GENDER_MALE != GENDER_FEMALE && (mBirthRate == 1));
        return mGender;
	}


	/**
	* Tests if food is of the same type
	*
	* @param pWhatFood  A food object
	* @return           True if same
	*/
	public boolean canEatThis( FoodBase pWhatFood )
	{
		return mRightFood.getName().equalsIgnoreCase( pWhatFood.getName() );
	}
}
