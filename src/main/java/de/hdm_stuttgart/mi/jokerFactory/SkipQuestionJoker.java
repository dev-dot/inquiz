package de.hdm_stuttgart.mi.jokerFactory;

import de.hdm_stuttgart.mi.guiHandler.MainController;
import de.hdm_stuttgart.mi.interfaces.IJoker;

import java.io.IOException;

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;

public class SkipQuestionJoker implements IJoker {
    @Override
    public void useJoker() {
        try {
            MainController.gameController.nextRound();
        } catch (IOException e) {
            e.printStackTrace();
        }
        game.setRightAnswerCounter();
        MainController.gameController.skipJoker.setDisable(true);
    }
}
