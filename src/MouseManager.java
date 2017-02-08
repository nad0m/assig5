import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MouseManager implements MouseListener
{
   public int index;
 
   
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
     System.out.println(playHumanCard().compareTo(playComputerCard()));
     Phase3.myCardTable.repaint();
     //JLabel j = new JLabel();
     //j.setText("you lost");
     //Phase3.myCardTable.pnlHumanHand.remove(0);
     //Phase3.myCardTable.pnlHumanHand.add(j);
     //Phase3.myCardTable.pack();
     //JOptionPane.showMessageDialog(Phase3.myCardTable, "You lost");
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

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

}
