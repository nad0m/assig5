/**
 * @author BigMac
 *
 */	

	import java.awt.*;
	import javax.swing.*;
	import javax.swing.border.*;

	
public class Phase2 
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
	      CardTable myCardTable = new CardTable();
	      myCardTable.setSize(800, 600);
	      myCardTable.setLocationRelativeTo(null);
	      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      myCardTable.pnlComputerHand.setBorder(BorderFactory.createTitledBorder("Computer Hand"));
	      myCardTable.pnlHumanHand.setBorder(BorderFactory.createTitledBorder("Your Hand"));
	      myCardTable.pnlPlayArea.setBorder(BorderFactory.createTitledBorder("Playing Area"));
	      myCardTable.pnlPlayArea.setLayout(new GridLayout(2, 2));

	      // show everything to the user
	      myCardTable.setVisible(true);

	      // CREATE LABELS ----------------------------------------------------

	  
	      // ADD LABELS TO PANELS -----------------------------------------

	      
	      // and two random cards in the play region (simulating a computer/hum ply)


	      // show everything to the user
	      //myCardTable.setVisible(true);
	   }
}
