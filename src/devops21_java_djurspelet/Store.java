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
	protected void displayGreeting()
	{
		System.out.println( "Välkommen till " + mName );
	}


	/**
	*  Loops through the list av animals available in store
	*/
	protected void displayAnimalInventory()
	{
		// Write to screen kind, health and price of animals
		System.out.println( "\nVi har dessa djur till försäljning :" );
		for (  int i = 0; i < mAnimals.size(); i++ )
		{
			AnimalBase a = mAnimals.get( i );
			String lStr = String.format( "%d art: %s   hälsa: %d%%   kön: %s   pris: %d kr", 1 + i, a.getKind(), a.getHealth(), a.getGenderStr(), a.getPrice() );
			System.out.println( lStr );
		}
	}

	/**
	 *  Loops through the list av foods available in store
	 */
	protected void displayFoodInventory()
	{
		// Write to screen name of food, price and how much there is left
		System.out.println( "\nVi har dessa djurfoder till försäljning:" );
		for (  int i = 0; i < mFoods.size(); i++ )
		{
			FoodBase f = mFoods.get( i );
			String lStr = String.format( "%d namn: %s   pris: %dkr/Kg    : %d kg", 1 + i, f.getName(), f.getPrice(), f.getQuantity() );
			System.out.println( lStr );
		}
	}


	protected void playerEntersAnimalStore( Player pPlayer )
	{
		// Say Hi
		displayGreeting();
		// Show what is available in the store
		displayAnimalInventory();

		// Show what animals the player owns
		pPlayer.printLivestock();
		//pPlayer.printFood();
		pPlayer.printCredits();

		char lPlayerChoiceChar = Game.askForValidChar( "Vill du köpa något: ", "JNjn" );
		System.out.println( "lPlayerChoiceChar: " + lPlayerChoiceChar );
		if ( lPlayerChoiceChar == 'J' || lPlayerChoiceChar == 'j' )
		{
			// Show a player a message and wait for a valid input
			int lPlayerChoiceInt = Game.askForValidNumber( "Vad vill du köpa:", 1, mAnimals.size() );
			mAnimals.get( lPlayerChoiceInt );
		}
	}


	protected void playerEntersFoodStore( Player pPlayer )
	{
		// Say Hi
		displayGreeting();
		// Show what is available in the store
		displayFoodInventory();

		// Show what animals the player owns
		pPlayer.printLivestock();
		//pPlayer.printFood();
		pPlayer.printCredits();

		char lPlayerChoiceChar = Game.askForValidChar( "Vill du köpa något: ", "JNjn" );
		System.out.println( "lPlayerChoiceChar: " + lPlayerChoiceChar );
		if ( lPlayerChoiceChar == 'J' || lPlayerChoiceChar == 'j' )
		{
			// Show a player a message and wait for a valid input
			int lPlayerChoiceInt = Game.askForValidNumber( "Vad vill du köpa:", 1, mFoods.size() );
			mFoods.get( lPlayerChoiceInt );
		}
	}
}
