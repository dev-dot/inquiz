package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import org.junit.Test;

public class IllegalFactoryArgumentTest {
    Game game = new Game();

    public IllegalFactoryArgumentTest() throws IllegalFactoryArgument {
    }

    @Test(expected = IllegalFactoryArgument.class)
    public void ExceptionIsThrown() throws IllegalFactoryArgument {
        game.setGameMode(5);
    }
}
