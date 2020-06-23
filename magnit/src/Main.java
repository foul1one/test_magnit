import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws TransformerException, ParserConfigurationException, IOException, SAXException {

Insert Db = new Insert();
       Db.insert(); // вносим данные

       System.out.println("Данные внесены");

       SelectAndXMLcreate Db1 = new SelectAndXMLcreate();
       Db1.select(); // выводим данные

        Db1.xmlCreate(); // создаем 1.xml и наполняем его

        System.out.println(" ");
        System.out.println("Вышеперечисленные значения из таблицы 'TEST' добавлены в новосозданный файл '1.xml'");

        CreateXML2 xml2 = new CreateXML2(); // создаем 2.xml
        xml2.createXML2();

        System.out.println("Файл 2.xml создан");

        SummField sum = new SummField();
        sum.summField();



    }
}
