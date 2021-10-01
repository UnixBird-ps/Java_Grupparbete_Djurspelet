package com.animalgame.food;

import com.animalgame.bases.FoodBase;
import com.animalgame.enums.FoodKind;

public class Carrots extends FoodBase
{
	public static final float PRICE = 20.0f;
	public static final String NAME = "Morötter";


	/**
	* Initializes this object
	*
	* @param pQuantity  Quantity of food held (whole kilograms)
	*
	* @author P.S.
	*/
	public Carrots( float pQuantity )
	{
		super( NAME, FoodKind.CARROTS, PRICE, pQuantity );
	}


	/**
	* Create a new separate instance of same class
	* @return  New object with specified quantity
	*
	* @author P.S.
	*/
	public FoodBase createNewWithQuantity( float pQuantity )
	{
		return new Carrots( pQuantity );
	}
}
