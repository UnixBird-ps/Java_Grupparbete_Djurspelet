package devops21_java_djurspelet;

import java.util.ArrayList;

/**
 *
 */
public class Store
{
	static final int ATSTART_QUANTITY_PER_ANIMAL = 10;
	static final int ATSTART_QUANTITY_PER_FOOD   = 2000; // in kilograms

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
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Horse( 5000 ) );

		mFoods.add( new Forage( "Grovfoder", 2, ATSTART_QUANTITY_PER_FOOD ) );
		mFoods.add( new Carrots( "Morötter", 15, ATSTART_QUANTITY_PER_FOOD ) );
	}


	void displayGreeting()
	{
		System.out.println( "Välkommen till " + mName );
	}


	public void displayInventory()
	{
		// Loop through the list av animals available in store
		System.out.println( "Vi har dessa djur till försäljning :" );
		for ( AnimalBase a : mAnimals )
		{
			String lStr = String.format( "Djurets hälsa: %d%%  pris: %d kr", a.getHealth(), a.getPrice() );
			System.out.println( lStr );
		}

		// Loop through the list av foods available in store
		System.out.println( "Vi har dessa djurfoder till försäljning:" );
		for ( FoodBase f : mFoods )
		{
			String lStr = String.format( "Mat för djuren: %s   pris: %d/Kg    : %d kg", f.getName(), f.getPrice(), f.getQuantity() );
			System.out.println( lStr );
		}
	}
}
