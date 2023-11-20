package cn.kiroe.day10.oop._03interface._07example.model;

import java.util.Objects;

/**
 * @author kiro
 * @description:
 * @data 17:47 24/10/2023
 **/
public class Product {

    private int id;
    private String name;
    private double price;
    private String brand;
    private static int initId = 10000;

    {
        initId++;
        this.id = initId;

    }
    public Product(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public Product(int id, String name, double price, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void print(){
        System.out.println(this);
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
