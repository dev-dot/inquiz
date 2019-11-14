package de.hdm_stuttgart.mi.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        Game game = new Game();

        game.start();
        log.info("game started");

    }
}
