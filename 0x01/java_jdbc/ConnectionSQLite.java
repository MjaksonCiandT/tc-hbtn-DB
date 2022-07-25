import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public static void main(String[] args) {
        initConnection();
    }

    public static void initConnection(){
        Connection conectar = null;
        try {
            String url = "jdbc:sqlite:sqlite_database_2022.db";
            conectar = DriverManager.getConnection(url);
            System.out.print("Conectado");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conectar != null) {
                    conectar.close();
                    System.out.print("Desconectado");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}