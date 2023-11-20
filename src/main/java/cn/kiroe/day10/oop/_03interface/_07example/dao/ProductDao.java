package cn.kiroe.day10.oop._03interface._07example.dao;

import cn.kiroe.day10.oop._03interface._07example.model.Product;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:11 25/10/2023
 **/
public interface ProductDao {

    List<Product> queryAllProducts();

    boolean createProduct(Product product);

    Product findByProductId(int id);

    List<Product> findByProductName(String name);

    Product updateProductByid(Product product);

    boolean deleteByProductId(int id);
}
