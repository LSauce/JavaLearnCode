package _02dsdb.day02_collection._02ds;

import cn.kiroe.day02.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedListD<E> implements List<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        E e;
        Node next;

        public Node() {
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedListD() {
        head = new Node();
        tail = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean contains(Object o) {

        // 遍历判断是否相同
        Node temp = head;
        while (temp != null) {
            if (o == temp.e) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    // 增
    @Override
    public boolean add(E e) {
        // 通过尾部节点添加
        tail.next = new Node(e);
        tail = tail.next;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // 寻找当前节点
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.e == o) {
                // 删除
                temp.next = temp.next.next;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int i) {
        if (i < size && i >= 0) {
            Node temp = head;
            for (int j = 0; j <= i; j++) {
                temp = temp.next;
            }
            return temp.e;
        }
        return null;
    }

    @Override
    public E set(int i, E e) {
        if (i < size && i >= 0) {
            Node temp = head.next;
            for (int j = 0; j < i; j++) {
                temp = temp.next;
            }
            temp.e = e;
            return e;
        }
        return null;
    }

    @Override
    public void add(int i, E e) {
        // 插入
        if (i >= 0 && i < size) {
            //获取i-1个节点
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.next;
            }
            temp.next = new Node(e, temp.next);
            size++;
        }
    }

    @Override
    public E remove(int i) {
        // 移出
        if(i >=0 && i < size ){
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.next;

            }
            Node result = temp.next;
            temp.next = temp.next.next;
            size--;
            return result.e;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        //查找
        Node temp  = head.next;
        int count = 0;
        while (temp != null){
            if(temp.e == o){
                return count;
            }
            if(temp!=null && temp.e.equals(o)){
                return count;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }

    @Override
    public String toString() {
        return "LinkedListD{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }


}
