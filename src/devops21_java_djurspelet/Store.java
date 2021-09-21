package devops21_java_djurspelet;

import java.util.ArrayList;

/**
 *  Holds foods and animals for sale
 */
public class Store
{
	static final int ATSTART_QUANTITY_PER_ANIMAL = 5;
	static final int ATSTART_QUANTITY_PER_FOOD   = 2000; // in kilograms

	String mName;                          // Initialized in the constructor
	public ArrayList<AnimalBase> mAnimals; // Sellable to players
	public ArrayList<FoodBase> mFoods;     // Sellable to players

	// Creates a store with a name
	public Store( String pName )
	{
		mName = pName;
		mAnimals = new ArrayList<>();
		mFoods   = new ArrayList<>();

		// Create data
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Horse( 10000 ) );
		mFoods.add( new Forage( "Grovfoder", 2, ATSTART_QUANTITY_PER_FOOD ) );
		mFoods.add( new Carrots( "Morötter", 15, ATSTART_QUANTITY_PER_FOOD ) );
	}


	/**
	*  Greets a player
	*/
	void displayGreeting()
	{
		System.out.println( "Välkommen till " + mName );
	}


	/**
	*  Loops through the list av animals and foods available in store
	*/
	public void displayInventory()
	{
		// Write to screen kind, health and price of animals
		System.out.println( "\nVi har dessa djur till försäljning :" );
		for ( AnimalBase a : mAnimals )
		{
			String lStr = String.format( "art: %s   hälsa: %d%%   pris: %d kr", a.getKind(), a.getHealth(), a.getPrice() );
			System.out.println( lStr );
		}

		// Write to screen name of food, price and how much there is left
		System.out.println( "Vi har dessa djurfoder till försäljning:" );
		for ( FoodBase f : mFoods )
		{
			String lStr = String.format( "%s   pris: %d/Kg    : %d kg", f.getName(), f.getPrice(), f.getQuantity() );
			System.out.println( lStr );
		}
	}
}
