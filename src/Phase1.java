
import javax.swing.*;
import java.awt.*;


/**
 * @author BigMac
 *
 */
public class Phase1 
{
	   // static for the 57 icons and their corresponding labels
	   // normally we would not have a separate label for each card, but
	   // if we want to display all at once using labels, we need to.
	   
	   static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
	   static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
	      
	   static void loadCardIcons()
	   {
		   char[] suit = {'C', 'D', 'H', 'S'};
		   char[] value = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T',
                      'J', 'Q', 'K', 'X'};
		   int counter = 0;
		   		   
		   for (int i = 0; i < suit.length; i++)
		   {			   
			   for (int j = 0; j < value.length; j++)
			   {
				   icon[counter] = new ImageIcon (turnIntIntoCardValue(value, j) +
						   						  turnIntIntoCardSuit(suit, i));
				   counter++;
			   }
		   }		   
		   icon[counter] = new ImageIcon("images/BK.gif");			   
	   }
	   
	   // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
	   static String turnIntIntoCardValue(char[] value, int j)
	   {		   
	      return "images/" + String.valueOf(value[j]);
	   }
	   
	   // turns 0 - 3 into "C", "D", "H", "S"
	   static String turnIntIntoCardSuit(char[] suit, int i)
	   {
	      return String.valueOf(suit[i]) + ".gif";
	   }
	   
	   // a simple main to throw all the JLabels out there for the world to see
	   public static void main(String[] args)
	   {
	      int k;
	      
	      // prepare the image icon array
	      loadCardIcons();
	      CardTable table = new CardTable();
	      
	      // establish main frame in which program will run
	      JFrame frmMyWindow = new JFrame("Card Room");
	      frmMyWindow.setSize(1150, 650);
	      frmMyWindow.setLocationRelativeTo(null);
	      frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      // set up layout which will control placement of buttons, etc.
	      FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
	      frmMyWindow.setLayout(layout);
	      
	      
	     // prepare the image label array
	      JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
	      for (k = 0; k < NUM_CARD_IMAGES; k++)
	         labels[k] = new JLabel(icon[k]);
	      
	      // place your 3 controls into frame
	      for (k = 0; k < NUM_CARD_IMAGES; k++)
	         frmMyWindow.add(labels[k]);

	      // show everything to the user

	      frmMyWindow.setVisible(true);
	   }

}
