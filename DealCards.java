/*

Dealing Cards

Create a program to deal a specified number of cards from a standard deck of 52.
Use the Random class (see Roll Dice and the Random Class Notes) to pick a random
number between 0 and 51.  Use integer division to get the suit and modulo (%) to 
get the rank (A, 2, 3, ..., K).  For the purposes of this program, don't worry 
about repeated cards. 

Use the four class constants defined below to print out the proper character for 
each suit. You will need to write some if...else if...else code to print out the 
correct character for non-numeric ranks (A, J, Q, K).

Your program should produce output similar to the following:
(The letters H D C S should be replaced by the characters for each suit)

  How many cards would you like to deal (Enter 0 to quit)? 5
  
  Dealing 5 cards:  2H  AS  JC  9C 10D

  How many cards would you like to deal (Enter 0 to quit)? 0
  
*/

import java.util.Random;
import java.util.Scanner;

public class DealCards
{
	public final static char hearts   = (char) 3;
	public final static char diamonds = (char) 4;
	public final static char clubs    = (char) 5;
	public final static char spades   = (char) 6;
	
	private static Random anyCard = new Random();
    private static Scanner myInput = new Scanner (System.in);
    
     

    public static void main(String[] args) {

	 char suit;
	 int rank;
	 int card;
	 int nCards;

		for (;;) // Infinite loop!
		{
			System.out.print ("\nHow many cards would you like to deal (Enter 0 to exit)? ");
			nCards = myInput.nextInt();
			
			if (nCards <= 0) break; // Exit loop immediately
			
			System.out.println("\nDealing " + nCards + " cards: ");
			
			// Loop to deal and print the chosen number of random cards
			//
			for (;nCards > 0; nCards--) // Loop counts down from nCards
			{
				card = anyCard.nextInt(52);
				
			   	System.out.print (getCard(card));
			}
		   	System.out.println ();
	   	}
	}
	
	public static String getCard(int c)
	{
		String numSuit = "";
		
		int rank = (c%13)+1;
		if(rank<10 && rank!=1){numSuit+=" "+rank;}
		else if(rank == 10){numSuit+=rank;}
		else if(rank == 1){numSuit+=" A";}
		else if(rank == 11){numSuit+=" J";}
		else if(rank == 12){numSuit+=" Q";}
		else if(rank == 13){numSuit+=" K";}
		
		int suit = c/13;
		numSuit += (char)(suit+3)+" "; 
		
		return numSuit;
	}
}