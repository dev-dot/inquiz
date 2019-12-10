package de.hdm_stuttgart.mi.guiHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static de.hdm_stuttgart.mi.guiHandler.MainController.parser;
import static de.hdm_stuttgart.mi.guiHandler.MainController.quiz;

public class GameController implements Initializable {

    private static final Logger log = LogManager.getLogger(MainController.class);

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
    }


    public void fifty(ActionEvent event) {
        buttonB.setVisible(false);
        buttonC.setVisible(false);
    }
}