package com.animalgame.animals;

import com.animalgame.bases.AnimalBase;
import com.animalgame.enums.*;
import com.animalgame.food.Forage;

import java.util.ArrayList;
import java.util.Random;


/**
* A class for horse specifics
*
* @author Mauro, P.S.
*/
public class Horse extends AnimalBase
{
	protected static final int PRICE = 20000;
	protected static final String KIND = "häst";
	protected static final float FOOD_REQ_QUANTITY = 10.0f;
	protected static final int TYPICAL_NUMBER_OF_OFFSPRING = 1;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Horse()
	{
		super( AnimalKind.HORSE, PRICE, 25, FOOD_REQ_QUANTITY );
		this.mRightFood.add( Forage.NAME );
	}


	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Horse( AnimalGender pGender )
	{
		super( AnimalKind.HORSE, PRICE, 25, FOOD_REQ_QUANTITY, pGender );
		this.mRightFood.add( Forage.NAME );
	}


	/**
	* Checks if this animal can mate with other animal
	* Creates a random number of new offspring up to TYPICAL_NUMBER_OF_OFFSPRING
	* Returns this list to the caller
	*
	* @param pOtherAnimal  Which animal for mating
	* @return              An ArrayList of AnimalBase
	*
	* @author P.S.
	*/
	public ArrayList<AnimalBase> tryMateWith( AnimalBase pOtherAnimal )
	{
		// Create a list that holds animals to be sent back to the caller later
		ArrayList<AnimalBase> lNewOffspringList = new ArrayList<>();

		// Is the other animal matable
		if ( this.canMateWith( pOtherAnimal ) )
		{
			Random lRandom = new Random();

			// 50% of chance
			if ( lRandom.nextBoolean() )
			{
				// How many foals?
				int lNum = 1 + lRandom.nextInt( TYPICAL_NUMBER_OF_OFFSPRING );
				for ( int i = 0; i < lNum; i++ ) lNewOffspringList.add( new Horse() );
				System.out.println( "Parningen lyckades!" );
			}
			else
				System.out.println( "Parningen misslyckades!" );
		}

		return lNewOffspringList;
	}


	/**
	* @return  A new separate rabbit instance
	*
	* @author Mauro
	*/
	@Override
	public AnimalBase createChild() {
		return new Horse();
	}


	/**
	* Creates a new separate instance of same class
	* @return  New animal of same kind but of specified gender
	*
	* @author P.S.
	*/
	public AnimalBase createNewWithGender( AnimalGender pWhatGender )
	{
		return new Horse( pWhatGender );
	}


	/**
	* @return  Animal's kind as a string
	*
	* @author P.S.
	*/
	public String getKindStr()
	{
		return String.valueOf( KIND );
	}
 }
