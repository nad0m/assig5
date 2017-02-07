import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Phase3 implements MouseMotionListener
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
      
   public static void main(String[] args)
   {
      int numPacksPerDeck = 1;
      int numJokersPerPack = 0;
      int numUnusedCardsPerPack = 0;
      Card [] unusedCardsPerPack = null;

      CardGameFramework highCardGame = new CardGameFramework( 
            numPacksPerDeck, numJokersPerPack,  
            numUnusedCardsPerPack, unusedCardsPerPack, 
            NUM_PLAYERS, NUM_CARDS_PER_HAND);
      highCardGame.deal();

       // establish main frame in which program will run
       CardTable myCardTable = new CardTable("Card Game", NUM_CARDS_PER_HAND, NUM_PLAYERS);
       myCardTable.setSize(900, 600);
       myCardTable.setLocationRelativeTo(null);
       myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Phase3 p = new Phase3();
       myCardTable.addMouseMotionListener(p);
         
       // show everything to the user
       myCardTable.setVisible(true);

       // CREATE LABELS ----------------------------------------------------
       GUICard.loadCardIcons();
         
       for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
       {
         computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
         humanLabels[i] = new JLabel (GUICard.getIcon(highCardGame.getHand(0).inspectCard(i)));       
       }
     
       // ADD LABELS TO PANELS -----------------------------------------
       for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
       {
         myCardTable.pnlComputerHand.add(computerLabels[i]);
         myCardTable.pnlHumanHand.add(humanLabels[i]);
         humanLabels[i].addMouseMotionListener(p);
  
       }
       JLabel playerCardLabel;
       JLabel computerCardLabel;
       
       playedCardLabels[0] = new JLabel (GUICard.getIcon(highCardGame.getHand(0).inspectCard(1)));
       playedCardLabels[1] = new JLabel (GUICard.getIcon(highCardGame.getHand(1).inspectCard(1)));
          
       playerCardLabel = new JLabel( "You", JLabel.CENTER );
    
       computerCardLabel = new JLabel( "Computer", JLabel.CENTER );
       
       
       myCardTable.pnlPlayArea.add(playedCardLabels[0]);
       myCardTable.pnlPlayArea.add(playedCardLabels[1]);
      
       myCardTable.pnlPlayArea.add(playerCardLabel);
       myCardTable.pnlPlayArea.add(computerCardLabel);
       myCardTable.pack();
    
       
       
       
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

   @Override
   public void mouseDragged(MouseEvent e)
   {
      JLabel j = (JLabel)e.getSource();
      Icon i =j.getIcon();
      i.paintIcon(e.getComponent(), j.getParent().getGraphics(), e.getX(), e.getY());
      j.getParent().getParent().repaint();
      // TODO Auto-generated method stub
      System.out.println("test");
   }

   @Override
   public void mouseMoved(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }
      
}
