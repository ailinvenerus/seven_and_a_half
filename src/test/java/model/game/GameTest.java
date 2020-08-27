package model.game;

import model.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
        game = new Game(players, bench);
    }

    @Test
    void winners_losers() {
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

}