package DB;

import Products.ProductList;

import java.sql.*;

public class StoreDAO {
    private Connection connection;
    public StoreDAO() throws SQLException {
        Connector connector = new Connector();
        connection = connector.getConnection();
        PreparedStatement st = connection.prepareStatement("use ass5;");
        st.executeQuery();
    }

    public ResultSet getResultSet() throws SQLException {
        PreparedStatement st = connection.prepareStatement("select * from products");
        ResultSet res = st.executeQuery();
        return res;
    }
}
