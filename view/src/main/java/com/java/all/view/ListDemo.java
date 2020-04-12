package com.java.all.view;

import com.google.gson.Gson;

import java.util.Stack;

/**
 * @author: ps
 * @since: 2019/5/15  5:44 PM
 * @version: 1.0.0
 */
public class ListDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));

//        System.out.println(kReverse(head,2));

        System.out.println(new Gson().toJson(reverse(head)));
        ListNode head1= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));

        System.out.println(new Gson().toJson(reverse2(head1)));
    }

    // 按照给定值K进行局部链表反转，例如：1->2->3->4 result: 2->1->4->3
    public static ListNode kReverse(ListNode head,int k){
        int index = 0;
        if(head == null){
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        index++;

        ListNode node = null;
        ListNode current = null;
        while (current != null || !stack.isEmpty()){
            if(index % k == 0){
                for(int i = 0; i< stack.size();i++){
                    current = stack.pop();
                    if(node == null){
                        node = current;
                        continue;
                    }
                    node.next = current;
                }
            }else{
                stack.push(stack.peek().next);
                index++;
            }
        }
        return current;
    }

    public static ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode temp = node.next;
        ListNode newHead = reverse(node.next);
        temp.next = node;
        node.next = null;
        return newHead;
    }

    public static ListNode reverse2(ListNode node) {
        // 当前节点的前驱节点
        ListNode pre = null;
        // 当前节点
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
