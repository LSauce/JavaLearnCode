package cn.kiroe.day10.oop._03interface._07example.service;

import cn.kiroe.day10.oop._03interface._07example.model.Product;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:04 25/10/2023
 **/
public interface ProductService {
    List<Product> findAllProduct();

    boolean createProduct(Product product);

    Product findByProductId(int id);

    List<Product> findByProductName(String name);

    Product updateProductByid(Product product);

    boolean deleteByProductId(int id);

    // 请求ProductService 的功能
    // 需要ProductService 的
}
