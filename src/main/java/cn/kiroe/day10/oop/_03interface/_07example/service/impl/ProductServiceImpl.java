package cn.kiroe.day10.oop._03interface._07example.service.impl;

import cn.kiroe.day10.oop._03interface._07example.dao.ProductDao;
import cn.kiroe.day10.oop._03interface._07example.dao.impl.ProductDaoImpl;
import cn.kiroe.day10.oop._03interface._07example.model.Product;
import cn.kiroe.day10.oop._03interface._07example.service.ProductService;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:05 25/10/2023
 **/
public class ProductServiceImpl implements ProductService {
    // 从dao层获取数据
   private ProductDao dao =   new ProductDaoImpl();
    @Override
    public List<Product> findAllProduct() {

        return dao.queryAllProducts();
    }

    @Override
    public boolean createProduct(Product product) {
        return dao.createProduct(product);
    }

    @Override
    public Product findByProductId(int id) {

        return dao.findByProductId(id);
    }

    @Override
    public List<Product> findByProductName(String name) {
        return dao.findByProductName(name);
    }

    @Override
    public Product updateProductByid(Product product) {
        return dao.updateProductByid(product);
    }

    @Override
    public boolean deleteByProductId(int id) {
        return dao.deleteByProductId(id);
    }
}
