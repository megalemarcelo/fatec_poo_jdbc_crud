import java.sql.DriverManager;
import java.sql.Connection;
public class ConnectionFactory {
    private static String host = "localhost";
    private static String port = "3306";
    private static String db = "20221_fatec_ipi_poo_pessoas";
    private static String user = "root";
    private static String password = "1234";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(
            String.format(
                "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC",
                host,
                port,
                db
            ),
            user,
            password
        );
    }
}
