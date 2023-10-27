package cn.kiroe.day10.oop._03interface._07example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 17:50 24/10/2023
 **/
// 模拟数据库,假的
public class ProductData {

    public static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        // 初始化 操作
        PRODUCTS.add(new  Product( "鼠标",199,"罗技"));
        PRODUCTS.add(new  Product( "键盘",1929,"罗技"));
        PRODUCTS.add(new  Product( "显示器",1991,"罗技"));
        PRODUCTS.add(new  Product( "笔记本",13399,"华硕"));
        PRODUCTS.add(new  Product( "本子",5,"得力"));
    }
}
