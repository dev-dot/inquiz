package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
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
        label.setOpacity(50);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/Style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 100));


        FadeTransition fade = new FadeTransition(Duration.millis(3000), label);
        fade.setFromValue(0);
        fade.setToValue(100);
        fade.play();


        TranslateTransition transition = new TranslateTransition();
        transition.setDelay(Duration.millis(1500));
        transition.setDuration(Duration.millis(300));
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