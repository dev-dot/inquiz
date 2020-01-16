package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.guiHandler.GameController;
import de.hdm_stuttgart.mi.guiHandler.MainController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.io.IOException;

import static de.hdm_stuttgart.mi.guiHandler.MainController.selectedGameMode;

public class Animations {

    GameController gameController = MainController.gameController;
    private Timeline timer = new Timeline();

    public void setTimer(ProgressBar timeBar){
        int time = selectedGameMode.getRemainingTime();
        timer.getKeyFrames().removeAll();
        KeyValue kV1 = new KeyValue(timeBar.progressProperty(), 0);
        KeyValue kV2 = new KeyValue(timeBar.progressProperty(), 1);
        KeyFrame kF1 = new KeyFrame(Duration.ZERO, kV1);
        KeyFrame kF2 = new KeyFrame(Duration.millis(time), kV2);
        timer.getKeyFrames().add(kF1);
        timer.getKeyFrames().add(kF2);
        timer.playFromStart();
        timer.setOnFinished(event -> {
            try {
                gameController.timeElapsed();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
