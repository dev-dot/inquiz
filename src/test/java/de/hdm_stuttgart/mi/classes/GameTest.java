package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.gameModeFactory.GamemodeFactory;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTest {
    Game game = new Game();

    public GameTest() throws IllegalFactoryArgument {
    }

    @Test
    public void testNotNullGameObject() {
        Assert.assertNotNull(game);
    }

    @Test
    public void testSetGamemode() throws IllegalFactoryArgument {
        // Setup

        // Run the test
        game.setGameMode(0);

        // Verify the results
        Assert.assertEquals(30000, GamemodeFactory.createGameMode(IGamemode.Gamemodes.LEICHT).getRemainingTime());
        Assert.assertEquals(20000, GamemodeFactory.createGameMode(IGamemode.Gamemodes.MITTEL).getRemainingTime());
        Assert.assertEquals(10000, GamemodeFactory.createGameMode(IGamemode.Gamemodes.SCHWER).getRemainingTime());
    }

    @Test
    public void testSetNewGame() {
        // Setup
        game.setRoundCount(5);
        game.setRightAnswerCounter();
        game.setWrongAnswerCounter();
        game.setWrongAnswerCounter();
        game.setWrongAnswerCounter();
        // Run the test
        game.setNewGame();

        // Verify the results
        Assert.assertEquals("Setting the round counter back to zero", 0, game.getRoundCount());
        Assert.assertEquals("Setting the right answer counter back to zero", 0, game.getRightAnswerCounter());
        Assert.assertEquals("Setting the wrong answer counter back to zero", 0, game.getWrongAnswerCounter());
    }

    @Test
    public void testGetQuestionIndex() {
        // Setup

        // Run the test
        final int result = game.getQuestionIndex(0);
        final int maxRandomInt = Game.quiz.getLength();

        // Verify the results
        assertTrue("Index is in the right range", result <= maxRandomInt);
    }
}

