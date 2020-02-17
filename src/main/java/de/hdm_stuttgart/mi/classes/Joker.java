package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.guiHandler.MainController;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;

public class Joker {
    private int jokerCounter;
    private final Logger log = LogManager.getLogger(Joker.class);

    public int getJokerCounter() {
        return jokerCounter;
    }

    public void setJokerCounter(int jokerCounter) {
        this.jokerCounter = jokerCounter;
    }


    public void fifty(Button buttonA, Button buttonB, Button buttonC, Button buttonD, Button fiftyJoker) {
        String rightAnswer = Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer();
        List<String> list = Arrays.asList(buttonA.getText(), buttonB.getText(), buttonC.getText(), buttonD.getText());
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        int i = 0;
        while (i < 2) {
            System.out.println(random);
            switch (random) {
                case 0:
                    if (!list.get(0).equals(rightAnswer)) {
                        log.info("A is wrong and disabled by fifty");
                        buttonA.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 1:
                    if (!list.get(1).equals(rightAnswer)) {
                        log.info("B is wrong and disabled by fifty");
                        buttonB.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 2:
                    if (!list.get(2).equals(rightAnswer)) {
                        log.info("C is wrong and disabled by fifty");
                        buttonC.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 3:
                    if (!list.get(3).equals(rightAnswer)) {
                        log.info("D is wrong and disabled by fifty");
                        buttonD.setVisible(false);
                        i++;
                    }
                    random = 0;
                    break;
                default:
                    log.error("no wrong answers");
            }
        }
        fiftyJoker.setDisable(true);
    }

    public void skipQuestion(Button skipJoker) throws IOException {
        MainController.gameController.nextRound();
        game.setRightAnswerCounter();
        skipJoker.setDisable(true);
    }

    public void extraTime(Button timeJoker, ProgressBar timeBar) {
        MainController.gameController.animations.setTimer(timeBar);
        timeJoker.setDisable(true);
    }


    public void reset(Button timeJoker, Button skipJoker, Button fiftyJoker) {
        timeJoker.setDisable(false);
        skipJoker.setDisable(false);
        fiftyJoker.setDisable(false);
    }

}
