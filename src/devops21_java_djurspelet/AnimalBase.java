package devops21_java_djurspelet;

public abstract class AnimalBase
{
	private int mPriceAtMaxHealth;
	private int mHealth;
	private String mName;

	public AnimalBase( int pPriceAtMaxHealth )
	{
		mName = "Unnamed";
		mPriceAtMaxHealth = pPriceAtMaxHealth;
		mHealth = 100;
	}
}
