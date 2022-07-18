import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    private final File myFile;
    ArrayList<String> CurrencyList = new ArrayList<>();
    ArrayList<Double> RateList = new ArrayList<>();

    Parser(File file) {
        this.myFile = file;
        init(myFile);
    }

    public void init(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList CubeNodeList = document.getElementsByTagName("Cube");

            for (int i = 0; i < CubeNodeList.getLength(); i++) {
                Node item = CubeNodeList.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element CubeElement = (Element) item;
                    String currency = CubeElement.getAttribute("currency");
                    String rate = CubeElement.getAttribute("rate");
                    if (currency.isEmpty() || rate.isEmpty()) System.out.print("");
                    else addToList(currency, Double.parseDouble(rate));
                }
            }
            /*System.out.println(currencyy);
            System.out.println(ratee);*/
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void addToList(String currency, double rate){
        CurrencyList.add(currency);
        RateList.add(rate);
    }
}
