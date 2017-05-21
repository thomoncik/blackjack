package blackjack.model;

import javafx.util.Pair;

/**
 * Created by Jan on 5/5/2017.
 */
class Card {
    private Suit suit;
    private Rank rank;
    private Integer[] value;

    private Pair[] values = new Pair[]{
            new Pair<>(Rank.TWO, 2),
            new Pair<>(Rank.THREE, 3),
            new Pair<>(Rank.FOUR, 4),
            new Pair<>(Rank.FIVE, 5),
            new Pair<>(Rank.SIX, 6),
            new Pair<>(Rank.SEVEN, 7),
            new Pair<>(Rank.EIGHT, 8),
            new Pair<>(Rank.NINE, 9),
            new Pair<>(Rank.TEN, 10),
            new Pair<>(Rank.JACK, 10),
            new Pair<>(Rank.QUEEN, 10),
            new Pair<>(Rank.KING, 10),
            new Pair<>(Rank.ACE, new Integer[]{1, 11})
    };

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        for (Pair p : values) {
            if (p.getKey() == rank) {
                if( rank == Rank.ACE ){
                    this.value = (Integer[]) p.getValue();
                } else {
                    this.value = new Integer[]{ (Integer) p.getValue() };
                }
                // problem with casting single Integer to array of Integers
            }
        }
    }

    Rank getRank() {
        return this.rank;
    }

    Suit getSuit() {
        return this.suit;
    }

    Integer[] getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        } else if (((Card) o).rank == this.rank && ((Card) o).suit == this.suit) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return rank.ordinal() + 100 * suit.ordinal();
    }

    enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    enum Suit {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES
    }

    public String toString(){
        return suit + " " + rank;
    }
}