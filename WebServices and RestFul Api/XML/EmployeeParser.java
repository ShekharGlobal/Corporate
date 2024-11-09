import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeParser {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Parse the XML file
            String fileName = "employees.xml";
            Document doc = builder.parse(fileName);
            
            // Normalize XML structure
            doc.getDocumentElement().normalize();
            
            // Print employee details
            printEmployeeDetails(doc);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    /* This method iterates through employee nodes and prints each employee's details */
    public static void printEmployeeDetails(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("employee");
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                // Get attribute `id`
                String id = element.getAttribute("id");
                
                // Get elements by tag name
                String firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                String location = element.getElementsByTagName("location").item(0).getTextContent();

                // Print employee details
                System.out.println("Employee ID: " + id);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Location: " + location);
                System.out.println("-----------------------------");
            }
        }
    }
}
