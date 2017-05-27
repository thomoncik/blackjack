package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class TableProvider {
    private Player player;
    private Dealer dealer;
    private DeckProvider deck;

    public TableProvider(String s){
        deck = new DeckProvider(s);
        player = new Player(deck);
        dealer = new Dealer(deck);
        player.setDealer(dealer);
    }

    public Player getPlayer(){return player;}

    public Dealer getDealer(){return dealer;}
}
