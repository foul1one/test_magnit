import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert1 extends Thread {

    private String end = "end";
    private Statement stmt;

    public ThreadInsert1(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=1; s <= 100_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}