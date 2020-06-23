import java.sql.*;

public class Insert {

    private static final String url = "jdbc:mysql://localhost:3306/magnit";
    private static final String user = "admin";
    private static final String password = "123";
    private static Connection con;
    private static Statement stmt;

    public void insert() {

      try {
          con = DriverManager.getConnection(url, user, password); // подключаемся к БД
          stmt = con.createStatement();
          stmt.executeUpdate("truncate table test;"); // очищаем таблицу
          for (int s=1; s <= 100000/*Math.random()*100*/; s++) {
              stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
          }

      } catch (SQLException sqlEx) {
          sqlEx.printStackTrace();
      } finally {
          try { con.close(); } catch(SQLException se) {  }
          try { stmt.close(); } catch(SQLException se) {  }
      }

    }

}
