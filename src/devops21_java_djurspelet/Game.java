package devops21_java_djurspelet;

import java.util.Scanner;   // import the Scanner class


public class Game {

	private static final int ATSTART_MIN_PLAYERS = 2;
	private static final int ATSTART_MAX_PLAYERS = 4;
	private static final int ATSTART_MIN_ROUNDS  = 5;
	private static final int ATSTART_MAX_ROUNDS  = 30;
	private static final int ATEND_MINMAX_PLAYERS   = 1;

	private static int mNumOfPlayersRequested;  // Anges av användaren
	//private static ArrayList<Player> mPlayers;
	private static int mRoundsStillToRun;


	Game ()
	{
		askGameStartVars();
		// mRoundsStillToRun = ?; // From user input

		runMainGameLoop();
	}

	/**
	* Asks for user input. Loops until a valid value within a range has been entered.
	* Prints to screen valid range.
	* Shows a notice if the value is outside range.
	*
	* @param pValidMin  Lower limit
	* @param pValidMax  Upper limit
	* @return           A value between pValidMin and pValidMax, inclusive
	*/
	private int askChoice( String pMsg, int pValidMin, int pValidMax )
	{
		boolean lIsValid = false; // Not yet!
		int lParsedInt = 0;

		while ( !lIsValid ) // Keep asking for valid choice
		{
			// Print to screen the message and valid intervall
			System.out.print( pMsg + " Ange ett tal mellan " + pValidMin + " och " + pValidMax + ": " );

			// Get input from user
			Scanner lScanner = new Scanner( System.in );
			String lInputStr = lScanner.nextLine();
			String lRegExStr = "/[-0-9]+/";

			// Validate input with regular expression
			lIsValid = lInputStr.matches( lRegExStr );

			try
			{
				lParsedInt = Integer.parseInt( lInputStr );
				lIsValid = true;
			}
			catch ( Exception ignored ) {}

			// Check if input is valid
			if ( lParsedInt < pValidMin || lParsedInt > pValidMax )
			{
				System.out.println( "Värdet du har angett ligger inte inom intervallet." );
				lIsValid = false;
			}
		}

		return lParsedInt;
	}

	/**
	* Asks the user for valid values to initialize the game with.
	* Asks for number of rounds to play.
	* Asks for number of how meny players to have in this game.
	* Shows a notice if the value is outside range.
	*/
	private void askGameStartVars()
	{
		mNumOfPlayersRequested = askChoice( "Hur många spelare?", ATSTART_MIN_PLAYERS, ATSTART_MAX_PLAYERS );
		mRoundsStillToRun = askChoice( "Hur många rundor?", ATSTART_MIN_ROUNDS, ATSTART_MAX_ROUNDS );
	}


	private void runMainGameLoop()
	{
		System.out.println( "Main game loop entered." );
		System.out.println( "NumOfPlayersRequested: " + mNumOfPlayersRequested );
		System.out.println( "RoundsStillToRun: " + mRoundsStillToRun );
		System.out.println( "Main game loop ended." );
	}
}
