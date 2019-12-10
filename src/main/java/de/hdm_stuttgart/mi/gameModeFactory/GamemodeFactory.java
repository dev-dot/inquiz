package de.hdm_stuttgart.mi.gameModeFactory;

import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GamemodeFactory {
    private static final Logger log = LogManager.getLogger(GamemodeFactory.class);

    public static IGamemode createGameMode(de.hdm_stuttgart.mi.interfaces.IGamemode.Gamemodes gamemodes) throws IllegalFactoryArgument {

        switch (gamemodes){
            case LEICHT: return new Gamemode(3,60000);
            case MITTEL: return new Gamemode(2,45000);
            case SCHWER: return new Gamemode(1,30000);
            default:
                log.error("wrong Gamemode!");
                throw new IllegalFactoryArgument(
                        "Wrong Gamemode!");
        }
    }
}
