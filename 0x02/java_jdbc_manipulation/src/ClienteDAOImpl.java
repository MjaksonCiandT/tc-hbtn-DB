import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ClienteDAOImpl implements ClienteDAO{

    Connection conn = null;

    @Override
    public Connection connect(String urlConexao) {
        try {
            conn = DriverManager.getConnection(urlConexao);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }

    @Override
    public void createTable(String urlConexao) {
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS cliente (");
        sql.append("id integer PRIMARY KEY , ");
        sql.append("nome VARCHAR(100) NOT NULL, ");
        sql.append("idade INTEGER NOT NULL, ");
        sql.append("cpf VARCHAR(15) NOT NULL, ");
        sql.append("rg VARCHAR(20)");
        sql.append(")");

        try {
            connect(urlConexao);
            PreparedStatement stmt = conn.prepareStatement(String.valueOf(sql));
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        String sql = "INSERT INTO cliente(nome,idade, cpf, rg) VALUES(?,?,?,?)";
        try {
            connect(url_conexao);
            PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, cliente.getNome());
                pstmt.setInt(2, cliente.getIdade());
                pstmt.setString(3, cliente.getCpf());
                pstmt.setString(4, cliente.getRg());
                pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String sql = "SELECT * FROM Clientes";
        List<Cliente> clientes = new ArrayList<>();

        try {
            connect(urlConexao);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();
                cliente.setNome(result.getString("nome"));
                cliente.setIdade(result.getInt("idade"));
                cliente.setCpf(result.getString("CPF"));
                cliente.setRg(result.getString("RG"));

                clientes.add(cliente);
            }
            result.close();
            stmt.close();

            clientes.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sql = "UPDATE Clientes SET nome =?, idade = ? where id = ?";
        try {
            connect(urlConexao);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, idade);
            stmt.setInt(3, id);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE FROM Clientes where id = ?";

        try {
            connect(urlConexao);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
