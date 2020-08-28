package model.game;

import model.cards.*;
import model.cards.Number;
import model.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameTest {

    @Mock
    Player anna = mock(Player.class);
    Player bench = mock(Player.class);
    Player john = mock(Player.class);
    Player peter = mock(Player.class);
    Game game;

    @BeforeAll
    public void init() {
        List<Player> players = new ArrayList<>();
        players.add(anna);
        players.add(john);
        players.add(peter);
        game = new Game(players);
    }

    @Test
    void winners_losers() {
        game.setBench(bench);
        Mockito.when(anna.hasWon(bench)).thenReturn(true);
        Mockito.when(john.hasWon(bench)).thenReturn(false);
        Mockito.when(peter.hasWon(bench)).thenReturn(true);
        List<Player> winners = new ArrayList<>();
        winners.add(anna);
        winners.add(peter);
        List<Player> losers = new ArrayList<>();
        losers.add(john);

        Assertions.assertEquals(winners, game.winners());
        Assertions.assertEquals(losers, game.losers());
    }

    @Test
    void getDeck() {
        Assertions.assertNotNull(game.getDeck());
    }

    @Test
    void getBench() {
        Assertions.assertNotNull(game.getBench());
    }

    @Test
    void initialHandOut() {
        loadPlayers();
        game.initialHandOut();
        Assertions.assertTrue(game.getPlayers().stream().allMatch(p -> (long) p.getCards().size() == 1));
    }

    @Test
    void handOutCards() {
        loadPlayers();
        List<Card> cardsRick = new ArrayList<>();
        List<Card> cardsAlan = new ArrayList<>();
        List<Card> cardsEdward = new ArrayList<>();
        cardsRick.add(new Number(Suit.SPADES, 5));
        cardsAlan.add(new Figure(Suit.CLUBS, FigureType.KING));
        cardsAlan.add(new Figure (Suit.CUPS, FigureType.JACK));
        cardsEdward.add(new Number(Suit.COINS, 2));
        cardsEdward.add(new Number(Suit.SPADES, 6));
        game.getPlayers().get(0).setCards(cardsRick);
        game.getPlayers().get(0).setPointsToStop(5);
        game.getPlayers().get(1).setCards(cardsAlan);
        game.getPlayers().get(1).setPointsToStop(4);
        game.getPlayers().get(2).setCards(cardsEdward);
        game.getPlayers().get(2).setPointsToStop(3);

        Assertions.assertEquals(1, game.getPlayers().get(0).getCards().size());
        Assertions.assertEquals(2, game.getPlayers().get(1).getCards().size());
        Assertions.assertEquals(2, game.getPlayers().get(2).getCards().size());
    }

    @Test
    void play() {
        loadPlayers();
        game.play();
        List<Player> oneCardOnly = game.getPlayers().stream().filter(p -> p.getCards().size() == 1).collect(Collectors.toList());
        List<Player> stopAfterFirstCard = game.getPlayers().stream().filter(p -> p.getCards().get(0).getPoints() >= p.getPointsToStop()).collect(Collectors.toList());

        Assertions.assertEquals(oneCardOnly, stopAfterFirstCard);
    }

    void loadPlayers() {
        List<Player> players = new ArrayList<>();
        Player rick = new Player("Rick");
        Player alan = new Player("Alan");
        Player edward = new Player("Edward");
        players.add(rick);
        players.add(alan);
        players.add(edward);
        game = new Game(players);
    }

}