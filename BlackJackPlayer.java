public class BlackJackPlayer
{
  int playerPos;
  Cards [] playerHand = new Cards[5];
  int total=0;
  int aces = 0;
  public BlackJackPlayer(Deck deck)
  {
    deck.shuffle();
    playerPos = -1;
    Cards [] playerHand = new Cards[5];
    playerHand = deck.dealHand(5);   
  }
  public void getNewCard(Deck deck)
  {
    playerPos++;
    if(playerPos<5)
    {                      
      playerHand[playerPos]= deck.getNextCard();
      
      if(playerHand[playerPos].getRank()==11||playerHand[playerPos].getRank()==12||playerHand[playerPos].getRank()==13){total+=10;}
      else if(playerHand[playerPos].getRank()==1){aces++;} 
      else total+=playerHand[playerPos].getRank();
      
      for(int i = 0; i<=playerPos;i++)
      {
        if(playerHand[i].getRank()==1 && i==playerPos)
        {          
          if(total+11<=21)
          {
            total+=11;  
          }
          else 
            total+=1;
        }
        
        if(total>21)
        {
          while(total>21 && aces!=0)
          {
            total-=10;
            aces--;
          }
        }
      }
    }
    
  }
  public Cards getCard(int pos){return playerHand[pos];}
  public int getTotal(){return total;}
  
  public String toString()
  {
    String result="";
    for(int i = 0; i<=playerPos;i++)
    {
      result+=playerHand[i]+" ";
    }
    return result;
  }
}