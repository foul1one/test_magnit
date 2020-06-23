import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreateXML2 {

    ArrayList<String>znachEntry = new ArrayList<String>(); // создаем список для хранения значение field

    public void createXML2() throws TransformerException, ParserConfigurationException, IOException, SAXException {

            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // создаем новый документ
            Document doc = db.parse("1.xml"); // парсим 1.xml

            Node entries = doc.getDocumentElement();

            NodeList xml1 = entries.getChildNodes();
            int b = xml1.getLength();

            for (int i = 0; i < b; i++) { // переносим Контет из field в ArrayList

                Node fieldNode = xml1.item(i);

                String a;
                if (fieldNode.getNodeType() == fieldNode.ELEMENT_NODE) {
                    a = ((Element) fieldNode).getTextContent();
                    znachEntry.add(a);
                }
                }

            Node del = doc.getElementsByTagName("entries").item(0);
            NodeList nodeList = del.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) { // Удаляем предыдущие записи

                Node nextNode = nodeList.item(i);

                if (nextNode.getNodeName().equals("entry")) {
                    del.removeChild(nextNode);
                }
            }

            for (int i = 0; i < znachEntry.size(); i++) { // создаем новые записи в нужном формате
                Element entry = doc.createElement("entry");
                int c = i + 1;
                String d = Integer.toString(c);
                entry.setAttribute("field", d);
                entries.appendChild(entry);
            }

            File file = new File("2.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));

    }
}