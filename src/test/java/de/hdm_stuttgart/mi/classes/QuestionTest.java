package de.hdm_stuttgart.mi.classes;

import org.junit.Assert;
import org.junit.Test;

public class QuestionTest {


    @Test
    public void testNotNullQuestion() {

        // Setup
        Question question = new Question();

        // Verify the results
        Assert.assertNotNull("question array is null", question);

    }

    @Test
    public void testNullQuestionVariables() {

        // Setup
        Question question = new Question();

        // Verify the results
        Assert.assertNull("question answer is not null", question.getAnswer());
        Assert.assertNull("question optionA is not null", question.getOptionA());
        Assert.assertNull("question optionB is not null", question.getOptionB());
        Assert.assertNull("question optionC is not null", question.getOptionC());
        Assert.assertNull("question optionD is not null", question.getOptionD());
        Assert.assertNull("question questionname is not null", question.getQuestionname());
        Assert.assertNull("question category is not null", question.getCategory());

    }

}
