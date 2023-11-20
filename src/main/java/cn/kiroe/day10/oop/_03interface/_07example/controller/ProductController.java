package cn.kiroe.day10.oop._03interface._07example.controller;

import cn.kiroe.day10.oop._03interface._07example.model.Product;
import cn.kiroe.day10.oop._03interface._07example.service.ProductService;
import cn.kiroe.day10.oop._03interface._07example.service.impl.ProductServiceImpl;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 09:56 25/10/2023
 **/
public class ProductController {

    // 请求ps的功能
    // 需要ps作为成员变量
    private static ProductService service = new ProductServiceImpl();

    public List<Product> findAllProducts() {


        return service.findAllProduct();
    }

    public boolean createProduct(Product product) {

        return service.createProduct(product);
    }

    public Product findByProductId(int id) {
        return service.findByProductId(id);
    }

    public List<Product> findByProductName(String name) {
        return service.findByProductName(name);
    }

    public Product updateProductById(Product product) {
        return service.updateProductByid(product);
    }

    public boolean deleteByProductId(int id) {
        return service.deleteByProductId(id);
    }
}
