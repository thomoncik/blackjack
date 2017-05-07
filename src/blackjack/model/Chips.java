package blackjack.model;

import javafx.util.Pair;

/**
 * Created by Jan on 5/7/2017.
 */
public class Chips {

    private Pair[] values = new Pair[]{
            new Pair<>(5, Chips.Color.GRAY),
            new Pair<>(25, Chips.Color.RED),
            new Pair<>(50, Chips.Color.GREEN),
            new Pair<>(100, Chips.Color.BLACK),
            new Pair<>(500, Chips.Color.BLUE),
    };
    private int value;
    private Color color;

    public Chips(int value) {
        this.value = value;
        for (Pair p : values) {
            if (p.getKey() == new Integer(value)) {
                this.color = (Color) p.getValue();
            }
        }
    }

    public int getValue() {
        return this.value;
    }

    public Color getColor() {
        return this.color;
    }

    enum Color {
        GRAY,
        RED,
        GREEN,
        BLACK,
        BLUE
    }
}
