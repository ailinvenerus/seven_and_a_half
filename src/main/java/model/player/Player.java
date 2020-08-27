package model.player;

import model.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private List<Card> cards;

    private Integer pointsToStop;

    public Player() {
        this.cards = new ArrayList<>();
        this.pointsToStop = generateRandomStop();
    }

    private Integer generateRandomStop() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    public Double calculatePoints() {
        return cards.stream().mapToDouble(Card::getPoints).sum();
    }

    public Boolean hasWon(Player bench) {
        Double points = calculatePoints();
        return (points <= 7.5 && bench.calculatePoints() <= points) || bench.calculatePoints() > 7.5;
    }

    public void receiveNewCard(Card card) {
        cards.add(card);
    }

    public boolean canReceiveCard() {
        return getPointsToStop() > calculatePoints();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Integer getPointsToStop() {
        return pointsToStop;
    }

    public void setPointsToStop(Integer pointsToStop) {
        this.pointsToStop = pointsToStop;
    }

}
