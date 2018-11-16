/**
 * @(#)CardMatching.java
 *
 *
 * @author 
 * @version 1.00 2016/5/13
 */

import java.applet.Applet;
import java.awt.*;
import java.text.*;

public class CardMatching extends Applet{

  Deck gameDeck;
  Image [] cardImgs;
  MatchingGrid [] grid;
  Image backSide;
  int checking = 1;
  int cardsChosen;
  int thisCard = 0;
  int lastCard = 0;
  int tries;
  boolean started;
  DecimalFormat percent = new DecimalFormat("0.00%");
  Rectangle replay;
  Image table ;
  

  public void init()
  {
  	table =  getImage(getDocumentBase(),"Cards/table.jpg");
  	MatchingGrid.amtMatched = 0;
  	replay = new Rectangle(1150,100,135,50);
  	started = true;
    cardsChosen = 0;
    tries = 0;
    backSide =  getImage(getDocumentBase(),"Cards/BackCardRed.jpg");
    gameDeck = new Deck();
    gameDeck.shuffle();
    cardImgs = new Image[52];
    grid = new MatchingGrid[52];
    for(int i=0;i<52;i++)
    {  
      int xPos = (i%13)+1;
      int yPos = i/13;
      cardImgs[i] = getImage(getDocumentBase(),gameDeck.getNextCard().getLocation());
      grid[i] = new MatchingGrid(xPos*80,yPos*150,70,140);
    }
  }
    
  public void paint(Graphics g)
  {
  
  	
  	g.drawImage(table,0,0,1300,650,this);
  	
  	Expo.setFont(g,"Arial",Font.BOLD,20);
    if(MatchingGrid.amtMatched==50 && cardsChosen==2)
    {
      MatchingGrid.amtMatched+=2;
      tries++;
    }
    
    Expo.drawString(g,"Cards Matched: "+MatchingGrid.amtMatched + "/52" ,100,620);
    
    
    
    for(int i=0;i<52;i++)
    {
      int xPos = (i%13)+1;
      int yPos = i/13;
      if(grid[i].isMatched() == false)
      { 
	      if(!started)
	      {
	      	g.drawImage(backSide,xPos*80,yPos*150,70,140,this);
	      }
	      if(grid[i].isFlipped() || started )
	      { 
	        g.drawImage(cardImgs[i],xPos*80,yPos*150,70,140,this);
	      }
      }
      
    }
    
      
      
      Expo.setColor(g,Expo.red);
      Expo.drawString(g,"Click to Restart",1150,125);
      Expo.setColor(g,Expo.black);
      
      
    if(MatchingGrid.amtMatched==52)
    {
    	double score = ((52-tries)/26.0);
    	if(score<0){score=0;}
    	Expo.drawString(g,"YOU WIN",475,620);
      Expo.drawString(g,"Your Accuracy " + percent.format(score) ,1000,620);

    }
    
  }
    
  public boolean mouseDown(Event e, int x, int y)
  {  
  	
  	if(replay.inside(x,y))
  	{
  		init();
  		repaint();
  		return true; 
  	}
  	started = false;
    for(int i = 0; i<grid.length; i++)
    {                      
      if(grid[i].inside(x,y) && !grid[i].flipped)
      {
        if(cardsChosen == 0)
        {
          lastCard = i;
        }
        else if(cardsChosen == 1)
        {
          thisCard = i;
        }
        checking *=-1;
        grid[i].flip();
        if(grid[i].flipped){cardsChosen++;}
      } 
    }
    
    if(cardsChosen>2)
    {
    	tries++;
      cardsChosen=0;
      if(isMatched(lastCard,thisCard) )
      {
        grid[lastCard].matched = true;
        grid[thisCard].matched = true;
        MatchingGrid.amtMatched+=2;
      }
      for(int c=0;c<52;c++)
      {
        if(!grid[c].isMatched() &&  grid[c].isFlipped() )
        {  
          Expo.delay(100);
          grid[c].flip();
        }  
      }
    }
    
    for(int i = 0; i<grid.length; i++)
    {                      
      if(grid[i].inside(x,y) && !grid[i].flipped)
      {
        if(cardsChosen == 0)
        {
          lastCard = i;
        }
        else if(cardsChosen == 1)
        {
          thisCard = i;
        }
        checking *=-1;
        grid[i].flip();
        if(grid[i].flipped){cardsChosen++;}
      } 
    }
    
    repaint();
    return true;  
  }
    
  public boolean isMatched(int f, int s)
  {
    if(gameDeck.deck[f].getRank() == gameDeck.deck[s].getRank())
      return true;
    else
    return false;
  }
    
    
}