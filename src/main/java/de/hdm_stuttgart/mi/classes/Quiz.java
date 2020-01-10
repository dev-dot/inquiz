package de.hdm_stuttgart.mi.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

@XmlRootElement
public class Quiz {

    private ArrayList<Question>questions;
    private int[] indices = new int[10];
    private final Logger log = LogManager.getLogger(Quiz.class);
    public Quiz(){
    }

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }
    @XmlElement
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    int getLength() {
        return questions.size();
    }

    int[] getQuestionIndices() {

        log.info("a quiz indecies array was created");
        Random random = new Random();
        Quiz quiz = Game.getQuiz();

        return IntStream.iterate(random.nextInt(quiz.getLength()), i -> random.nextInt(quiz.getLength()))
                .distinct()
                .limit(10)
                .toArray();
    }
}

