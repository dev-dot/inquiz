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

        switch (gamemode) {
            case 0:
                standardMode();
                log.info("gamemode was set to standard; " + timeToAnswer + ":Time to answer," + remainingJoker + ":Remaining Joker");
                break;
            case 1:
                speedMode();
                log.info("gamemode was set to speed");
                break;
            case 2:
                expertMode();
                log.info("gamemode was set to expert");
                break;

            default:

        }

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

    void setNewPlayer(String nickname) {

        Player player = new Player(nickname);
        log.info("player: " + player.getId() + " was created");
    }


    /* Interface methods */

    @Override
    public void standardMode() {
        setRemainingJoker(3);
        setTimeToAnswer(1000);
    }

    @Override
    public void speedMode() {
        setRemainingJoker(2);
        setTimeToAnswer(750);
    }

    @Override
    public void expertMode() {
        setRemainingJoker(1);
        setTimeToAnswer(500);
    }
}
