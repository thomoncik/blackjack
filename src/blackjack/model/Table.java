package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class Table {
    protected Deck deck;
    private Player player;
    private Dealer dealer;

    public Table() {
        deck = new Deck();
        player = new Player(deck);
        dealer = new Dealer(deck);
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public boolean canBuyInsurance() {
        if (player.isInsured()) {
            return false;
        }

        if (player.getBet() / 2 > player.getBank()) {
            return false;
        }

        return dealer.gotAceOnFace();
    }

    public boolean isPlayerRound() {
        return player.isDuringRound();
    }

    public boolean isDealerRound() {
        return !isPlayerRound() && dealer.canTakeCard();
    }
}
