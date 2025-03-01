package uk.ac.glos.CT5025.S1803267.scoring;

import java.io.File;

import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ScoreBoard {

  public void addScore(Score score) {
    try {

      // Create the XML document
      DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
      Document document = documentBuilder.parse("scores.xml");

      // Add the root XML element to the document
      Element root = document.getDocumentElement();

      // Create the score element
      Element newScore = document.createElement("score");
      newScore.appendChild(createChildElement(document, "name", score.getName()));
      newScore.appendChild(createChildElement(document, "score", ""+score.getScore())); // Convert int to String
      newScore.appendChild(createChildElement(document, "outcome", score.getOutcome()));

      root.appendChild(newScore);

      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult("scores.xml");

      // Where the autobots are made
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();

      // Set XML formatting
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
      
      // Autobots roll out. Send the XML to the file
      transformer.transform(source, result);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public Score[] getScoreBoard() {

    List<Score> scoreArray = new ArrayList<>();
    try {

      DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
      Document document = documentBuilder.parse("scores.xml");

      NodeList scores = document.getElementsByTagName("score");

      Score tempScoreObj;
      String tempName;
      int tempScore;
      String tempOutcome;
      for ( int i = 0; i<scores.getLength(); i++ ) {
        Node score = scores.item(i);
        if(score.getNodeType() == Node.ELEMENT_NODE) {
          Element scoreElement = (Element) score;
          try {
            tempName = scoreElement.getElementsByTagName("name").item(0).getTextContent();
            tempScore = Integer.parseInt(scoreElement.getElementsByTagName("score").item(0).getTextContent()); 
            tempOutcome = scoreElement.getElementsByTagName("outcome").item(0).getTextContent();
            tempScoreObj = new Score(tempName, tempScore, tempOutcome);
            scoreArray.add(tempScoreObj);      
          } catch (NullPointerException e) {
            System.out.println("Caught null pointer");
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    scoreArray = sortScores(scoreArray);

    return scoreArray.toArray(new Score[scoreArray.size()]);
  }

  public List<Score> sortScores(List<Score> scoreArray) {
    // Will sort a score array to Highest->Lowest
    // Uses a merge sort algorithm

    if ( scoreArray.size() == 1 ) {
      System.out.println("len 1");
      return scoreArray;
    } else if ( scoreArray.size() == 2 ) {
      if ( scoreArray.get(0).getScore() <  scoreArray.get(1).getScore() ) {
        Score tempScore = scoreArray.get(0);;
        scoreArray.remove(0);
        scoreArray.add(tempScore);
        return scoreArray;
      }
    } else {
      int cutPoint = scoreArray.size()/2;
      List<Score> head = new ArrayList<>();
      List<Score> tail = new ArrayList<>(); 

      int end = scoreArray.size()-1;
      tail.addAll(sortScores(scoreArray.subList(cutPoint, end)));
      scoreArray.subList(cutPoint, end).clear();
      head.addAll(sortScores(scoreArray));

      scoreArray.clear();

      while (!(head.isEmpty())) {
        while(!(tail.isEmpty())) {
          if ( head.get(0).getScore() > tail.get(0).getScore() ) {
            scoreArray.add(head.get(0));
            head.remove(0);
            break;
          } else {
            scoreArray.add(tail.get(0));
            tail.remove(0);
          }
        }
        if (!(head.isEmpty())) {
          scoreArray.addAll(head);
          head.clear();
        }
      }
      if (!(tail.isEmpty())) {
        scoreArray.addAll(tail);
      }
    }
    return scoreArray;
  }

  private Element createChildElement(Document document, String name, String value) {
    Element child = document.createElement(name);
    child.setTextContent(value);
    return child;
  }
}
