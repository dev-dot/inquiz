package de.hdm_stuttgart.mi.classes;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuizTest {


    @Test
    public void testGetAnswer() {
        // Setup
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            // Run the test
            final String result = Game.quiz.getAnswer(i);

            // Verify the results
            if (Game.quiz.getQuestions().get(game.getQuestionIndex(i)).getOptionA().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(game.getQuestionIndex(i)).getOptionB().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(game.getQuestionIndex(i)).getOptionC().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(game.getQuestionIndex(i)).getOptionD().equals(result)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("No right answer found");
            }
        }
    }

    @Test
    public void testAllAnswers() {
        // Setup
        new Game();

        // Run the test
        for (int i = 0; i < Game.quiz.getLength(); i++) {
            final String result = Game.quiz.getQuestions().get(i).getAnswer();

            // Verify the results
            if (Game.quiz.getQuestions().get(i).getOptionA().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(i).getOptionB().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(i).getOptionC().equals(result)) {
                Assert.assertTrue(true);
            } else if (Game.quiz.getQuestions().get(i).getOptionD().equals(result)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("No right answer found");
            }
        }
    }

    @Test
    public void testGetNotNullLength() {
        // Setup
        new Game();
        // Run the test
        final int result = Game.quiz.getLength();

        // Verify the results
        Assert.assertTrue(result >= 0);
    }

    @Test
    public void testGetQuestionIndices() {
        // Setup
        new Game();
        // Run the test
        final int result = Game.quiz.getQuestionIndices().length;

        // Verify the results
        assertEquals("", 10, result);
    }
}
