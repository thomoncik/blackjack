package blackjack.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mat_k on 24.05.2017.
 */
public class PlayerTest {
    @Test
    public void isSplitted() throws Exception {
    }

    @Test
    public void canSplit() throws Exception {
        TableProvider split = new TableProvider("split");
        TableProvider falseSplit = new TableProvider("falseSplit");

        assertFalse(split.getPlayer().canSplit());
        assertFalse(falseSplit.getPlayer().canSplit());

        split.getPlayer().hit();
        falseSplit.getPlayer().hit();

        assertTrue(split.getPlayer().canSplit());
        assertFalse(falseSplit.getPlayer().canSplit());
    }

    @Test
    public void canDoubleDown() throws Exception {
        TableProvider doubleDown = new TableProvider("doubleDown");

        assertFalse(doubleDown.getPlayer().canDoubleDown());

        doubleDown.getPlayer().hit();

        assertTrue(doubleDown.getPlayer().canDoubleDown());

        doubleDown.getPlayer().setBet(501);

        assertFalse(doubleDown.getPlayer().canDoubleDown());

        doubleDown.getPlayer().setBet(-2);

        assertTrue(doubleDown.getPlayer().canDoubleDown());

        doubleDown.getPlayer().hit();

        assertFalse(doubleDown.getPlayer().canDoubleDown());
    }

    @Test
    public void ifCanInsurance() throws Exception {
        TableProvider insurance = new TableProvider("insurance");
        TableProvider falseInsurance = new TableProvider("falseInsurance");

        assertTrue(insurance.getPlayer().ifCanInsurance());
        assertFalse(falseInsurance.getPlayer().ifCanInsurance());

        insurance.getPlayer().insurance();

        assertFalse(insurance.getPlayer().ifCanInsurance());

        insurance = new TableProvider("insurance");

        assertTrue(insurance.getPlayer().ifCanInsurance());

        insurance.getPlayer().setBet(750);

        assertFalse(insurance.getPlayer().ifCanInsurance());
    }

    @Test
    public void hit() throws Exception {
    }

    @Test
    public void stand() throws Exception {
    }

    @Test
    public void doubleDown() throws Exception {
    }

    @Test
    public void split() throws Exception {
    }

    @Test
    public void insurance() throws Exception {
    }

    @Test
    public void dealerTurn() throws Exception {
    }

    @Test
    public void myCards() throws Exception {
    }

    @Test
    public void myValue() throws Exception {
    }

    @Test
    public void main() throws Exception {
    }

}