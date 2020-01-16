package de.hdm_stuttgart.mi.jokerFactory;
import de.hdm_stuttgart.mi.classes.Game;
import de.hdm_stuttgart.mi.guiHandler.GameController;
import de.hdm_stuttgart.mi.guiHandler.MainController;
import de.hdm_stuttgart.mi.interfaces.IJoker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;

public class FiftyFiftyJoker implements IJoker {
    @Override
    public void useJoker() {
        String rightAnswer = Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer();
        List<String> list = Arrays.asList(MainController.gameController.buttonA.getText(), MainController.gameController.buttonB.getText(), MainController.gameController.buttonC.getText(), MainController.gameController.buttonD.getText());
        int random = ThreadLocalRandom.current().nextInt(0, 4);
        int i = 0;
        while (i < 2) {
            System.out.println(random);
            switch (random) {
                case 0:
                    if (!list.get(0).equals(rightAnswer)) {
                        MainController.gameController.buttonA.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 1:
                    if (!list.get(1).equals(rightAnswer)) {
                        MainController.gameController.buttonB.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 2:
                    if (!list.get(2).equals(rightAnswer)) {
                        MainController.gameController.buttonC.setVisible(false);
                        i++;
                    }
                    random++;
                    break;
                case 3:
                    if (!list.get(3).equals(rightAnswer)) {
                        MainController.gameController.buttonD.setVisible(false);
                        i++;
                    }
                    random = 0;
                    break;
                default:

            }
        }
        MainController.gameController.fiftyJoker.setDisable(true);
    }


}

