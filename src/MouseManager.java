import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseManager implements MouseListener
{
   public int index;
   private static Card humanLastMove;
   public static int turn = 0;
   public static int computerCardWins;
   public static int humanCardWins;
   public static Card computerLastMove;

   public MouseManager(int index)
   {
      this.index = index;
   }

   public int getIndex()
   {
      return index;
   }

   @Override
   public void mouseClicked(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      determineWinner();
      addWinnings();
      turn++;
      System.out.println(turn);
      if (turn >= Phase3.NUM_CARDS_PER_HAND)
      {
         if (computerCardWins > humanCardWins)
         {
            JOptionPane.showMessageDialog(Phase3.myCardTable, "GAME OVER\nYou lost");
         } else
         {
            JOptionPane.showMessageDialog(Phase3.myCardTable, "You WON");
         }

      }
      Phase3.myCardTable.repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {

   }

   /**
    * Determines the winner of a match
    */
   public void determineWinner()
   {
      Card a;
      Card b;
      if (computerLastMove == null)
      {
         b = playComputerCard();
      } else
      {
         b = computerLastMove;
         computerLastMove = null;
      }
      if (humanLastMove == null)
      {
         a = playHumanCard();
      } else
      {
         a = humanLastMove;
         humanLastMove = null;
      }

      if (a.compareTo(b) > 0)
      {
         Phase3.computerWinning[humanCardWins++] = a;
         Phase3.computerWinning[humanCardWins++] = b;
         JOptionPane.showMessageDialog(Phase3.myCardTable, "Nice!");
         resetHumanCard();
         resetComputerCard();

      } else if (a.compareTo(b) < 0)
      {
         Phase3.computerWinning[computerCardWins++] = a;
         Phase3.computerWinning[computerCardWins++] = b;
         JOptionPane.showMessageDialog(Phase3.myCardTable, "Bummer");
         if (turn < Phase3.NUM_CARDS_PER_HAND - 1)
         {
            computerLastMove = playComputerCard();
         }
         resetHumanCard();

      } else
      {
         JOptionPane.showMessageDialog(Phase3.myCardTable, "Tie!");
      }
   }

   public Card playHumanCard()
   {
      // System.out.println(index);
      if (index < Phase3.humanLabels.length)
      {
         Phase3.playedCardLabels[0].setIcon(Phase3.humanLabels[index].getIcon());
         Phase3.myCardTable.pnlHumanHand.remove(Phase3.humanLabels[index]);
         return Phase3.highCardGame.getHand(0).inspectCard(index);
      } else
      {
         return null;
      }
   }

   /**
    * resets the computer card on the table
    */
   private void resetComputerCard()
   {
      Phase3.playedCardLabels[1].setIcon(GUICard.getBackCardIcon());

   }

   public void resetHumanCard()
   {
      Phase3.playedCardLabels[0].setIcon(GUICard.getBackCardIcon());
   }

   public Card playComputerCard()
   {
      if (index < Phase3.humanLabels.length)
      {
         Random gen = new Random();
         int rand = gen.nextInt(Phase3.NUM_CARDS_PER_HAND);
         if (index < Phase3.humanLabels.length)

            while (Phase3.computerLabels[rand] == null)
            {
               rand = gen.nextInt(Phase3.NUM_CARDS_PER_HAND);
            }

         Phase3.myCardTable.pnlComputerHand.remove(Phase3.computerLabels[rand]);
         Phase3.computerLabels[rand] = null;
         Phase3.playedCardLabels[1].setIcon(GUICard.getIcon(Phase3.highCardGame.getHand(1).inspectCard(rand)));
         return Phase3.highCardGame.getHand(1).inspectCard(rand);
      } else
      {
         return null;
      }
   }

   /**
    * add point to players' panels and stacks winning cards.
    */
   public static void addWinnings()
   {
      Phase3.results[0].setText(humanCardWins + " cards won");
      Phase3.results[1].setText(computerCardWins + " cards won");

      for (int i = 0; i < humanCardWins; i += 2)
      {
         JLabel top = new JLabel();

         top.setBackground(Color.white);
         top.setIcon(GUICard.getBackCardIcon());
         top.setBounds(i, 0, GUICard.getBackCardIcon().getIconWidth(), GUICard.getBackCardIcon().getIconHeight());

         // Place the buttons in different layers
         Phase3.winningStack[0].add(top, new Integer(i));
      }
      for (int i = 0; i < computerCardWins; i += 2)
      {
         JLabel top = new JLabel();

         top.setBackground(Color.white);
         Icon back = GUICard.getBackCardIcon();
         top.setIcon(back);
         top.setBounds(Phase3.winningStack[1].getWidth() - back.getIconWidth()
            - i, 0, GUICard.getBackCardIcon().getIconWidth(), GUICard.getBackCardIcon().getIconHeight());

         // Place the buttons in different layers
         Phase3.winningStack[1].add(top, new Integer(i));
      }
   }

}
