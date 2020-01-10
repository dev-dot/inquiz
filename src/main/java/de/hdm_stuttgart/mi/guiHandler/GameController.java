package de.hdm_stuttgart.mi.guiHandler;

import de.hdm_stuttgart.mi.classes.Game;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
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

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;
import static de.hdm_stuttgart.mi.guiHandler.MainController.selectedGameMode;

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
    @FXML
    public Button gameStats;
    @FXML
    public Button timeJoker;
    @FXML
    public Button skipJoker;
    @FXML
    public Button fiftyJoker;


    public void gameExitAction(ActionEvent actionEvent) throws IOException {
        sceneChanger("/fxml/StartWindow.fxml", actionEvent);
        game.setNewGame();
        resetJokers();
    }

    public void gameStatsAction(ActionEvent actionEvent) throws IOException {
        timer.pause();
        sceneChanger("/fxml/GameOverWindow.fxml", actionEvent);
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
        fiftyJoker.setDisable(true);
    }

    void setUserID(TextField label) {
        userID.setText(label.getText().toUpperCase());


    }

    void setQuestionWindow(int random) {
        questionLabel.setText(Game.quiz.getQuestions().get(random).getQuestionname());
        buttonA.setText(Game.quiz.getQuestions().get(random).getOptionA());
        buttonB.setText(Game.quiz.getQuestions().get(random).getOptionB());
        buttonC.setText(Game.quiz.getQuestions().get(random).getOptionC());
        buttonD.setText(Game.quiz.getQuestions().get(random).getOptionD());
        timer.stop();
        setTimer();
    }

    private Timeline timer = new Timeline();

    private void setTimer(){
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
                timeElapsed();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void fifty() {
        buttonB.setVisible(false);
        buttonC.setVisible(false);
    }

    public void clickButtonA() {
        validateAnswer(buttonA);
        roundCounterLabel.setText(setRoundCounter());

    }

    public void clickButtonB() {
        validateAnswer(buttonB);
        roundCounterLabel.setText(setRoundCounter());

    }

    public void clickButtonC() {
        validateAnswer(buttonC);
        roundCounterLabel.setText(setRoundCounter());

    }

    public void clickButtonD() {
        validateAnswer(buttonD);
        roundCounterLabel.setText(setRoundCounter());

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
        timeline.setOnFinished(event -> {
            try {
                nextRound();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void labelTransition(Label label) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), evt -> label.setVisible(false)),
                new KeyFrame(Duration.seconds(0.25), evt -> label.setVisible(true)));
        timeline.setCycleCount(3);
        timeline.play();
    }

    private void timeBarTransition(ProgressBar bar) {
        bar.setProgress(1);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), evt -> bar.setVisible(false)),
                new KeyFrame(Duration.seconds(0.4), evt -> bar.setVisible(true)));
        timeline.setCycleCount(3);
        timeline.play();
    }

    private void validateAnswer(Button button) {
        String buttonString = button.toString().substring(10, 17);
        switch (buttonString) {
            case "buttonA":
                log.info("selected answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionA());
                log.info("right answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionA().equals(Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonA);
                } else {
                    wrongAnswer(buttonA);
                }

                //resetButtons();
                break;
            case "buttonB":
                log.info("selected answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionB());
                log.info("right answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionB().equals(Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonB);
                } else {
                    wrongAnswer(buttonB);
                }

                //resetButtons();
                break;
            case "buttonC":
                log.info("selected answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionC());
                log.info("right answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionC().equals(Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
                    rightAnswer(buttonC);
                } else {
                    wrongAnswer(buttonC);
                }

                //resetButtons();
                break;
            case "buttonD":
                log.info("selected answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionD());
                log.info("right answer: " + Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer());
                if (Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getOptionD().equals(Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer())) {
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
        timer.stop();
        setButtonGreen(button);
        log.info("right");
        fadeTransition(button);
        game.setRightAnswerCounter();
    }

    private void wrongAnswer(Button button) {
        timer.stop();
        setButtonRed(button);
        log.info("wrong");
        fadeTransition(button);
        game.setWrongAnswerCounter();
    }

    private void timeElapsed() throws IOException {
        log.info("time elapsed");
        game.setWrongAnswerCounter();
        roundCounterLabel.setText(setRoundCounter());
        nextRound();
    }

    private void nextRound() throws IOException {
        game.setNextRound();
        roundCounterLabel.setText(setRoundCounter());
        log.info(game.getRoundCount());
        if (game.getRoundCount() < 10) {
            setQuestionWindow(game.getQuestionIndex(game.getRoundCount()));
            resetButtons();
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resetJokers();
            gameStats.fire();
        }
    }

    String setRoundCounter() {
        return String.format("%d/10", (game.getRoundCount() + 1));
    }

    public void clickTimeJoker(ActionEvent event) {
        setTimer();
        timeJoker.setDisable(true);
    }


    public void clickSkipJoker(ActionEvent event) throws IOException {
        nextRound();
        game.setRightAnswerCounter();
        skipJoker.setDisable(true);
    }

    private void resetJokers() {
        timeJoker.setDisable(false);
        skipJoker.setDisable(false);
    }
}