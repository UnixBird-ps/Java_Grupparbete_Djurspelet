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


	/**
	* Creates a store with a name
	*
	* @param pName
	*
	* @author P.S.
	*/
	public Store( String pName )
	{
		mName = pName;
		mAnimals = new ArrayList<>();
		mFoods   = new ArrayList<>();

		// Create data
		mAnimals.add( new Cat( 1000, AnimalGender.MALE ) );
		mAnimals.add( new Cat( 1000, AnimalGender.FEMALE ) );
		mAnimals.add( new Dog( 1000, AnimalGender.MALE) );
		mAnimals.add( new Dog( 1000, AnimalGender.FEMALE ) );
		mAnimals.add( new Rabbit( 1000, AnimalGender.MALE ) );
		mAnimals.add( new Rabbit( 1000, AnimalGender.FEMALE ) );
		mAnimals.add( new Cattle( 10000, AnimalGender.MALE ) );
		mAnimals.add( new Cattle( 10000, AnimalGender.FEMALE ) );
		mAnimals.add( new Horse( 10000, AnimalGender.MALE ) );
		mAnimals.add( new Horse( 10000, AnimalGender.FEMALE ) );
		mFoods.add( new Forage( "Grovfoder", 2, ATSTART_QUANTITY_PER_FOOD ) );
		mFoods.add( new Carrots( "Morötter", 15, ATSTART_QUANTITY_PER_FOOD ) );
		mFoods.add( new DogFood( "Torrfoder för hundar", 50, ATSTART_QUANTITY_PER_FOOD ) );
		mFoods.add( new CatFood( "Torrfoder för katter", 50, ATSTART_QUANTITY_PER_FOOD ) );
	}


	/**
	* Greets a player
	*
	* @author P.S.
	*/
	protected void displayGreeting()
	{
		System.out.println( "\nVälkommen till " + mName );
	}


	/**
	* Displays a nicely formated list
	* Loops through the list av animals available in store
	*
	* @author P.S.
	*/
	protected void displayAnimalInventory()
	{
		// Write to screen kind, health and price of animals
		System.out.println( "\nVi har dessa djur till försäljning :" );

		int lNumLength = 0, lKindLength = 0, lHealthLength = 0, lGenderLength = 0, lPriceLength = 0;
		for (  int i = 0; i < mAnimals.size(); i++ )
		{
			AnimalBase a = mAnimals.get( i );
			if ( Integer.toString( i ).length() > lNumLength ) lNumLength = Integer.toString( i ).length();
			if ( a.getKind().length() > lKindLength ) lKindLength = a.getKind().length();
			if ( a.getGenderStr().length() > lGenderLength ) lGenderLength = a.getGenderStr().length();
			if ( Integer.toString( a.getHealth() ).length() > lHealthLength ) lHealthLength = Integer.toString( a.getHealth() ).length();
			if ( Integer.toString( a.getPrice() ).length() > lPriceLength ) lPriceLength = Integer.toString( a.getPrice() ).length();
		}
		System.out.println( lNumLength + " " + lKindLength + " " + lHealthLength + " " + lGenderLength + " " + lPriceLength );

		for (  int i = 0; i < mAnimals.size(); i++ )
		{
			AnimalBase a = mAnimals.get( i );
			String lStr = String.format( "%" + lNumLength + "d  art: %" + lKindLength + "s   hälsa: %" + lHealthLength + "d%%   kön: %" + lGenderLength + "s   pris: %" + lPriceLength + "d kr", i, a.getKind(), a.getHealth(), a.getGenderStr(), a.getPrice() );
			System.out.println( lStr );
		}
	}


	/**
	* Displays a nicely formated list
	* Loops through the list av foods available in store
	*
	* @author P.S.
	*/
	protected void displayFoodInventory()
	{
		// Write to screen name of food, price and how much there is left
		System.out.println( "\nVi har dessa djurfoder till försäljning:" );

		int lNumLength = 0, lNameLength = 0, lPriceLength = 0, lQuantityLength = 0;
		for (  int i = 0; i < mFoods.size(); i++ )
		{
			FoodBase f = mFoods.get( i );
			if ( Integer.toString( i ).length() > lNumLength ) lNumLength = Integer.toString( i ).length();
			if ( f.getName().length() > lNameLength ) lNameLength = f.getName().length();
			if ( Integer.toString( f.getPrice() ).length() > lPriceLength ) lPriceLength = Integer.toString( f.getPrice() ).length();
			if ( Integer.toString( f.getQuantity() ).length() > lQuantityLength ) lQuantityLength = Integer.toString( f.getQuantity() ).length();
		}
		System.out.println( lNumLength + " " + lNameLength + " " + lPriceLength + " " + lQuantityLength );

		for (  int i = 0; i < mFoods.size(); i++ )
		{
			FoodBase f = mFoods.get( i );
			String lStr = String.format( "%" + lNumLength + "d  namn: %" + lNameLength + "s   pris: %" + lPriceLength + "dkr/Kg", i, f.getName(), f.getPrice() );
			System.out.println( lStr );
		}
	}


	/**
	* Show what animals the player owns
	* Ask if the player wants to buy food for the animals
	* Show a message and wait for a valid input
	* Calls a method that does the actual movement of data
	*
	* @param pPlayer  The player object who enters the store
	*
	* @author P.S.
	*/
	protected void playerEntersAnimalBuyStore( Player pPlayer )
	{
		// Say Hi
		displayGreeting();
		// Show what is available in the store
		displayAnimalInventory();

		// Show what animals the player owns
		pPlayer.printLivestock();
		pPlayer.printFoodOwned();
		pPlayer.printCredits();

		// Ask if the player wants to buy an animal
		char lPlayerChoiceChar = Game.askForValidChar( "Vill du köpa något?", "JN" );
		System.out.println( "lPlayerChoiceChar: " + lPlayerChoiceChar );
		if ( lPlayerChoiceChar == 'J' || lPlayerChoiceChar == 'j' )
		{
			// Prevent index go beyond the bounds
			int lLastIndex = mAnimals.size() - 1;
			if ( lLastIndex < 0 ) lLastIndex = 0;

			// Show a message and wait for a valid input
			int lPlayerChoiceInt = Game.askForValidNumber( "Vad vill du köpa?", 0, lLastIndex );
			AnimalBase lChosenAnimal = mAnimals.get( lPlayerChoiceInt );
			System.out.println( "Spelarens val: " + lChosenAnimal.getKind() + "(" + lChosenAnimal.getName() + ")" );

			// Do the actual buy
			pPlayer.buyAnimal( lChosenAnimal );
		}
	}


	/**
	* Show what animals and food the player owns
	* Ask if the player wants to sell an animal
	* Show a message and wait for a valid input
	* Calls a method that does the actual movement of data
	*
	* @author P.S.
	*/
	protected void playerEntersAnimalSellStore( Player pPlayer )
	{
		// Say Hi
		displayGreeting();

		// Show what animals the player owns
		pPlayer.printLivestock();
		pPlayer.printFoodOwned();
		pPlayer.printCredits();

		if ( pPlayer.mAnimals.size() > 0 )
		{
			// Prevent index go beyond the bounds
			int lLastIndex = pPlayer.mAnimals.size() - 1;
			if ( lLastIndex < 0 ) lLastIndex = 0;

			// Show a message and wait for a valid input
			int lPlayerChoiceInt = Game.askForValidNumber( "Vad vill du sälja?", 0, lLastIndex );
			AnimalBase lChosenAnimal = pPlayer.mAnimals.get( lPlayerChoiceInt );
			System.out.println( "Spelarens val: " + lChosenAnimal.getKind() + "(" + lChosenAnimal.getName() + ")" );

			// Do the actual sell
			pPlayer.sellAnimal( lChosenAnimal );
		}
		else
			System.out.println( pPlayer.getName() + ", du äger inga djur." );
	}


	/**
	* Show what animals the player owns
	* Ask if the player wants to buy food for the animals
	* Show a message and wait for a valid input
	* Calls a method that does the actual movement of data
	*
	* @param pPlayer  The player object who enters the store
	*
	* @author P.S.
	*/
	protected void playerEntersFoodStore( Player pPlayer )
	{
		// Say Hi
		displayGreeting();
		// Show what is available in the store
		displayFoodInventory();

		// Show what animals the player owns
		pPlayer.printLivestock();
		pPlayer.printFoodOwned();
		pPlayer.printCredits();

		// Ask if the player wants to buy food for the animals
		char lPlayerChoiceChar = Game.askForValidChar( "Vill du köpa något?", "JN" );
		System.out.println( "lPlayerChoiceChar: " + lPlayerChoiceChar );
		if ( lPlayerChoiceChar == 'J' || lPlayerChoiceChar == 'j' )
		{
			// Prevent index go beyond the bounds
			int lLastIndex = mFoods.size() - 1;
			if ( lLastIndex < 0 ) lLastIndex = 0;

			// Show a message and wait for a valid input
			int lPlayerChoiceInt = Game.askForValidNumber( "Vad vill du köpa?", 0, lLastIndex );
			FoodBase lChosenFood = mFoods.get( lPlayerChoiceInt );
			System.out.println( "Spelarens val: " + lChosenFood.getName() );

			// Do the actual buy
			pPlayer.buyFood( lChosenFood ); //, this );
		}

	}

}
