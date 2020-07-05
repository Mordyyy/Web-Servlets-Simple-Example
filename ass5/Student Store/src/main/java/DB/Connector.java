package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    Connection con;
    private static final String url = "jdbc:mysql://localhost";
    private static final String username = "root";
    private static final String password = "password";

    public Connector() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return con;

    }
}
