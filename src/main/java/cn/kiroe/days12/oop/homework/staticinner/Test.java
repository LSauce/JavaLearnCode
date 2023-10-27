package cn.kiroe.days12.oop.homework.staticinner;

import cn.kiroe.day10.oop._03interface._07example.model.Product;

import java.util.Arrays;

/**
 * @author kiro
 * @description:
 * @data 20:42 26/10/2023
 **/
/*
创建一个名为Library的外围类，其中包含一个名为Book的静态内部类。

Book类包含两个私有成员变量：String title和String author，
以及一个构造函数用于初始化这些变量。

Library类存在一个Book对象数组作为成员变量，
用于存储Book对象。再定义一个成员方法addBook，
该方法需要传入书名和作者作为参数，
然后将这个Book对象添加到成员变量的Book数组中
（找null的位置，进行插入，可以考虑将Book数组的长度初始值给大一点）

Library类包含一个名为displayBooks的方法，
用于打印Book对象数组中所有书籍的详细信息。

Book类还包含一个名为displayInfo的方法，用于打印书籍的详细信息。

最后，在测试类当中创建Library对象并调用方法，进行代码测试
 */
public class Test {
    public static void main(String[] args) {
        Library library =new Library();
        library.addBook("t1","a1");
        library.addBook("t2","a2");
        library.addBook("t3","a3");
        library.addBook("t4","a4");
        library.displayBooks();
    }
}

/*
创建一个名为Library的外围类，其中包含一个名为Book的静态内部类。

Book类包含两个私有成员变量：String title和String author，
以及一个构造函数用于初始化这些变量。
 */

class Library {
    //Library类存在一个Book对象数组作为成员变量，
    //用于存储Book对象。再定义一个成员方法addBook，
    //该方法需要传入书名和作者作为参数，
    //然后将这个Book对象添加到成员变量的Book数组中
    //（找null的位置，进行插入，可以考虑将Book数组的长度初始值给大一点）
    Book[] bookArray = new Book[1000];

    public boolean addBook(String title, String author) {
        boolean flag = false;
        //寻找null位置
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i] == null) {
                bookArray[i] = new Book(title, author);
                return true;
            }
        }
        return false;
    }

    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    public void displayBooks(){
        for (Book book : bookArray) {
            if(book!=null){
                System.out.println(book);
            }
        }
    }
    @Override
    public String toString() {
        return "Library{" +
                "bookArray=" + Arrays.toString(bookArray) +
                '}';
    }
}
