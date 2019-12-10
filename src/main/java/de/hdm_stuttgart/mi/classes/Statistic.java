package de.hdm_stuttgart.mi.classes;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

import static javax.xml.bind.JAXBContext.newInstance;

@XmlRootElement
public class Statistic {

    private String userGameID;
    private int rightAnswerCounter;
    private int wrongAnswerCounter;
    private int totalAnswer = rightAnswerCounter + wrongAnswerCounter;

    private double averageQuota;

    public Statistic(String userGameID) {
        this.userGameID = userGameID;
    }

    public Statistic() {
    }

    Statistic(String userGameID, int rightAnswerCounter, int wrongAnswerCounter) {
        this.userGameID = userGameID;
        this.rightAnswerCounter = rightAnswerCounter;
        this.wrongAnswerCounter = wrongAnswerCounter;
    }

    public void writeStatistic(Statistic customer) {
        try {

            File file = new File("src/main/resources/content/statistic.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Statistic.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    void readStatistic() {
        try {

            File file = new File("src/main/resources/content/statistic.xml");
            JAXBContext jaxbContext = newInstance(Statistic.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Statistic stats = (Statistic) jaxbUnmarshaller.unmarshal(file);
            System.out.println(stats.getUserGameID());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


    String getUserGameID() {
        return userGameID;
    }

    @XmlAttribute
    public void setUserGameID(String userGameID) {
        this.userGameID = userGameID.toUpperCase();
    }


    int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    @XmlElement
    public void setRightAnswerCounter(int rightAnswerCounter) {
        this.rightAnswerCounter = rightAnswerCounter;
    }


    int getWrongAnswerCounter() {
        return wrongAnswerCounter;
    }

    @XmlElement
    public void setWrongAnswerCounter(int wrongAnswerCounter) {
        this.wrongAnswerCounter = wrongAnswerCounter;
    }

    double getAverageQuota() {
        return averageQuota;
    }

    @XmlElement
    public void setAverageQuota(double averageQuota) {
        this.averageQuota = averageQuota;
    }

    public double calculateQuata() {
        return averageQuota = rightAnswerCounter / (wrongAnswerCounter + rightAnswerCounter);
    }
}
