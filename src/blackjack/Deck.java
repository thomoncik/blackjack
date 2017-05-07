package blackjack;

import java.util.Random;

/**
 * Created by Jan on 5/5/2017.
 */
public class Deck {

    Card[] cards;
    Card.Rank[] ranks = { Card.Rank.ACE, Card.Rank.TWO, Card.Rank.THREE, Card.Rank.FOUR, Card.Rank.FIVE,
            Card.Rank.SIX, Card.Rank.SEVEN, Card.Rank.EIGHT, Card.Rank.NINE, Card.Rank.TEN, Card.Rank.JACK, Card.Rank.QUEEN, Card.Rank.KING };
    Card.Suit[] suits = { Card.Suit.CLUBS, Card.Suit.DIAMONDS, Card.Suit.SPADES, Card.Suit.HEARTS };

    public Deck() {
        cards = new Card[52];
        int i = 0;
        for( Card.Rank rank: ranks ) {
            for( Card.Suit suit: suits ) {
                cards[i++] = new Card( suit, rank );
            }
        }
    }

    public Card getRandomCard() {
        return cards[ new Random().nextInt(52) ];
    }
}
