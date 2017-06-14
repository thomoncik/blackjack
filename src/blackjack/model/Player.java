package blackjack.model;

/**
 * Created by Jan on 5/5/2017.
 */
public class Player {
    private Hand hand;
    private Hand splitHand;
    private int bank;
    private int bet;
    private int insuranceBet;
    private Deck deck;
    private boolean insured;
    private boolean duringRound;

    public Player(Deck deck) {
        this.duringRound = true;
        this.insured = false;
        this.splitHand = null;

        this.hand = new Hand();
        this.deck = deck;

        hit();

        this.bank = 1000;
        this.bet = 0;
        this.insuranceBet = 0;
    }

    public Hand getHand() {
        return hand;
    }

    public int getBet() {
        return this.bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
//        this.bank -= bet;
    }

    public boolean isSplitted() {
        return splitHand != null;
    }

    public boolean canSplit() {
        if (this.hand.cardsOnHand.size() != 2) {
            return false;
        } else if (!hand.cardsOnHand.get(0).getValue()[0].equals(hand.cardsOnHand.get(1).getValue()[0])) {
            return false;
        } else if (bet > bank) {
            return false;
        } else if (isSplitted()) {
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

    public void hit() {
        hand.addCard(deck.getNextCard());

        if (hand.getValue() > 21) {
            duringRound = false;
        }
    }

    public void stand() {
        duringRound = false;
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
        bank -= bet;
        bet += bet;
    }

    public void insurance() {
        insuranceBet = bet / 2;
        insured = true;
    }

    void clearHand() {
        hand.clear();
        bet = 0;
        insuranceBet = 0;
        insured = false;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getValue() {
        return hand.getValue();
    }

    public boolean busted() {
        return this.hand.getValue() > 21;
    }

    public int getInsuranceBet() {
        return insuranceBet;
    }

    public void setInsuranceBet(int insuranceBet) {
        this.insuranceBet = insuranceBet;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public boolean isDuringRound() {
        return duringRound;
    }
}