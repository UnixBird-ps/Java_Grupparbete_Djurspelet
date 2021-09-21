package devops21_java_djurspelet;

import java.util.ArrayList;

/**
 *
 */
public class Store
{
	static final int ATSTART_QUANTITY_PER_ANIMAL = 10;
	static final int ATSTART_QUANTITY_PER_FOOD   = 1000; // in kilograms

	String mName;                          // Initialized in the constructor
	public ArrayList<AnimalBase> mAnimals; // Sellable to players
	public ArrayList<FoodBase> mFoods;     // Sellable to players

	// Creates store with a name
	public Store( String pName )
	{
		mName = pName;
		mAnimals = new ArrayList<>();
		mFoods   = new ArrayList<>();

		// Data
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Horse( 5000 ) );
	}


	void displayGreeting()
	{
		System.out.println( "Välkommen till " + mName );
	}


	public void displayInventory()
	{
		// Loop through the list av animals available in store
		System.out.println( "This animals are available:" );
		for ( AnimalBase a : mAnimals )
		{
			System.out.println( "Djurets hälsa: " + a.getHealth() + "   pris: " + a.getPrice() );
		}

		// Loop through the list av foods available in store
		System.out.println( "This foods are available:" );
		for ( FoodBase f : mFoods )
		{
			System.out.println( "Mat för djuren: " + f.getName() + "   pris: " + f.getPrice() + "   : " + f.getQuantity() );
		}
	}
}
