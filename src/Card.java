/**
 * The Card class is responsible for holding data and methods related to the
 * individual cards. It contains instance variables for the value and suit. It
 * also contains an error flag for invalid cards.
 * 
 * @author Keith
 *
 */
class Card
{
   private char value;
   private Suit suit;
   private boolean errorFlag;

   /**
    * The suit enum is used to track the possible suits of the standard deck of
    * cards
    * 
    */
   public static enum Suit
   {
      CLUBS, DIAMONDS, HEARTS, SPADES
   }

   public final static char[] cardNumber =
   { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };

   /**
    * The constructor calls the mutator to initialize the values. It takes two
    * parameters for the value and suit
    * 
    * @param value
    * @param suit
    */
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }

   /**
    * This is the default constructor meant to handle the creation of a card
    * without any parameters. The default card is an Ace of SPADES.
    */
   public Card()
   {
      set('A', Suit.SPADES);
   }

   /**
    * A mutator that accepts the legal values for card using the isValid()
    * method to check. If a bad value is passed the errorFlag is set to true.
    */
   public boolean set(char value, Suit suit)
   {
      if (isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         errorFlag = false;
         return true;
      } else
      {
         errorFlag = true;
         return false;
      }

   }

   /**
    * isValid checks if the cards value and suit are valid. Suit is unchecked at
    * this time.
    * 
    * @param value
    * @param suit
    * @return
    */
   private boolean isValid(char value, Suit suit)
   {
      for (int i = 0; i < cardNumber.length; i++)
      {
         if (cardNumber[i] == value)
         {
            return true;
         }
      }
      return false;
   }

   /**
    * Checks if a card is equal to this card
    * 
    * @param card
    * @return true of false.
    */
   boolean equals(Card card)
   {
      boolean same;
      if (this.suit == card.getSuit() && this.value == card.getValue())
      {
         same = true;
      } else
      {
         same = false;
      }
      return same;
   }

   /**
    * returns the String version of the card
    */
   public String toString()
   {
      if (errorFlag == false)
      {
         return value + " of " + suit;
      } else
      {
         return "ILLEGAL STATE";
      }
   }

   /**
    * Returns the value of the card
    * 
    * @return value
    */
   public char getValue()
   {
      return value;
   }

   /**
    * returns the suit of the cart
    * 
    * @return suit
    */
   public Suit getSuit()
   {
      return suit;
   }

   /**
    * Returns the error flag.
    * 
    * @return
    */
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
}
