package model.cards;

public class Number implements Card {
    private final Suit suit;
    private final Integer number;

    public Number(Suit suit, Integer number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public double getPoints() {
        return (double) number;
    }

    public Integer getNumber() {
        return number;
    }

    public FigureType getFigureType() {
        return null;
    }

}
