package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameController extends Application {

    private static final Logger log = LogManager.getLogger(MainController.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/InGameWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/Style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 10);
        scene.getStylesheets().add(getClass().getResource("/Style/ingame.css").toExternalForm());
        MainController.setWindow(primaryStage, scene, log);
    }

    public static void main(String[] args) {
        launch(args);
    }
}