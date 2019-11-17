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

public class XMLParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, NullPointerException {

        File xmlfile = new File("src/main/resources/content/questions.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document xml = dBuilder.parse(xmlfile);
        NodeList nList = xml.getElementsByTagName("questionelement");
        int numberOfQuestions = nList.getLength();
        int questionIndex = 5;
        String selectedQuestion = "";
        String selectedAnswer = "";
        ArrayList<String> selectedOptions = new ArrayList<>();
        String selectedCategory = "";

        if(questionIndex < numberOfQuestions){

            ArrayList<String> inneroptions = new ArrayList<>();
            ArrayList<String> questions = new ArrayList<>();
            ArrayList<String> answers = new ArrayList<>();
            ArrayList<String> options = new ArrayList<>();
            ArrayList<String> category = new ArrayList<>();

            for (int i = 0; i < nList.getLength(); i++)
            {
                inneroptions.clear();
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    questions.add(eElement.getElementsByTagName("question").item(0).getTextContent());
                    answers.add(eElement.getElementsByTagName("answer").item(0).getTextContent());
                    inneroptions.add(eElement.getElementsByTagName("options").item(0).getTextContent());
                    options.addAll(inneroptions);
                    category.add(eElement.getElementsByTagName("category").item(0).getTextContent());
                }
            }

            System.out.println(questions.get(questionIndex));
            System.out.println(answers.get(questionIndex));
            System.out.println(options.get(questionIndex));
            System.out.println(category.get(questionIndex));
        }

    }
}