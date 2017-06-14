package blackjack.model;

/**
 * Created by mat_k on 27.05.2017.
 */
public class TableProvider extends Table {
    public TableProvider(String s) {
        this.deck = new DeckProvider(s);
        this.dealer = new Dealer(deck);
        this.player = new Player(deck);
    }
}
