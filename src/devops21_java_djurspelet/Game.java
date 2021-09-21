package devops21_java_djurspelet;

import java.util.Scanner;
import java.util.ArrayList;


public class Game
{
	// Local class for testing only
	private static class TestPlayer
	{
		static final int ATSTART_CREDITS = 10000;
		private String mName;
		private int mCredits;
		// Constructor
		TestPlayer( String pReqName )
		{ mName = pReqName; mCredits = ATSTART_CREDITS; }
		public String getName()
		{ return mName; }
	}

	private static final String mName = "Djurspelet";
	private static final int ATSTART_MIN_PLAYERS = 2;
	private static final int ATSTART_MAX_PLAYERS = 4;
	private static final int ATSTART_MIN_ROUNDS  = 5;
	private static final int ATSTART_MAX_ROUNDS  = 30;

	private static Store mStore;
	private static ArrayList<TestPlayer> mPlayers;
	private static int mNumOfPlayersRequested;
	private static int mRoundsStillToRun;


	/**
	* Calls method where game is set up by asking players some values
	* Calls method where main loop runs
	*/
	Game ()
	{
		System.out.println( this.getName() );

		mStore = new Store( "Lantdjursbutiken" );
		mPlayers = new ArrayList<>();

		setupGame();

		runMainGameLoop();
	}


	String getName() { return mName; }


	/**
	* Asks for user input. Loops until a valid value within a range has been entered.
	* Prints to screen valid range.
	* Shows a notice if value is outside range.
	*
	* @param pValidMin  Lower limit
	* @param pValidMax  Upper limit
	* @return           A value between pValidMin and pValidMax, inclusive
	*/
	private int askForValidNumber( String pMsg, int pValidMin, int pValidMax )
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
	public String askForValidName( String pMsg )
	{
		boolean lIsValid = false; // Not yet!
		Scanner lScanner = new Scanner( System.in );
		String lInputStr = "";

		String lRegExStr = "[A-ZÅÄÖ][A-ZÅÄÖa-zåäö -]+"; // Swedish alphabet

		while ( !lIsValid ) // Keep asking for valid choice
		{
			// Show the message on screen
			System.out.print( pMsg + " : " );

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
		mNumOfPlayersRequested = askForValidNumber( "Hur många spelare?", ATSTART_MIN_PLAYERS, ATSTART_MAX_PLAYERS );
		mRoundsStillToRun = askForValidNumber( "Hur många rundor?", ATSTART_MIN_ROUNDS, ATSTART_MAX_ROUNDS );

//		// Ask for player names and add players to the game.
//		for ( int i = 0; i < mNumOfPlayersRequested; i++ )
//		{
//			String lReqPlayerName = askForValidName( "Vad heter spelare #" + ( 1 + i ) + "?" );
//			mPlayers.add( new TestPlayer( lReqPlayerName ) );
//		}

			// For testing only
			mNumOfPlayersRequested = ATSTART_MIN_PLAYERS;
			mRoundsStillToRun = ATSTART_MIN_ROUNDS;
			mPlayers.add( new TestPlayer( "Åsa" ) );
			mPlayers.add( new TestPlayer( "Östen" ) );
			mPlayers.add( new TestPlayer( "Håkan" ) );
	}


	/**
	* Runs the main game loop
	* Until number of players still in this game is 1
	* or all of this game rounds has been run
	*/
	private void runMainGameLoop()
	{
		// For testing only
		System.out.println( "\nNumOfPlayersRequested: " + mNumOfPlayersRequested );
		System.out.println( "Players:" );
		for ( int i = 0; i < mPlayers.size(); i++ )
		{
			System.out.println( "lPlayerName #" + ( 1 + i ) + ": " + mPlayers.get( i ).getName() );
		}

		// For testing only
		System.out.println( "\nMain game loop entered.\n" );

		// Keep looping until all rounds has run or until all but one player is left
		while ( mRoundsStillToRun > 0 && mPlayers.size() > 1 )
		{
			// For testing only
			System.out.println( "RoundsStillToRun: " + mRoundsStillToRun );
			System.out.println( "mPlayers.size(): " + mPlayers.size() );

			runOneRound();

			// Count down
			mRoundsStillToRun--;
		}

		// For testing only
		System.out.println( "\nRoundsStillToRun: " + mRoundsStillToRun );
		System.out.println( "mPlayers.size(): " + mPlayers.size() );
		System.out.println( "\nMain game loop ended." );
	}


	private void runOneRound()
	{
		// For testing only
		System.out.println( "\nGame round step entered.\n" );

		// The round logic starts here

		// player's turn while loop starts
		for ( int i = 0; i < mPlayers.size(); i++ )
		{
			boolean lEndPlayerTurn = false;
			// Continue until player is happy

			// For every player
			mStore.displayGreeting();

			// Show what is available in the store
			mStore.displayInventory();

			// Show what animals the player owns
			// mPlayers

		} // Player's turn loop end

		// For testing. Removes a player. Prints out who was removed
		TestPlayer lRemovedPlayer = mPlayers.remove( (int)( Math.random() * mPlayers.size() ) );
		System.out.println( lRemovedPlayer.getName() + " has left the game." );

		// For testing
		System.out.println( "\nGame round step ended." );
	}
}
