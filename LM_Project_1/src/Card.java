/**
 *Program Name: Card.java 
 *Purpose:      The card class contains all the data and methods needed to instantiate card objects and various
 *				methods to use on them
 *@author       Logan Maxfield, 0797005, Section 04
 *@version      1.0
 *@since        Feb 10, 2025
 */

public class Card
{
	private String suit;
	private int rank;
	
	/**
	 * Constructs a new Card object initializes attributes
	 */
	public Card() {
		this.suit = "fill this";
		this.rank = -1;
	}
	/**
	 * Constructs a new Card object
	 * @param suit initializes attribute
	 */
	public Card(String suit) {
		this.suit = suit;
		this.rank = 1;
	}
	/**
	 * Constructs a new Card object
	 * @param suit
	 * @param rank initializes attribute
	 */
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	/**
	 * Gets the suit of this object
	 * @return the suit
	 */
	public String getSuit()
	{
		return suit;
	}
	/**
	 * Gets the rank of this object
	 * @return the rank
	 */
	public int getRank()
	{
		return rank;
	}
	/**
	 * Sets the suit of this object
	 * @param suit the suit to set
	 */
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	/**
	 * Sets the rank of this object
	 * @param rank the rank to set
	 */
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	
	/**
	 * Compares this card to another cards suit
	 * @param card object to compare
	 * @return a boolean, true if equal, false if not
	 */
	public boolean isSameSuit(Card c) {
		return c.getSuit() == this.suit ? true : false;
	}

	/**
	 * Returns the "face" value of this card objects rank
	 * @return A String that represents this cards face value
	 */
	public String findFaceValue() {
		String[] values = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", 
				"Nine", "Ten", "Jack", "Queen" , "King"};
		return values[rank - 1];
	}
	
	/**
	 * Check the value of the cards rank, ie 1-10 base cards , and 10 for jack, queen, king
	 * @return an int that represents this cards value
	 */
	public int findCardValue() {
		return (rank < 11) ? rank : 10;
	}
		
	/**
	 * Compares this cards value to another card objects value
	 * @param card object to compare
	 * @return a boolean, true if equal, false if not
	 */
	public boolean isGreaterThan(Card c) {
		return c.findCardValue() < this.findCardValue() ? true : false;
	}
	
	/**
	 * Compares this card to another card to see if they are equal
	 * @param card object to compare
	 * @return a boolean, true if equal, false if not
	 */
	public boolean equals(Card c) {
		return c.rank == this.rank && c.suit == this.suit ? true : false;
	}
	
	/*
	* (non-Javadoc)
	*@see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return this.findFaceValue() +" of " +  this.suit; 
	}	
}
//End of class