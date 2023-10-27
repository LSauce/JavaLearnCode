package cn.kiroe.day10.oop._03interface._07example.dao.impl;

import cn.kiroe.day10.oop._03interface._07example.dao.ProductDao;
import cn.kiroe.day10.oop._03interface._07example.model.Product;
import cn.kiroe.day10.oop._03interface._07example.model.ProductData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kiro
 * @description:
 * @data 10:11 25/10/2023
 **/
public class ProductDaoImpl implements ProductDao {
    // 模拟数据库的数据源
    private static List<Product> products = ProductData.PRODUCTS;

    @Override
    public List<Product> queryAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public boolean createProduct(Product product) {
        if (products.contains(product)) {
            return false;
        }

        //插入数据
        products.add(product);
        return true;
    }

    @Override
    public Product findByProductId(int id) {
        // 在 集合中查询 id
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByProductName(String name) {
        List<Product> productList = new ArrayList<>();
        //查询操作，可使用sql
      /*  for (Product product : products) {
            if (product.getName().contains(name)) {
                productList.add(product);
            }
        }*/
        // 看参

        return products.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public Product updateProductByid(Product product) {
        for (Product product1 : products) {
            if(product1.equals(product) ){
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setBrand(product.getBrand());
                return  product1;
            }
        }
        return null;
    }

    @Override
    public boolean deleteByProductId(int id) {
        for (Product product : products) {
            // 根据id查找
            if(product.getId() == id){
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
