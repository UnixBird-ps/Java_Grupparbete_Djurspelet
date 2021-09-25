package devops21_java_djurspelet;

public class Carrots extends FoodBase {

    protected static final int ATSTART_CARROTS_PRICE = 20;


    /**
     * Initializes this object
     *
     * @param pName     Food name
     * @param pQuantity Quantity of food held in whole kilograms
     */
    public Carrots(String pName, int pQuantity) {
        super(pName, ATSTART_CARROTS_PRICE, pQuantity);
    }

    public Double carrotFood(String animal) {

        Rabbit rabbit = new Rabbit();
        Cattle cattle = new Cattle();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Horse horse = new Horse();

        switch(animal.toLowerCase()) {
            case "horse":
                int horseHealth = horse.getHealth();
                double newHorseHealth = horseHealth * 0.10;
                return newHorseHealth;
            case "dog":
                int dogHealth = dog.getHealth();
                double newDogHealth = dogHealth * 0.50;
                return newDogHealth;
            case "cat":
                int catHealth = horse.getHealth();
                double newCatHealth = catHealth * 0.50;
                return newCatHealth;
            case "rabbit":
                int rabbitHealth = rabbit.getHealth();
                double newRabbitHealth = rabbitHealth * 0.50;
                return newRabbitHealth;
            case "Cattle":
                int cattleHealth = cattle.getHealth();
                double newCattleHealth = cattleHealth * 0.10;
                return newCattleHealth;
            default:
                break;

        }
        return null;
    }


}