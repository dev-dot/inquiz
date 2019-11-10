package de.hdm_stuttgart.mi.classes;

public class Statistic {
    private int rightAnswerCounter;
    private int wrongAnswerCounter;
    private double averageQuota;

    private void calculateQuota() {
    }

    public int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    public void setRightAnswerCounter(int rightAnswerCounter) {
        this.rightAnswerCounter = rightAnswerCounter;
    }

    public int getWrongAnswerCounter() {
        return wrongAnswerCounter;
    }

    public void setWrongAnswerCounter(int wrongAnswerCounter) {
        this.wrongAnswerCounter = wrongAnswerCounter;
    }
}
