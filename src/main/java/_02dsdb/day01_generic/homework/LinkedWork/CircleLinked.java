package _02dsdb.day01_generic.homework.LinkedWork;

/**
 * @author kiro
 * @description:
 * @data 19:21 9/11/2023
 **/
/*
1,如果存在一个单链表, 我们只拥有单链表的头结点,
实现一个方法, 判断链表中是否有环
 (即: 这个单链表的尾结点, 它下一个指向, 指向链表中的另外一个结点, 构成一个环)
 */

public class CircleLinked {

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
    }
    public static void main(String[] args) {
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // a --> b --> c --> d --> e --> c --> d --> e --> ...
        e.next = c;

        boolean bool = hasCircle(a);
        System.out.println(bool);
    }
    /**
     * 判断链表是否有环,通过快慢指针判断
     * @param head : 头结点
     * @return : 是否有环
     */
    /*
        设置快指针，每次走两步，慢指针每次走一步，判断是否会重合
     */
    private static boolean hasCircle(Node head) {
        if(head == null){
            return  false;
        }
        Node fast = head;
        Node slow = head;

        // fast每次走两步
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
