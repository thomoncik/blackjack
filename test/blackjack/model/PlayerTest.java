package blackjack.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mat_k on 24.05.2017.
 */
public class PlayerTest {
    @Test
    public void canSplit() throws Exception {
        TableProvider table = new TableProvider("split");
        table.getPlayer().setDuringRound(true);
        table.getDealer().begin();
        table.getPlayer().hit();

        assertFalse(table.getPlayer().canSplit()); // for split player needs 2 cards

        table.getPlayer().hit();
        assertTrue(table.getPlayer().canSplit());

        table.getPlayer().split();
        assertTrue(table.getPlayer().isSplitted());

        table.getPlayer().hit();
        assertFalse(table.getPlayer().canSplit()); // exactly 2 cards

        table = new TableProvider("falseSplit");
        table.getPlayer().setDuringRound(true);
        table.getDealer().begin();
        table.getPlayer().hit();

        table.getPlayer().hit();
        assertFalse(table.getPlayer().canSplit());
    }

    @Test
    public void canDoubleDown() throws Exception {
        TableProvider table = new TableProvider("doubleDown");
        table.getPlayer().setDuringRound(true);
        table.getDealer().begin();
        table.getPlayer().hit();

        assertTrue(table.getPlayer().canDoubleDown());

        table = new TableProvider("doubleDown");
        table.getPlayer().setDuringRound(true);
        table.getDealer().begin();
        table.getPlayer().hit();

        table.getPlayer().setBet(100);
        table.getPlayer().setBank(50);
        assertFalse(table.getPlayer().canDoubleDown());
    }

    @Test
    public void ifCanInsurance() throws Exception {
        TableProvider insurance = new TableProvider("insurance");
        TableProvider falseInsurance = new TableProvider("falseInsurance");

        insurance.getPlayer().setDuringRound(true);
        insurance.getDealer().begin();
        insurance.getPlayer().hit();

        falseInsurance.getPlayer().setDuringRound(true);
        falseInsurance.getDealer().begin();
        falseInsurance.getPlayer().hit();

        assertTrue(insurance.canBuyInsurance());
        assertFalse(falseInsurance.canBuyInsurance());

        insurance.getPlayer().insurance();

        assertFalse(insurance.canBuyInsurance());

        insurance = new TableProvider("insurance");

        insurance.getPlayer().setDuringRound(true);
        insurance.getDealer().begin();
        insurance.getPlayer().hit();

        assertTrue(insurance.canBuyInsurance());

        insurance.getPlayer().setBet(750);
        insurance.getPlayer().setBank(20);

        assertFalse(insurance.canBuyInsurance());
    }

    @Test
    public void clearMyHand() throws Exception {
        Table table = new Table();
        table.getPlayer().setDuringRound(true);
        table.getDealer().begin();
        table.getPlayer().hit();

        assertTrue(table.getPlayer().getValue() > 0);

        table.getPlayer().clearHand();

        assertTrue(table.getPlayer().getValue() == 0);
    }

    @Test
    public void myValue() throws Exception {
        TableProvider aces = new TableProvider("aces");
        aces.getPlayer().setDuringRound(true);
        aces.getDealer().begin();
        aces.getPlayer().hit();

        aces.getPlayer().hit();
        assertEquals(12, aces.getPlayer().getValue());

        aces.getPlayer().hit();
        assertEquals(13, aces.getPlayer().getValue());
    }

}