package de.hdm_stuttgart.mi.jokerFactory;

import de.hdm_stuttgart.mi.guiHandler.GameController;
import de.hdm_stuttgart.mi.guiHandler.MainController;
import de.hdm_stuttgart.mi.interfaces.IJoker;

public class TimeJoker implements IJoker {
    @Override
    public void useJoker() {
        MainController.gameController.animations.setTimer(MainController.gameController.timeBar);
        MainController.gameController.timeJoker.setDisable(true);
    }
}
