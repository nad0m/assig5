import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


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
     playHumanCard();
     playComputerCard();
     Phase3.myCardTable.repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }
   
   public void playHumanCard(){
      System.out.println(index);
      Phase3.playedCardLabels[0].setIcon(Phase3.humanLabels[index].getIcon());
      Phase3.myCardTable.pnlHumanHand.remove(Phase3.humanLabels[index]);
      
   }
   
   public void playComputerCard(){
      int rand = new Random().nextInt(Phase3.NUM_CARDS_PER_HAND);
      while(Phase3.computerLabels[rand] == null){
        rand = new Random().nextInt(Phase3.NUM_CARDS_PER_HAND);
      }
      
      Phase3.myCardTable.pnlComputerHand.remove(Phase3.computerLabels[rand]);
      Phase3.computerLabels[rand] = null;
      Phase3.playedCardLabels[1].setIcon(GUICard.getIcon(Phase3.highCardGame.getHand(1).inspectCard(rand)));
    
   
   }

}
