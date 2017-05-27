package blackjack.model;

import java.util.Objects;
import java.util.Scanner;

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

    public Player(Deck d) {
        hand = new Hand();
        deck = d;
        hand.addCard(deck.getNextCard());
        splitHand = null;
        bank = 1000;
        bet = 0;
        splitBet = 0;
        insuranceBet = 0;
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

    public boolean ifCanInsurance() {
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
        dealerTurn();
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
        bank -= bet / 2;
        insuranceBet = bet / 2;
        insured = true;
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

}
