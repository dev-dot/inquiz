package de.hdm_stuttgart.mi.guiHandler;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static javafx.util.Duration.seconds;


public class Launcher extends Application {


    private static final Logger log = LogManager.getLogger(Launcher.class);
    Button button;

    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle(String.valueOf(Color.BLUE));
        Label label = new Label();
        button = new Button("Hallo Welt");
        button.setOnAction(event -> {
            try {
                loadMainGui(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        button.setVisible(false);
        startSceneTimer();

        //button.setDisable(true);
        label.setLayoutX(430);
        label.setText("inquiz");
        label.setTextFill(Color.BLUE);
        label.setOpacity(50);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 100));


        FadeTransition fade = new FadeTransition(Duration.seconds(3), label);
        fade.setFromValue(0);
        fade.setToValue(100);
        fade.setAutoReverse(true);
        fade.play();

/*
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDelay(Duration.millis(1500));
        rotateTransition.setDuration(Duration.millis(900));
        rotateTransition.setByAngle(20000);
        rotateTransition.setNode(label);
        rotateTransition.play();
*/
        TranslateTransition transition = new TranslateTransition();
        transition.setDelay(Duration.millis(1500));
        transition.setDuration(Duration.millis(300));
        transition.setToY(250);
        transition.setNode(label);
        transition.setAutoReverse(true);
        // transition.setCycleCount(3);
        transition.play();


        Pane root = new Pane();
        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 1200, 750);


        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);

    }


    public void loadMainGui(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene launchMainView = new Scene(root);
        Stage gameStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        gameStage.setScene(launchMainView);
        Timeline t1 = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
        t1.getKeyFrames().add(kf);
        t1.play();
        gameStage.show();
    }

    private void startSceneTimer() {

        Timeline timeline = new Timeline(
                new KeyFrame(seconds(3)));
        timeline.play();
        timeline.setOnFinished(event -> button.fire());


    }
}