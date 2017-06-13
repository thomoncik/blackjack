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
    private boolean insured;
    private boolean busted;

    public Player(Deck d) {
        hand = new Hand();
        deck = d;
        hit();
        splitHand = null;
        bank = 1000;
        bet = 0;
        splitBet = 0;
        insuranceBet = 0;
        busted = false;
    }

    public Hand getHand(){
        return hand;
    }

    void setDealer(Dealer d){
        dealer = d;
    }

    public void setBet(int i){
        bet += i;
        bank -= i;
    }

    public boolean isSplitted() {
        return splitHand != null;
    }

    public boolean canSplit() {
        if (hand.cardsOnHand.size() != 2) {
            return false;
        } else if (!hand.cardsOnHand.get(0).getValue()[0].equals(hand.cardsOnHand.get(1).getValue()[0])) {
            return false;
        } else if(bet > bank) {
            return false;
        }else if(isSplitted()) {
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

    public boolean canBuyInsurance() {
        if(insured)
            return false;

        if (bet / 2 > bank) {
            return false;
        }

        return dealer.gotAceOnFace();
    }

    public void hit() {
        hand.addCard(deck.getNextCard());

        if(hand.getHandsValue() > 21) {
            stand();
        }
    }

    public void stand() {
        if(hand.getHandsValue()<=21)
            dealerTurn();
        else
            busted = true;
    }

    public void doubleDown() {
        bet *= 2;
        bank -= bet;
        hit();
    }

    public void split() {
        splitHand = new Hand();
        splitHand.addCard(hand.cardsOnHand.get(1));
        hand.cardsOnHand.remove(1);
        splitBet += bet;
        bank -= bet;
    }

    public void insurance() {
        insuranceBet = bet / 2;
        insured = true;
    }

    public void dealerTurn(){
        while(dealer.canTakeCard()){
            dealer.hit();
        }
    }

    void clearMyHand(){
        hand.clear();
        bet = 0;
        splitBet = 0;
        insuranceBet = 0;
        insured = false;
    }

    void begin(){
        hit();
        dealer.begin();
    }

    private void actualizeBank() {
        if (!busted) {
            if (dealer.busted()) {
                bank += 2 * (bet + splitBet);
            } else if (!isSplitted()) {
                if (dealer.myValue() < myValue()) {
                    bank += 2 * bet;
                } else if (dealer.myValue() == myValue()) {
                    bank += bet;
                }
            } else {
                if (dealer.myValue() < myValue()) {
                    bank += 2 * bet;
                } else if (dealer.myValue() == myValue()) {
                    bank += bet;
                }

                if (dealer.myValue() < splitHand.getHandsValue()) {
                    bank += 2 * splitBet;
                } else if (dealer.myValue() == splitHand.getHandsValue()) {
                    bank += splitBet;
                }
            }
        }

        if (insured && dealer.gotBlackjack()) {
            bank += 2*insuranceBet;
        }
    }

    void ending() {
        actualizeBank();

        dealer.clearMyHand();
        clearMyHand();
    }

    //void for testing
    public int myBank(){
        return bank;
    }

    public int myValue(){
        return hand.getHandsValue();
    }

}