package blackjack.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mat_k on 27.05.2017.
 */
public class DealerTest {
    @Test
    public void canTakeCard() throws Exception {
        TableProvider aces = new TableProvider("aces");
        TableProvider takeCard = new TableProvider("takeCard");

        assertFalse(aces.getDealer().canTakeCard());
        assertTrue(takeCard.getDealer().canTakeCard());

        takeCard.getDealer().hit();
        assertTrue(takeCard.getDealer().canTakeCard());
        takeCard.getDealer().hit();
        assertTrue(takeCard.getDealer().canTakeCard());
        assertEquals(16,takeCard.getDealer().myValue());
        takeCard.getDealer().hit();
        assertFalse(takeCard.getDealer().canTakeCard());
    }

    @Test
    public void gotBlackjack() throws Exception {
        TableProvider aces = new TableProvider("aces");

        assertTrue(aces.getDealer().gotBlackjack());
    }

    @Test
    public void hit() throws Exception {
    }

    @Test
    public void gotAceOnFace() throws Exception {
        TableProvider aces = new TableProvider("aces");
        TableProvider falseAces = new TableProvider("falseAces");

        assertTrue(aces.getDealer().gotAceOnFace());
        assertFalse(falseAces.getDealer().gotAceOnFace());
    }

    @Test
    public void myCards() throws Exception {
    }

    @Test
    public void myValue() throws Exception {
    }

}