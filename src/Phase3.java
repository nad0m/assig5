import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class Phase3
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] results = new JLabel[NUM_PLAYERS];
   static CardTable myCardTable;
   static CardGameFramework highCardGame;
   static Card[] computerWinning = new Card[NUM_CARDS_PER_HAND*NUM_PLAYERS];
   static Card[] humanWinning = new Card[NUM_CARDS_PER_HAND*NUM_PLAYERS];
   static  JLayeredPane[] winningStack = new JLayeredPane[NUM_PLAYERS];
   public static void main(String[] args)
   {
      int numPacksPerDeck = 1;
      int numJokersPerPack = 0;
      int numUnusedCardsPerPack = 0;
      Card [] unusedCardsPerPack = null;

     highCardGame = new CardGameFramework( 
            numPacksPerDeck, numJokersPerPack,  
            numUnusedCardsPerPack, unusedCardsPerPack, 
            NUM_PLAYERS, NUM_CARDS_PER_HAND);
      highCardGame.deal();

       // establish main frame in which program will run
       myCardTable = new CardTable("Card Game", NUM_CARDS_PER_HAND, NUM_PLAYERS);
       myCardTable.setSize(900, 600);
       myCardTable.setLocationRelativeTo(null);
       myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
         
       // show everything to the user
       myCardTable.setVisible(true);

       // CREATE LABELS ----------------------------------------------------
       GUICard.loadCardIcons();
         
       for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
       {

         computerLabels[i] = new JLabel(GUICard.getBackCardIcon());
         humanLabels[i] = new JLabel (GUICard.getIcon(highCardGame.getHand(0).inspectCard(i)));
         humanLabels[i].addMouseListener(new MouseManager(i));
       }
       playedCardLabels[0] = new JLabel (GUICard.getBackCardIcon());
       playedCardLabels[1] = new JLabel (GUICard.getBackCardIcon());
       // ADD LABELS TO PANELS -----------------------------------------
       for (int i = 0; i < NUM_CARDS_PER_HAND; i++)
       {
         myCardTable.pnlComputerHand.add(computerLabels[i]);
         myCardTable.pnlHumanHand.add(humanLabels[i]);
        
  
       }
       for(int i = 0; i<NUM_PLAYERS; i++){
          winningStack[i] = new JLayeredPane();
       }
       // Create 3 buttons
       
       
       
       //TODO add to playlabel text array
 
       playLabelText[0] =  new JLabel( "You", JLabel.CENTER );
       playLabelText[1] =  new JLabel( "Computer", JLabel.CENTER );
       results[0] = new JLabel( "", JLabel.CENTER );
       results[1] = new JLabel( "", JLabel.CENTER );
       
       myCardTable.pnlPlayArea.add(winningStack[0]);
       myCardTable.pnlPlayArea.add(playedCardLabels[0]);
       myCardTable.pnlPlayArea.add(playedCardLabels[1]);
       myCardTable.pnlPlayArea.add(winningStack[1]);
       myCardTable.pnlPlayArea.add(results[0]);
       myCardTable.pnlPlayArea.add(playLabelText[0]);
       myCardTable.pnlPlayArea.add(playLabelText[1]);
       myCardTable.pnlPlayArea.add(results[1]);
       
       
       myCardTable.pack();
    
       
       
       
       // show everything to the user
       myCardTable.setVisible(true);
    }


    
   


      
}
