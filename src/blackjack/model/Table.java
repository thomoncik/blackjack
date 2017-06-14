package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class Table {
    protected Deck deck;
    protected Player player;
    protected Dealer dealer;

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

    public boolean playerWon() {
        if (player.busted()) {
            return false;
        }
        return dealer.busted() || player.getValue() > dealer.getValue();

    }

    public void endRound() {
        if (!player.busted() && dealer.busted()) {
            player.setBank(2 * player.getBet() + player.getBank());
        } else if (!player.busted() && !dealer.busted() && player.getValue() > dealer.getValue()) {
            player.setBank(player.getBank() + 2 * player.getBet());
        } else if (!player.busted() && !dealer.busted() && player.getValue() == dealer.getValue()) {
            player.setBank(player.getBank() + player.getBet());
        } else if (player.isInsured() && dealer.gotBlackjack()) {
            player.setBank(player.getBank() + player.getBet());
        }

        player.clearHand();
        dealer.clearHand();
    }
}
