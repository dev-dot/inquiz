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

public class XMLParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlfile = new File("src/main/resources/content/questions.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document xml = dBuilder.parse(xmlfile);
        xml.getDocumentElement().normalize();
        Element root = xml.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nList = xml.getElementsByTagName("questionelement");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node node = nList.item(i);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                System.out.println("Question :"  + eElement.getElementsByTagName("question").item(0).getTextContent());
                System.out.println("Answer : "   + eElement.getElementsByTagName("answer").item(0).getTextContent());
                System.out.println("Options : "    + eElement.getElementsByTagName("options").item(0).getTextContent());
                System.out.println("Category : "    + eElement.getElementsByTagName("category").item(0).getTextContent());
            }
        }
    }
}