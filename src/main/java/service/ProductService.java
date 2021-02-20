package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from category;");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name_shoes");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String title = rs.getString("title");
                String descripton = rs.getString("description");
                productList.add(new Product(id, name, image, price, title, descripton));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void findbyId(int id) {

    }

    @Override
    public void insertProduct(Product product) {

    }

    @Override
    public void editProduct(int id) {

    }

    @Override
    public void deleteProduct(int id) {

    }

}
