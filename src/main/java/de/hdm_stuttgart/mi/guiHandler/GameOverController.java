package de.hdm_stuttgart.mi.guiHandler;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static de.hdm_stuttgart.mi.guiHandler.MainController.game;

public class GameOverController extends Application implements Initializable {
    private static final Logger log = LogManager.getLogger(MainController.class);

    @FXML
    private Label userID;

    @FXML
    private Label rightanswer;

    @FXML
    private Label wronganswer;

    @FXML
    private PieChart pieChart;

    @FXML
    private Label roundCounterLabel;


    public GameOverController() {
    }

    @FXML
    void gameExitAction(ActionEvent event) throws IOException {
        sceneChanger("/fxml/StartWindow.fxml", event);
        game.setNewGame();
    }

    @FXML
    void gameStatsAction(ActionEvent event) {
        //GameController.timer.playFrom(GameController.timer.getCurrentTime());
        //sceneChanger("/fxml/Game.fxml", event);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameOver.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/style/default.css").toExternalForm());

        MainController.setWindow(stage, scene, log);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        rightanswer.setText("Right Answers: " + game.getRightAnswerCounter());
        wronganswer.setText("Wrong Answers: " + game.getWrongAnswerCounter());


        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        PieChart.Data rightAnswers = new PieChart.Data("Right Answers", game.getRightAnswerCounter());
        PieChart.Data wrongAnswers = new PieChart.Data("Wrong Answers", game.getWrongAnswerCounter());


        list.addAll(rightAnswers, wrongAnswers);
        pieChart.setLegendVisible(false);
        pieChart.setData(list);

    }

    //Other outsourced Functions
    private void sceneChanger(String xmlFIlePath, ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource(xmlFIlePath));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }
}
