package blackjack.model;

/**
 * Created by Jan on 5/7/2017.
 */
class Dealer {
    // @TODO: hand is not assigned nowhere
    private Hand hand;
    private Deck deck;

    Dealer(Deck d){
        hand = new Hand();
        deck = d;
        hand.addCard(d.getNextCard());
        hand.addCard(d.getNextCard());
    }

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

    public void hit() {
        hand.addCard(deck.getNextCard());
    }

    boolean gotAceOnFace() {
        return hand.cardsOnHand.get(0).getRank() == Card.Rank.ACE;
    }

    //void for testing
    public void myCards(){
        for(int i = 0; i < hand.cardsOnHand.size(); i++)
            System.out.println(hand.cardsOnHand.get(i));
    }

    //void for testing
    public int myValue(){
        return hand.getHandsValue();
    }
}
