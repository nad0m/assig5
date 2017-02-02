
/**
 * 
 * @author Keith
 *
 */
class Deck
{

   private static final int NUMBER_OF_CARDS = 52;
   public static final int MAX_CARDS = 6 * NUMBER_OF_CARDS;
   private static Card[] masterPack = new Card[NUMBER_OF_CARDS];
   private static boolean emptyMasterPack = true;
   private Card[] cards;
   private int topCard;
   private int numPacks;

   /**
    * a constructor that populates the arrays and assigns initial values to
    * members.
    * 
    * @param numPacks
    */
   public Deck(int numPacks)
   {
      if (numPacks * NUMBER_OF_CARDS > MAX_CARDS)
      {
         this.numPacks = 1; // default pack is 1 if number of packs exceed
                            // MAX_CARDS
      }
      if (emptyMasterPack)
      {
         allocateMasterPack();
      }
      init(numPacks); // make a certain amount of decks using MasterPack as the
                      // model
   }

   /**
    * initializes the Deck to 1 pack by default
    */
   public Deck()
   {
      this.numPacks = 1; // if no parameters passed, 1 pack is assumed

      if (emptyMasterPack)
      {
         allocateMasterPack();
      }
      init(numPacks);
   }

   /**
    * initializes the cards array.
    * 
    * @param numPacks
    */
   public void init(int numPacks)
   {

      cards = new Card[numPacks * NUMBER_OF_CARDS];
      for (int i = 0; i < cards.length; i++)
      {
         cards[i] = masterPack[i % 52];
         topCard++;
      }

   }

   private static void allocateMasterPack()
   {
      Card.Suit suit;
      for (int i = 0; i < masterPack.length; i++)
      {
         if (i < 13)
         {
            suit = Card.Suit.CLUBS;
         } else if (i < 26)
            suit = Card.Suit.DIAMONDS;
         else if (i < 39)
         {
            suit = Card.Suit.HEARTS;
         } else
         {
            suit = Card.Suit.SPADES;
         }
         // change suit after every 13th card
         masterPack[i] = new Card(Card.cardNumber[i % 13], suit);
      }
      emptyMasterPack = false;
   }

   public Card[] getPack()
   {
      return cards;
   }

   public void shuffle()
   {
      Card temp;
      for (int i = cards.length - 1; i > 0; i--)
      {
         int rand = (int) (Math.random() * i);
         temp = cards[i];
         cards[i] = cards[rand];
         cards[rand] = temp;
      }

   }

   /**
    * 
    * @return
    */
   public Card dealCard()
   {
      if (topCard == 0)
      {
         return null;
      }

      Card theCard = new Card(cards[topCard - 1].getValue(),
         cards[topCard - 1].getSuit());
      cards[topCard - 1] = null;
      topCard--;

      return theCard;
   }

   public int getTopCard()
   {
      return topCard;
   }

}
