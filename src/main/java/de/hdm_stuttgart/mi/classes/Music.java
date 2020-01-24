package de.hdm_stuttgart.mi.classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


public class Music implements Runnable {

    public static MediaPlayer mediaPlayer;
    final Logger log = LogManager.getLogger(Music.class);

    public Music() {
    }


    public void run() {
        try {
            log.debug("Starting Music Thread!");
            String fileLocation = "src/main/resources/Music/Hypnotic-Puzzle4.mp3";
            Media hit = new Media(new File(fileLocation).toURI().toString());
            mediaPlayer = new MediaPlayer(hit);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.setVolume(0.4);

            log.info("Now playing Music!");
        } catch (Exception ignored) {

        }
    }
}
