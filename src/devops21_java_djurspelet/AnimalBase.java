package devops21_java_djurspelet;


public abstract class AnimalBase // Enforce creation of subclasses
{
	static final int ATSTART_HEALTH = 100;

	private String mName;
	private String mKind;
	private int mPriceAtMaxHealth;
	private int mHealth;
	private int mAge;
	private int mExpectedLifeLength;

	/**
	 * @param pKind                What animal
	 * @param pPriceAtMaxHealth    Original price
	 * @param pExpectedLifeLength  Dies at end
	 */
	protected AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Unnamed";
		mKind = pKind;
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
}
