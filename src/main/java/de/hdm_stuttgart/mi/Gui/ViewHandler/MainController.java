package de.hdm_stuttgart.mi.Gui.ViewHandler;

import de.hdm_stuttgart.mi.classes.Game;
import de.hdm_stuttgart.mi.classes.Quiz;
import de.hdm_stuttgart.mi.classes.XMLParser;
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
import java.util.Stack;
import com.github.rage28.log4j2.slack.message.SlackLogMessage;
import com.github.rage28.log4j2.slack.model.SlackLog.SlackLogBuilder;

public class MainController extends Application {

    static XMLParser parser = new XMLParser();
    static Quiz quiz;

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

    public Label getGameUserID() {
        return gameUserID;
    }

    public void setGameUserID(Label gameUserID) {
        this.gameUserID = gameUserID;
    }

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
        log.error(new SlackLogMessage(SlackLogBuilder.builder()
                .withTitle("MainController")
                .withColor("red")
                .withText("Main Scene initialized")
                .build()));
        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> System.out.println(newSceneWidth));//log.info("Width: " + newSceneWidth));
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> System.out.println(newSceneHeight));//log.info("Height: " + newSceneHeight));
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
        sceneChanger("/fxml/Statistics.fxml", actionEvent);
    }

    @FXML
    public void mainEnterStartAction(ActionEvent actionEvent) throws IOException {
        validateUserName(actionEvent);
        launchGameWindow(actionEvent);
    }

    @FXML
    public void mainStartAction(ActionEvent actionEvent) throws IOException {
        validateUserName(actionEvent);
        launchGameWindow(actionEvent);
    }

    //Other outsourced Functions
    private void sceneChanger(String xmlFIlePath, ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource(xmlFIlePath));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }

    private void validateUserName(ActionEvent actionEvent) throws IOException {
        if (mainUserNameTextField.getText().length() > 0) {
            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setDelay(Duration.millis(1500));
            rotateTransition.setDuration(Duration.millis(900));
            rotateTransition.setByAngle(720);
            rotateTransition.setNode(gameUserID);
            rotateTransition.play();
        } else {
            mainUserNameHintLabel.setText("please enter a username");
            mainUserNameHintLabel.setTextFill(Color.web("#FF0000"));
        }
    }

    @FXML
    private void launchGameWindow(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InGameWindow.fxml"));
        try {
            Parent root = loader.load();
            GameController gameController = loader.getController();
            gameController.setGameWindow(mainUserNameTextField);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}