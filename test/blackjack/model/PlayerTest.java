package blackjack.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mat_k on 24.05.2017.
 */
public class PlayerTest {

    @Test
    public void ending() throws Exception {
        TableProvider tworound = new TableProvider("tworounds");

        assertTrue(tworound.getDealer().gotBlackjack());
        assertTrue(tworound.canBuyInsurance());

        tworound.getPlayer().setBet(200);
        tworound.getPlayer().insurance();
        tworound.getPlayer().stand();
//        tworound.getPlayer().ending();

        assertEquals(1000, tworound.getPlayer().getBank());

//        tworound.getPlayer().begin();

        tworound.getPlayer().setBet(300);
        tworound.getPlayer().hit();
        tworound.getPlayer().stand();

        assertEquals(19, tworound.getPlayer().getValue());
        assertEquals(17, tworound.getDealer().getValue());

//        tworound.getPlayer().ending();

        assertEquals(1300, tworound.getPlayer().getBank());
    }

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

        split.getPlayer().split();
        assertTrue(split.getPlayer().isSplitted());
        assertFalse(split.getPlayer().canSplit());

        split = new TableProvider("split");
        split.getPlayer().hit();
        split.getPlayer().hit();

        assertFalse(split.getPlayer().canSplit());
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

        assertTrue(insurance.canBuyInsurance());
        assertFalse(falseInsurance.canBuyInsurance());

        insurance.getPlayer().insurance();

        assertFalse(insurance.canBuyInsurance());

        insurance = new TableProvider("insurance");

        assertTrue(insurance.canBuyInsurance());

        insurance.getPlayer().setBet(750);

        assertFalse(insurance.canBuyInsurance());
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
    public void clearMyHand() throws Exception {
        Table table = new Table();

        assertTrue(table.getPlayer().getValue() > 0);

        table.getPlayer().clearHand();

        assertTrue(table.getPlayer().getValue() == 0);
    }

    @Test
    public void begin() throws Exception {
        Table table = new Table();
        table.getPlayer().clearHand();
//        table.getPlayer().begin();

        assertTrue(table.getPlayer().getValue() > 0 && table.getPlayer().getValue() < 12);
    }

    @Test
    public void myCards() throws Exception {
    }

    @Test
    public void myValue() throws Exception {
        TableProvider aces = new TableProvider("aces");

        aces.getPlayer().hit();
        assertEquals(12, aces.getPlayer().getValue());

        aces.getPlayer().hit();
        assertEquals(13, aces.getPlayer().getValue());
    }

}