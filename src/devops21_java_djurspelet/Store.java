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
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Cat( 1000 ) );
		mAnimals.add( new Dog( 1000 ) );
		mAnimals.add( new Dog( 1000 ) );
		mAnimals.add( new Dog( 1000 ) );
		mAnimals.add( new Dog( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Rabbit( 1000 ) );
		mAnimals.add( new Horse( 10000 ) );
		mAnimals.add( new Horse( 10000 ) );
		mAnimals.add( new Horse( 10000 ) );
		mAnimals.add( new Cattle( 10000 ) );
		mAnimals.add( new Cattle( 10000 ) );
		mAnimals.add( new Cattle( 10000 ) );
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
		for (  int i = 0; i < mAnimals.size(); i++ )
		{
			AnimalBase a = mAnimals.get( i );
			String lStr = String.format( "%d art: %s   hälsa: %d%%   kön: %s   pris: %d kr", i, a.getKind(), a.getHealth(), a.getGenderStr(), a.getPrice() );
			System.out.println( lStr );
		}

		// Write to screen name of food, price and how much there is left
		System.out.println( "\nVi har dessa djurfoder till försäljning:" );
		for (  int i = 0; i < mFoods.size(); i++ )
		{
			FoodBase f = mFoods.get( i );
			String lStr = String.format( "%d namn: %s   pris: %dkr/Kg    : %d kg", i, f.getName(), f.getPrice(), f.getQuantity() );
			System.out.println( lStr );
		}
	}

	public void playerEntersFoodStore(Player lCurrentPlayer) {
	}

	public void playerEntersAnimalStore(Player lCurrentPlayer) {
	}
}
