package cn.kiroe.day10.oop._03interface._07example.views;

import cn.kiroe.day10.oop._03interface._07example.model.Product;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 10:02 25/10/2023
 **/
public class Views {

    public void  printProducts(List<Product> list){
        list.forEach(System.out::println);
    }
}
