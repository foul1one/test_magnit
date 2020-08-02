import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert4 extends Thread {

    private Statement stmt;

    public ThreadInsert4(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=300_001; s <= 400_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
