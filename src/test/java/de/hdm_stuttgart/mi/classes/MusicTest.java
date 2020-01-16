package de.hdm_stuttgart.mi.classes;

import org.junit.Assert;
import org.junit.Test;

public class MusicTest {
    Thread thread = new Thread(new Music());

    @Test
    public void testRunning(){
        thread.start();
        Assert.assertFalse(thread.isInterrupted());
        thread.interrupt();
    }
}
