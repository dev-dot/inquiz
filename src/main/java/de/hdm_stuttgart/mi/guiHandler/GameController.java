package de.hdm_stuttgart.mi.guiHandler;

import de.hdm_stuttgart.mi.classes.Animations;
import de.hdm_stuttgart.mi.classes.Game;
import de.hdm_stuttgart.mi.classes.Music;
import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.interfaces.IJoker;
import de.hdm_stuttgart.mi.jokerFactory.JokerFactory;
import javafx.animation.KeyFrame;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;

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
    @FXML
    public Button gameSoundButton;
    @FXML
    public ImageView gameSoundImage;

    private Timeline timer = new Timeline();
    public Image soundOffImage = new Image(getClass().getResourceAsStream("/media/icons/sound/off/sound_off@3x.png"));
    public Image soundOnImage = new Image(getClass().getResourceAsStream("/media/icons/sound/on/sound_on@3x.png"));

    public Animations animations = new Animations();

    //Initializing Scene
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameSoundImage.setImage(soundOffImage);
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
        animations.setTimer(timeBar);
    }

    //General Click Actions
    public void gameExitAction(ActionEvent actionEvent) throws IOException {
        sceneChanger("/fxml/StartWindow.fxml", actionEvent);
        game.setNewGame();
        Game.joker.reset(timeJoker, skipJoker, fiftyJoker);
    }

    public void gameStatsAction(ActionEvent actionEvent) throws IOException {
        timer.pause();
        sceneChanger("/fxml/GameOverWindow.fxml", actionEvent);
    }

    public void gameSoundAction(ActionEvent actionEvent) {
        if (gameSoundImage.getImage() == soundOffImage) {
            Music.mediaPlayer.play();
            gameSoundImage.setImage(soundOnImage);
        } else {
            Music.mediaPlayer.pause();
            gameSoundImage.setImage(soundOffImage);
        }
    }

    //Button Click Actions
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

    //Button/Answer Methods
    private void resetButtons() {
        buttonA.setVisible(true);
        buttonB.setVisible(true);
        buttonC.setVisible(true);
        buttonD.setVisible(true);
        buttonA.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonB.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonC.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        buttonD.setStyle("-fx-background-color: rgba(53, 53, 211, 0.7)");
        disableButtons(false);
    }

    private void setButtonRed(Button button) {
        button.setStyle("-fx-background-color: #F24343; -fx-text-fill: black");
    }

    private void setButtonGreen(Button button) {
        button.setStyle("-fx-background-color: #59E570; -fx-text-fill: black");
    }

    private void buttonAnimation(Button button) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.40), evt -> button.setVisible(true)));
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

    private void validateAnswer(Button button) {
        disableButtons(true);
        String rightAnswer = Game.quiz.getAnswer(game.getRoundCount());
        String buttonString = button.toString().substring(10, 17);
        switch (buttonString) {
            case "buttonA":
                log.info("selected answer: " + buttonA.getText());
                log.info("right answer: " + rightAnswer);
                if (buttonA.getText().equals(rightAnswer)) {
                    flashRightAnswer(buttonA);
                } else {
                    flashWrongAnswer(buttonA);
                }

                //resetButtons();
                break;
            case "buttonB":
                log.info("selected answer: " + buttonB.getText());
                log.info("right answer: " + rightAnswer);
                if (buttonB.getText().equals(rightAnswer)) {
                    flashRightAnswer(buttonB);
                } else {
                    flashWrongAnswer(buttonB);
                }

                //resetButtons();
                break;
            case "buttonC":
                log.info("selected answer: " + buttonC.getText());
                log.info("right answer: " + rightAnswer);
                if (buttonC.getText().equals(rightAnswer)) {
                    flashRightAnswer(buttonC);
                } else {
                    flashWrongAnswer(buttonC);
                }

                //resetButtons();
                break;
            case "buttonD":
                log.info("selected answer: " + buttonD.getText());
                log.info("right answer: " + rightAnswer);
                if (buttonD.getText().equals(rightAnswer)) {
                    flashRightAnswer(buttonD);
                } else {
                    flashWrongAnswer(buttonD);
                }

                //resetButtons();
                break;
            default:
                log.info("Wrong");
                break;
        }
    }

    private void flashRightAnswer(Button button) {
        timer.stop();
        setButtonGreen(button);
        log.info("right");
        buttonAnimation(button);
        game.setRightAnswerCounter();
    }

    private void flashWrongAnswer(Button button) {
        timer.stop();
        setButtonRed(button);
        log.info("wrong");
        buttonAnimation(button);
        game.setWrongAnswerCounter();
        showRightAnswer();
    }

    public void timeElapsed() throws IOException {
        log.info("time elapsed");
        game.setWrongAnswerCounter();
        roundCounterLabel.setText(setRoundCounter());
        nextRound();
    }

    public void nextRound() throws IOException {
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
            Game.joker.reset(timeJoker, skipJoker, fiftyJoker);
            gameStats.fire();
        }
    }

    String setRoundCounter() {
        return String.format("%d/10", (game.getRoundCount() + 1));
    }

    public void showRightAnswer() {
        String rightAnswer = Game.quiz.getQuestions().get(game.getQuestionIndex(game.getRoundCount())).getAnswer();

        if (buttonA.getText().equals(rightAnswer)) {
            setButtonGreen(buttonA);

        } else if (buttonB.getText().equals(rightAnswer)) {
            setButtonGreen(buttonB);

        } else if (buttonC.getText().equals(rightAnswer)) {
            setButtonGreen(buttonC);

        } else if (buttonD.getText().equals(rightAnswer)) {
            setButtonGreen(buttonD);
        } else {
            log.info("no right answer");
        }
    }

    private void disableButtons(boolean status) {
        buttonA.setDisable(status);
        buttonB.setDisable(status);
        buttonC.setDisable(status);
        buttonD.setDisable(status);
    }

    public void clickTimeJoker(ActionEvent event) throws IllegalFactoryArgument {
        //Game.joker.extraTime(timeJoker, timeBar);
        IJoker joker = JokerFactory.createJoker(IJoker.AvailableJoker.TIME);
        joker.useJoker();
        game.jokerUsedCounter();
        disableJoker();
    }

    public void clickSkipJoker(ActionEvent event) throws IOException, IllegalFactoryArgument {
        //Game.joker.skipQuestion(skipJoker);
        IJoker joker = JokerFactory.createJoker(IJoker.AvailableJoker.SKIP);
        joker.useJoker();
        game.jokerUsedCounter();
        disableJoker();
    }

    public void clickFiftyJoker(ActionEvent event) throws IllegalFactoryArgument {
        //Game.joker.fifty(buttonA, buttonB, buttonC, buttonD, fiftyJoker);
        IJoker joker = JokerFactory.createJoker(IJoker.AvailableJoker.FIFTYFIFTY);
        joker.useJoker();
        game.jokerUsedCounter();
        disableJoker();
    }

    private void disableJoker() {
        if (game.getRemainingJoker() == 0) {
            skipJoker.setDisable(true);
            fiftyJoker.setDisable(true);
            timeJoker.setDisable(true);
        }

    }

    //Scene Changer Helper Function
    private void sceneChanger(String xmlFIlePath, ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource(xmlFIlePath));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }

}