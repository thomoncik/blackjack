package blackjack.model;

import java.util.ArrayList;

/**
 * Created by Jan on 5/5/2017.
 */
public class Hand {
    ArrayList<Card> cardsOnHand;
    private int sumOfValues;

    Hand() {
        cardsOnHand = new ArrayList<>();
        sumOfValues = 0;
    }

    public Card getIthCard(int i){
        if( i >= 0 && i < cardsOnHand.size() ) return cardsOnHand.get(i);
        else return null;
    }

    void addCard(Card card) {
        cardsOnHand.add(card);
        actualizeValue(card);
    }

    int getHandsValue() {
        return sumOfValues;
    }

    private void actualizeValue(Card card) {
        if (card.getRank() == Card.Rank.ACE) {
            if (sumOfValues + 11 > 21) sumOfValues += card.getValue()[0];
            else sumOfValues += card.getValue()[1];
        } else {
            sumOfValues += card.getValue()[0];
        }
    }

}
