package model.cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    public void creating_cards() {
        Card fiveOfSpades = new Number(Suit.SPADES, 5d);
        Card kingOfClubs = new Figure(Suit.CLUBS, FigureType.KING);
        Card jackOfCups = new Figure(Suit.CUPS, FigureType.JACK);
        Card twoOfCoins = new Number(Suit.COINS, 2d);
        Card sixOfSpades = new Number(Suit.SPADES, 6d);

        Assertions.assertEquals(Suit.SPADES, fiveOfSpades.getSuit());
        Assertions.assertEquals(5, fiveOfSpades.getPoints());
        Assertions.assertEquals(Suit.CLUBS, kingOfClubs.getSuit());
        Assertions.assertEquals(FigureType.KING, kingOfClubs.getFigureType());
        Assertions.assertEquals(1.5, kingOfClubs.getPoints());
        Assertions.assertEquals(Suit.CUPS, jackOfCups.getSuit());
        Assertions.assertEquals(FigureType.JACK, jackOfCups.getFigureType());
        Assertions.assertEquals(1.5, jackOfCups.getPoints());
        Assertions.assertEquals(Suit.COINS, twoOfCoins.getSuit());
        Assertions.assertEquals(2, twoOfCoins.getPoints());
        Assertions.assertEquals(Suit.SPADES, sixOfSpades.getSuit());
        Assertions.assertEquals(6, sixOfSpades.getPoints());
    }
}