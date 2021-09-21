package devops21_java_djurspelet;

import java.util.ArrayList;

public class Store
{
	static final int ATSTART_QUANTITY_PER_ANIMAL = 10;
	static final int ATSTART_QUANTITY_PER_FOOD = 1000; // in kilograms

	String mName;                          // Initialized in the constructor
	public ArrayList<AnimalBase> mAnimals; // Sellable to players
	public ArrayList<FoodBase> mFoods;     // Sellable to players

	public Store( String pName )
	{
		mName = pName;
	}


	void displayGreeting()
	{
		System.out.println( "Välkommen till " + mName );
	}


	static void displayInventory()
	{
		// Loop through the list av animals
		System.out.println( "TODO: Loops through the list of animals available" );
	}
}
