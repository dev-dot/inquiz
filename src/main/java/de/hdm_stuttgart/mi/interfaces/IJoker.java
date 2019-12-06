package de.hdm_stuttgart.mi.interfaces;

public interface IJoker {
    enum AvailableJoker{
        FIFTYFIFTY, TIME, SKIP;

        AvailableJoker(){}
    }

    void useJoker();
}
