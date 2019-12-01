package de.hdm_stuttgart.mi.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Scanner;


public class App {

    private static final Logger log = LogManager.getLogger(App.class);
    private static final Scanner input = new Scanner(System.in);
    private static int roundCounter = 10;
    private static XMLParser parser = new XMLParser();
    private static Quiz quiz;
    private static boolean validAnswer=false;

    public static void main(String[] args) {

        log.info("Application started");

        Game game = new Game();
        Random random = new Random();

        System.out.println("Choose your Nickname?");
        String nickname = input.nextLine();
        Player player = game.createNewPlayer(nickname);


        System.out.println("Choose your Level? \n 0 = Standard Mode \n 1 = Speed Mode \n 2 = Expert Mode");
        int gamemode=input.nextInt();

        game.setGamemode(gamemode);
        game.start();

        quiz = parser.createQuestions();
        input.nextLine();

        while (roundCounter>0) {
            int randomNumber = random.nextInt(quiz.getLength() + 1);
            do {
                System.out.println();
                System.out.println(quiz.getQuestions().get(randomNumber).getQuestionname());
                quiz.getQuestions().get(randomNumber).getAllOptions();

                String answer = input.nextLine();

                switch (answer.toUpperCase()) {
                    case "A":
                        quiz.getQuestions().get(randomNumber).checkQuestion(quiz.getQuestions().get(randomNumber).getOptionA(), quiz.getQuestions().get(randomNumber).getAnswer());
                        validAnswer=true;
                        break;
                    case "B":
                        quiz.getQuestions().get(randomNumber).checkQuestion(quiz.getQuestions().get(randomNumber).getOptionB(), quiz.getQuestions().get(randomNumber).getAnswer());
                        validAnswer=true;
                        break;
                    case "C":
                        quiz.getQuestions().get(randomNumber).checkQuestion(quiz.getQuestions().get(randomNumber).getOptionC(), quiz.getQuestions().get(randomNumber).getAnswer());
                        validAnswer=true;
                        break;
                    case "D":
                        quiz.getQuestions().get(randomNumber).checkQuestion(quiz.getQuestions().get(randomNumber).getOptionD(), quiz.getQuestions().get(randomNumber).getAnswer());
                        validAnswer=true;
                        break;
                    default:
                        System.out.println("Please enter an valid Answer");

                }
            } while(!validAnswer);
        }
        roundCounter--;




    }
}
