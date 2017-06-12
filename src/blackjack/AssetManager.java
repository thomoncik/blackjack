package blackjack;

import blackjack.model.Card;
import blackjack.model.Deck;
import javafx.scene.image.Image;

import java.util.HashMap;

/**
 * Created by Jan on 6/1/2017.
 */
public class AssetManager {
    private static AssetManager ourInstance = new AssetManager();
    private static HashMap<String, Image> mappedImages = new HashMap<String, Image>();


    private AssetManager() {

    }

    public static AssetManager getInstance() {
        return ourInstance;
    }

    public static void LoadCards() {
        Deck deck = new Deck();
        Image img = null;
        for (int i = 0; i < Deck.DECK_SIZE; i++) {
            Card card = deck.getNextCard();
            img = new Image("file:img/cards/" + card.toString() + ".png");
            mappedImages.put(card.toString(), img);
        }
        img = new Image("file:img/cards/backOfCard.png");
        mappedImages.put("backOfCard", img);
    }

    public Image getAsset(String Asset) {
        return mappedImages.get(Asset);
    }
}
