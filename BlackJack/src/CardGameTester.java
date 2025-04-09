import java.util.Scanner;

/**
 *Program Name: CardGameTester.java 
 *Purpose:      This class will test the various methods and implementations of the CardGame Project as a whole
 *@author       Logan Maxfield, 0797005, Section 04
 *@version      1.0
 *@since        Feb 18, 2025
 */

public class CardGameTester
{
	public static void main(String[] args)
	{
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String user = scnr.nextLine();
		
		CardGame myGame = new GameOf21(user);
		myGame.startGame();
		scnr.close();
		
	}//End of main method
}//End of class