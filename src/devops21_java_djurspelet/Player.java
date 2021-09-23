package devops21_java_djurspelet;

import java.util.ArrayList;
import java.util.Scanner;


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
            System.out.print("Välj hur många djur du vill köpa: ");
            int animalAmount = Game.askForValidNumber("",1,1000);
            if (mCredits >= pAnimal.getPrice()*animalAmount) {
                mCredits -= pAnimal.getPrice();
                for(int i =0; i<animalAmount;i++){
                    mAnimals.add(pAnimal);
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
                if (Game.askForValidChar("Är du säker? j/n", "jn") == 'j') {
                    if(mCredits < lQuantity * pFood.getPrice()) {
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
     * filters out int from players choice through console input
     * catches any other wrongful inputs
     *
     * @return returns chosen integer
     */
    public int playerIntChoice() {
        Scanner scan = new Scanner(System.in);
        boolean badInput = true;
        String lTemp;
        int result = 0;
        while (badInput) {
            lTemp = scan.nextLine();
            try {
                result = Integer.parseInt(lTemp);
                badInput = false;
            } catch (Exception e) {
                System.out.println("Endast heltal!\nförsök igen:");
            }
        }
        if(result<0){
            System.out.println("Inga negativa siffror!\nförsök igen:");
            playerIntChoice();
        }
        return result;
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
        for (int i = 0; i < mAnimals.size(); i++) {
            //System.out.println(index++ + ". " + temp.getKind() + "(" + temp.getName() + ")" );
            AnimalBase a = mAnimals.get(i);
            String lStr = String.format("%d. art: %s   hälsa: %d%%   kön: %s   pris: %d kr", i, a.getKind(), a.getHealth(), a.getGenderStr(), a.getPrice());
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
                System.out.println(food.getName() + food.getQuantity() + " kg");
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
}
