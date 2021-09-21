package devops21_java_djurspelet;

public abstract class AnimalBase
{
	private String mName;
	private int mPriceAtMaxHealth;
	private int mHealth;
	private int mAge;

	public AnimalBase( int pPriceAtMaxHealth )
	{
		mName = "Unnamed";
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = 100;
		mAge = 0;
	}


	String getName() { return mName; }
	int getHealth() { return mHealth; }
	int getPrice() { return mHealth * mPriceAtMaxHealth; }
}
