package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 2017-02-06.
 */
public class DomParser {
    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    public DomParser() {
        words = new ArrayList<>();
        try {
            File inputFile = new File("thesaurus-sv.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.print("Loading synonyms from ");
            System.out.println(doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("syn");
            System.out.println("There is " + nList.getLength() + " synonyms");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double level = Double.valueOf(eElement.getAttribute("level"));
                    NodeList wordList = eElement.getElementsByTagName("w1");
                    Node w1 = wordList.item(0);
                    NodeList wordList2 = eElement.getElementsByTagName("w2");
                    Node w2 = wordList2.item(0);
                    words.add(new Word(w1.getTextContent(), w2.getTextContent(), level));
                } else {
                    System.out.println("icke!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
