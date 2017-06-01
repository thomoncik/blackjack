package blackjack;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import blackjack.model.Card;
import blackjack.model.Deck;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;

/**
 * Created by Jan on 6/1/2017.
 */
public class AssetManager {
    private static AssetManager ourInstance = new AssetManager();
    private static HashMap<String, Image> mappedImages = new HashMap<String, Image>();


    private AssetManager() {
//        Deck deck = new Deck();
//        Image img = null;
//        for (int i = 0; i < Deck.DECK_SIZE; i++) {
//            Card card = deck.getNextCard();
//            System.out.println("file:view/img/cards/"+ card.toString() +".png");
//            img = new Image("file:view/img/cards/"+ card.toString() +".png");
//            mappedImages.put(card.toString(), img);
//        }
//        img = new Image("view/img/cards/backOfCard.png");
//        mappedImages.put("backOfCard", img);

    }

    public static AssetManager getInstance() {
        return ourInstance;
    }

    public Image getAsset(String Asset) {
        return new Image("file:view/img/cards/pobrane.jpg");
        //return mappedImages.get(Asset);
    }
    public static void main(String[] args){

    }
}
