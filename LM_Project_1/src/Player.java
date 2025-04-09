import java.util.ArrayList;

/**
 *Program Name: Player.java 
 *Purpose:     	The Player class is a template for Player objects that will hold
 *				all the data and methods for our players
 *@author       Logan Maxfield, 0797005, Section 04
 *@version      1.0
 *@since        Feb 10, 2025
 */

public class Player 
{
	private String name;
	private ArrayList<Card> hand;
	
	/**
	 * Constructs a new Player object initializes attribute
	 */
	public Player() {
		name = "Computer";
		hand = new ArrayList<Card>();
	}
	/**
	 * Constructs a new Player object
	 * @param name initializes attribute
	 */
	public Player(String name) {
		this.name = name;
		hand = new ArrayList<Card>();
	}
	/**
	 * Gets the name of this object
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Gets the hand of this object
	 * @return the hand
	 */
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	/**
	 * Sets the name of this object
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Sets the hand of this object
	 * @param hand the hand to set
	 */
	public void setHand(ArrayList<Card> hand)
	{
		this.hand = hand;
	}
	

	/**
	 * The draw(Card c) method adds a Card object to a Player’s hand, which is dealt from the CardGame class deck.
	 * @param c
	 */
	public void draw(Card c) {
		this.hand.add(c);
	}
	

	/**
	 * The totalHand() method finds the total value of a Player’s hand based on the Cards’ values. 
	 * This method also checks if a Card is an Ace and, if it is, calls the findAceValue() helper method.
	 * @return int
	 */
	public int totalHand() {
		int sum = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).findCardValue() == 1)
				sum += findAceValue(sum);
			else
				sum += hand.get(i).findCardValue();
		}
		return sum;
	}
	
	   
	/**
	 * A helper method which checks if the Player’s current hand total plus 11 goes over 21,
	 * then returns ace as 1, otherwise returns ace as 11. 
	 * @param total
	 * @return int
	 */
	private int findAceValue(int total) {
		if((total + 11) > 21)
			return 1;
		else
			return 11;
	}
	
	/**
	 * Empties the current hand object to start a new game
	 */
	public void emptyHand() {
		hand.removeAll(hand);
	}
	
	/**
	 * non-javadoc
	 * Override the Object class to string method and return a print out of this object.
	 * returns a string
	 */
	@Override
	public String toString() {
		System.out.println(this.name + " has " + hand.size() + " cards:");
		for(int i = 0; i < hand.size(); i++) {
			System.out.println((i + 1) + ") " + hand.get(i));
		}
		return "Hand Value = " + totalHand();
	}
	
	
	
	
}
//End of class