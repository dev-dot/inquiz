package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Launcher extends Application {


    private static final Logger log = LogManager.getLogger(Launcher.class);

    @Override
    public void start(Stage primaryStage) {


        Label label = new Label();
        label.setLayoutX(430);
        label.setText("inquiz");
        label.setTextFill(Color.BLUE);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/Style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 100));
        label.setOpacity(50);


        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(700));
        transition.setToY(250);
        transition.setNode(label);
        transition.setAutoReverse(true);
        transition.setCycleCount(3);
        transition.play();

        Pane root = new Pane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 1200, 750);


        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}