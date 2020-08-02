import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert7 extends Thread {

    private String end = "end";
    private Statement stmt;

    public ThreadInsert7(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=600_001; s <= 700_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
