import java.sql.*;

public class InsertDB {

    private static final String url = "jdbc:mysql://localhost:3306/magnit?useSSL=false";
    private static final String user = "admin";
    private static final String password = "123";

    public void insert() throws SQLException, InterruptedException {

          Connection con = DriverManager.getConnection(url, user, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("truncate table test;"); // очищаем таблицу

        for (int i = 1; i <= 1_000; i++) {
              stmt.executeUpdate("insert into magnit.test (field) values (" + i + ");"); // вносим значения в таблицу test
        }

          stmt.close();
          con.close();

    }

}