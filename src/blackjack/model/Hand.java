package blackjack.model;

import java.util.ArrayList;

/**
 * Created by Jan on 5/5/2017.
 */
class Hand {
    ArrayList<Card> cardsOnHand;
    private int sumOfValues;

    Hand() {
        cardsOnHand = new ArrayList<>();
        sumOfValues = 0;
    }

    void addCard(Card card) {
        cardsOnHand.add(card);
        actualizeValue(card);
    }

    void clear(){
        cardsOnHand.clear();
        sumOfValues = 0;
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
