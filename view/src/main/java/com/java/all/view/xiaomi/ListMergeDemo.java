package com.java.all.view.xiaomi;

/**
 * @author: ps
 * @since: 2019/4/30  12:48 PM
 * @version: 1.0.0
 * @desc 严格有序列表合并, 合并完成后的列表也是严格有序列表：
 * list1 = [1,2,3,4,5,6]
 * list2 = [6,7,8]
 */
public class ListMergeDemo {

    public static void main(String[] args) {
        Node node6 = new Node(null, 6);
        Node node5 = new Node(node6, 5);
        Node node4 = new Node(node5, 4);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 2);
        Node node1 = new Node(node2, 1);
        Node nodeA = node1;

        Node node9 = new Node(null, 8);
        Node node8 = new Node(node9, 7);
        Node node7 = new Node(node8, 6);
        Node nodeB = node7;

        Node head = merge(nodeA, nodeB);

        while (head != null) {
            System.out.println(head.getData());
            head = head.next;
        }

    }

    public static final Node merge(Node node1, Node node2) {
        Node head;
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }

        // 列表1的该位置的元素小于等于列表2位置的元素时，列表1进入next
        if (node1.getData() < node2.getData()) {
            head = node1;
            head.next = merge(node1.next, node2);
        } else {
            head = node2;
            head.next = merge(node1, node2.next);
        }

        return head;
    }

    public static Node mergeList(Node head1, Node head2) {
        Node head = null;
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head = head1;
            head.next = mergeList(head1.next, head2);
        } else if(head1.data > head2.data){
            head = head2;
            head.next = mergeList(head1, head2.next);
        }else{

        }

        return head;

    }

    static class Node {
        Node next;
        int data;

        public Node(Node next, int data) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public int getData() {
            return data;
        }
    }

}
