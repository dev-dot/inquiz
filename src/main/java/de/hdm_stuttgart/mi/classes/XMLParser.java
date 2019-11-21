/*
package de.hdm_stuttgart.mi.classes;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.util.ArrayList;
import java.util.Arrays;

public class XMLParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, NullPointerException {

        File xmlfile = new File("src/main/resources/content/questions.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document xml = dBuilder.parse(xmlfile);
        NodeList nList = xml.getElementsByTagName("questionElement");
        int numberOfQuestions = nList.getLength();
        int questionIndex = 5;
        String selectedQuestion = "";
        String selectedAnswer = "";
        ArrayList<String> selectedOptions = new ArrayList<>();
        String selectedCategory = "";

        if(questionIndex < numberOfQuestions){

            ArrayList<String> questions = new ArrayList<>();
            ArrayList<String> answers = new ArrayList<>();
            ArrayList<String> optionsA = new ArrayList<>();
            ArrayList<String> optionsB = new ArrayList<>();
            ArrayList<String> optionsC = new ArrayList<>();
            ArrayList<String> optionsD = new ArrayList<>();
            ArrayList<String> category = new ArrayList<>();

            for (int i = 0; i < nList.getLength(); i++)
            {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    questions.add(eElement.getElementsByTagName("question").item(0).getTextContent());
                    answers.add(eElement.getElementsByTagName("answer").item(0).getTextContent());
                    optionsA.add(eElement.getElementsByTagName("optionA").item(0).getTextContent());
                    optionsB.add(eElement.getElementsByTagName("optionB").item(0).getTextContent());
                    optionsC.add(eElement.getElementsByTagName("optionC").item(0).getTextContent());
                    optionsD.add(eElement.getElementsByTagName("optionD").item(0).getTextContent());
                    category.add(eElement.getElementsByTagName("category").item(0).getTextContent());
                }
            }

            selectedQuestion = questions.get(questionIndex);
            selectedAnswer = answers.get(questionIndex);
            selectedOptions.add(optionsA.get(questionIndex));
            selectedOptions.add(optionsB.get(questionIndex));
            selectedOptions.add(optionsC.get(questionIndex));
            selectedOptions.add(optionsD.get(questionIndex));
            selectedCategory = category.get(questionIndex);
            System.out.println(selectedQuestion);
            System.out.println(selectedAnswer);
            System.out.println(selectedOptions);
            System.out.println(selectedCategory);
        }
    }
}*/
