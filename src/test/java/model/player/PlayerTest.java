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
    Player bank;
    List<Card> cards;
    List<Card> bankCards;
    Card fiveOfSpades = new Number(Suit.SPADES, 5);
    Card kingOfClubs = new Figure(Suit.CLUBS, FigureType.KING);
    Card jackOfCups = new Figure(Suit.CUPS, FigureType.JACK);
    Card twoOfCoins = new Number(Suit.COINS, 2);
    Card sixOfSpades = new Number(Suit.SPADES, 6);

    @BeforeEach
    public void init() {
        anna = new Player("Anna");
        cards = new ArrayList<>();
        anna.setCards(cards);
        bank = new Player("Bank");
        bankCards = new ArrayList<>();
        bank.setCards(bankCards);
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
        bankCards.add(sixOfSpades);
        bankCards.add(twoOfCoins);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bank));
    }

    @Test
    void hasWon_notEnoughPoints() {
        bankCards.add(twoOfCoins);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bank));
    }

    @Test
    void hasWon_tie() {
        bankCards.add(fiveOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertTrue(anna.hasWon(bank));
    }

    @Test
    void lose_notEnoughPoints() {
        bankCards.add(sixOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertFalse(anna.hasWon(bank));
    }

    @Test
    void lose_excessOfPoints() {
        bankCards.add(twoOfCoins);
        cards.add(sixOfSpades);
        cards.add(fiveOfSpades);
        Assertions.assertFalse(anna.hasWon(bank));
    }

    @Test
    void receiveNewCard() {
        anna.receiveNewCard(fiveOfSpades);
        Assertions.assertTrue(anna.getCards().contains(fiveOfSpades));
    }

    @Test
    void canReceiveCard_true() {
        anna.setPointsToStop(5);
        cards.add(twoOfCoins);
        Assertions.assertTrue(anna.canReceiveCard());
    }

    @Test
    void canReceiveCard_false_equalPointsToStop() {
        anna.setPointsToStop(5);
        cards.add(fiveOfSpades);
        Assertions.assertFalse(anna.canReceiveCard());
    }

    @Test
    void canReceiveCard_false_tooMuchPoints() {
        anna.setPointsToStop(5);
        cards.add(sixOfSpades);
        Assertions.assertFalse(anna.canReceiveCard());
    }

}