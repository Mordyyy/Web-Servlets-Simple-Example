package Products;

import DB.StoreDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductList {

    private HashMap<String, Product> products;   // key is product id, value is product

    public ProductList(){
        products = new HashMap<>();
    }

    public void addProduct(String id, Product product){
        products.put(id,product);
    }

    public Product getProduct(String id){
        return products.get(id);
    }

    public ArrayList<Product> getProductList(){
       ArrayList<Product> productList= new ArrayList<>();
        for(String key : products.keySet()){
            productList.add(products.get(key));
        }
        return productList;
    }
    public boolean isFilled(){
        return products.size() > 0;
    }

    public void fillProductList(HttpServletRequest request) throws SQLException {
        StoreDAO storeDAO = (StoreDAO) request.getServletContext().getAttribute("database");
        ResultSet resultSet = storeDAO.getResultSet();
        while(resultSet.next()){
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String image = resultSet.getString(3);
            double price = Double.parseDouble(resultSet.getString(4));
            Product product = new Product(id,name,image,price);
            products.put(id,product);
        }
    }
}
