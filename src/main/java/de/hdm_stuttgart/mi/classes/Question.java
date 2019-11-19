package de.hdm_stuttgart.mi.classes;

public class Question {

    private String questionElement;
    private String answer;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String category;

    public Question(String questionElement, String answer, String optionA, String optionB, String optionC, String optionD, String category) {
        this.questionElement = questionElement;
        this.answer = answer;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.category = category;
    }

    /*     Getter and Setter method     */





    /*     Class methods     */

    public boolean checkQuestion() {
        return true;
    }

    public void setQuestion() {
    }

    public void getQuestion() {
    }

}
