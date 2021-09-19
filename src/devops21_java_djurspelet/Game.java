package devops21_java_djurspelet;

import java.util.function.DoubleToIntFunction;

public class Game {

	private static final int ATSTART_MIN_ROUNDS  = 5;
	private static final int ATSTART_MAX_ROUNDS  = 30;
	private static final int ATSTART_MIN_PLAYERS = 2;
	private static final int ATSTART_MAX_PLAYERS = 4;
	private static final int ATEND_MINMAX_PLAYERS   = 1;

	private static int mNumOfRoundsRequested;   // Anges av användaren
	private static int mNumOfPlayersRequested;  // Anges av användaren
	//private static ArrayList<Player> mPlayers;
	private static int mRoundsStillToRun;


	private static void runMainGameLoop()
	{
	}


	Game ()
	{
		askGameStartVars();
		// mRoundsStillToRun = ?; // From user input

		runMainGameLoop()
	}

	private void askGameStartVars()
	{
		mNumOfRoundsRequested = 0;
		mNumOfPlayersRequested = 0;
		mRoundsStillToRun = 0;
		System.out.println( "Hur många spelare? Ange ett tal mellan " + ATSTART_MIN_ROUNDS + " och " + ATSTART_MAX_ROUNDS + "." );
	}

}
