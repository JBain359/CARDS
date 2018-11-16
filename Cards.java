
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
import java.awt.*;


public class Cards
{
	
	public int suit;
	public int rank;
	

	public Cards(int c)
	{
		suit = c/13;
		rank = (c%13)+1;
	}
	
	public void setSuit(int s){suit = s;}
	public void setRank(int r){rank = r;}
	
	public int getSuit(){return suit;}
	public int getRank(){return rank;}
	
	public String getLocation()
	{
		String location = "Cards"; 
			
		switch(suit)
		{
			case 0:
				location+="/hearts";
				break;
			case 1:
				location+="/diamonds";
				break;
			case 2:
				location+="/clubs";
				break;
			case 3:
				location+="/spades";
				break;
		}
				
		location +=  rank + ".jpg";
				
		
		return location	;
				
		
	}
	
	public String toString()
	{
		String numSuit = "";
		
		if(rank<10 && rank!=1){numSuit+=" "+rank;}
		else if(rank == 10){numSuit+=rank;}
		else if(rank == 1){numSuit+=" A";}
		else if(rank == 11){numSuit+=" J";}
		else if(rank == 12){numSuit+=" Q";}
		else if(rank == 13){numSuit+=" K";}
		
		numSuit += (char)(suit+3)+" "; 
		
		return numSuit;
	}
}