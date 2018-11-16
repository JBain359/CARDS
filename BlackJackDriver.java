// Josh was here, Bain-boy
import java.util.Scanner;
public class BlackJackDriver
{
  private static Scanner myInput = new Scanner (System.in);
  public static void main(String [] args)
  {
    String playing = "y"; 
    while(playing.equals("y"))
    {
      System.out.print("**********************************************************************\n");
      playBlackJack();
      System.out.print("\nPlay Again? (y/n): ");
      playing = myInput.nextLine();
      System.out.print("\n");
    }
  }
  public static void playBlackJack()
  {
    Deck blackDeck = new Deck();
    BlackJackPlayer player = new BlackJackPlayer(blackDeck);
    BlackJackPlayer computer = new BlackJackPlayer(blackDeck);
    
    player.getNewCard(blackDeck); 
    player.getNewCard(blackDeck);
    computer.getNewCard(blackDeck);
    computer.getNewCard(blackDeck);
    while(computer.getTotal()<16)
    {
      computer.getNewCard(blackDeck);
    }
    
    System.out.println("Your Cards: " + player.getCard(0) + " " +player.getCard(1) + "| Computer's Cards: " + computer.getCard(0) + " " + computer.getCard(1)+ "\n");
    //System.out.println("Your Total: " + player.getTotal());
    
    
    String hitMe;
    int hits = 2;
    
    for(;;)
    { 
      if(hits>4)
      {
        compareTotals(player,computer);
        break;
      }
      System.out.print("Get another card? (y/n): ");
      hitMe =  myInput.nextLine();
      
      
      if(hitMe.equals("y")||hitMe.equals("Y"))
      {
        hits++;
        player.getNewCard(blackDeck);
        System.out.println("Your Card: " + player.getCard(hits-1) +"\n");
        if(player.getTotal()>=21)
        {
          compareTotals(player,computer);
          break;
        }  
        
        if(computer.getTotal()<16)
          computer.getNewCard(blackDeck);
      }
      else
      {
        compareTotals(player,computer);
        break;
      }
    } 
  }
  
  public static void compareTotals(BlackJackPlayer p1, BlackJackPlayer cpu)
  {
    String result = "Your Total: "+p1.getTotal()+" | Computer's Total: " + cpu.getTotal();
    System.out.println(result);
    System.out.println("Your Cards: " + p1 + "| Computer's Cards: " + cpu);
    if(p1.getTotal()>21)
    {
      System.out.println("You Busted!");
    }    
    else if(p1.getTotal()==cpu.getTotal())
    {
      System.out.println("You Tied!")  ;
    }
    else if(p1.getTotal()<21)
    {
      if(p1.getTotal()>cpu.getTotal() || cpu.getTotal()>21)
      {
        System.out.println("You Win!");
      }  
      else
      {
        System.out.println("You Lose!");
      }  
    }
    else if(p1.getTotal()==21)
    {
      System.out.println("You Win!");
    } 
  }  
}