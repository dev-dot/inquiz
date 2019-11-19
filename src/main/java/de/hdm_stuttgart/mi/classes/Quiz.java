package de.hdm_stuttgart.mi.classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
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
}

