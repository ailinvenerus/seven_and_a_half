package model.cards;

public interface Card {

    Suit getSuit();
    double getPoints();
    FigureType getFigureType();
    Integer getNumber();

}
