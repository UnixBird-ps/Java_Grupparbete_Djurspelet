package devops21_java_djurspelet;

import java.util.Scanner;
import java.util.ArrayList;


public class Game {
    // Local class for testing only
//	private static class TestPlayer
//	{
//		static final int ATSTART_CREDITS = 10000;
//		private String mName;
//		private int mCredits;
//		// Constructor
//		TestPlayer( String pReqName )
//		{ mName = pReqName; mCredits = ATSTART_CREDITS; }
//		public String getName()
//		{ return mName; }
//	}

    private static final String mName = "Djurspelet";
    private static final int ATSTART_MIN_PLAYERS = 2;
    private static final int ATSTART_MAX_PLAYERS = 4;
    private static final int ATSTART_MIN_ROUNDS = 5;
    private static final int ATSTART_MAX_ROUNDS = 30;

    private static Store mStore;
    private static ArrayList<Player> mPlayers;
    private static int mNumOfPlayersRequested;
    private static int mNumOfRoundsRequested;
    private static int mRoundsStillToRun;
    private static int mRoundNumber;


    /**
     * Calls method where game is set up by asking players some values
     * Calls method where main loop runs
     */
    Game() {
        System.out.println(getName());

        mStore = new Store("Lantdjursbutiken");
        mPlayers = new ArrayList<>();

        setupGame();

        runMainGameLoop();
    }

    /**
     * Asks the user for values to initialize the game with.
     * Asks for number of rounds to play.
     * Asks for number of players in this game.
     */
    private void setupGame() {
        mRoundNumber = 0;

//		Following commented out lines are important in the game when testing is over
//		mNumOfPlayersRequested = askForValidNumber( "Hur många spelare?", ATSTART_MIN_PLAYERS, ATSTART_MAX_PLAYERS );
//		mNumOfRoundsRequested = askForValidNumber( "Hur många rundor?", ATSTART_MIN_ROUNDS, ATSTART_MAX_ROUNDS );
//		mRoundsStillToRun = mNumOfRoundsRequested;
//
//		// Ask for player names and add players to the game.
//		for ( int i = 0; i < mNumOfPlayersRequested; i++ )
//		{
//			String lReqPlayerName = askForValidName( "Vad heter spelare #" + ( 1 + i ) + "?" );
//			mPlayers.add( new TestPlayer( lReqPlayerName ) );
//		}

        // For testing only
        mNumOfRoundsRequested = ATSTART_MAX_ROUNDS;
        mRoundsStillToRun = mNumOfRoundsRequested;

        mPlayers.add(new Player("Åsa"));
        mPlayers.get(0).mAnimals.add(new Cat(1000));
        mPlayers.get(0).mAnimals.add(new Dog(1000));
        mPlayers.add(new Player("Östen"));
        mPlayers.get(1).mAnimals.add(new Dog(1000));
        mPlayers.get(1).mAnimals.add(new Rabbit(1000));
        mPlayers.add(new Player("Håkan"));
        mPlayers.get(2).mAnimals.add(new Rabbit(1000));
        mPlayers.get(2).mAnimals.add(new Cattle(1000));
        mNumOfPlayersRequested = mPlayers.size();
    }

    /**
     * Prints to screen valid range.
     * Asks for user input. Loops until a valid value within a range has been entered.
     * Shows a notice if value is outside range.
     *
     * @param pMsg      Message shown on th screen
     * @param pValidMin Lower limit
     * @param pValidMax Upper limit
     * @return A value between pValidMin and pValidMax, inclusive
     */
    public static int askForValidNumber(String pMsg, int pValidMin, int pValidMax) {
        boolean lIsValid = false; // Not yet!
        Scanner lScanner = new Scanner(System.in);
        int lParsedInt = 0;

        while (!lIsValid) // Keep asking for a valid choice
        {
            // Print to screen the message and a valid intervall
            System.out.print(pMsg + "Ange ett tal mellan " + pValidMin + " och " + pValidMax + ": ");

            // Get input from user
            String lInputStr = lScanner.nextLine();
            String lRegExStr = "/[-0-9]+/";

            // Validate input with regular expression
            lIsValid = lInputStr.matches(lRegExStr);

            try {
                lParsedInt = Integer.parseInt(lInputStr);
                lIsValid = true;
            } catch (Exception ignored) {
            }

            // Check if input is valid
            if (lParsedInt < pValidMin || lParsedInt > pValidMax) {
                System.out.println("Värdet du har angett ligger inte inom intervallet.");
                lIsValid = false;
            }
        }

        return lParsedInt;
    }

    /**
     * Asks for user input. Loops until a valid character has been entered
     * Shows a notice if value is not valid.
     *
     * @param pMsg        Message shown on the screen
     * @param pValidChars List of valid chars as a plain string
     * @return The character entered
     */
    protected static char askForValidChar(String pMsg, String pValidChars) {
        boolean lIsValid = false; // Not yet!
        char lReturnChar = ' ';
        pValidChars = pValidChars.toUpperCase();
        String lRegExStr = "[" + pValidChars + "]";  // Square brackets are for matching one of possible chars
        Scanner lScanner = new Scanner(System.in);

        while (!lIsValid) // Keep asking for valid choice
        {
            // Show the message on screen
            System.out.print("\n" + pMsg + " Ange (" + pValidChars + "): ");

            // Get input from user
            String lInputStr = lScanner.nextLine();
            lInputStr = lInputStr.toUpperCase();

            // Validate input with regular expression
            lIsValid = lInputStr.matches(lRegExStr);

            // Check if input is valid
            if (lIsValid) {
                lReturnChar = lInputStr.charAt(0);
            } else {
                System.out.println("Alternativet finns inte.");
            }
        }

        return lReturnChar;
    }

