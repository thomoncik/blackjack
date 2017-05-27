package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class DeckProvider extends Deck{
    public int DECK_SIZE = Card.Rank.values().length * Card.Suit.values().length;
    private Card[] cards;
    public Player me;
    private int nextCard;

    public DeckProvider(String s){
        nextCard = 0;

        if(s.equals("insurance")) {
            DECK_SIZE = 4;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(suit,Card.Rank.FOUR);
            cards[1] = new Card(suit,Card.Rank.ACE);
            cards[2] = new Card(suit,Card.Rank.QUEEN);
            cards[3] = new Card(suit,Card.Rank.NINE);
        }else if(s.equals("falseInsurance")){
            DECK_SIZE = 4;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(suit,Card.Rank.FOUR);
            cards[1] = new Card(suit,Card.Rank.QUEEN);
            cards[2] = new Card(suit,Card.Rank.ACE);
            cards[3] = new Card(suit,Card.Rank.NINE);
        }else if(s.equals("doubleDown")){
            DECK_SIZE = 5;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(suit,Card.Rank.FOUR);
            cards[1] = new Card(suit,Card.Rank.QUEEN);
            cards[2] = new Card(suit,Card.Rank.ACE);
            cards[3] = new Card(suit,Card.Rank.NINE);
            cards[4] = new Card(suit,Card.Rank.FOUR);
        }else if (s.equals("split")){
            DECK_SIZE = 5;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(suit,Card.Rank.JACK);
            cards[1] = new Card(suit,Card.Rank.QUEEN);
            cards[2] = new Card(suit,Card.Rank.ACE);
            cards[3] = new Card(suit,Card.Rank.KING);
            cards[4] = new Card(suit,Card.Rank.FOUR);
        }else if(s.equals("falseSplit")){
            DECK_SIZE = 5;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(suit,Card.Rank.FOUR);
            cards[1] = new Card(suit,Card.Rank.QUEEN);
            cards[2] = new Card(suit,Card.Rank.ACE);
            cards[3] = new Card(suit,Card.Rank.NINE);
            cards[4] = new Card(suit,Card.Rank.TWO);
        }else if(s.equals("falseAces")){
            DECK_SIZE = 5;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(Card.Suit.CLUBS,Card.Rank.ACE);
            cards[1] = new Card(suit,Card.Rank.QUEEN);
            cards[2] = new Card(Card.Suit.SPADES,Card.Rank.ACE);
            cards[3] = new Card(suit,Card.Rank.ACE);
            cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        }else if(s.equals("aces")){
            DECK_SIZE = 5;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(Card.Suit.CLUBS,Card.Rank.ACE);
            cards[1] = new Card(Card.Suit.SPADES,Card.Rank.ACE);
            cards[2] = new Card(suit,Card.Rank.QUEEN);
            cards[3] = new Card(suit,Card.Rank.ACE);
            cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
        }else if(s.equals("takeCard")){
            DECK_SIZE = 6;
            cards = new Card[DECK_SIZE];
            Card.Suit suit = Card.Suit.HEARTS;
            cards[0] = new Card(Card.Suit.CLUBS,Card.Rank.TWO);
            cards[1] = new Card(Card.Suit.SPADES,Card.Rank.ACE);
            cards[2] = new Card(suit,Card.Rank.TWO);
            cards[3] = new Card(Card.Suit.DIAMONDS,Card.Rank.TWO);
            cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
            cards[5] = new Card(Card.Suit.CLUBS,Card.Rank.ACE);
        }
    }

    @Override
    Card getNextCard() {
        return cards[nextCard++];
    }
}
