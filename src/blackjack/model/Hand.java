package blackjack.model;

import java.util.ArrayList;

/**
 * Created by Jan on 5/5/2017.
 */
public class Hand {
    ArrayList<Card> cardsOnHand;
    int sumOfValues;

    public Hand() {
        cardsOnHand = new ArrayList<>();
        sumOfValues = 0;
    }

    public void addCard(Card card) {
        cardsOnHand.add(card);
        actualizeValue(card);
    }

    public int getHandsValue() {
        return sumOfValues;
    }

    public void actualizeValue(Card card) {
        if( card.getRank() == Card.Rank.ACE ) {
            if( sumOfValues + 11 > 21 ) sumOfValues += card.getValue()[0];
            else sumOfValues += card.getValue()[1];
        }
        else{
            sumOfValues += card.getValue()[0];
        }
    }

}
