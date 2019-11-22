package de.hdm_stuttgart.mi.GameModeFactory;

import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factory {
    private static final Logger log = LogManager.getLogger(Factory.class);

    public static IGamemode createGameMode(de.hdm_stuttgart.mi.interfaces.IGamemode.Gamemodes g) throws IllegalFactoryArgument {

        switch (g){
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
