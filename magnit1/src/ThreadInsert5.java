import java.sql.SQLException;
import java.sql.Statement;

public class ThreadInsert5 extends Thread{

    private String end = "end";
    private Statement stmt;

    public ThreadInsert5(Statement stmt) {
        this.stmt = stmt;
    }

    public void run() {
        try {
            for (int s=400_001; s <= 500_000; s++) {
                stmt.executeUpdate("insert into magnit.test (field) values (" + s + ");"); // вносим значения в таблицу test
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }
}
