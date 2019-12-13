package de.hdm_stuttgart.mi.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@XmlRootElement
public class Quiz {

    private ArrayList<Question>questions;

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

    int[] getQuestionIndices (){
        int[] indices = new int [10];
        Random random = new Random();
        XMLParser xmlParser = new XMLParser();
        Quiz quiz = xmlParser.createQuestions();

        for(int i=0; i<10; i++){
            int randomNumber = random.nextInt(quiz.getLength());
            indices[i] = randomNumber;
            for (int j = 1 ; j<=i - 1; j++){
                if (randomNumber == indices[j-1]){
                    indices[i] = 0;
                    i--;
                    break;
                }
            }
        }
        return indices;
    }
}

