package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class Table {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Table(){
        deck = new Deck();
        player = new Player(deck);
        dealer = new Dealer(deck);
        player.setDealer(dealer);
    }

    public Player getPlayer(){return player;}

    public Dealer getDealer(){return dealer;}
}
