import static org.junit.Assert.*;

import java.util.Arrays;

import javax.swing.JLabel;

import org.junit.Test;

public class TestPhase3
{
   static int NUM_CARDS_PER_HAND = 7;
   static int NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
   static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

   @Test
   public void test()
   {
      int numPacksPerDeck = 1;
      int numJokersPerPack = 0;
      int numUnusedCardsPerPack = 0;
     
      Card[] unusedCardsPerPack = null;
      
      CardGameFramework highCardGame = new CardGameFramework(numPacksPerDeck, numJokersPerPack, numUnusedCardsPerPack, unusedCardsPerPack, NUM_PLAYERS, NUM_CARDS_PER_HAND);
      
      highCardGame.deal();
   }

   /**
    * test
    */
   @Test
   public void sortCardTest()
   {
      Deck d = new Deck(1);
      d.getPack();
      d.shuffle();
      Card[] test = d.getPack();
      System.out.println(Arrays.toString(test));
      Card.arraySort(test, test.length);
      System.out.println(Arrays.toString(test));
      d.dealCard();
      d.dealCard();
      test = d.getPack();
      Card.arraySort(test, test.length);
      System.out.println(Arrays.toString(test));
   }

   @Test
   public void removeCardTest()
   {
      System.out.println("\nRemove Card Test");
      Deck d = new Deck(2);
      System.out.println(Arrays.toString(d.getPack()));
      d.removeCard(new Card('A', Card.Suit.S));
      System.out.println(Arrays.toString(d.getPack()));
      boolean exist = false;
      int cards = 0;
      for (int i = 0; i < d.getPack().length; i++)
      {
         if (d.getPack()[i] != null)
         {
            if (d.getPack()[i].equals(new Card('A', Card.Suit.S)))
            {
               exist = true;
            } else if (d.getPack()[i].getValue() == '2'){
               cards++;
            }
         }
      }
      assertEquals(false, exist);
      assertEquals(8, cards);

   }

   @Test
   public void dealCardTest()
   {
      System.out.println("DealCard test");
      Deck d = new Deck();
      System.out.println(Arrays.toString(d.getPack()));

      assertEquals(true, d.dealCard().equals(new Card('X', Card.Suit.S)));
   }
   
   @Test
   public void addCardTest(){
      Deck d = new Deck();
      assertEquals(false, d.addCard(new Card('A',Card.Suit.S)));
      d.removeCard(new Card('A',Card.Suit.D));
      assertEquals(true,d.addCard(new Card('A',Card.Suit.D)));
     
   }
   
}
