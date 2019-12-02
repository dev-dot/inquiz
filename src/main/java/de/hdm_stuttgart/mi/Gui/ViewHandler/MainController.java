package de.hdm_stuttgart.mi.Gui.ViewHandler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/StartWindow.fxml"));
        Scene scene = new Scene(root);
        javafx.scene.text.Font.loadFont("fonts/Source_Code_Pro/SourceCodePro-ExtraLight.ttf", 200);
        scene.getStylesheets().add(getClass().getResource("/Style/default.css").toExternalForm());
        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> System.out.println("Width: " + newSceneWidth));
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> System.out.println("Height: " + newSceneHeight));
        primaryStage.setTitle("inquiz");
        primaryStage.setMinWidth(340);
        primaryStage.setMinHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}