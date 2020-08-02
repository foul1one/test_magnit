import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert2 extends Thread {

    private Statement stmt;

    public ThreadInsert2(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=100_001; s <= 200_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
