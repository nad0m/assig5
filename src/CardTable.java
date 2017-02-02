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
	static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
	   
	private int numCardsPerHand;
	private int numPlayers;
	
	public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
	
	CardTable()
	{	
	      super();
	      setSize(1150, 650);
	      setLocationRelativeTo(null);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      JPanel mainPanel = new JPanel();
	      pnlComputerHand = new JPanel();
	      pnlHumanHand = new JPanel();
	      pnlPlayArea = new JPanel();
	      mainPanel.setLayout(new GridLayout(3, 1));
	      mainPanel.add(pnlComputerHand);
	      mainPanel.add(pnlPlayArea);
	      mainPanel.add(pnlHumanHand);
	      add(mainPanel, BorderLayout.CENTER);
	}
	
	
}
