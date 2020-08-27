package model.player;

import model.cards.Number;
import model.cards.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlayerTest {

    Player anna;
    Player bench;
    List<Card> cards;
    List<Card> benchCards;
    Card fiveOfSpades = new Number(Suit.SPADES, 5);
    Card kingOfClubs = new Figure(Suit.CLUBS, FigureType.KING);
    Card jackOfCups = new Figure(Suit.CUPS, FigureType.JACK);
    Card twoOfCoins = new Number(Suit.COINS, 2);
    Card sixOfSpades = new Number(Suit.SPADES, 6);

    @BeforeEach
    public void init() {
        anna = new Player();
        cards = new ArrayList<>();
        anna.setCards(cards);
        bench = new Player();
        benchCards = new ArrayList<>();
        bench.setCards(benchCards);
    }

    @Test
    void calculatePoints_5() {
        cards.add(fiveOfSpades);
        Assertions.assertEquals(5, anna.calculatePoints());
    }

    @Test
    void calculatePoints_11() {
        cards.add(fiveOfSpades);
        cards.add(sixOfSpades);
        Assertions.assertEquals(11, anna.calculatePoints());
    }

    @Test
    void calculatePoints_7_5() {
        cards.add(fiveOfSpades);
        cards.add(twoOfCoins);
        cards.add(jackOfCups);
        Assertions.assertEquals(7.5, anna.calculatePoints());
    }

    @Test
    void calculatePoints_8() {
        cards.add(fiveOfSpades);
        cards.add(twoOfCoins);
        cards.add(jackOfCups);
        cards.add(kingOfClubs);
        Assertions.assertEquals(8, anna.calculatePoints());
    }

    @Test
    void hasWon_excessOfPoints() {
        benchCards.add(sixOfSpades);
        benchCards.add(twoOfCoins);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bench));
    }

    @Test
    void hasWon_notEnoughPoints() {
        benchCards.add(twoOfCoins);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bench));
    }

    @Test
    void hasWon_tie() {
        benchCards.add(fiveOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bench));
    }

    @Test
    void lose_notEnoughPoints() {
        benchCards.add(sixOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertFalse(anna.hasWon(bench));
    }

    @Test
    void lose_excessOfPoints() {
        benchCards.add(twoOfCoins);
        cards.add(sixOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertFalse(anna.hasWon(bench));
    }
}