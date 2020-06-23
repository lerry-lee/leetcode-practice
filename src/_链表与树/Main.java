package _链表与树;

import java.util.*;

/**
 * @author lerry_ang
 * @description TODO
 * @create 2020/06/13 10:36
 */
public class Main {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println("输出：");
        test_二叉树的最近公共祖先();
        long t2 = System.currentTimeMillis();
        System.out.println("执行耗时：" + (t2 - t1) + "ms");
    }

    public static void test_二叉树的最近公共祖先(){
        TreeNode a=fill_tree();
        TreeNode p=a.left;
        TreeNode q=a.right;
        display_tree(a);
        display_tree(new _二叉树的最近公共祖先().lowestCommonAncestor(a,p,q));
    }

    public static void test_相交链表() {
        ListNode n1 = fill(Arrays.asList(4, 1));
        ListNode n2 = fill(Arrays.asList(5, 0, 1));
        ListNode tail = fill(Arrays.asList(8, 4, 5));
        connectTail(n1, tail);
        connectTail(n2, tail);
        display(n1);
        display(n2);
//        display_node_string(n1);
//        display_node_string(n2);
        display(new _相交链表().getIntersectionNode_romantic(n1, n2));
    }

    public static void display_node_string(ListNode n1) {
        while (n1 != null) {
            System.out.print(n1.toString() + ">");
            n1 = n1.next;
        }
        System.out.println();
    }

    public static ListNode connectTail(ListNode head, ListNode tail) {
        ListNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = tail;
        return head;
    }

    public static void test_二叉树的锯齿形层次遍历() {
        TreeNode node = fill_tree();
        new _二叉树的锯齿形层次遍历().zigzagLevelOrder(node);
        new _二叉树的锯齿形层次遍历().m2(node);
    }

    public static void test_合并K个排序链表() {
        ListNode n1 = fill(Arrays.asList(1, 4, 5));
        ListNode n2 = fill(Arrays.asList(1, 3, 4));
        ListNode n3 = fill(Arrays.asList(2, 6));
        ListNode[] lists = {n1, n2, n3};
        display(new _合并K个排序链表().mergeKLists(lists));
    }

    public static void test_环形链表2() {
        ListNode node = fill(Arrays.asList(3, 2, 0, -4, 1));
        display(node);
        display(new _环形链表2().detectCycle(node));
    }

    public static void test_排序链表() {
        ListNode node = fill(Arrays.asList(-1, 5, 3, 4, 0));
        display(node);
        display(new _排序链表().sortList_(node));
    }

    public static void test_两数相加() {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);
        ListNode node3 = fill(Arrays.asList(0, 1, 3));
        ListNode node4 = fill(Arrays.asList(9, 9, 9));
        display(node3);
        display(node4);
        _两数相加 demo = new _两数相加();
        display(demo.addTwoNumbers(node3, node4));
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

    public static ListNode fill(List<Integer> list) {
        ListNode node = new ListNode(-1);
        ListNode root = node;
        for (Integer i : list) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return root.next;
    }

    public static TreeNode fill_tree() {
        TreeNode node = new TreeNode(-1);
        TreeNode head = node;
        node.val = 3;
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        return head;
    }

    public static void display_tree(TreeNode node){
        Deque<TreeNode> deque=new LinkedList<>();
        deque.addLast(node);
        while(!deque.isEmpty()){
            TreeNode temp=deque.pollFirst();
            System.out.print(temp.val+" ");
            if(temp.left!=null) deque.addLast(temp.left);
            if(temp.right!=null) deque.addLast(temp.right);
        }
        System.out.println();
    }

}
