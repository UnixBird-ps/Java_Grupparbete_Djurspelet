package devops21_java_djurspelet;

public abstract class AnimalBase
{
	static final int ATSTART_HEALTH = 100;

	private String mName;
	private String mKind;
	private int mPriceAtMaxHealth;
	private int mHealth;
	private int mAge;
	private int mExpectedLifeLength;

	public AnimalBase( String pKind, int pPriceAtMaxHealth, int pExpectedLifeLength )
	{
		mName = "Unnamed";
		mKind = pKind;
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = ATSTART_HEALTH;
		mAge = 0;
		mExpectedLifeLength = pExpectedLifeLength;
	}


	public String getKind() { return mKind; }
	public String getName() { return mName; }
	public int getHealth() { return mHealth; }
	public int getPrice() { return mHealth * mPriceAtMaxHealth / 100; }
	public int getAge() { return mAge; }
}
