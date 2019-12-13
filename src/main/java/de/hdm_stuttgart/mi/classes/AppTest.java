package de.hdm_stuttgart.mi.classes;

import de.hdm_stuttgart.mi.guiHandler.MainController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;

public class AppTest extends Application {


    private static final Logger log = LogManager.getLogger(App.class);
    private static final Scanner input = new Scanner(System.in);
    private static int roundCounter = 10;
    private static XMLParser parser = new XMLParser();
    static Random random = new Random();
    public int[] questionsIndices = new Quiz().getQuestionIndices();


    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        MainController mainController = new MainController();
        mainController.start(stage);

    }

}
