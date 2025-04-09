/**
 *Program Name: LeaderBoard.java 
 *Purpose:      Leaderboard object template that will store the values of game winners
 *				and the string to print the totals at the end of the game.
 *@author       Logan Maxfield, 0797005, Section 04
 *@version      1.0
 *@since        Feb 10, 2025
 */

public class LeaderBoard
{
	private int gameNumber;
	private int userWin;
	private int computerWin;
	private int draw;
	
	
	/**
	 * Constructs a new LeaderBoard object
	 * @param gameNumber
	 * @param userWin
	 * @param computerWin
	 * @param draw 
	 */
	public LeaderBoard()
	{
		this.gameNumber = 0;
		this.userWin = 0;
		this.computerWin = 0;
		this.draw = 0;
	}


	/**
	 * Gets the gameNumber of this object
	 * @return the gameNumber
	 */
	public int getGameNumber()
	{
		return gameNumber;
	}


	/**
	 * Gets the userWin of this object
	 * @return the userWin
	 */
	public int getUserWin()
	{
		return userWin;
	}


	/**
	 * Gets the computerWin of this object
	 * @return the computerWin
	 */
	public int getComputerWin()
	{
		return computerWin;
	}


	/**
	 * Gets the draw of this object
	 * @return the draw
	 */
	public int getDraw()
	{
		return draw;
	}


	/**
	 * Sets the gameNumber of this object
	 * @param gameNumber the gameNumber to set
	 */
	public void setGameNumber(int gameNumber)
	{
		this.gameNumber = gameNumber;
	}


	/**
	 * Sets the userWin of this object
	 * @param userWin the userWin to set
	 */
	public void setUserWin(int userWin)
	{
		this.userWin = userWin;
	}


	/**
	 * Sets the computerWin of this object
	 * @param computerWin the computerWin to set
	 */
	public void setComputerWin(int computerWin)
	{
		this.computerWin = computerWin;
	}


	/**
	 * Sets the draw of this object
	 * @param draw the draw to set
	 */
	public void setDraw(int draw)
	{
		this.draw = draw;
	}


	/*
	* (non-Javadoc)
	*@see java.lang.Object#toString()
	*/
	public String toString()
	{
		System.out.print("\n-------------------------------------------------");
		System.out.print("\nLeader Board Summary");
		System.out.print("\n-------------------------------------------------");
		System.out.print("\nGames Played:       "+this.getGameNumber());
		System.out.print("\nUser Wins:          "+this.getUserWin());
		System.out.print("\nComputer Wins:      "+this.getComputerWin());
		System.out.print("\nDraws:              "+this.getDraw());
		System.out.print("\n-------------------------------------------------\n");
		return"";
	}


	
	
	
	
	
	
	
}//End of class