package model.game;

import model.cards.Deck;
import model.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private Deck deck;
    private List<Player> players;
    private Player bench;

    public Game(List<Player> players) {
        this.deck = new Deck();
        this.players = players;
        this.bench = new Player("Bench");
    }

    public List<Player> winners() {
        return players.stream().filter(p -> p.hasWon(bench)).collect(Collectors.toList());
    }

    public List<Player> losers() {
        return players.stream().filter(p -> !p.hasWon(bench)).collect(Collectors.toList());
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
    }

    private void benchPlays() {
        deck.handOutCards(bench);
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getBench() {
        return bench;
    }

    public void setBench(Player bench) {
        this.bench = bench;
    }
}
