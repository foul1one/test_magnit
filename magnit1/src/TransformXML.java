import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TransformXML {

    public void xmlTransform() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("transform.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("1.xml"));
        transformer.transform(xml, new StreamResult(new File("2.xml")));
    }
}