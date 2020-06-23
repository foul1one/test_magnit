import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class SelectAndXMLcreate {

    private static final String url = "jdbc:mysql://localhost:3306/magnit";
    private static final String user = "admin";
    private static final String password = "123";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    ArrayList<Integer> znachField = new ArrayList<Integer>(); // список для хранения данных таблицы

    public void select() {

        try {
        con = DriverManager.getConnection(url, user, password); // подключаемся к БД
        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from test;"); // запрос на вывод данных из БД
        while (rs.next()) {
            int field = rs.getInt(1); // присваем каждое значение таблицы переменное field
            System.out.print(field + " ");

            znachField.add(field); // добавляем значения таблицы в список
        }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {  }
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }

    }

    public void xmlCreate() throws TransformerException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document doc = factory.newDocumentBuilder().newDocument(); // создаем новый xml документ

        Element entries = doc.createElement("entries"); //назначаем тег entries
        doc.appendChild(entries);

        for (int a = 0; a < znachField.size(); a++) {

            String b = Integer.toString(znachField.get(a)); // переводим значения таблицы из списка в строки

            Element entry = doc.createElement("entry"); // создаем теги entry
            entries.appendChild(entry);

            Element field = doc.createElement("field"); // вкладываем в entry теги field
            field.setTextContent(b); // присваиваем значение контекста в field
            entry.appendChild(field);
        }

        File file = new File("1.xml");

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(file)); // сохраняем файл
    }

}
