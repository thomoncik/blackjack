package blackjack.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

/**
 * @author Tomasz Homoncik
 */
public class DeckTest {
    @Test
    public void getNextCard() throws Exception {
        Deck deck = new Deck();
        ArrayList<Card> testDeck = new ArrayList<>();
        for(int i = 0; i < deck.DECK_SIZE; i++){
            Card temp = deck.getNextCard();
            assertFalse(testDeck.contains(temp));
            testDeck.add(temp);
        }
    }
}