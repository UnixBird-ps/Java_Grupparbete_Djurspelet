package devops21_java_djurspelet;

public class CatFood extends FoodBase{
    /**
     * Initializes this object
     *
     * @param pName     food name
     * @param pPrice    In kilograms
     * @param pQuantity quantity of food held
     */
    public CatFood(String pName, int pPrice, int pQuantity) {
        super(pName, pPrice, pQuantity);
    }
}
