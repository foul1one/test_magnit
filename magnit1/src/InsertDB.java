import java.sql.*;

public class InsertDB {

    private static final String url = "jdbc:mysql://localhost:3306/magnit?useSSL=false";
    private static final String user = "admin";
    private static final String password = "123";

    public void insert() throws SQLException, InterruptedException {

          Connection con = DriverManager.getConnection(url, user, password);
          Statement stmt = con.createStatement();
          stmt.executeUpdate("truncate table test;"); // очищаем таблицу

          ThreadInsert1 thread1 = new ThreadInsert1(stmt);
          ThreadInsert2 thread2 = new ThreadInsert2(stmt);
          ThreadInsert3 thread3 = new ThreadInsert3(stmt);
          ThreadInsert4 thread4 = new ThreadInsert4(stmt);
          ThreadInsert5 thread5 = new ThreadInsert5(stmt);
          ThreadInsert6 thread6 = new ThreadInsert6(stmt);
          ThreadInsert7 thread7 = new ThreadInsert7(stmt);
          ThreadInsert8 thread8 = new ThreadInsert8(stmt);
          ThreadInsert9 thread9 = new ThreadInsert9(stmt);
          ThreadInsert10 thread10 = new ThreadInsert10(stmt);

          thread1.start();
          thread2.start();
          thread3.start();
          thread4.start();
          thread5.start();
          thread6.start();
          thread7.start();
          thread8.start();
          thread9.start();
          thread10.start();

          thread1.join();
          thread2.join();
          thread3.join();
          thread4.join();
          thread5.join();
          thread6.join();
          thread7.join();
          thread8.join();
          thread9.join();
          thread10.join();

          stmt.close();
          con.close();

    }

}