import static org.junit.Assert.*;

import java.util.Arrays;

import javax.swing.JLabel;

import org.junit.Test;


public class TestPhase3 {
	static int NUM_CARDS_PER_HAND = 7;
	static int  NUM_PLAYERS = 2;
	static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
	static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
	static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
	static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
	   
	@Test
	public void test() {
	      int numPacksPerDeck = 1;
	      int numJokersPerPack = 0;
	      int numUnusedCardsPerPack = 0;
	      Card [] unusedCardsPerPack = null;
	      CardGameFramework highCardGame = new CardGameFramework( 
	            numPacksPerDeck, numJokersPerPack,  
	            numUnusedCardsPerPack, unusedCardsPerPack, 
	            NUM_PLAYERS, NUM_CARDS_PER_HAND);
	}
	
	
	@Test
	public void sortCardTest(){
	   Deck d = new Deck(1);
	   d.getPack();
	   d.shuffle();
	   Card[] test = d.getPack();
	   System.out.println(Arrays.toString(test));
	   Card.arraySort(test, test.length);
	     System.out.println(Arrays.toString(test));

	
	}

}
