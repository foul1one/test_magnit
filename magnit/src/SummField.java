import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class SummField {

    ArrayList<Integer> znachForSum = new ArrayList<Integer>(); // создаем список для хранения значение field

    public void summField () throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // создаем новый документ
        Document doc = db.parse("2.xml"); // парсим 2.xml

        Node entries = doc.getDocumentElement();

        NodeList xml1 = entries.getChildNodes();
        int b = xml1.getLength();

        for (int i = 0; i < b; i++) { // переносим значение атрибутов в ArrayList

            Node fieldNode = xml1.item(i);

            String a;
            if (fieldNode.getNodeType() == fieldNode.ELEMENT_NODE) {
                a = ((Element) fieldNode).getAttribute("field");
                int c = Integer.parseInt(a);
                znachForSum.add(c);
            }
        }

        int summa = 0;

        for (int i = 0; i < znachForSum.size(); i++) {
            summa += znachForSum.get(i);
        }

        System.out.println("Сумма значений всех атрибутов field = " + summa);

    }
}
