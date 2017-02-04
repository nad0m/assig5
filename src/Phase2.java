/**
 * @author BigMac
 *
 */	

import java.awt.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

	
class Phase2 
{
	static int NUM_CARDS_PER_HAND = 7;
	static int  NUM_PLAYERS = 2;
	static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
	static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
	static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
	static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
	   
	public static void main(String[] args)
	{
		int k;
	    Icon tempIcon;
	      
	    // establish main frame in which program will run
	    CardTable myCardTable = new CardTable("Card Game", NUM_CARDS_PER_HAND, NUM_PLAYERS);
	    myCardTable.setSize(800, 600);
	    myCardTable.setLocationRelativeTo(null);
	    myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      
	    // show everything to the user
	    myCardTable.setVisible(true);

	    // CREATE LABELS ----------------------------------------------------
	    GUICard.loadCardIcons();
	      
	    for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
	    {
	    	computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
	    	humanLabels[i] = new JLabel (GUICard.getIcon(generateRandomCard()));	    	
	    }
	  
	    // ADD LABELS TO PANELS -----------------------------------------
	    for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
	    {
	    	myCardTable.pnlComputerHand.add(computerLabels[i]);
	    	myCardTable.pnlHumanHand.add(humanLabels[i]);
	    	
	    	if (i < 2)
	    	{
	    		playedCardLabels[i] = new JLabel (GUICard.getIcon(generateRandomCard()));
	    		myCardTable.pnlPlayArea.add(playedCardLabels[i]);
	    	}
	    }
	      
	    
	    
	    
	    // show everything to the user
	    myCardTable.setVisible(true);
	 }
	   
	 static Card generateRandomCard()
	 {
		 return new Card(getRandomValue(), getRandomSuit());
	 }
	   
	 private static Card.Suit getRandomSuit()
	 {
		 Random randNum = new Random();	   
		 return Card.Suit.values()[randNum.nextInt(Card.Suit.values().length)];
	 }
	   
	 private static char getRandomValue()
	 {
		 Random randNum = new Random();
		 return Card.cardNumber[randNum.nextInt(Card.cardNumber.length)];
	 }
	   
}
