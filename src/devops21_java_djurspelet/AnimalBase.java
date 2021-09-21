package src.devops21_java_djurspelet;


public abstract class AnimalBase {

	byte health = 100;
	boolean gender = new Random().nextBoolean();

	public AnimalBase(byte health, boolean gender) {

		this.health = health;
		this.gender = gender;
	}

	public byte getHealth() {
		return health;
	}

	public boolean isGender() {
		return gender;
	}

	public int FeedMe(FoodBase pFood, int pQuantity) {

	}
	public abstract void speak();
}