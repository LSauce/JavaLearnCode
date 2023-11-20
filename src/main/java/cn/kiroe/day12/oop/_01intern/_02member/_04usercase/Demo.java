package cn.kiroe.day12.oop._01intern._02member._04usercase;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author kiro
 * @description:
 * @data 11:21 26/10/2023
 **/
public class Demo {
    public static void main(String[] args) {
        // 线性表
        // 1. 顺序存储
        // 2. 链式存储
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三1");
        list.add("张三2");
        System.out.println("list = " + list);
        //list.forEach(System.out::println);
        // 链式存储
        LinkedList<String> list1 = new LinkedList<>();

        list1.add("aa");
        list1.add("aa1");
        list1.add("aa2");
        list1.add("aa3");
        System.out.println("list1 = " + list1);

        // 自定义储存：
        MyLinkedList<String> list2  = new MyLinkedList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        System.out.println("list2 = " + list2);
        list2.remove(1);
        System.out.println("list2 = " + list2);
        System.out.println("list2.get(1) = " + list2.get(1));

    }


}

class MyLinkedList<E> {
    // 链表的创建
    private Node head = new Node(null, null);
    private Node tail = head;

    //长度
    private int size = 0;

    public MyLinkedList() {

    }

    public int getSize() {
        return size;
    }

    public boolean add(E val) {
        tail.next = new Node(val, null);
        tail = tail.next;
        size++;
        return true;
    }

    public boolean remove(int index){
        if(index >= size){
            return false;
        }
        Node temp =  head;
        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
        return true;
    }

    public E get(int index){
        if(index >= size){
            return null;
        }

        Node temp = head.next;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return  temp.val;
    }



    // 成员内部类
    private  class Node {
        E val;
        Node next;

        public Node(E val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next  +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}



