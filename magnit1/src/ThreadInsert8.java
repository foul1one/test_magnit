import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert8 extends Thread {

    private String end = "end";
    private Statement stmt;

    public ThreadInsert8(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=700_001; s <= 800_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
