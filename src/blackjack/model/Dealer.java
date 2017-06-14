package blackjack.model;

/**
 * Created by Jan on 5/7/2017.
 */
public class Dealer {
    private Hand hand;
    private Deck deck;

    Dealer(Deck d) {
        hand = new Hand();
        deck = d;
    }

    public boolean canTakeCard() {
        if (hand.getValue() <= 16) {
            return true;
        } else {
            return false;
        }
    }

    public boolean gotBlackjack() {
        if (hand.getValue() == 21 && hand.cardsOnHand.size() == 2) {
            return true;
        } else {
            return false;
        }
    }

    public void hit() {
        hand.addCard(deck.getNextCard());
    }

    boolean gotAceOnFace() {
        return hand.cardsOnHand.get(0).getRank() == Card.Rank.ACE;
    }

    boolean busted() {
        return hand.getValue() > 21;
    }

    void clearHand() {
        hand.clear();
    }

    public void begin() {
        hit();
        hit();
    }

    public Hand getHand() {
        return hand;
    }


    public int getValue() {
        return hand.getValue();
    }
}