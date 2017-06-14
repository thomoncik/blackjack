package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jan on 5/5/2017.
 */
public class Deck {
    public static final int DECK_SIZE = Card.Rank.values().length * Card.Suit.values().length;
    protected Card[] cards;
    protected int nextCard;
    private ArrayList<Integer> randomOrderOfCards;

    public Deck() {
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

    public Card getNextCard() {
        if(nextCard == 52){
            Collections.shuffle(randomOrderOfCards);
            nextCard = 0;
        }
        return cards[randomOrderOfCards.get(nextCard++)];
    }

}
