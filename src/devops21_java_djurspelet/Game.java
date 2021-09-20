package devops21_java_djurspelet;

import java.util.Scanner;
import java.util.ArrayList;


public class Game
{
	// Local class for testing only
	private static class TestPlayer
	{
		private String mName;
		// Constructor
		TestPlayer( String pReqName )
		{ mName = pReqName; }
		public String getName()
		{ return mName; }
	}

	private static final int ATSTART_MIN_PLAYERS = 2;
	private static final int ATSTART_MAX_PLAYERS = 4;
	private static final int ATSTART_MIN_ROUNDS  = 5;
	private static final int ATSTART_MAX_ROUNDS  = 30;

	private static int mNumOfPlayersRequested;
	private static ArrayList<TestPlayer> mPlayers;
	private static int mRoundsStillToRun;


	/**
	* Calls method where game is set up by asking players some values
	* Calls method where main loop runs
	*/
	Game ()
	{
		mPlayers = new ArrayList<>();

		setupGame();

		runMainGameLoop();
	}


	/**
	* Asks for user input. Loops until a valid value within a range has been entered.
	* Prints to screen valid range.
	* Shows a notice if value is outside range.
	*
	* @param pValidMin  Lower limit
	* @param pValidMax  Upper limit
	* @return           A value between pValidMin and pValidMax, inclusive
	*/
	private int askForNumber( String pMsg, int pValidMin, int pValidMax )
	{
		boolean lIsValid = false; // Not yet!
		Scanner lScanner = new Scanner( System.in );
		int lParsedInt = 0;

		while ( !lIsValid ) // Keep asking for a valid choice
		{
			// Print to screen the message and a valid intervall
			System.out.print( pMsg + " Ange ett tal mellan " + pValidMin + " och " + pValidMax + ": " );

			// Get input from user
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
	* Asks for user input. Loops until a valid value has been entered
	* Shows a message on the screen
	*
	* @param pMsg  Message shown on th screen
	* @return      Validated string
	*/
	public String askForName( String pMsg )
	{
		boolean lIsValid = false; // Not yet!
		Scanner lScanner = new Scanner( System.in );
		String lInputStr = "";

		String lRegExStr = "[A-ZÅÄÖ][a-zåäö0-9-]+"; //

		while ( !lIsValid ) // Keep asking for valid choice
		{
			// Print to screen the message
			System.out.print( pMsg + " Börja med en versal: " );

			// Get input from user
			lInputStr = lScanner.nextLine();

			// Validate input with regular expression
			lIsValid = lInputStr.matches( lRegExStr );

			if ( !lIsValid )
				System.out.println( "Namnet godtas inte." );
		}

		return lInputStr;
	}


	/**
	* Asks the user for values to initialize the game with.
	* Asks for number of rounds to play.
	* Asks for number of players in this game.
	*/
	private void setupGame()
	{
		mNumOfPlayersRequested = askForNumber( "Hur många spelare?", ATSTART_MIN_PLAYERS, ATSTART_MAX_PLAYERS );
		mRoundsStillToRun = askForNumber( "Hur många rundor?", ATSTART_MIN_ROUNDS, ATSTART_MAX_ROUNDS );

		for ( int i = 0; i < mNumOfPlayersRequested; i++ )
		{
			String lReqPlayerName = askForName( "Vad heter spelare# " + ( 1 + i ) + "?" );
			mPlayers.add( new TestPlayer( lReqPlayerName ) );
		}
	}


	/**
	* Runs the main game loop
	* Until number of players left is 1 or less
	* Until number of game rounds is 0
	*/
	private void runMainGameLoop()
	{
		System.out.println( "\nNumOfPlayersRequested: " + mNumOfPlayersRequested );

		// For testing
		for ( int i = 0; i < mPlayers.size(); i++ )
		{
			System.out.println( "lPlayerName #" + ( 1 + i ) + ": " + mPlayers.get( i ).getName() );
		}

		System.out.println( "\nMain game loop entered.\n" );

		while ( mRoundsStillToRun > 0 && mPlayers.size() > 1 )
		{
			// For testing
			System.out.println( "RoundsStillToRun: " + mRoundsStillToRun );
			System.out.println( "mPlayers.size(): " + mPlayers.size() );
			TestPlayer lRemovedPlayer = mPlayers.remove( (int)( Math.random() * mPlayers.size() ) );
			System.out.println( lRemovedPlayer.getName() + " left the game." );

			// TODO: Place the game round step here

			// Count to 0
			mRoundsStillToRun--;
		}

		// For testing
		System.out.println( "RoundsStillToRun: " + mRoundsStillToRun );
		System.out.println( "mPlayers.size(): " + mPlayers.size() );
		System.out.println( "\nMain game loop ended." );
	}
}
