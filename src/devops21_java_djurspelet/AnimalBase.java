package devops21_java_djurspelet;

public abstract class AnimalBase
{
	static final int ATSTART_HEALTH = 100;

	private String mName;
	private int mPriceAtMaxHealth;
	private int mHealth;
	private int mAge;
	private int mExpectedLifeLength;

	public AnimalBase( int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Unnamed";
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
	}


	String getName() { return mName; }
	int getHealth() { return mHealth; }
	int getPrice() { return mHealth * mPriceAtMaxHealth; }
}
