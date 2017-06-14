package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class DeckProvider extends Deck {
    public DeckProvider(String s) {
        nextCard = 0;

        cards = new Card[DECK_SIZE];

        switch (s) {
            case "blackjack": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.ACE);
                cards[1] = new Card(suit, Card.Rank.JACK);

                cards[2] = new Card(suit, Card.Rank.QUEEN);
                cards[3] = new Card(suit, Card.Rank.NINE);
                break;
            }
            case "insurance": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
                cards[1] = new Card(suit, Card.Rank.ACE);

                cards[2] = new Card(suit, Card.Rank.QUEEN);
                cards[3] = new Card(suit, Card.Rank.NINE);
                break;
            }
            case "falseInsurance": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.FOUR);
                cards[1] = new Card(suit, Card.Rank.QUEEN);

                cards[2] = new Card(suit, Card.Rank.ACE);
                cards[3] = new Card(suit, Card.Rank.NINE);
                break;
            }
            case "doubleDown": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.FOUR);
                cards[1] = new Card(suit, Card.Rank.QUEEN);

                cards[2] = new Card(suit, Card.Rank.ACE);
                cards[3] = new Card(suit, Card.Rank.NINE);
                cards[4] = new Card(suit, Card.Rank.FOUR);
                break;
            }
            case "split": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.JACK);
                cards[1] = new Card(suit, Card.Rank.QUEEN);

                cards[2] = new Card(suit, Card.Rank.TEN);
                cards[3] = new Card(suit, Card.Rank.KING);
                cards[4] = new Card(suit, Card.Rank.FOUR);
                break;
            }
            case "falseSplit": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.FOUR);
                cards[1] = new Card(suit, Card.Rank.QUEEN);

                cards[2] = new Card(suit, Card.Rank.ACE);
                cards[3] = new Card(suit, Card.Rank.NINE);
                cards[4] = new Card(suit, Card.Rank.TWO);
                break;
            }
            case "falseAces": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(suit, Card.Rank.QUEEN);
                cards[1] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);

                cards[2] = new Card(Card.Suit.SPADES, Card.Rank.ACE);
                cards[3] = new Card(suit, Card.Rank.ACE);
                cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
                break;
            }
            case "aces": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
                cards[1] = new Card(Card.Suit.SPADES, Card.Rank.ACE);

                cards[2] = new Card(suit, Card.Rank.TWO);
                cards[3] = new Card(suit, Card.Rank.TEN);
                cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
                break;
            }
            case "takeCard": {
                Card.Suit suit = Card.Suit.HEARTS;
                cards[0] = new Card(Card.Suit.CLUBS, Card.Rank.TWO);
                cards[1] = new Card(Card.Suit.SPADES, Card.Rank.ACE);

                cards[2] = new Card(suit, Card.Rank.TWO);
                cards[3] = new Card(Card.Suit.DIAMONDS, Card.Rank.TWO);
                cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.ACE);
                cards[5] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
                break;
            }
            case "tworounds": {
                Card.Suit suit = Card.Suit.HEARTS;

                cards[0] = new Card(Card.Suit.SPADES, Card.Rank.ACE);
                cards[1] = new Card(Card.Suit.CLUBS, Card.Rank.JACK);

                cards[2] = new Card(suit, Card.Rank.QUEEN);

                // second round
                cards[3] = new Card(Card.Suit.DIAMONDS, Card.Rank.KING);
                cards[4] = new Card(Card.Suit.DIAMONDS, Card.Rank.THREE);

                cards[5] = new Card(Card.Suit.CLUBS, Card.Rank.ACE);
                cards[6] = new Card(suit, Card.Rank.NINE);

                cards[7] = new Card(suit, Card.Rank.FIVE);
                break;
            }
        }
    }

    @Override
    public Card getNextCard() {
        return cards[nextCard++];
    }
}
