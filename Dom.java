package project7;
import javax.xml.parsers.*;
import org.w3c.dom.*;
//import java.net.URL;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


class Dom {
public static void main(String args[]) {		
		try {
			
			File xmlFile = new File("src/project7/reed.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document document = docBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			//System.out.println("Root Element : " + document.getDocumentElement().getNodeName());
			NodeList courseList = document.getElementsByTagName("course");
			for(int i = 0 ; i < courseList.getLength() ; i ++) {
				Node courseNode = courseList.item(i);
				if(courseNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cE = (Element) courseNode;
					if(cE.getElementsByTagName("subj").item(0).getTextContent().equals("MATH")) {
						NodeList placeList = cE.getElementsByTagName("place");
						for(int j = 0 ; j < placeList.getLength() ; j ++) {
							Node subjectNode = placeList.item(j);
							//System.out.println(subjectNode.getNodeName());
							if(subjectNode.getNodeType() == Node.ELEMENT_NODE) {
								Element element = (Element) subjectNode;
								Node placeNode = element.getElementsByTagName("building").item(0);
								Element placeElement = (Element) placeNode ;
								//System.out.println(element.getElementsByTagName("building").item(0).getTextContent());
								if(element.getElementsByTagName("building").item(0).getTextContent().equals("LIB") && element.getElementsByTagName("room").item(0).getTextContent().equals("204"))
								{
									System.out.println(cE.getElementsByTagName("title").item(0).getTextContent());
								}
								
						}	
					}
					}
				}
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}