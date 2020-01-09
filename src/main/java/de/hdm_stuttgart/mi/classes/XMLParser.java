package de.hdm_stuttgart.mi.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

public class XMLParser {
    final Logger log = LogManager.getLogger(XMLParser.class);

    public Quiz createQuestions() {
        Quiz quiz;



        File file = new File("src/main/resources/content/questions.xml");


        try {
            JAXBContext jaxbContext = newInstance(Quiz.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            quiz = (Quiz) unmarshaller.unmarshal(file);
            log.info("Questions parsed successfully!");
            return quiz;


        } catch (JAXBException e) {
            e.printStackTrace();
        }


        return null;
    }

}