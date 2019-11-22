package de.hdm_stuttgart.mi.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class App {

    private static final Logger log = LogManager.getLogger(App.class);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        log.info("Application started");

        Game game = new Game();

        System.out.println("Choose your Nickname?");
        String nickname = input.nextLine();
        Player player = game.createNewPlayer(nickname);


        System.out.println("Choose your Level? \n 0 = Standard Mode \n 1 = Speed Mode \n 2 = Expert Mode");
        int gamemode=input.nextInt();


        game.setGamemode(gamemode);


        game.start();


    }
}
