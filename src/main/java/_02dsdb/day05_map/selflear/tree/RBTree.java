package _02dsdb.day05_map.selflear.tree;

import lombok.Data;

/**
 * @author kiro
 * @description:
 * @data 21:21 14/11/2023
 **/
public class RBTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    // 红黑树的 root节点
    private RBNode root;


    static class RBNode<K extends Comparable<K>,V>{
        private RBNode parent;
        private RBNode left;
        private RBNode right;
        private boolean color;

        private K key;
        private V values;

        public RBNode(RBNode parent, RBNode left, RBNode right, boolean color, K key, V values) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.values = values;
        }

        public RBNode(RBNode parent, K key, V values) {
            this.parent = parent;
            this.key = key;
            this.values = values;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }
    }
}
