package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Jan on 5/5/2017.
 */
class Deck {
    public static final int DECK_SIZE = Card.Rank.values().length * Card.Suit.values().length;
    private Card[] cards;
    private ArrayList<Integer> randomOrderOfCards;
    private int nextCard;

    Deck() {
        cards = new Card[DECK_SIZE];
        randomOrderOfCards = new ArrayList<>();
        int i = 0;
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                randomOrderOfCards.add(i);
                cards[i++] = new Card(suit, rank);
            }
        }
        Collections.shuffle(randomOrderOfCards);
        nextCard = 0;
    }

    public static void main(String[] args){
        // pseudo unit tests checking getting random card
        Deck deck = new Deck();
        for( int i = 0 ; i < DECK_SIZE; i++ ) System.out.println(deck.getNextCard());
    }

    Card getNextCard() {
        return cards[randomOrderOfCards.get(nextCard++)];
    }

    Card getRandomCard() {
        return cards[new Random().nextInt(DECK_SIZE)];
    }
}
