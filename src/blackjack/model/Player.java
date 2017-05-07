package blackjack.model;

/**
 * Created by Jan on 5/5/2017.
 */
public class Player {
    Hand hand;
    Hand splitHand;
    int bank;
    int bidInTheMoment;
    Deck deck;

    public Player() {
        hand = new Hand();
        deck = new Deck();
        splitHand = null;
        bank = 1000;
        bidInTheMoment = 0;
    }

    public boolean ifSplitted() {
        return splitHand != null;
    }

    public void hit() {
        hand.addCard( deck.getRandomCard() );
    }

    public void stand() {
        return;
    }

    public void double_down() {
        bidInTheMoment *= 2;
    }

    public void split() {
        return;
    }

    public void insurance() {

    }
}
