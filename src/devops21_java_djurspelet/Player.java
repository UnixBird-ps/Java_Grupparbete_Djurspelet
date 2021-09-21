package devops21_java_djurspelet;

import java.util.ArrayList;

public class Player {

    private static final int ATSTART_CREDITS = 10000;
    private String mName;
    public int mCredits;
    ArrayList<AnimalBase> mAnimals;

    Player(String name){
        mName = name;
        mCredits = ATSTART_CREDITS;
        mAnimals = new ArrayList<>();
    }

    /**
     * Stores any AnimalBase child object sent into the player ArrayList
     * @param pAnimal animal to add to local AnimalBase ArrayList
     * @param pStore store to remove the animal from
     */
    public void buyAnimal(AnimalBase pAnimal, Store pStore){
        if(mCredits >= pAnimal.getPrice()){
            mCredits -= pAnimal.getPrice();
            mAnimals.add(pAnimal);
            pStore.mAnimals.remove(pAnimal);
        }else{
            System.out.println("Du har inte råd att köpa detta djur!");
        }
    }

    /**
     * method sells an animal adding it to store sent and removing it from player
     * @param pAnimal player animal to sell
     * @param pStore store for list adress to send animal to
     */
    public void sellAnimal(AnimalBase pAnimal, Store pStore){
        mCredits += pAnimal.getPrice();
        pStore.mAnimals.add(pAnimal);
        mAnimals.remove(pAnimal);
    }

    /**
     * prints animal in a horizontal format
     * includes index animal is in
     */
    public void printLivestock(){
        int index = 0;
        for (AnimalBase temp:mAnimals) {
            System.out.println(index++ +"."+ temp.getName() +"\t");
        }
    }

    /**
     * prints to console the current amount this Player holds
     */
    public void printCredits(){
        System.out.println(mName +" has "+ mCredits + " Credit(s)");
    }

}
