package blackjack.model;

import java.util.Random;

/**
 * Created by Jan on 5/5/2017.
 */
class Deck {
    private Card[] cards;

    Deck() {
        cards = new Card[52];
        int i = 0;
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    Card getRandomCard() {
        return cards[new Random().nextInt(52)];
    }
}
