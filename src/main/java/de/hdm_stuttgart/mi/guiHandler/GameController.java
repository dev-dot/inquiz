package de.hdm_stuttgart.mi.guiHandler;

import de.hdm_stuttgart.mi.classes.AppTest;
import de.hdm_stuttgart.mi.classes.Game;
import de.hdm_stuttgart.mi.classes.Quiz;
import de.hdm_stuttgart.mi.gameModeFactory.Gamemode;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static de.hdm_stuttgart.mi.guiHandler.MainController.*;

public class GameController implements Initializable {

    private final Logger log = LogManager.getLogger(GameController.class);

    @FXML
    public Label userID;

    @FXML
    public Label questionLabel;
    @FXML
    public Button buttonA;
    @FXML
    public Button buttonB;
    @FXML
    public Button buttonC;
    @FXML
    public Button buttonD;
    @FXML
    public Label roundCounterLabel;
    @FXML
    public ProgressBar timeBar;

    private int roundCounter = 0;

    private AppTest appTest = new AppTest();






    public void gameExitAction(ActionEvent actionEvent) throws IOException {
        sceneChanger("/fxml/StartWindow.fxml", actionEvent);
    }

    public void gameStatsAction(ActionEvent actionEvent) throws IOException {
        sceneChanger("/fxml/Statistics.fxml", actionEvent);
    }

    //Other outsourced Functions
    private void sceneChanger(String xmlFIlePath, ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource(xmlFIlePath));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    void setUserID(TextField label) {
        userID.setText(label.getText().toUpperCase());
        quiz = parser.createQuestions();

    }

    void setQuestionWindow(int random) {
        questionLabel.setText(quiz.getQuestions().get(random).getQuestionname());
        buttonA.setText(quiz.getQuestions().get(random).getOptionA());
        buttonB.setText(quiz.getQuestions().get(random).getOptionB());
        buttonC.setText(quiz.getQuestions().get(random).getOptionC());
        buttonD.setText(quiz.getQuestions().get(random).getOptionD());
        setTimer();
    }


    private void setTimer(){
        Game game = new Game();
        int time = 3000; //TODO get Time

        Timeline timer = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        new KeyValue(timeBar.progressProperty(), 0)
                ),
                new KeyFrame(
                        Duration.millis(time),
                        new KeyValue(timeBar.progressProperty(), 1)
                )
        );
        timer.playFromStart();
        timer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               wrongAnswer(buttonA);
            }
        });
    }


    public void fifty(ActionEvent event) {
        buttonB.setVisible(false);
        buttonC.setVisible(false);
    }

    public void clickButtonA(ActionEvent event) {
        validateAnswer(buttonA);
        roundCounterLabel.setText(setRoundCounter());
        log.info(game.getRoundCount());
    }

    public void clickButtonB(ActionEvent event) {
        validateAnswer(buttonB);
        roundCounterLabel.setText(setRoundCounter());
        log.info(game.getRoundCount());
    }

    public void clickButtonC(ActionEvent event) {
        validateAnswer(buttonC);
        roundCounterLabel.setText(setRoundCounter());
        log.info(game.getRoundCount());
    }

    public void clickButtonD(ActionEvent event) {
        validateAnswer(buttonD);
        roundCounterLabel.setText(setRoundCounter());
        log.info(game.getRoundCount());
    }

    private void setButtonRed(Button button) {
        button.setStyle("-fx-background-color: #ff0000");
    }

    private void setButtonGreen(Button button) {
        button.setStyle("-fx-background-color: #00FF00");
    }

    private void resetButtons() {
        buttonA.setVisible(true);
        buttonB.setVisible(true);
        buttonC.setVisible(true);
        buttonD.setVisible(true);
        buttonA.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonB.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonC.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonD.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
    }

    private void fadeTransition(Button button) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), evt -> button.setVisible(false)),
                new KeyFrame(Duration.seconds(0.25), evt -> button.setVisible(true)));
        timeline.setCycleCount(3);
        timeline.play();
    }

    private void validateAnswer(Button button) {
        String buttonString = button.toString().substring(10, 17);
        switch (buttonString) {
            case "buttonA":
                log.info("selected answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionA());
                log.info("right answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionA().equals(quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonA);
                } else {
                    wrongAnswer(buttonA);
                }

                //resetButtons();
                break;
            case "buttonB":
                log.info("selected answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionB());
                log.info("right answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionB().equals(quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonB);
                } else {
                    wrongAnswer(buttonB);
                }

                //resetButtons();
                break;
            case "buttonC":
                log.info("selected answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionC());
                log.info("right answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionC().equals(quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonC);
                } else {
                    wrongAnswer(buttonC);
                }

                //resetButtons();
                break;
            case "buttonD":
                log.info("selected answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionD());
                log.info("right answer: " + quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionD().equals(quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonD);
                } else {
                    wrongAnswer(buttonD);
                }

                //resetButtons();
                break;
            default:
                log.info("Wrong");
                break;
        }
    }

    private void rightAnswer(Button button) {
        setButtonGreen(button);
        fadeTransition(button);
        game.setNextRound();
        log.info("right");
        if (game.getRoundCount() < 10) {
            setQuestionWindow(game.getQuestionIndex(game.getRoundCount()));
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    private void wrongAnswer(Button button) {
        setButtonRed(button);
        fadeTransition(button);
        game.setNextRound();
        log.info("wrong");
        if (game.getRoundCount() < 10) {
            setQuestionWindow(game.getQuestionIndex(game.getRoundCount()));
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    private String setRoundCounter() {
        return String.format("%d/10", game.getRoundCount());
    }
}