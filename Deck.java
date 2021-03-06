/*
   Create a Deck class that has an array of 52 Card objects as an attribute.
   There should also be an attribute to keep track of the current position in 
   the array for card games that deal more than one hand from a single Deck.
   
   The Deck constructor should use a for loop to initialize the cards array 
   to contain all of the cards in a standard deck of 52 cards.
   
   The toString method should return a String value that will display all of 
   the cards in the Deck (possibly by using the Arrays class).
   
   Define a getNextCard() method that returns the next card in the array of cards
   or returns null if there are no cards left to be dealt. Use this method to
   get a single card from the deck. 
   Advance the current position by one if a card was available.
   
   Define a dealHand(int numCards) method that returns an array of cards with 
   the number of cards specified in the numCards parameter, or returns null if
   there are not enough cards left in the deck to deal a full hand. 
   Advance the current position by numCards if the hand was dealt successfully.
   
   Define a shuffle() method randomly choose two index values from 1 to 51 and
   swaps the two cards at those locations in the cards array a total of 1000 times.
   Check out the DealCards program for an example of using the Java Random class,
   or copy the Expo class to your folder and use Expo.random.
   Remember to reset the next card to be dealt to the first card in the array. 
*/
            
public class Deck
{
  public Cards [] deck = new Cards[52];
  public int currentCard = 0;
  
  public Deck()
  {
    for(int i = 0 ;i<52;i++)
    {
      deck[i] = new Cards(i);
    }
  }
  public String toString()
  {
    String totalDeck="";
    for(int i = 0; i<deck.length;i++)
    {                                         
      totalDeck+= deck[i]+ " ";
      if((i+1)%13==0){totalDeck+="\n";}
    }
    return "a deck of 52 cards \n"+totalDeck;
  }
  
  public Cards getNextCard()
  {
    if(currentCard>51){return null;}
      
    
    return deck[currentCard++];
  }
  
  public Cards[] dealHand (int numCards)
  {
    Cards [] hand = new Cards[numCards];
    if(numCards> deck.length-currentCard){return null;}
    
    int p = 0;
    for(int i = currentCard; i<currentCard+numCards;i++)
    {
      hand[p] = deck[i];
      p++;  
    }
    currentCard+=numCards;
    return hand;
  }
  public void shuffle()
  {
    currentCard = 0;
    Cards placeHolder;
    int index = 0;
    int newIndex = 0;
    for(int i = 0; i<999;i++)
    {
    	index = Expo.random(0,51);
    	placeHolder = deck[index];
    	newIndex = Expo.random(0,51);
    	deck[index] = deck[newIndex];
    	deck[newIndex] = placeHolder;
    	
    }
  }
}