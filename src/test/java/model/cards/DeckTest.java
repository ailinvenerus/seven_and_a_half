package model.cards;

import model.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    Deck deck = new Deck();

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