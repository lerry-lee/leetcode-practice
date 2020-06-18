package _链表与树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lerry_ang
 * @description TODO
 * @create 2020/06/13 10:36
 */
public class Main {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("输出：");
        test_二叉树的锯齿形层次遍历();
        long t2 = System.currentTimeMillis();
        System.out.println("执行耗时：" + (t2 - t1) + "ms");
    }

    public static void test_二叉树的锯齿形层次遍历(){
        TreeNode node=fill_tree();
        new _二叉树的锯齿形层次遍历().zigzagLevelOrder(node);
        new _二叉树的锯齿形层次遍历().m2(node);
    }

    public static void test_合并K个排序链表(){
        ListNode n1=fill(Arrays.asList(1,4,5));
        ListNode n2=fill(Arrays.asList(1,3,4));
        ListNode n3=fill(Arrays.asList(2,6));
        ListNode[] lists={n1,n2,n3};
        display(new _合并K个排序链表().mergeKLists(lists));
    }

    public static void test_环形链表2(){
        ListNode node=fill(Arrays.asList(3,2,0,-4,1));
        display(node);
        display(new _环形链表2().detectCycle(node));
    }

    public static void test_排序链表(){
        ListNode node=fill(Arrays.asList(-1,5,3,4,0));
        display(node);
        display(new _排序链表().sortList(node));
    }

    public static void test_两数相加(){
        ListNode node1=new ListNode(2);node1.next=new ListNode(4);node1.next.next=new ListNode(3);
        ListNode node2=new ListNode(5);node2.next=new ListNode(6);node2.next.next=new ListNode(4);
        ListNode node3=fill(Arrays.asList(0,1,3));
        ListNode node4=fill(Arrays.asList(9,9,9));
        display(node3);
        display(node4);
        _两数相加 demo=new _两数相加();
        display(demo.addTwoNumbers(node3,node4));
    }

    public static void test_反转链表() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        _反转链表 demo = new _反转链表();
        display(node);
        ListNode res = demo.reverseList(node);
        display(res);
    }


    public static void testMergeTwoLists() {

        _合并有序链表 demo = new _合并有序链表();
//        demo.mergeTwoLists();
        demo.m2();
    }

    public static void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println("null");
    }
    public static ListNode fill(List<Integer> list){
        ListNode node=new ListNode(-1);
        ListNode root=node;
        for(Integer i:list){
            node.next=new ListNode(i);
            node=node.next;
        }
        return root.next;
    }

    public static TreeNode fill_tree(){
        TreeNode node=new TreeNode(-1);
        TreeNode head=node;
        node.val=3;
        node.left=new TreeNode(9);
        node.left.left=new TreeNode(2);
        node.right=new TreeNode(20);
        node.right.left=new TreeNode(15);
        node.right.right=new TreeNode(7);
        return head;
    }

}
