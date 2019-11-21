package de.hdm_stuttgart.mi.classes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TestRun {

    public static void main(String[] args){
        Quiz quiz = null;


        File file = new File("src/main/java/Test/question.xml");



        {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Quiz.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                quiz = (Quiz) unmarshaller.unmarshal(file);
            } catch (JAXBException e) {
                e.printStackTrace();
            }

            System.out.println(quiz.getQuestions().get(0).getAnswer());

        }


    }

}