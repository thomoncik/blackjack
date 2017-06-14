package blackjack.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Tomasz Homoncik
 */
public class DeckTest {
    @Test
    public void getNextCard() throws Exception {
        Deck deck = new Deck();
        ArrayList<Card> testDeck = new ArrayList<>();
        for (int i = 0; i < Deck.DECK_SIZE; i++) {
            Card temp = deck.getNextCard();
            assertFalse(testDeck.contains(temp));
            testDeck.add(temp);
        }

        ArrayList<Card> testDeckv2 = new ArrayList<>();
        for (int i = 0; i < Deck.DECK_SIZE; i++) {
            Card temp = deck.getNextCard();
            assertFalse(testDeckv2.contains(temp));
            testDeckv2.add(temp);
        }

        assertNotEquals(testDeck,testDeckv2);
    }
}