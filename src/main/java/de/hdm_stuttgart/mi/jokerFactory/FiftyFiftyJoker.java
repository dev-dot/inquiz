package de.hdm_stuttgart.mi.jokerFactory;

import de.hdm_stuttgart.mi.classes.App;
import de.hdm_stuttgart.mi.classes.Quiz;
import de.hdm_stuttgart.mi.interfaces.IJoker;

import java.util.Random;

public class FiftyFiftyJoker implements IJoker {
    @Override
    public void useJoker() {
        App app = new App();
        Random random = new Random();
        Quiz quiz = app.getQuiz();
        int questionIndex = app.getRandomNumber();
        String[] wrongAnswers = new String[3];
        int arrayIndex = 0;
        int pickedQuestion;
        int answerIndex = -1;
        String prefix = "";

        for (int i = 0; i <= 3; i++) {
            switch (i) {
                case 0:
                    if (!(quiz.getQuestions().get(questionIndex).getOptionA().equals(quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = "A: " + quiz.getQuestions().get(questionIndex).getOptionA();
                        arrayIndex++;
                    } else {
                        answerIndex = 0;
                        prefix = "A: ";
                    }
                    break;
                case 1:
                    if (!(quiz.getQuestions().get(questionIndex).getOptionB().equals(quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = "B: " + quiz.getQuestions().get(questionIndex).getOptionB();
                        arrayIndex++;
                    } else {
                        answerIndex = 1;
                        prefix = "B: ";
                    }
                    break;
                case 2:
                    if (!(quiz.getQuestions().get(questionIndex).getOptionC().equals(quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = "C: " + quiz.getQuestions().get(questionIndex).getOptionC();
                        arrayIndex++;
                    } else {
                        answerIndex = 2;
                        prefix = "C: ";
                    }
                    break;
                case 3:
                    if (!(quiz.getQuestions().get(questionIndex).getOptionD().equals(quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = "D: " + quiz.getQuestions().get(questionIndex).getOptionD();
                    } else {
                        answerIndex = 3;
                        prefix = "D: ";
                    }
                    break;
            }
        }
        pickedQuestion = random.nextInt(3);
        if (pickedQuestion < answerIndex) {
            System.out.println(wrongAnswers[pickedQuestion]);
            System.out.println(prefix + quiz.getQuestions().get(questionIndex).getAnswer());
        } else {
            System.out.println(prefix + quiz.getQuestions().get(questionIndex).getAnswer());
            System.out.println(wrongAnswers[pickedQuestion]);
        }
    }
}
