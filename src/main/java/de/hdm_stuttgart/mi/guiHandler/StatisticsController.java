package de.hdm_stuttgart.mi.guiHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class StatisticsController extends Application {

    private static final Logger log = LogManager.getLogger(MainController.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Statistics.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 10);
        scene.getStylesheets().add(getClass().getResource("/style/ingame.css").toExternalForm());
        MainController.setWindow(primaryStage, scene, log);
    }



    public void gameExitAction(ActionEvent actionEvent) throws IOException {
        Parent gameView = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene gameViewScene = new Scene(gameView);
        Stage gameStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        gameStage.setScene(gameViewScene);
        gameStage.show();
    }

}
