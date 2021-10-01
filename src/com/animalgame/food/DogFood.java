package com.animalgame.food;

import com.animalgame.bases.FoodBase;
import com.animalgame.enums.FoodKind;

public class DogFood extends FoodBase
{
	public static final float PRICE = 20.0f;
	public static final String NAME = "Torrfoder för hundar";


	/**
	* Initializes this object
	*
	* @param pQuantity  Quantity of food held in whole kilograms
	*
	* @author P.S.
	*/
	public DogFood( float pQuantity )
	{
		super( NAME, FoodKind.DOGFOOD, PRICE, pQuantity );
	}


	/**
	* Create a new separate instance of same class
	* @return  New object with specified quantity
	*
	* @author P.S.
	*/
	public FoodBase createNewWithQuantity( float pQuantity )
	{
		return new DogFood( pQuantity );
	}
}
