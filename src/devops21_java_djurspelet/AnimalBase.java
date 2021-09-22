package devops21_java_djurspelet;


import java.util.Random;

public abstract class AnimalBase // Enforce creation of subclasses
{
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
	private Random rand;
	int birthRate = rand.nextInt(2);


	/**
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
	* @return  This animal's kind
	*/
	public String getKind() { return mKind; }


	/**
	* @return
	*/
	public int getGender() { return mGender; }
	public String getGenderStr()
	{
		String lGenderStr = switch ( mGender ) {
			case GENDER_MALE -> "hane";
			case GENDER_FEMALE -> "hona";
			default -> "";
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

	public void growOlder(){
		mAge++;
		mHealth -= (int)(Math.random()*20)+10;
	}
	public int tryMate(){
	if ((mKind.equals(mKind)) && (GENDER_MALE != GENDER_FEMALE) && (birthRate == 1));
		return mGender;
	}

}
