package blackjack.model;

import java.util.Random;

/**
 * Created by Jan on 5/5/2017.
 */
class Deck {
    private Card[] cards;
    public static final int DECK_SIZE = Card.Rank.values().length * Card.Suit.values().length;

    Deck() {
        cards = new Card[DECK_SIZE];
        int i = 0;
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cards[i++] = new Card(suit, rank);
            }
        }
    }

    // @TODO: Fix
    Card getRandomCard() {
        return cards[new Random().nextInt(DECK_SIZE)];
    }
}
