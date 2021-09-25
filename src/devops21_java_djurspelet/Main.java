package devops21_java_djurspelet;

public class Main
{
	public static void main( String[] args )
	{
		Carrots carrot = new Carrots("newCarrot", 100);
		double health = carrot.carrotFood("dog");
		System.out.println(health);
		//Start the game here
		//ame mGame = new Game(); // The game runs within this object
	}
}
