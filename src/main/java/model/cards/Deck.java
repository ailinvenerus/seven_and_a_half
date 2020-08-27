package model.cards;

import model.player.Player;

import java.util.Random;

public class Deck {

    private Card generateCard() {
        Card card = new Number(Suit.SPADES, 2);
    return card;
    }
//        //todo
//        Random random = new Random();
//        Integer cardType = random.nextInt(1 + 1);
//        if(cardType == 0) {
//            Card card = new Figure(S)
//        }
//        Card card = new
//    }

    public void handOutCard(Player player) {
        if(player.getPointsToStop() < player.calculatePoints()) player.receiveNewCard(generateCard());
    }

}
