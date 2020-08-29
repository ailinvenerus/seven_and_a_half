package model.game;

import model.cards.Deck;
import model.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private Deck deck;
    private List<Player> players;
    private Player bank;

    public Game(List<Player> players) {
        this.deck = new Deck();
        this.players = players;
        this.bank = new Player("Bank");
    }

    public List<Player> winners() {
        return players.stream().filter(p -> p.hasWon(bank)).collect(Collectors.toList());
    }

    public List<Player> losers() {
        return players.stream().filter(p -> !p.hasWon(bank)).collect(Collectors.toList());
    }

    protected void initialHandOut() {
        players.forEach(p -> deck.handOutCard(p));
    }

    protected void handOutCards() {
        players.forEach(p -> deck.handOutCards(p));
    }

    public void play() {
        initialHandOut();
        handOutCards();
        bank();
    }

    private void bank() {
        deck.handOutCards(bank);
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getBank() {
        return bank;
    }

    public void setBank(Player bank) {
        this.bank = bank;
    }
}
