 import java.util.Arrays;
public class PokerHand
{
  public static String eval(Cards [] hand)
  {
    String evaluation="High Card";
    int [] ranks = new int[hand.length];
    int [] suits = new int[hand.length];
    if(hand.length>5){return "";}
    
    
    
    for(int i = 0;i<hand.length;i++)
    {
      ranks[i] = hand[i].getRank();
      suits[i] = hand[i].getSuit();
    }
    
    ///*
    if(matches(ranks)==1){evaluation = "Pair";}
    if(matches(ranks)==2){evaluation = "Two Pair";}
    if(matches(ranks)==3){evaluation = "Three of a Kind";}       
    if(matches(ranks)==6){evaluation = "Four of a Kind";} 
    if(matches(ranks)==4){evaluation = "Full House";}  
    if(straight(ranks)){evaluation = "Straight";}    
    if(flush(suits)){evaluation = "Flush";}  
    if(flush(suits) && straight(ranks)){evaluation = "Straight Flush";} 
    if(flush(suits) && royal(ranks)){evaluation = "Royal Flush";} 
    //*/
    //if(straight(test)){evaluation ="Straight";} 
    
    return evaluation;
  }
    
  private static boolean flush(int [] array)
  {
    boolean flush = true;
    for(int i = 0; i<array.length;i++)
    {
      if(array[0] != array[i]){flush=false;}
    }
    return flush;
  }
    
  private static int matches(int [] array)
  {
    int matches = 0;
    for(int i = 0;i<array.length;i++)
    {
      int cPos = array[i];
      for(int s = i+1;s<array.length;s++)
      {
        if(cPos==array[s]){matches++;}
        
      }
    }
    return matches;
  }
  
  private static boolean straight(int [] array)
  {
    boolean straight = true;
    int index = 0;
    
    Arrays.sort(array);
    
    if(array[4]==13 && array[0]==1)
    { 
      for(index = 1;index<array.length-1;index++)
      {
        if(array[index+1]-array[index]!=1){straight= false;}
        
      }
    }else
    {
      
      for(index = 0;index<array.length-1;index++)
      {
        if(array[index+1]-array[index]!=1){straight= false;}
        
      }
      
    }
    return straight;
  }
  
  private static boolean royal(int [] array)
  {
    boolean allRoyal = false;
    Arrays.sort(array);
    if(array[0]==1 && array[1]==10 && array[2]==11 && array[3]==12 && array[4]==13){allRoyal = true;}
    return allRoyal; 
  }
}