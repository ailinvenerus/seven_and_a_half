package model.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    public void creating_cards() {
        Card fiveOfSpades = new Number(Suit.SPADES, 5);
        Card kingOfClubs = new Figure(Suit.CLUBS, FigureType.KING);
        Card jackOfCups = new Figure(Suit.CUPS, FigureType.JACK);
        Card twoOfCoins = new Number(Suit.COINS, 2);
        Card sixOfSpades = new Number(Suit.SPADES, 6);

        Assertions.assertEquals(Suit.SPADES, fiveOfSpades.getSuit());
        Assertions.assertEquals(5, fiveOfSpades.getPoints());
        Assertions.assertEquals(5, fiveOfSpades.getNumber());
        Assertions.assertEquals(Suit.CLUBS, kingOfClubs.getSuit());
        Assertions.assertEquals(FigureType.KING, kingOfClubs.getFigureType());
        Assertions.assertEquals(0.5, kingOfClubs.getPoints());
        Assertions.assertEquals(Suit.CUPS, jackOfCups.getSuit());
        Assertions.assertEquals(FigureType.JACK, jackOfCups.getFigureType());
        Assertions.assertEquals(0.5, jackOfCups.getPoints());
        Assertions.assertEquals(Suit.COINS, twoOfCoins.getSuit());
        Assertions.assertEquals(2, twoOfCoins.getPoints());
        Assertions.assertEquals(2, twoOfCoins.getNumber());
        Assertions.assertEquals(Suit.SPADES, sixOfSpades.getSuit());
        Assertions.assertEquals(6, sixOfSpades.getPoints());
        Assertions.assertEquals(6, sixOfSpades.getNumber());
    }
}