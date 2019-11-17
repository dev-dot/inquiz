package de.hdm_stuttgart.mi.classes;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class testParser{

    public static void main( String[] args ) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse( new File("src/main/resources/content/questions.xml") );
        System.out.println( document.getFirstChild().getTextContent() );
    }
}