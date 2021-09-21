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
     * @param animal animal to add to local AnimalBase ArrayList
     */
    public void buyAnimal(AnimalBase animal){
        if(mCredits >= animal.getPrice()){
            mAnimals.add(animal);
        }else{
            System.out.println("Du har inte råd att köpa detta djur!");
        }
    }

    /**
     * sends animal to foreign ArrayList and removes from it this class
     * @param index indicates animal you want to sell
     * @param storeList the list address to sell to
     */
    public void sellAnimal(int index, ArrayList<AnimalBase> storeList){
        storeList.add(mAnimals.get(index));
        mAnimals.remove(index);
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
