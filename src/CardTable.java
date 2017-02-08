/**
 * 
 */

import javax.swing.*;

import java.awt.*;

/**
 * @author BigMac
 *
 */
public class CardTable extends JFrame
{
   static int MAX_CARDS_PER_HAND = 56;
   static int MAX_PLAYERS = 2; // for now, we only allow 2 person games

   private int numCardsPerHand;
   private int numPlayers;

   public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;

   // public JLabel lblConsole;

   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      super(title);

      JPanel mainPanel = new JPanel();
      pnlComputerHand = new JPanel();
      pnlHumanHand = new JPanel();
      pnlPlayArea = new JPanel();

      mainPanel.setLayout(new GridLayout(3, 1));
      mainPanel.add(pnlComputerHand);
      mainPanel.add(pnlPlayArea);
      mainPanel.add(pnlHumanHand);

      add(mainPanel, BorderLayout.CENTER);

      pnlComputerHand.setBorder(BorderFactory.createTitledBorder("Computer Hand"));
      pnlHumanHand.setBorder(BorderFactory.createTitledBorder("Your Hand"));
      pnlPlayArea.setBorder(BorderFactory.createTitledBorder("Playing Area"));
      pnlPlayArea.setLayout(new GridLayout(2, 4));
   }

   public int getNumCardsPerHand()
   {
      return numCardsPerHand;
   }

   public int getNumPlayers()
   {
      return numPlayers;
   }

}
