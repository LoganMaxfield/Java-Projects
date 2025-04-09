import java.util.Scanner;

/**
 * Program Name: GameOf21.java 
 * Purpose: This class contains all the data and methods to actually play a game of 21
 * @author Logan Maxfield, 0797005, Section 04
 * @version 1.0
 * @since Feb 10, 2025
 */

public class GameOf21 extends CardGame
{ 
	private Player user;
	private Player computer;
	private LeaderBoard record;

	private static Scanner input = new Scanner(System.in);

	/**
	 * Constructs a new GameOf21 object
	 * 
	 * @param user     
	 * initializes attribute
	 */
	public GameOf21(String user)
	{
		super("21");
		this.user = new Player(user);
		this.computer = new Player();
		this.record = new LeaderBoard();
	}

	/**
	 * Gets the user of this object
	 * 
	 * @return the user
	 */
	public Player getUser()
	{
		return user;
	}

	/**
	 * Gets the computer of this object
	 * 
	 * @return the computer
	 */
	public Player getComputer()
	{
		return computer;
	}

	/**
	 * Gets the record of this object
	 * 
	 * @return the record
	 */
	public LeaderBoard getRecord()
	{
		return record;
	}

	/**
	 * Gets the input of this object
	 * 
	 * @return the input
	 */
	public Scanner getInput()
	{
		return input;
	}

	/**
	 * Sets the user of this object
	 * 
	 * @param user the user to set
	 */
	public void setUser(Player user)
	{
		this.user = user;
	}

	/**
	 * Sets the computer of this object
	 * 
	 * @param computer the computer to set
	 */
	public void setComputer(Player computer)
	{
		this.computer = computer;
	}

	/**
	 * Sets the record of this object
	 * 
	 * @param record the record to set
	 */
	public void setRecord(LeaderBoard record)
	{
		this.record = record;
	}

	/**
	 * Sets the input of this object
	 * 
	 * @param input the input to set
	 */
	public void setInput(Scanner input)
	{
		GameOf21.input = input;
	}


	public void startGame()
	{
		printTitle(getGameType());
		printInstructions();
		playGame();
	}


	protected void printTitle(String gameType)
	{
		System.out.println("Welcome to Logan Maxfield's " + gameType + " Application!");
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}


	protected void printInstructions()
	{
		System.out.println("How to play the game of 21");
		System.out.println("-------------------------------------------------------------------------------------------------------");
		System.out.println("The objective of the game is getting the closest to 21 without going over. "
				+ "\nEach player is dealt with 2 cards. The user can then decide whether to draw another card.");
		System.out.println("The computer does the same. Face cards have a value of 10 and Aces can be high or low "
				+ "\n(that is, 11 points or 1 point) depending on achieving the closest score to 21 without going over.");
		System.out.println("After 2 or more cards have been drawn by each player, the score is totaled, and a winner is declared.");
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}


	protected void playAgain()
	{
		if(getDeck().size() > 10) { //NOTE: Stopping play with 10 cards remaining, this is because a 6 card hand is the highest but still somewhat reasonable hand size
									// 	    for a round of blackjack. The odds of both players having 6 card hands is even lower, therefore 10 is a safe bet.				
			
			record.setGameNumber(record.getGameNumber() + 1); // GameCount incremented
			if(user.totalHand() == computer.totalHand()) {
				record.setDraw(record.getDraw() + 1); //Checks for even hand values in case of draw
			}
			else if(user.totalHand() > computer.totalHand() && user.totalHand() <= 21 || (computer.totalHand() > 21 && user.totalHand() <= 21)) {
				//if Users hand is > comp hand and less than 21 OR comp hand is > 21 and user hand is less.
				record.setUserWin(record.getUserWin()+ 1);
			}
			else {
				record.setComputerWin(record.getComputerWin() + 1); //All other cases are computer wins
			}
			//Ask user to play again
			System.out.println("Play another game (Y/N)?");
			char playAgain = input.next().toUpperCase().charAt(0);
			if(playAgain == 'Y') {
				user.emptyHand();
				computer.emptyHand();
				playGame();
			}
			//If no print end message + score print out
			else{
				record.toString();
				System.out.println("Thanks for playing, Bye!");
				//System.out.println("deck remaining: " + getDeck().size());
			}
		}
		else {
			//Case for deck empty
			record.toString();
			//System.out.println("deck remaining: " + getDeck().size());
			System.out.println("Deck empty... ending program");
			System.out.println("Thanks for playing, Bye!");
			
		}
	}


	protected void printWinner() // Uses the same logic as the above method to print winner of individual hands
	{
		System.out.print("\n-------------------------------------------------");
		System.out.print("\nGame of 21 Game #" + (record.getGameNumber() + 1));
		System.out.print("\n-------------------------------------------------") ;
		System.out.printf("\n%s points: %10d",user.getName() ,user.totalHand()  );
		System.out.printf("\n%s points: %10d",computer.getName(), computer.totalHand());
		System.out.print("\n-------------------------------------------------\n");
		
		if(user.totalHand() == computer.totalHand()) {
			System.out.println("Game is a draw.");
			System.out.println("-------------------------------------------------");
		}
		else if(user.totalHand() > computer.totalHand() && user.totalHand() <= 21 || (computer.totalHand() > 21 && user.totalHand() <= 21)) {
			System.out.println(user.getName() + " wins!");
			System.out.println("-------------------------------------------------");
		}
		else {
			System.out.println(computer.getName() + " wins!");
			System.out.println("-------------------------------------------------");
		}
	}


	protected void playGame()
	{
		//Start by drawing two cards each
		user.draw(dealCard());
		computer.draw(dealCard());
		user.draw(dealCard());
		computer.draw(dealCard());
		//Print hands once before loop
		System.out.println(user +"\n");
		System.out.println(computer + "\n");

		
		char playerFlag = ' ';
		while((playerFlag != 'N' || computer.totalHand() < 17) && user.totalHand() < 21) {	
		
			if(user.totalHand() < 21 && playerFlag != 'N')
				playerFlag = userDraws();
			
			if(computer.totalHand() < user.totalHand() || computer.totalHand() < 17)
				computerDraws();
			
			//Print hands
			System.out.println(user +"\n");
			System.out.println(computer + "\n");
			
			//End loop early if hands exceed 21 or player stands and computer has a better hand.
			if((user.totalHand() > 21 || computer.totalHand() > 21) || (computer.totalHand() > user.totalHand() && playerFlag == 'N'))
				break;
		}
		printWinner();
		playAgain();	
	}

	/**
	 * asks the user if he wants to draw another card and, if he does, draws another card; 
	 * otherwise the user stands. 
	 */
	private char userDraws()
	{
		System.out.println("Do you want another card (Y/N)?");
		char tempChar = input.next().toUpperCase().charAt(0);
		if(tempChar == 'Y') {
			user.draw(dealCard());
		}
		else {
			System.out.println(user.getName() + " stands.");
		}
		return tempChar;
	}
	
	/*
	 * draw another card if the user’s total hand is >= to the computer’s hand; otherwise the computer stands. 
	 * Computer will stand at 17 or above.
	 */
	private void computerDraws() 
	{
		if(user.totalHand() > 21)
			System.out.println("Computer stands.");
		else if(computer.totalHand() < 17)
			computer.draw(dealCard());
	}
	
}// End of class