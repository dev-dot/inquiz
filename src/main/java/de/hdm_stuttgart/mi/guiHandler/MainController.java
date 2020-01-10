package de.hdm_stuttgart.mi.guiHandler;

import de.hdm_stuttgart.mi.classes.Game;
import de.hdm_stuttgart.mi.classes.Music;
import de.hdm_stuttgart.mi.classes.Quiz;
import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static de.hdm_stuttgart.mi.gameModeFactory.GamemodeFactory.createGameMode;

public class MainController extends Application {
    static de.hdm_stuttgart.mi.interfaces.IGamemode selectedGameMode;

   // static XMLParser parser = new XMLParser();
    public static Quiz quiz;
    public Thread thread = new Thread(new Music());

    public MainController() {

    }

    //Logger
    private static final Logger log = LogManager.getLogger(MainController.class);

    //Setting FXML Elements
    @FXML
    public Button mainStartButton;
    @FXML
    public TextField mainUserNameTextField;
    @FXML
    public ComboBox gameModeSelector;
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
    @FXML
    public Button mainGameRulesButton;

    private Stage gameRulesStage = new Stage();
    private VBox gameRulePane = new VBox();
    private Text gameRuleText = new Text();
    private Button gameRuleButton = new Button();
    private Scene gameRulesScene = new Scene( gameRulePane, 500, 300);

    public Label getGameUserID() {
        return gameUserID;
    }

    public void setGameUserID(Label gameUserID) {
        this.gameUserID = gameUserID;
    }

    public static Game game = new Game();




    //Setting Scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/style/default.css").toExternalForm());
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
    public void mainExitAction() {
        Runtime.getRuntime().exit(0);
    }

    @FXML
    public void mainStatsAction(ActionEvent actionEvent) throws IOException {
        sceneChanger("/fxml/Statistics.fxml", actionEvent);
    }

    @FXML
    public void mainEnterStartAction(ActionEvent actionEvent) {
        selectGameMode();
        launchGameWindow(actionEvent);
    }

    @FXML
    public void mainStartAction(ActionEvent actionEvent) {
        selectGameMode();
        launchGameWindow(actionEvent);
    }

    public void mainGameRulesAction() {
        gameRulePane.getChildren().clear();
        gameRulePane.getChildren().add(gameRuleText);
        gameRulePane.getChildren().add(gameRuleButton);
        gameRulePane.setAlignment(Pos.CENTER);
        gameRuleText.setTextAlignment(TextAlignment.CENTER);
        gameRuleText.setLineSpacing(10);
        gameRuleText.setFont(Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14));
        gameRuleText.setText(
                "GAMEMODES\n\n" +
                "Normal:\n" +
                "3 Jokers and 30 seconds per Question  \n" +
                "Speed:\n" +
                "2 Jokers and 20 seconds per Question \n" +
                "Expert:\n" +
                "1 Joker and 10 seconds per Question  \n"
                );
        gameRuleButton.setText("OK");
        gameRuleButton.setPrefWidth(30);
        gameRuleButton.setTextAlignment(TextAlignment.CENTER);
        gameRuleButton.setPadding(new Insets(4));
        gameRuleButton.setStyle("-fx-focus-color: transparent; fx-faint-focus-color: transparent; -fx-border-color: black; -fx-border-width: 0.75; -fx-border-radius: 5px; -fx-background-radius: 5px; -fx-background-insets: -1.4, 0, 1, 2; -fx-background-color: #f0f0f0!important;");
        gameRuleButton.setOnAction(e -> gameRulesStage.close());
        gameRulesStage.setTitle("Game Rules");
        gameRulesStage.setScene(gameRulesScene);
        gameRulesStage.centerOnScreen();
        gameRulesStage.setResizable(false);
        if (!(gameRulesStage.getModality() == Modality.APPLICATION_MODAL)){
            gameRulesStage.initModality(Modality.APPLICATION_MODAL);
            if (!gameRulesStage.isMaximized()){
                gameRulesStage.initStyle(StageStyle.UNDECORATED);
            }
        }
        gameRulesStage.show();
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
            //USER ID STILL NEEDS TO NE CHANGED !!!
            //String userIDString = mainUserNameTextField.getText();
            RotateTransition rotateTransition = new RotateTransition();
            rotateTransition.setDelay(Duration.millis(1500));
            rotateTransition.setDuration(Duration.millis(900));
            rotateTransition.setByAngle(720);
            rotateTransition.setNode(mainUserNameTextField);
            rotateTransition.play();
            sceneChanger("/fxml/InGameWindow.fxml", actionEvent);
        } else {
            mainUserNameHintLabel.setText("please enter a username");
            mainUserNameHintLabel.setTextFill(Color.web("#FF0000"));
        }
    }

    private void selectGameMode(){

        String mode = gameModeSelector.getValue().toString();
        switch (mode){
            case "standard":
                game.setGamemode(0);
                try {
                    selectedGameMode = createGameMode(IGamemode.Gamemodes.LEICHT);
                } catch (IllegalFactoryArgument illegalFactoryArgument) {
                    illegalFactoryArgument.printStackTrace();
                }
                break;
            case "speed":
                game.setGamemode(1);
                try {
                    selectedGameMode = createGameMode(IGamemode.Gamemodes.MITTEL);
                } catch (IllegalFactoryArgument illegalFactoryArgument) {
                    illegalFactoryArgument.printStackTrace();
                }
                break;
            case "expert":
                game.setGamemode(2);
                try {
                    selectedGameMode = createGameMode(IGamemode.Gamemodes.SCHWER);
                } catch (IllegalFactoryArgument illegalFactoryArgument) {
                    illegalFactoryArgument.printStackTrace();
                }
                break;
            default:
                log.info("Invalid GameMode");
        }
        log.info("GameMode set to " + mode);
    }

    @FXML
    private void launchGameWindow(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InGameWindow.fxml"));
        thread.start();
        try {
            Parent root = loader.load();
            GameController gameController = loader.getController();
            gameController.setUserID(mainUserNameTextField);
            gameController.roundCounterLabel.setText(gameController.setRoundCounter());
            gameController.setQuestionWindow(game.getQuestionIndex(game.getRoundCount()));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            log.info("Setting UserId: " + mainUserNameTextField.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}