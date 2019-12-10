package de.hdm_stuttgart.mi.classes;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class QuestionTest {

    Question tester = new Question();
    XMLParser parser = new XMLParser();
    Quiz quiz = parser.createQuestions();
    Random random = new Random();
    int randomNumber = random.nextInt(quiz.getLength());

    @Test
    public void testNotNullQuestion() {

        Assert.assertNotNull(tester);
    }

    @Test
    public void testCheckQuestion() {
        Assert.assertFalse(quiz.getQuestions().get(0).getOptionA() == "Georgia");
    }


}
