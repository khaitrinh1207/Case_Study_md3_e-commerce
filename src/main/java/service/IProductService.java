package service;

import model.Product;

import java.util.List;

public interface IProductService {

    List<Product> selectAll();

    void findbyId(int id);

    void insertProduct(Product product);

    void editProduct(int id);

    void deleteProduct(int id);
}
