package blackjack.model;

/**
 * Created by Jan on 5/5/2017.
 */
public class Player {
    private Hand hand;
    private Hand splitHand;
    private int bank;
    private int bet;
    private int splitBet;
    private int insuranceBet;
    private Deck deck;
    private Dealer dealer;

    public Player() {
        hand = new Hand();
        deck = new Deck();
        splitHand = null;
        bank = 1000;
        bet = 0;
        splitBet = 0;
        insuranceBet = 0;
        dealer = new Dealer(deck);
    }

    public boolean isSplitted() {
        return splitHand != null;
    }

    public boolean canSplit() {
        if (hand.cardsOnHand.size() != 2) {
            return false;
        } else if (!hand.cardsOnHand.get(0).equals(hand.cardsOnHand.get(1))) {
            return false;
        } else if(bet > bank) {
            return false;
        }

        return true;
    }

    public boolean canDoubleDown() {
        if (bet > bank) {
            return false;
        } else if (hand.cardsOnHand.size() != 2) {
            return false;
        }

        return true;
    }

    public boolean ifCanInsurance() {
        if (bet / 2 > bank) {
            return false;
        }

        return dealer.gotAceOnFace();
    }

    public void hit() {
        if(hand.getHandsValue() > 21)
            stand();

        hand.addCard(deck.getNextCard());
    }

    public void stand() {
    }

    public void doubleDown() {
        bet *= 2;
        bank -= bet;
        hand.addCard(deck.getRandomCard());
    }

    public void split() {
        splitHand = new Hand();
        splitHand.addCard(hand.cardsOnHand.get(1));
        hand.cardsOnHand.remove(1);
        splitBet += bet;
        bank -= bet;
    }

    public void insurance() {
        bank -= bet / 2;
        insuranceBet = bet / 2;
    }

    public void dealerTurn(){
        while(dealer.canTakeCard()){
               dealer.hit();
        }
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

    //testing
    public static void main(String[] args){
        Player me = new Player();
        me.hit();
        me.hit();
        me.dealerTurn();
        System.out.println("MY CARDS");
        me.myCards();
        System.out.println("MY CARDS VALUE : " + me.myValue());
        System.out.println("DEALER CARDS");
        me.dealer.myCards();
        System.out.println("DEALER CARDS VALUE : " + me.dealer.myValue());
    }
}
