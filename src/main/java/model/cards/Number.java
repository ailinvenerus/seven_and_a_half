package model.cards;

public class Number implements Card {
    private final Suit suit;
    private final Double number;

    public Number(Suit suit, Double number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public Double getPoints() {
        return number;
    }

    public FigureType getFigureType() {
        return null;
    }

}
