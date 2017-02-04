    import java.awt.*;
	import javax.swing.*;
	import javax.swing.border.*;

/**
 * 
 */

/**
 * @author BigMac
 *
 */
class GUICard 
{
	 private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
	 private static Icon iconBack;
	 static boolean iconsLoaded = false;
	 
	 GUICard()
	 {
		 if (iconsLoaded == false)
		 {
			 loadCardIcons();
		 }
	 }
	
	 static void loadCardIcons()
	 {		   		   
		 for (int i = 0; i < Card.cardNumber.length; i++)
		 {			   
			 for (int j = 0; j < Card.Suit.values().length; j++)
			 {
				 iconCards[i][j] = new ImageIcon (turnIntIntoCardValue(i) +
						   						  turnIntIntoCardSuit(j));
				 
				 System.out.println(iconCards[i][j]);

			 }
		 }		   
		 
		 iconBack = new ImageIcon("images/BK.gif");	
		 
		 iconsLoaded = true;
	 }
	
	 static String turnIntIntoCardValue(int i)
	 {		   
		 return "images/" + Card.cardNumber[i];
	 }
	 
	 static String turnIntIntoCardSuit(int j)
	 {		   
		 return Card.Suit.values()[j] + ".gif";
	 }
	   
	 static public Icon getBackCardIcon()
	 {
		 return (Icon) iconBack;
	 }

	 static public Icon getIcon(Card card)
	 {
		 return iconCards[valueAsInt(card)][suitAsInt(card)];
	 }
	 
	 private static int valueAsInt(Card card)
	 {
		 return new String(Card.cardNumber).indexOf(card.getValue());		 
	 }
	 
	 private static int suitAsInt(Card card)
	 {
		 return card.getSuit().ordinal();		 
	 }
	
}
