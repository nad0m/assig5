import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MouseManager implements MouseListener
{
   public int index;
   public static int turn = 0;
   public static int computerCardWins;
   public static int humanCardWins;
   
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
     Phase3.myCardTable.repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }
   public void determineWinner(){
      Card a = playHumanCard();
      Card b = playComputerCard();
      if(a.compareTo(b)>0){
         Phase3.computerWinning[humanCardWins++] = a;
         Phase3.computerWinning[humanCardWins++] = b;
      } else if( a.compareTo(b)<0){
      Phase3.computerWinning[computerCardWins++] = a;
      Phase3.computerWinning[computerCardWins++] = b;
      JOptionPane.showMessageDialog(Phase3.myCardTable, "You lost");
      }else{
         JOptionPane.showMessageDialog(Phase3.myCardTable, "Tie!");
      }
   }
   
   public Card playHumanCard(){
     // System.out.println(index);
      Phase3.playedCardLabels[0].setIcon(Phase3.humanLabels[index].getIcon());
      Phase3.myCardTable.pnlHumanHand.remove(Phase3.humanLabels[index]);
      return Phase3.highCardGame.getHand(0).inspectCard(index);
      
   }
   
   public Card playComputerCard(){
      Random gen = new Random();
      int rand = gen.nextInt(Phase3.NUM_CARDS_PER_HAND);
      while(Phase3.computerLabels[rand] == null){
        rand = gen.nextInt(Phase3.NUM_CARDS_PER_HAND);
      }
      
      Phase3.myCardTable.pnlComputerHand.remove(Phase3.computerLabels[rand]);
      Phase3.computerLabels[rand] = null;
      Phase3.playedCardLabels[1].setIcon(GUICard.getIcon(Phase3.highCardGame.getHand(1).inspectCard(rand)));
      return Phase3.highCardGame.getHand(1).inspectCard(rand);
    
   
   }
   
   public static void addWinnings(){
      for (int i = 0; i < humanCardWins; i+=2)
      {
          JLabel top = new JLabel();
         
       top.setBackground(Color.white);
       top.setIcon(GUICard.getBackCardIcon());
       top.setBounds( i, 0, GUICard.getBackCardIcon().getIconWidth(), GUICard.getBackCardIcon().getIconHeight());

       // Place the buttons in different layers
       Phase3.winningStack[0].add(top, new Integer(i));
      }
      for (int i = 0; i < computerCardWins; i+=2)
      {
          JLabel top = new JLabel();
         
       top.setBackground(Color.white);
       Icon back = GUICard.getBackCardIcon();
       top.setIcon(back);
       top.setBounds(Phase3.winningStack[1].getWidth()-back.getIconWidth()-i, 0, GUICard.getBackCardIcon().getIconWidth(), GUICard.getBackCardIcon().getIconHeight());

       // Place the buttons in different layers
       Phase3.winningStack[1].add(top, new Integer(i));
      }
   }

}
