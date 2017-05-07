package blackjack.model;

import javafx.util.Pair;

/**
 * Created by Jan on 5/7/2017.
 */
public class Chip {

    private Pair[] values = new Pair[]{
            new Pair<>(5, Chip.Color.GRAY),
            new Pair<>(25, Chip.Color.RED),
            new Pair<>(50, Chip.Color.GREEN),
            new Pair<>(100, Chip.Color.BLACK),
            new Pair<>(500, Chip.Color.BLUE),
    };
    private int value;
    private Color color;

    public Chip(int value) {
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
