package support;
import nicebank.Account;
import org.javalite.activejdbc.Base;

public class TestDatabase {

    public TestDatabase() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/bank",
                    System.getenv("DB_USER"),
                    System.getenv("DB_PASSWORD")
            );
        }

        Account.deleteAll();
    }
}
