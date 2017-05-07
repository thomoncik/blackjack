package blackjack.model;

import javafx.util.Pair;

/**
 * Created by Jan on 5/7/2017.
 */
public class Token {

    enum Color{
        GRAY,
        RED,
        GREEN,
        BLACK,
        BLUE
    }
    private Pair[] values = new Pair[]{
            new Pair<>(5, Token.Color.GRAY),
            new Pair<>(25, Token.Color.RED),
            new Pair<>(50, Token.Color.GREEN),
            new Pair<>(100, Token.Color.BLACK),
            new Pair<>(500, Token.Color.BLUE),
    };
    private int value;
    private Color color;
    public Token( int value ){
        this.value = value;
        for (Pair p : values) {
            if (p.getKey() == new Integer(value)) {
                this.color = (Color) p.getValue();
            }
        }
    }

    public int getValue(){
        return this.value;
    }

    public Color getColor(){
        return this.color;
    }
}
