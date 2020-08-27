package model.cards;

import model.player.Player;

public class Deck {

    public void handOutCard(Player player) {
        player.receiveNewCard(generateCard());
    }

    protected Card generateCard() {
        int suitNumber = randomNumber(4);
        int number = randomNumber(10);
        Card card;
        Suit suit = generateSuit(suitNumber);
        if (number < 8 && number > 0) {
            card = new Number(suit, number);
        } else {
            card = new Figure(suit, generateFigure(number));
        }
        return card;
    }

    private Suit generateSuit(Integer number) {
        Suit suit;
        switch (number) {
            case 1:
                suit = Suit.SPADES;
                break;
            case 2:
                suit = Suit.CUPS;
                break;
            case 3:
                suit = Suit.COINS;
                break;
            default:
                suit = Suit.CLUBS;
        }
        return suit;
    }

    private FigureType generateFigure(Integer number) {
        FigureType figureType;
        switch (number) {
            case 8:
                figureType = FigureType.JACK;
                break;
            case 9:
                figureType = FigureType.KNIGHT;
                break;
            default:
                figureType = FigureType.KING;
        }
        return figureType;
    }

    private int randomNumber(int max) {
        return (int) (Math.random() * max);
    }
}
