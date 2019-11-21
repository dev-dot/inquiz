package de.hdm_stuttgart.mi.GameModeFactory;

import de.hdm_stuttgart.mi.interfaces.IGamemode;

public class Gamemode implements IGamemode {
    private int jokerCounter;
    private int remainingTime;

    public Gamemode(int jokerCounter, int remainingTime) {
        this.jokerCounter = jokerCounter;
        this.remainingTime = remainingTime;
    }

    public int getJokerCounter() {
        return jokerCounter;
    }

    public void setJokerCounter(int jokerCounter) {
        this.jokerCounter = jokerCounter;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
