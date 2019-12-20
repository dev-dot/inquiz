package de.hdm_stuttgart.mi.guiHandler;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    void gameExitAction(ActionEvent event) {

    }

    @FXML
    void gameStatsAction(ActionEvent event) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameOverWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/style/default.css").toExternalForm());

        MainController.setWindow(stage, scene, log);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        rightanswer.setText("Right Answers: " + game.getRightAnswerCounter());
        wronganswer.setText("Wrong Answers: " + game.getWrongAnswerCounter());


        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        PieChart.Data rightAnswers = new PieChart.Data("Right Answers", game.getRightAnswerCounter() + 7);
        PieChart.Data wrongAnswers = new PieChart.Data("Wrong Answers", game.getWrongAnswerCounter() + 3);


        list.addAll(rightAnswers, wrongAnswers);
        pieChart.setLegendVisible(false);
        pieChart.setData(list);

    }


}
