package de.hdm_stuttgart.mi.classes;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Music implements Runnable{
    final Logger log = LogManager.getLogger(Music.class);
    private static  volatile boolean run = true;
    public Music() { }


    public void run()
    {
        log.info("Starting Music Thread!");
        String fileLocation = "src/main/resources/Music/JPB - What I Want [NCS Release].mp3";
        Media hit = new Media(new File(fileLocation).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        while(run){
            mediaPlayer.play();
        }


        log.info("Now playing Music!");
    }

    public synchronized void doStop (){
        run = false;
    }
}
