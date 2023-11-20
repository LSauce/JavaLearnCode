package cn.kiroe.day10.oop._03interface._07example;

import cn.kiroe.day10.oop._03interface._07example.controller.ProductController;
import cn.kiroe.day10.oop._03interface._07example.model.Product;
import cn.kiroe.day10.oop._03interface._07example.views.Views;

import java.util.List;

/**
 * @author kiro
 * @description:
 * @data 17:54 24/10/2023
 **/

// 整体流程
/*
<span style='color:red;background:yellow;font-size:文字大小;font-family:字体;'>**(重要)**</span>某电商系统后台，前端程序员需要后端程序员，提供接口来完成商品的管理，展示页面。假如前后端商量好，要求能实现CRUD操作, 采用MVC分层思想, 业务逻辑如下:

- 展示全部商品（Products）页面时，将仅装有商品对象的数组返回，前端不提供任何数据。
- 新增商品时，前端提供商品各种参数，后端需要校验ID唯一性，然后将对象插入数组，返回插入结果(true/false)。
- 查询商品, 前端提供商品ID或者商品名称(可根据ID查询或者根据商品名称查询), 后端根据信息查询商品详情, 并返回结果(商品对象)
- 更新商品(每次更新商品中的一个信息即可), 前端提供要被更新的商品ID, 以及新的产品信息(可以用数组的形式存储新的产品信息), 后端根据商品ID找到该商品, 并将新的信息替换, 返回该商品对象.
- 删除商品时，前端提供商品ID，后端将该商品删除后，返回删除结果。（成功返回true，根据ID找不到该商品即删除失败返回false）

*/
public class ProductTest {
    private static ProductController controller = new ProductController();


    public static void main(String[] args) {

        System.out.println("查询所有商品");
        findAllProducts();
        System.out.println("新增商品");
        createProduct();
        System.out.println("查询所有商品");
        findAllProducts();

        System.out.println("- 查询商品, 根据id");
        findByProductId();

        System.out.println("- 查询商品，根据商品名");
        findByProductName();

        System.out.println("- 更新商品,根据商品id");
        updateProductById();

        System.out.println("- 删除商品，根据商品id");
        deleteByProductId();
        findAllProducts();
    }

    //- 删除商品时，前端提供商品ID，
    // 后端将该商品删除后，
    // 返回删除结果。（成功返回true，根据ID找不到该商品即删除失败返回false）
    private static void deleteByProductId() {
        int id = 10005;
        boolean ressult = controller.deleteByProductId(id);
        if (ressult){
            System.out.println("删除成功，id："+ id);
        }else {
            System.out.println("删除失败");
        }

    }



    // - 更新商品(每次更新商品中的一个信息即可),
    // 前端提供要被更新的商品ID,
    // 以及新的产品信息(可以用数组的形式存储新的产品信息),
    // 后端根据商品ID找到该商品, 并将新的信息替换, 返回该商品对象.
    private static void updateProductById() {
        int id = 10001;
        // 返回该商品对象
        // 直接更改
        Product productC = new Product(id, "橡皮擦", 3, "得力");
        Product product = controller.updateProductById(productC);
        if (product != null) {
            System.out.println("product = " + product);
        }else {
            System.out.println("为查询到id："+ id+"的物品");

        }
    }

    // 模糊搜索
    private static void findByProductName() {
        String name = "笔";

        List<Product> productList = controller.findByProductName(name);
        productList.forEach(System.out::println);
    }

    private static void findByProductId() {
        // 前端传递 id值
        int id = 10001;
        // 请求controller
        Product product = controller.findByProductId(id);
        System.out.println("product = " + product);

    }

    private static void createProduct() {
        // 模拟前端参数
        int id = 10006;
        String name = "笔记本";
        String brand = "联想";
        double price = 5999;
        // 参数封装至对象
        Product product = new Product(id, name, price, brand);
        // 请求 controller
        boolean result = controller.createProduct(product);
        if (result) {
            System.out.println("成功" + product);
        } else {
            System.out.println("失败" + product);
        }
    }

    private static void findAllProducts() {
        //List<Product> list= ProductData.PRODUCTS;//
        /*list.forEach(System.out::println);*/

        // 模拟前端请求，获取所有商品数据
        // 请求Controller

        List<Product> productList = controller.findAllProducts();
        new Views().printProducts(productList);
    }
}
