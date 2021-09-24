package devops21_java_djurspelet;

import java.util.ArrayList;


public class Player {

    private static final int ATSTART_CREDITS = 25000;
    private String mName;
    public int mCredits;
    public ArrayList<AnimalBase> mAnimals;
    public ArrayList<FoodBase> mFoods;

    Player(String name) {
        mName = name;
        mCredits = ATSTART_CREDITS;
        mAnimals = new ArrayList<>();
        mFoods = new ArrayList<>();
    }

    /**
     * lets you choose how many of received animals to purchase
     * @param pAnimal animal to purchase
     */
    public void buyAnimal(AnimalBase pAnimal) {
        boolean lLoop = true;
        while (lLoop){
            int animalAmount = Game.askForValidNumber("Välj hur många djur du vill köpa: ",1,1000);
            if (mCredits >= pAnimal.getPrice()*animalAmount) {
                mCredits -= pAnimal.getPrice()*animalAmount;
                for(int i =0; i<animalAmount;i++){
                    mAnimals.add(pAnimal);
                    mAnimals.get(mAnimals.size()-1).setmName(Game.askForValidName("Döp ditt djur!"));
                }
                lLoop =false;
            } else {
                System.out.println("Du har inte råd!");
                switch(Game.askForValidChar("Avbryt köp?","jn")){
                    case 'j':
                        lLoop = false;
                        break;
                    case 'n':
                }
            }
        }
    }

    /**
     * method sells an animal adding it to store sent and removing it from player
     *
     * @param pAnimal player animal to sell
     * @param pStore  store for list adress to send animal to
     */
    public void sellAnimaltoStore(AnimalBase pAnimal, Store pStore) {
        mCredits += pAnimal.getPrice();
        pStore.mAnimals.add(pAnimal);
        mAnimals.remove(pAnimal);
    }

    /**
     * sells animal to no recipient
     *
     * @param pAnimal sells animal for equivalent value
     */
    public void sellAnimal(AnimalBase pAnimal) {
        mCredits += pAnimal.getPrice();
        mAnimals.remove(pAnimal);
    }

    /**
     * Receives food from store as chosen type to purchase.
     * handles dialogue and choices and amount to buy from food object.
     * does nothing if player decides to not purchase any
     *
     * @param pFood food object to purchase of
     */
    public void buyFood(FoodBase pFood) {
        if (pFood.getQuantity() != 0) {
            System.out.println("Hur mycket " + pFood.getName() + " Vill du köpa?");
            int lQuantity = Game.askForValidNumber("Ange kg: ",1,10000);
            if (lQuantity <= pFood.getQuantity()) {
                System.out.println("Det kommer kosta: " + (lQuantity * pFood.getPrice()) + " Credits");
                char lPlayerChoiceChar = Game.askForValidChar("Är du säker? j/n", "jn");
							  if (  lPlayerChoiceChar == 'J' || lPlayerChoiceChar == 'j' ) {
                    if(mCredits > lQuantity * pFood.getPrice()) {
                    /*
                      adds obj food into list if not present and sets quantity to amount bought
                      else adds quantity bought onto existing obj in list
                     */
                        if (!mFoods.contains(pFood)) {
                            mFoods.add(pFood);
                            int temp = mFoods.indexOf(pFood);
                            mFoods.get(temp).setQuantity(lQuantity);
                            //pFood.removeQuantity(lQuantity); unintended effect
                        } else {
                            int temp = mFoods.indexOf(pFood);
                            mFoods.get(temp).addQuantity(lQuantity);
                            pFood.removeQuantity(lQuantity);
                        }
                    }else{
                        System.out.println("Du har inte råd!");
                    }
                } else {
                    System.out.println("För dyrt för dig?");
                }
            }
        } else {
            System.out.println("Det finns ingen mat att köpa!");
        }
    }


    /**
     * Makes all animals the player hold age (take health damage)
     */
    public void decayAnimalsOwned(){
        if(!mAnimals.isEmpty()){
            for (AnimalBase animal: mAnimals) {
                animal.growOlder();
            }
        }
    }

    /**
     * prints out list of animals in a vertical format
     * includes index animal is at
     */
    public void printLivestock() {
        int index = 0;
        if (mAnimals.isEmpty()) System.out.println(getName() + " har inga djur.");
        System.out.println("I " + mName + "'s djurbestånd finns det:");

			int lNumLength = 0, lKindLength = 0, lHealthLength = 0, lGenderLength = 0, lPriceLength = 0;
			for (  int i = 0; i < mAnimals.size(); i++ )
			{
				AnimalBase a = mAnimals.get( i );
				if ( Integer.toString( i ).length() > lNumLength ) lNumLength = Integer.toString( i ).length();
				if ( a.getKind().length() > lKindLength ) lKindLength = a.getKind().length();
				if ( a.getGenderStr().length() > lGenderLength ) lGenderLength = a.getGenderStr().length();
				if ( ( a.getHealthStr() + a.getHealthDeltaStr() ).length() > lHealthLength ) lHealthLength = ( a.getHealthStr() + a.getHealthDeltaStr() ).length();
				if ( Integer.toString( a.getPrice() ).length() > lPriceLength ) lPriceLength = Integer.toString( a.getPrice() ).length();
			}

        for (int i = 0; i < mAnimals.size(); i++) {
            //System.out.println(index++ + ". " + temp.getKind() + "(" + temp.getName() + ")" );
            AnimalBase a = mAnimals.get(i);
            String lStr = String.format( "%" + lNumLength + "d. art: %-" + lKindLength + "s   hälsa: %" + lHealthLength + "d%%(%d%%)   kön: %-" + lGenderLength + "s   pris: %" + lPriceLength + "d kr", i, a.getKind(), a.getHealth(), a.getHealthDelta(), a.getGenderStr(), a.getPrice() );
            System.out.println(lStr);
        }
    }

    /**
     * prints the food and amount of said food the player holds in their supply
     */
    public void printFoodOwned() {
        System.out.println("I " + mName + "'s matförråd finns det:");
        if (!mFoods.isEmpty()) {
            for (FoodBase food : mFoods) {
                System.out.println(food.getName() + " " + food.getQuantity() + " kg");
            }
        } else {
            System.out.println(mName + " du har ju ingen mat!");
        }
    }

    /**
     * prints to console the current amount this Player holds
     */
    public void printCredits() {
        System.out.println(mName + " has " + mCredits + " Credit(s)");
    }

    public String getName() {
        return mName;
    }


		/**
		* Show a list of animals the player owns
		* Let the player select an animal
		* Let the player select another animal of same kind but different gender
		* Create new animal using the keyword new and right constructor, there are two
		* Add the newly crated animal to player's list of animals
		*
		* @author P.S.
		*/
		public void tryAnimalBreeding()
		{
			System.out.println( "TODO: Method for animal breeding" );
		}


	/**
	* Show a list of animals the player owns
	* Let the player select an animal
	* Feed the aninal
	*
	* @author P.S.
	*/
	public void tryAnimalFeeding()
	{
		System.out.println( "TODO: Method for animal feeding" );
	}
}
