import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


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
      System.out.println(index);
      Phase3.playedCardLabels[0].setIcon(Phase3.humanLabels[index].getIcon());
      Phase3.myCardTable.pnlHumanHand.remove(Phase3.humanLabels[index]);
      Phase3.myCardTable.repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub

   }

}
