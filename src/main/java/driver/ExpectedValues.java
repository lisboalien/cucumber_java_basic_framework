package driver;

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
 * Created by aline on 15/08/2016.
 * Class that contains the methods that reads a xml file and gets the value you want from the file
 */
public class ExpectedValues {
    private String name;
    private String value;
    private static String language = new PropertyReader().readProperty("language");

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static List<ExpectedValues> expectedValuesList(String filePath) {
        List<ExpectedValues> expectedValues = new ArrayList<ExpectedValues>();

        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("value");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    ExpectedValues expectedValue = new ExpectedValues();

                    expectedValue.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    if (language.equals("pt-br")) {
                        expectedValue.setValue(eElement.getElementsByTagName("pt-br").item(0).getTextContent());
                    } else if (language.equals("en-us")) {
                        expectedValue.setValue(eElement.getElementsByTagName("en-us").item(0).getTextContent());
                    } else if (language.equals("fr")) {
                        expectedValue.setValue(eElement.getElementsByTagName("fr").item(0).getTextContent());
                    } else if (language.endsWith("de")) {
                        expectedValue.setValue(eElement.getElementsByTagName("de").item(0).getTextContent());
                    } else if (language.endsWith("nl")) {
                        expectedValue.setValue(eElement.getElementsByTagName("nl").item(0).getTextContent());
                    }
                    expectedValues.add(expectedValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expectedValues;
    }

    public static String getSpecificValue(String name, List<ExpectedValues> expectedValues) {
        String specificValue = null;
        try {
            for (int i = 0; i <= expectedValues.size(); i++) {
                if (name.equals(expectedValues.get(i).getName())) {
                    specificValue = expectedValues.get(i).getValue();
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This value doesn't exist. Error " + e.getMessage());
        }
        return specificValue;
    }
}
