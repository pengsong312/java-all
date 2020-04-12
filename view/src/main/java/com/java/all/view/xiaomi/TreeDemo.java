package com.java.all.view.xiaomi;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: ps
 * @since: 2019/4/30  12:35 PM
 * @version: 1.0.0
 * @desc 对树进行遍历，比如树
 *     1
 * |       |
 * 2       3
 * |   |   |   |
 * 4   5   6   7
 * 按照 7、6、5、4、3、2、1 输出
 */
public class TreeDemo {

    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Node node4 = new Node(null,null,4);
        Node node5 = new Node(null,null,5);
        Node node6 = new Node(null,null,6);
        Node node7 = new Node(null,null,7);
        Node node2 = new Node(node4,node5,2);
        Node node3 = new Node(node6,node7,3);
        Node node1 = new Node(node2,node3,1);
        stack.push(node1.getData());
        push(node1);


        System.out.println(stack);

        System.out.println("################二叉树的前序遍历：递归#################");
        preOrder1(node1);
        System.out.println("################二叉树的前序遍历：循环#################");
        preOrder2(node1);

        System.out.println("################二叉树的中序遍历：递归#################");
        midOrder1(node1);
        System.out.println("################二叉树的中序遍历：循环#################");
//        midOrder2(node1);

        System.out.println("################二叉树的后序遍历：递归#################");
        lastOrder1(node1);

        System.out.println("递归实现二叉树深度为： "+depth(node1));
        System.out.println("遍历实现二叉树深度为： "+depth2(node1));
        System.out.println("遍历实现二叉树深度为： "+treeDepth2(node1));

    }

    public static int treeDepth2(Node root) {
        if (root == null) {
            return 0;
        }
        // 初始化深度
        int depth =  0;
        // 存放每层树节点的栈
        Stack<Node> stack = new Stack<>();
        // 将树的根(即第一层)放入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            // 当栈不为空时，层数+1，
            // 因为每次都会pop出当前层的所有节点，并将该层所有节点的子节点放入栈中
            depth++;
            // 当前栈中元素的数量
            int length = stack.size();
            while (length-- > 0) {
                // 取出栈中所有的节点，并将对应节点的子节点放入栈中
                Node node = stack.pop();
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return depth;
    }

    static int depth2(Node root){
        if(root == null){
            return 0;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        int depth = 0;
        Node node;
        while(!stack.isEmpty()){
            depth++;

            int length = stack.size();
            while (length-- > 0) {
                node = stack.pop();
                if(node.right != null){
                    stack.push(node.right);
                }

                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }

        return depth;
    }

    static int depth(Node root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

    public static void push(Node node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() != null) {
            stack.push(node.getLeft().getData());
        }

        if (node.getRight() != null) {
            stack.push(node.getRight().getData());
        }

        if(node.getLeft() != null){
            push(node.getLeft());
        }

        if(node.getRight() != null){
            push(node.getRight());
        }
    }

    // 二叉树的前序遍历
    public static void preOrder1(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.getData());
        preOrder1(root.getLeft());
        preOrder1(root.getRight());
    }


    // 二叉树的前序遍历
    public static void preOrder2(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        if(root == null){
            return;
        }
        Node preNode = root;
        while (preNode != null || !stack.isEmpty()){
            if(preNode != null){
                System.out.println(preNode.getData());
                stack.push(preNode);
                preNode = preNode.getLeft();
            }else{
                Node node = stack.pop();
                preNode = node.getRight();
            }
        }
    }

    // 二叉树的中序遍历
    public static void midOrder1(Node root){
        if(root == null){
            return;
        }
        midOrder1(root.getLeft());
        System.out.println(root.getData());
        midOrder1(root.getRight());
    }
    // 二叉树的中序遍历
    public static void midOrder2(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        if(root == null){
            return;
        }
        Node preNode = root;
        while (preNode != null || !stack.isEmpty()){
            if(preNode != null){
                stack.push(preNode);
                preNode = preNode.getLeft();
            }else{
                Node node = stack.pop();
                System.out.println(preNode.getData());
                preNode = node.getRight();
            }
        }
    }

    // 二叉树的前序遍历
    public static void lastOrder1(Node root){
        if(root == null){
            return;
        }
        lastOrder1(root.getLeft());
        lastOrder1(root.getRight());
        System.out.println(root.getData());
    }
}

class Node {
    Node left;
    Node right;
    Integer data;

    public Node(Node left, Node right, Integer data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Integer getData() {
        return data;
    }
}
