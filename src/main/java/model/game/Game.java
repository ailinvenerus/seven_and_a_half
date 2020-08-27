package model.game;

import model.cards.Deck;
import model.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private Deck deck;
    private List<Player> players;
    private Player bench;

    public Game(List<Player> players, Player bench) {
        this.deck = new Deck();
        this.players = players;
        this.bench = bench;
    }

    public List<Player> winners() {
        return players.stream().filter(p -> p.hasWon(bench)).collect(Collectors.toList());
    }

    public List<Player> losers() {
        return players.stream().filter(p -> !p.hasWon(bench)).collect(Collectors.toList());
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

    //    public void handOutCard() {} //todo aca hace la logica de elegir al jugador y darle la carta
}
