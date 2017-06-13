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

    void addCard(Card card) {
        cardsOnHand.add(card);
        actualizeValue(card);
    }

    void clear(){
        cardsOnHand.clear();
        sumOfValues = 0;
    }

    public Card getCardByIndex(int i) {
        return cardsOnHand.get(i);
    }

    public ArrayList<Card> getCards() {
        return cardsOnHand;
    }

    int getValue() {
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
