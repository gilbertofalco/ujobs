package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gilberto
 */
public class Conexao {
    
    public Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ujobs", "postgres", "277798");
        return con;
    }
}
