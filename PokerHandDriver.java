/*

   Using the Deck Class

   Create a Poker_Hand class consisting of five Cards.
   Write a method eval() that returns the value of the hand {pair, two
   pairs, three of a kind, straight, flush, full house, four of a kind,
   straight-flush}.  It is a good idea to define private methods to
   check for each type of hand.

   Initialize a deck object, and repeatedly shuffle, deal a Poker hand,
   evaluate, and reset. Report the distribution of hands.

*/
import java.util.Arrays;

public class PokerHandDriver {

  //public static int [] test = {13,12,11,10,1};
  public static void main (String [] args)
  {
    
    for(int c = 0; c<9999;c++)
    {
      Deck beck = new Deck();
      beck.shuffle();
      Cards [] myHand = beck.dealHand(5);
      
      if(PokerHand.eval(myHand)!= "High Card")
      {
        System.out.println(Arrays.toString(myHand)+" "+PokerHand.eval(myHand));
      }
    }
  }
}