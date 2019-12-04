package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainController extends Application {

    private static final Logger log = LogManager.getLogger(MainController.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont(getClass().getResourceAsStream("/Style/fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("/Style/default.css").toExternalForm());
        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> log.info("Width: " + newSceneWidth));
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> log.info("Height: " + newSceneHeight));
        primaryStage.setTitle("inquiz");
        primaryStage.setMinWidth(650);
        primaryStage.setMinHeight(650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}