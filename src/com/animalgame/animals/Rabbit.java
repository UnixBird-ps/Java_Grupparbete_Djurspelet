package com.animalgame.animals;

import com.animalgame.bases.AnimalBase;
import com.animalgame.enums.*;
import com.animalgame.food.*;

import java.util.ArrayList;
import java.util.Random;


/**
* A class for rabbit specific values
*
* @author Mauro, P.S.
*/
public class Rabbit extends AnimalBase
{
	protected static final int PRICE = 1000;
	protected static final String KIND = "kanin";
	protected static final float FOOD_REQ_QUANTITY = 0.2f;
	protected static final int TYPICAL_NUMBER_OF_OFFSPRING = 5;

	/**
	* Initializes this object
	*
	* @author P.S.
	*/
	public Rabbit()
	{
		super( AnimalKind.RABBIT, PRICE, 10, FOOD_REQ_QUANTITY );
		this.mRightFood.add( Carrots.NAME );
		this.mRightFood.add( Forage.NAME );
	}



	/**
	* Initializes this object
	*
	* @param pGender  Desired gender of this animal
	*
	* @author P.S.
	*/
	public Rabbit( AnimalGender pGender )
	{
		super( AnimalKind.RABBIT, PRICE, 10, FOOD_REQ_QUANTITY, pGender );
		this.mRightFood.add( Carrots.NAME );
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
				// How many rabbits?
				int lNum = 1 + lRandom.nextInt( TYPICAL_NUMBER_OF_OFFSPRING );
				for ( int i = 0; i < lNum; i++ ) lNewOffspringList.add( new Rabbit() );
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
		return new Rabbit();
	}


	/**
	* Creates a new separate instance of same class
	* @param   pWhatGender  The gender of new animal
	* @return               New animal of same kind but of specified gender
	*
	* @author P.S.
	*/
	public AnimalBase createNewWithGender( AnimalGender pWhatGender )
	{
		return new Rabbit( pWhatGender );
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
