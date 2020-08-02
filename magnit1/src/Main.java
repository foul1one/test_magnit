import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String args[]) throws TransformerException, ParserConfigurationException, IOException, SAXException, SQLException, InterruptedException {

        System.out.println("Вношу данные в таблицу 'TEST'");
        long start = System.currentTimeMillis();

        InsertDB Db = new InsertDB();
        Db.insert(); // вносим данные

        System.out.println("Данные внесены в таблицу 'TEST'");

        CreateXML Db1 = new CreateXML();
        Db1.select(); // выводим данные

        Db1.xmlCreate(); // создаем 1.xml и наполняем его

        System.out.println("Значения таблицы 'TEST' добавлены в файл '1.xml'");

        TransformXML xml2 = new TransformXML(); // создаем 2.xml
        xml2.xmlTransform();

        System.out.println("Файл 2.xml создан, значения контекста field перенесены в атрибуты entry");

        SummField sum = new SummField();
        sum.summField();

        long finish = System.currentTimeMillis();
        float timeConsumedMillis = finish - start;
        int minute = (int) (timeConsumedMillis / 60_000);
        float second = (timeConsumedMillis - minute * 60_000) / 1000;
        System.out.println("Время выполнения программы: " + minute + " мин. " + second + " сек.");

    }
}