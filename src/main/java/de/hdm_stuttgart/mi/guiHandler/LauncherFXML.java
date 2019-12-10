package de.hdm_stuttgart.mi.guiHandler;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LauncherFXML extends Application {
    private static final Logger log = LogManager.getLogger(LauncherFXML.class);


    @FXML
    private Label label;

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;


    @Override
    public void start(Stage primaryStage) {


    }

    public static void animationCircle(Circle circle) {
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDelay(Duration.millis(1500));
        rotateTransition.setDuration(Duration.millis(900));
        rotateTransition.setByAngle(720);
        rotateTransition.setNode(circle);
        rotateTransition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}