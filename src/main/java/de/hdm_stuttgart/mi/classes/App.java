package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.guiHandler.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App extends Application {


    private static final Logger log = LogManager.getLogger(App.class);



    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        MainController mainController = new MainController();
        mainController.start(stage);

    }

}
