package project7;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class Xpath {

	
	 public static void main(String[] args) {
	      
	      try {
	         File xmlFile = new File("src/project7/reed.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(xmlFile);
	         doc.getDocumentElement().normalize();
	         XPath xPath =  XPathFactory.newInstance().newXPath();
	         
	         //Query for question 1
	         
	         String query1 = "/root/course[subj='MATH']/place[building='LIB'and room='204']/../title";
	         NodeList FirstList = (NodeList) xPath.compile(query1).evaluate(doc, XPathConstants.NODESET);
	              for (int i = 0; i < FirstList.getLength(); i++) {
	                 System.out.println("<---Output for Question One: ---->");
	                 System.out.println("Query1 :" + FirstList.item(i).getTextContent());
	              }
	         
	         //Query for question 2
	         String query2 = "/root/course[subj='MATH' and crse='412']/instructor";
	         NodeList SecondList = (NodeList) xPath.compile(query2).evaluate(doc, XPathConstants.NODESET);
             for (int j = 0; j < SecondList.getLength(); j++) {
                
            	System.out.println("< ------ Output for Question Two: ----- >");
                System.out.println("Query2 :" + SecondList.item(j).getTextContent());
             }
	         
	         //Query for question 3
	         String query3 = "/root/course[instructor='Wieting']/title";
	         NodeList ThirdList = (NodeList) xPath.compile(query3).evaluate(doc, XPathConstants.NODESET);
             for (int k = 0; k < ThirdList.getLength(); k++) {
            	 System.out.println("< ------- Output for Question Three: ----- >");
                System.out.println("Query3 :" + ThirdList.item(k).getTextContent());
             }
	         
	      
	      }
	      catch (ParserConfigurationException e) {
	          e.printStackTrace();
	       } catch (SAXException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       }
	      catch (XPathExpressionException e) {
	          e.printStackTrace();
	       }
	     
	 }
}
