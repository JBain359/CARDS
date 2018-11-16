/*

   Tests the Card and Deck classes

*/
import java.util.Arrays; 

public class DeckOfCardsDriver
{
	public static void main (String [] args)
	{
		testCard();
		testDeck();
	}
	public static void testCard ()
	{
		Cards firstCard = new Cards(0); 	// Should be an Ace of Hearts
		Cards finalCard = new Cards(51); 	// Should be a King of Spades
		
		System.out.println (firstCard);
		System.out.println (finalCard);
		
		// Add code to test get and set methods, then print out modified cards
	}
	public static void testDeck ()
	{
		Deck deck = new Deck();
		Cards [] myHand;
		Cards myCard;

		System.out.println ("Before shuffling " + deck);
		myCard = deck.getNextCard(); 	// Should be Ace of Hearts
		System.out.println (myCard);
		myHand = deck.dealHand(5);		// Should be 2-6 0f Hearts
		System.out.println (Arrays.toString(myHand));
		deck.shuffle();
		System.out.println ("After shuffling " + deck);
		myCard = deck.getNextCard(); 	// Should be the first shuffled card
		System.out.println (myCard);
		myHand = deck.dealHand(5);		// Should be shuffled cards 2-6
		System.out.println (Arrays.toString(myHand));
		myHand = deck.dealHand(7);		// Should be shuffled cards 7-13
		System.out.println (Arrays.toString(myHand));
		myHand = deck.dealHand(13);		// Should be shuffled cards 14-26
		System.out.println (Arrays.toString(myHand));
		myHand = deck.dealHand(13);		// Should be shuffled cards 27-39
		System.out.println (Arrays.toString(myHand));
		myHand = deck.dealHand(12);		// Should be shuffled cards 40-51
		System.out.println (Arrays.toString(myHand));
		myHand = deck.dealHand(5);		// Not enough cards left
		System.out.println ("Should be null and is " + Arrays.toString(myHand));
		myCard = deck.getNextCard();
		System.out.println ("Should be the last shuffled card and is " + myCard);
		myCard = deck.getNextCard();	// No cards left
		System.out.println ("Should be null and is " + myCard);
	}
}