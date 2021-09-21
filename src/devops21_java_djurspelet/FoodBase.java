package devops21_java_djurspelet;

public abstract class FoodBase
{
	private String mName;
	private int mCost;


	/**
	* Initializes this object
	*
	* @param pName
	* @param pCost  In kilograms
	*/
	public FoodBase( String pName, int pCost )
	{
		mName = pName;
		mCost = pCost;
	}
}
