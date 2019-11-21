package de.hdm_stuttgart.mi.interfaces;

public interface IGamemode {

    enum Gamemodes {
        LEICHT, MITTEL, SCHWER;


     Gamemodes(){}

    }
    int getJokerCounter();
    int getRemainingTime();

}
