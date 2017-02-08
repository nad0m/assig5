import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCardCheck
{

   @Test
   public void shuffleTest()
   {
      Deck d = new Deck(1);
      System.out.println(Arrays.toString(d.getPack()));
      Card[] old = d.getPack().clone();
      d.shuffle();
      System.out.println(Arrays.toString(d.getPack()));
      for (int j = 0; j < old.length; j++)
      {
         assertEquals(Arrays.asList(d.getPack()).contains(old[j]), true);
         assertEquals(false, d.getPack()[j].equals(old[j]));
      }
   }

   @Test
   public void testEqual()
   {
      Card c = new Card('A', Card.Suit.S);
      Card b = new Card('T', Card.Suit.H);
      Card a = new Card();
      assertEquals(false, c.equals(b));
      assertEquals(true, a.equals(c));
   }

   @Test
   public void errorFlagTest()
   {
      Card a = new Card('B', Card.Suit.C);
      assertEquals("ILLEGAL STATE", a.toString());

   }

   @Test
   public void initCardTest()
   {
      Deck d = new Deck(1);
      assertEquals((52 + 4) * 1, d.getPack().length);
      Deck c = new Deck();
      assertEquals(56, c.getPack().length);
      // assertEquals(false, c.emptyMasterPack); //private variable
      // assertEquals(1, c.calls);
   }
}
