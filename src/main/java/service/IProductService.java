package service;

import model.Category;
import model.Shoes;

import java.util.List;

public interface IProductService {

    List<Shoes> selectAllShoes();

    List<Category> selectAllCate();

    List<Shoes> findByNameShoes(String name);

    List<Shoes> CategoryByID(String id);

    Shoes selectShoesById(String id);

    void insertProduct(Shoes shoes);

    void editProduct(int id);

    void deleteProduct(int id);
}
