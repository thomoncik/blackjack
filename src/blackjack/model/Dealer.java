package blackjack.model;

/**
 * Created by Jan on 5/7/2017.
 */
class Dealer {
    // @TODO: hand is not assigned nowhere
    private Hand hand;

    public boolean canTakeCard() {
        if (hand.getHandsValue() <= 16) {
            return true;
        } else {
            return false;
        }
    }

    public boolean gotBlackjack() {
        if (hand.getHandsValue() == 21) {
            return true;
        } else {
            return false;
        }
    }

    boolean gotAceOnFace() {
        return hand.cardsOnHand.get(0).getRank() == Card.Rank.ACE;
    }
}
