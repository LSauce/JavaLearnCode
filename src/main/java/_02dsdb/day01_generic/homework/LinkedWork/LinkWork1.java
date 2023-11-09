package _02dsdb.day01_generic.homework.LinkedWork;

/**
 * @author kiro
 * @description:
 * @data 19:29 9/11/2023
 **/
// 1, 如果存在一个单链表,实现一个方法,
// 给定这个单链表的头结点,
// 获得这个链表经过反序之后链表的头结点

public class LinkWork1 {
    private static class Node{
        String val;
        Node next;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
    public static void main(String[] args) {
        // 翻转链表
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // e  --> d  -->  c  --> b  --> a
        Node newLinked = reLinked(a);

        System.out.println(newLinked);
    }
    /**
     * 翻转链表
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    /*
    设置假头，使用双指针
     */
    private static Node reLinked(Node head) {
        if(head == null){
            return  null;
        }
        // 双指针反转
        Node pre = null;
        Node cur = head;
        while (cur != null){
            // 反转链表
            Node temp =  cur.next;
            cur.next = pre;
            //迭代
            pre = cur;
            cur = temp;
        }
        return  pre;
    }
}
