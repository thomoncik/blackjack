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
        if (player.isInsured() || (player.getBet() / 2 > player.getBank())) {
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

    public void endRound() {
        if (!player.busted() && dealer.busted()) {
            player.setBank(2 * player.getBet() + player.getBank());
        }

        if (player.isInsured() && dealer.gotBlackjack()) {
            player.setBank(player.getBank() + player.getBet());
        }

        player.clearHand();
        dealer.clearHand();
    }
}
