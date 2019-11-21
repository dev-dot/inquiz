package de.hdm_stuttgart.mi.classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

public class TestRun {

    public static void main(String[] args){
        Quiz quiz;


        File file = new File("src/main/resources/content/questions.xml");



        {
            try {
                JAXBContext jaxbContext = newInstance(Quiz.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                quiz = (Quiz) unmarshaller.unmarshal(file);
                System.out.println(quiz.getQuestions().get(0).getAnswer());


            } catch (JAXBException e) {
                e.printStackTrace();
            }

        }


    }

}