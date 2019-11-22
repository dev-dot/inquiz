package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Game implements IGamemode {

    /* Constructor */
    Game() {
    }

    //Class var
    private int roundCount;
    private int timeToAnswer;
    private int remainingJoker;

    /* Logger */
    private static final Logger log = LogManager.getLogger(Game.class);


    /* Game methods */
    void start() {
        log.info("game started");
    }

    public void stop() {
        log.info("game over");
    }


    /* Getter and Setter methods */

    void setGamemode(int gamemode) {

    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRemainingJoker() {
        return remainingJoker;
    }

    private void setRemainingJoker(int remainingJoker) {
        this.remainingJoker = remainingJoker;
    }

    public int getTimeToAnswer() {
        return timeToAnswer;
    }

    private void setTimeToAnswer(int timeToAnswer) {
        this.timeToAnswer = timeToAnswer;
    }

    Player createNewPlayer(String nickname) {

        Player player = new Player(nickname);
        log.info("player: " + player.getId() + " was created");
        return player;
    }


    /* Interface methods */

    @Override
    public int getJokerCounter() {
        return 0;
    }

    @Override
    public int getRemainingTime() {
        return 0;
    }
}

