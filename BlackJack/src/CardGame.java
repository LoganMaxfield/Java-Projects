import java.util.ArrayList;
import java.util.Collections;

/**
 *Program Name: CardGame.java 
 *Purpose:      Abstract superclass if GameOf21 Contains a few concrete methods and a bunch of abstract methods
 *				needed for our game.
 *@author       Logan Maxfield, 0797005, Section 04
 *@version      1.0
 *@since        Feb 10, 2025
 */

public abstract class CardGame 
{
	private String gameType;
	private ArrayList<Card> deck;
	
	/**
	 * Constructs a new CardGame object
	 * @param gameType initializes attribute
	 * @param deck initializes attribute
	 */
	public CardGame(String gameType) {
		this.gameType = gameType;
		deck = new ArrayList<Card>();
		populateDeck();
	}

	/**
	 * Gets the gameType of this object
	 * @return the gameType
	 */
	public String getGameType()
	{
		return gameType;
	}

	/**
	 * Sets the gameType of this object
	 * @param gameType the gameType to set
	 */
	public void setGameType(String gameType)
	{
		this.gameType = gameType;
	}
	
	/**
	 * Gets the deck of this object
	 * @return the deck
	 */
	public ArrayList<Card> getDeck()
	{
		return deck;
	}


	/**
	 * The populateDeck() method loads an ArrayList<Card> deck with 52 Card objects made up of 4 suits, 
	 * each with 13 ranks. Once the deck is populated, the helper method shuffle() is called.
	 */
	private void populateDeck() {
		//Constant for card ranks and suits
		final int MAX_RANK = 13;
		final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		//Nested loop to populate deck with cards of every suit and rank to 52
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j < MAX_RANK; j++) {
				deck.add(new Card(suits[i], j + 1));
			}
		}
		shuffle();
	}
	
	/**
	 * The dealCard() method returns and removes the “top” Card object from the deck, that is, the Card at Index 0.
	 * @return a card
	 */
	public Card dealCard() {
		//Create temp card to store the card we will delete
		Card tempCard = new Card(deck.get(0).getSuit(), deck.get(0).getRank());
		deck.remove(0);
		return tempCard;
	}
	
	/**
	 * The shuffle() method shuffles the ArrayList<Card> deck in random order.
	 */
	private void shuffle() {
		//Call collections method to randomly shuffle the array
		Collections.shuffle(deck);
	}	
	
	/**
	 * Method Name: startGame()
	 * Purpose: The startGame() method will begin a Card Game by calling the printTitle(), printInstructions(), and playGame() methods.
	 */
	abstract public void startGame(); 

	/**
	 * methodName: printTitle;
	 * Purpose: prints the title of the message of our card game. Abstract method from CardGame.java
	 * @param gameType
	 */
	abstract protected void printTitle(String gameType); //This method doesnt appear in the rubric but it does in the UML so i added it.
	
	/**
	 * Method Name: printInstructions()
	 * Purpose: Abstract method from CardGame.java
	 * 			The printInstructions() method prints the instructions of the Card Game blackjack or 21.
	 */
	abstract protected void printInstructions(); 

	/**
	 * deals two cards to each player by having each Player object get cards from the deck by calling 
	 * its respective draw() method (userDraws() and computerDraws(). Print each player, showing their two cards. 
	 * Then, call userDraws() and computerDraws() repeatedly while the user’s hand is less than 21 or the user stands. 
	 * Then call printWinner() and playAgain() methods.
	 */
	abstract protected void playGame();
		
	/**
	 * Method Name: printWinner()
	 * Purpose: checks the total points of each player. 
	 * 			The player with the points closest to 21 without going over is the winner. A draw occurs if the points are equal. 
	 *			Update the corresponding attribute of the LeaderBoard object in each case: draw, user wins, computer wins.
	 */
	abstract protected void printWinner();
	
	/**
	 * Method Name: playAgain()
	 * Purpose: checks that the deck has cards; then prompts the user to play again,
	 * 			gets the user’s response to play again and, if yes, empties the Players’ hands, 
	 * 			populates the deck, updates the LeaderBoard game number, 
	 * 			and plays the game again; otherwise prints the LeaderBoard object and an exit message
	 */
	abstract protected void playAgain();
}//End of class