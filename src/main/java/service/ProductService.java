package service;

import model.Category;
import model.Shoes;

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
    public List<Shoes> selectAllShoes() {
        List<Shoes> shoesList = new ArrayList<>();
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from product_shoes;");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_category = rs.getInt("id_category");
                String name = rs.getString("name_product");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String descripton = rs.getString("description");
                shoesList.add(new Shoes(id, id_category,name, price, image, descripton));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoesList;
    }

    @Override
    public List<Shoes> findByNameShoes(String nameSearch) {
        List<Shoes> listFindByName = new ArrayList<>();
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from shoes.product_shoes where name_product like ?");
            ps.setString(1,"%"+nameSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int id_category = rs.getInt("id_category");
                String name1 = rs.getString("name_product");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String descripton = rs.getString("description");
                listFindByName.add(new Shoes(id, id_category,name1, price, image, descripton));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listFindByName;
    }


    @Override
    public List<Category> selectAllCate() {
        List<Category> categories = new ArrayList<>();
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from shoes.category_shoes");
            rs = ps.executeQuery();
            while (rs.next()){
                int cate_id = rs.getInt("id");
                String cate_name = rs.getString("name_category");
                categories.add(new Category(cate_id,cate_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public List<Shoes> CategoryByID(String id) {
        List<Shoes> categoryShoes = new ArrayList<>();
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from shoes.product_shoes where id_category = ?");
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id1 = rs.getInt("id");
                int id_category = rs.getInt("id_category");
                String name1 = rs.getString("name_product");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String descripton = rs.getString("description");
                categoryShoes.add(new Shoes(id1, id_category,name1, price, image, descripton));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryShoes;
    }

    @Override
    public Shoes selectShoesById(String id) {
        Shoes shoes = null;
        try {
            conn = new SingletonConnection().getConnection();
            ps = conn.prepareStatement("select * from shoes.product_shoes where id = ?");
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                int id1 = rs.getInt("id");
                int id_category = rs.getInt("id_category");
                String name = rs.getString("name_product");
                int price = rs.getInt("price");
                String image = rs.getString("image");
                String descripton = rs.getString("description");
                shoes = new Shoes(id1, id_category,name, price, image, descripton);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoes;
    }

    @Override
    public void insertProduct(Shoes shoes) {

    }

    @Override
    public void editProduct(int id) {

    }

    @Override
    public void deleteProduct(int id) {

    }

}
