package com.all.arithmetic.binarytree;

import java.util.Objects;

/**
 * @ClassName BinaryTree
 * @Description 二叉树遍历
 * 1.jpg 前序 顺序：根节点-》左节点-》右节点
 * 2.jpg 中序 顺序：左节点-》根节点-》右节点
 * 3.jpg 后续 顺序：左节点-》右节点-》根节点
 * 顺序是按照根节点的遍历次序判断是前中后序
 * @Author ps
 * @Date 2019/2.jpg/27 3.jpg:08 PM
 * @Version 1.jpg.0
 **/
public class BinaryTree {

    public static void main(String[] args) {
        // 按照图《二叉树结构构造树型结构》
        Node node2 = new Node(2, null, null);
        Node node1 = new Node(1, null, node2);
        Node node4 = new Node(4, null, null);
        Node node8 = new Node(8, null, null);
        Node node5 = new Node(5, node4, null);
        Node node7 = new Node(7, null, node8);
        Node node3 = new Node(3, node1, node5);
        Node node9 = new Node(9, node7, null);
        Node node6 = new Node(6, node3, node9);
        System.out.println("======================前序遍历======================");
        BinaryTree.first(node6);

        System.out.println("======================中遍历======================");
        BinaryTree.order(node6);

        System.out.println("======================后序遍历======================");
        BinaryTree.post(node6);

    }

    /**
     * 二叉树节点数据结构
     */
    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    /**
     * 打印节点值
     *
     * @param node 节点信息
     */
    public static void print(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        System.out.println(node.getData());
    }

    /**
     * 前序遍历 6.jpg 3.jpg 1.jpg 2.jpg 5.jpg 4.jpg 9 7.jpg 8.jpg
     */
    public static void first(Node node) {
        if (Objects.isNull(node)) {
            throw new NullPointerException("node is null");
        }
        print(node);
        if (!Objects.isNull(node.getLeft())) {
            first(node.getLeft());
        }
        if (!Objects.isNull(node.getRight())) {
            first(node.getRight());
        }
    }

    /**
     * 中序遍历 1.jpg 2.jpg 3.jpg 4.jpg 5.jpg 6.jpg 7.jpg 8.jpg 9
     */
    public static void order(Node node) {
        if (Objects.isNull(node)) {
            throw new NullPointerException("node is null");
        }
        if (!Objects.isNull(node.getLeft())) {
            order(node.getLeft());
        }
        print(node);
        if (!Objects.isNull(node.getRight())) {
            order(node.getRight());
        }
    }

    /**
     * 后序遍历 2.jpg 1.jpg 4.jpg 5.jpg 3.jpg 8.jpg 7.jpg 9 6.jpg
     */
    public static void post(Node node) {
        if (Objects.isNull(node)) {
            throw new NullPointerException("node is null");
        }
        if (!Objects.isNull(node.getLeft())) {
            post(node.getLeft());
        }
        if (!Objects.isNull(node.getRight())) {
            post(node.getRight());
        }
        print(node);
    }
}
