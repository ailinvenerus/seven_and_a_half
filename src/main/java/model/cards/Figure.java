package model.cards;

public class Figure implements Card {
    private final Suit suit;
    private final FigureType figureType;

    public Figure(Suit suit, FigureType figureType) {
        this.suit = suit;
        this.figureType = figureType;
    }

    public Suit getSuit() {
        return suit;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public Double getPoints() {
        return 1.5;
    }
}
