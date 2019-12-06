package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class MainController extends Application {

    //Logger
    private static final Logger log = LogManager.getLogger(MainController.class);

    //Setting FXML Elements
    @FXML
    public Button mainStartButton;
    @FXML
    public TextField mainUserNameTextField;
    @FXML
    public Button mainStatsButton;
    @FXML
    public Button mainExitButton;
    @FXML
    public Label mainUserNameHintLabel;
    @FXML
    public Label userID;
    @FXML
    public Label gameUserID;

    //Setting Scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/Style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/Style/default.css").toExternalForm());
        setWindow(primaryStage, scene, log);
    }

    //Setting Stage
    static void setWindow(Stage primaryStage, Scene scene, Logger log) {

        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> log.debug("Width: " + newSceneWidth));
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> log.debug("Height: " + newSceneHeight));
        primaryStage.setTitle("inquiz");
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Starting Stage
    public static void main(String[] args) {
        launch(args);
    }

    //Event Handler
    @FXML
    public void mainExitAction(ActionEvent actionEvent) {
        Runtime.getRuntime().exit(0);
    }

    @FXML
    public void mainStatsAction(ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource("/fxml/Statistics.fxml"));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }

    @FXML
    public void mainEnterStartAction(ActionEvent actionEvent) throws IOException {
        validateUserName(actionEvent);
    }

    @FXML
    public void mainStartAction(ActionEvent actionEvent) throws IOException {
        validateUserName(actionEvent);
    }

    //Other outsourced Functions
    private void validateUserName(ActionEvent actionEvent) throws IOException {
        if (mainUserNameTextField.getText().length() > 0) {
            //USER ID STILL NEEDS TO NE CHANGED !!!
            //String userIDString = mainUserNameTextField.getText();
            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setDelay(Duration.millis(1500));
            rotateTransition.setDuration(Duration.millis(900));
            rotateTransition.setByAngle(720);
            rotateTransition.setNode(gameUserID);
            rotateTransition.play();
            Parent gameView = FXMLLoader.load(getClass().getResource("/fxml/InGameWindow.fxml"));
            Scene gameViewScene = new Scene(gameView);
            Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            gameStage.setScene(gameViewScene);
            gameStage.show();
        } else {
            mainUserNameHintLabel.setText("please enter a username");
            mainUserNameHintLabel.setTextFill(Color.web("#FF0000"));
        }
    }
}