/**
 * @(#)MatchingGrid.java
 *
 *
 * @author 
 * @version 1.00 2016/5/17
 */

import java.awt.*;

public class MatchingGrid extends Rectangle {

	public boolean flipped;
	public boolean matched;
	public static int amtMatched = 0;
	public static int amtFlipped = 0;
	
    public MatchingGrid(int x,int y,int w,int h) 
    {
    	super(x,y,w,h);
    	
    }
    
    public void flip()
    {
    	if(flipped == false ){flipped = true; amtFlipped++;}
    	else if(flipped == true ){flipped = false; amtFlipped++;}
    	
    }
    
    public boolean isMatched(){	return matched;}
    public boolean isFlipped(){	return flipped;}
    
    public void matchCard()
    {
    	matched = true;
    	amtMatched++;
    } 
    
    
}