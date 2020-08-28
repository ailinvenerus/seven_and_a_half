package model.cards;

import model.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    Deck deck = new Deck();
    Player anna = new Player("Anna");

    @Test
    void handOutCard_total_1() {
        deck.handOutCard(anna);
        Assertions.assertEquals(1, (long) anna.getCards().size());
    }

    @Test
    void handOutCard_total_4() {
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        Assertions.assertEquals(4, (long) anna.getCards().size());
    }

    @Test
    void handOutCard_total_5() {
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        deck.handOutCard(anna);
        Assertions.assertEquals(5, (long) anna.getCards().size());
    }

    @Test
    void generateCard() {
        Card card = deck.generateCard();
        Assertions.assertTrue(isValid(card));
    }

    private boolean isValid(Card card) {
        if (card.getNumber() != null) {
            return card.getFigureType() == null;
        }
        return card.getFigureType() != null;
    }
}