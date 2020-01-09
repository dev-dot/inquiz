package de.hdm_stuttgart.mi.jokerFactory;
import de.hdm_stuttgart.mi.guiHandler.GameController;
import de.hdm_stuttgart.mi.guiHandler.MainController;
import de.hdm_stuttgart.mi.interfaces.IJoker;

import java.util.Random;

public class FiftyFiftyJoker implements IJoker {
    @Override
    public void useJoker() {
        Random random = new Random();
        GameController gameController = new GameController();
        int questionIndex = MainController.game.getQuestionIndex(MainController.game.getRoundCount());
        char[] wrongAnswers = new char[3];
        int arrayIndex = 0;
        int pickedQuestion;
        int alreadyPicked;

        for (int i = 0; i <= 3; i++) {
            switch (i) {
                case 0:
                    if (!(MainController.quiz.getQuestions().get(questionIndex).getOptionA().equals(MainController.quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = 'a';
                        arrayIndex++;
                    }
                    break;
                case 1:
                    if (!(MainController.quiz.getQuestions().get(questionIndex).getOptionB().equals(MainController.quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = 'b';
                        arrayIndex++;
                    }
                    break;
                case 2:
                    if (!(MainController.quiz.getQuestions().get(questionIndex).getOptionC().equals(MainController.quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = 'c';
                        arrayIndex++;
                    }
                    break;
                case 3:
                    if (!(MainController.quiz.getQuestions().get(questionIndex).getOptionD().equals(MainController.quiz.getQuestions().get(questionIndex).getAnswer()))) {
                        wrongAnswers[arrayIndex] = 'd';
                    }
                    break;
            }
        }
        pickedQuestion = random.nextInt(3);
        alreadyPicked = pickedQuestion;


        pickedQuestion = random.nextInt(3);

        while (pickedQuestion==alreadyPicked){
            pickedQuestion = random.nextInt(3);
        }
    }


}

