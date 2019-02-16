package project7;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
public class XSLT {
    public static void main ( String argv[] ) throws Exception {
	File stylesheet = new File("src/project7/math.xsl");
	File xmlfile  = new File("src/project7/reed.xml");
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db = dbf.newDocumentBuilder();
	Document document = db.parse(xmlfile);
	StreamSource stylesource = new StreamSource(stylesheet);
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer(stylesource);
	DOMSource source = new DOMSource(document);
	StreamResult result = new StreamResult(("src/project7/out.html"));
	transformer.transform(source,result);
	System.out.println("Please open the Out.Html file in a web browser to check the output.");
    }
}
