import java.sql.Connection;
import java.sql.DriverManager;
public class TesteConexao{
    public static void main(String[] args) throws Exception {
        //jdbc:mysql://localhost:3306/20221_fatec_ipi_poo_pessoas?useTimezone=true&serverTimezone=UTC
        String host = "localhost";
        String port = "3306";
        String db = "20221_fatec_ipi_poo_pessoas";
        String user = "root";
        String password = "1234";

        String stringDeConexao = String.format(
            "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC",
            host,
            port,
            db
        );
        //cláusula catch or declare
        Connection conexao = DriverManager.getConnection(
            stringDeConexao,
            user,
            password
        );
        if (conexao != null)
            System.out.println("Conexão OK!");
        else
            System.out.println("Conexão NOK!");
    }
}