    /**
     * Asks for user input. Loops until a valid value has been entered
     * Shows a notice if value is not valid.
     *
     * @param pMsg Message shown on th screen
     * @return Validated string
     */
    protected static String askForValidName(String pMsg) {
        boolean lIsValid = false; // Not yet!
        Scanner lScanner = new Scanner(System.in);
        String lInputStr = "";

        String lRegExStr = "[A-ZÅÄÖ][A-ZÅÄÖa-zåäö -]+"; // Swedish alphabet

        while (!lIsValid) // Keep asking for valid choice
        {
            // Show the message on screen
            System.out.print(pMsg + " : ");

            // Get input from user
            lInputStr = lScanner.nextLine();

            // Validate input with regular expression
            lIsValid = lInputStr.matches(lRegExStr);

            if (!lIsValid)
                System.out.println("Namnet godtas inte.");
        }

        return lInputStr;
    }

    /**
     * Shows a list of otions
     * Asks for user input. Loops until a valid value has been entered
     *
     * @param pMsg Message shown on th screen
     * @return Validated string
     */
    protected static int askForValidChoiceWithDesc(String pMsg, String[] pPlayerChoiceDesc) {
        System.out.println(pMsg);

        // Loop through pPlayerChoiceDesc array and write to screen every element
        for (int i = 0; i < pPlayerChoiceDesc.length; i++) {
            String s = pPlayerChoiceDesc[i];
            System.out.println((1 + i) + ": " + s);
        }

        // Reuse method
        return askForValidNumber("", 1, pPlayerChoiceDesc.length);
    }

    /**
     * Runs the main game loop
     * Until number of players still in this game is 1
     * or all of this game rounds has been run
     */
    private void runMainGameLoop() {
        // For testing only
        System.out.println("\nNumOfPlayersRequested: " + mNumOfPlayersRequested);
        System.out.println("Players:");
        for (int i = 0; i < mPlayers.size(); i++) {
            System.out.println("lPlayerName #" + (1 + i) + ": " + mPlayers.get(i).getName());
        }

        // For testing only
        System.out.println("\nMain game loop entered.");

        // Keep looping until all rounds has run or until all but one player is left
        while (mRoundsStillToRun > 0 && mPlayers.size() > 1) {
            mRoundNumber++;
            System.out.println("Round: " + mRoundNumber + " of " + mNumOfRoundsRequested + "   Rounds left: " + mRoundsStillToRun);

            // For testing only
//			System.out.println( "mPlayers.size(): " + mPlayers.size() );

            runOneRound();

            // Count down
            mRoundsStillToRun--;
        }

        // For testing only
        System.out.println("\nRoundsStillToRun: " + mRoundsStillToRun);
        System.out.println("mPlayers.size(): " + mPlayers.size());
        System.out.println("\nMain game loop ended.");
    }

    private void runOneRound() {
        // For testing only
        System.out.println("\nGame round step entered.");

        // The round logic starts here

        for (int i = 0; i < mPlayers.size(); i++) {
            // Maybe replacable by a different for loop, should be ordered maybe

            // For every player
            Player lCurrentPlayer = mPlayers.get(i);

            //boolean lEndPlayerTurn = false;

            System.out.println("\n" + lCurrentPlayer.getName() + "s tur.");


            //if ( mRoundNumber > 1 )
            //{
            // Remove animals that has died from players' animal list
            // Create a temp list, copy over only animals that are still alive
            ArrayList<AnimalBase> lNewAnimalList = new ArrayList<>();
            for (AnimalBase a : lCurrentPlayer.mAnimals) {
                if (a.getHealth() > 0)
                    lNewAnimalList.add(a);
                else
                    System.out.println(lCurrentPlayer.getName() + "s " + a.getKind() + "(" + a.getName() + ") har dött.");
            }
            lCurrentPlayer.mAnimals.clear();
            lCurrentPlayer.mAnimals.addAll(lNewAnimalList);
            //}

            // Show what animals the player owns
            lCurrentPlayer.printLivestock();
            lCurrentPlayer.printFoodOwned();
            lCurrentPlayer.printCredits();

            // Give a player 5 choices
            String lPlayerChoiceDesc[] =
                    {
                            "Köpa djur",
                            "Köpa mat till djuren",
                            "Mata djur",
                            "Försöka para djur",
                            "Sälja djur"
                    };

            switch (askForValidChoiceWithDesc("Vad vill du göra?", lPlayerChoiceDesc)) {
                case 1:
                    mStore.playerEntersAnimalBuyStore(lCurrentPlayer);
                    break;
                case 2:
                    mStore.playerEntersFoodStore(lCurrentPlayer);
                    break;
                case 3:
                    // Player feeding an animal
                    break;
                case 4:
                    // Player tries animal breeding
                    break;
                case 5:
                    // Player selling an animal
                    mStore.playerEntersAnimalSellStore(lCurrentPlayer);
                    break;
            }

            // Every animal the player owns
            for (AnimalBase a : lCurrentPlayer.mAnimals) {
                a.growOlder();
            }

        } // Player's turn loop end

        // For testing. Removes a player. Prints out who was removed
        //Player lRemovedPlayer = mPlayers.remove( (int)( Math.random() * mPlayers.size() ) );
        //System.out.println( "\n" + lRemovedPlayer.getName() + " har gått ur spelet." );

        // For testing only
        System.out.println("\nGame round step ended.");
    }

    static String getName() {
        return mName;
    }
}
