package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Game implements IGamemode {
    private int roundCount;

    private static final Logger log = LogManager.getLogger(Game.class);
    private static final Scanner input  = new Scanner(System.in);

    Game() {
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    void start() {
        log.info("game started");
    }

    public void stop() {
        log.info("game over");
    }

    void setGamemode(int gamemode) {

        switch(gamemode){
            case 0:
                standardMode();
                log.info("gamemode was set to standard");
                break;
            case 1:
               speedMode();
                log.info("gamemode was set to speed");
                break;
            case 2:
                expertMode();
                log.info("gamemode was set to expert");
                break;

            default :

    }

    }

    void setNewPlayer(String nickname) {

        Player player = new Player(nickname);
        log.info("player: " + player.getId() + " was created");
    }

    @Override
    public void standardMode() {

    }

    @Override
    public void speedMode() {

    }

    @Override
    public void expertMode() {

    }
}
