package _工具类;

import _数据结构.ListNode;
import _数据结构.TreeNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Common
 * @Author: lerry_li
 * @CreateTime: 2020/12/12
 * @Description
 */
public class CommonMethod {
    public static <T> void display(T[] array) {
        if (array == null) {
            System.out.println("数组对象为null");
        } else if (array.length == 0) {
            System.out.println("数组内容为空");
        } else {
            System.out.print("[ ");
            for (Object em : array) {
                System.out.print(em + " ");
            }
            System.out.println("]");
        }
    }


    public static <T> void display(T[] array, int start, int end) {
        if (array == null) {
            System.out.println("数组对象为null");
        } else if (array.length == 0) {
            System.out.println("数组内容为空");
        } else {
            System.out.print("[ ");
            for (int i = start; i <= end; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println("]");
        }
    }


    public static <T> void display(T[][] array) {
        if (array == null) {
            System.out.println("数组对象为null");
        } else if (array.length == 0) {
            System.out.println("数组内容为空");
        } else {
            System.out.print("[ ");
            for (T[] em : array) {
                System.out.print("[ ");
                for (T emi : em) {
                    System.out.print(emi + " ");
                }
                System.out.print("] ");
            }
            System.out.println("]");
        }
    }


    public static void display(ListNode head) {
        if (head == null) {
            System.out.println("链表对象为null");
        }
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void display(TreeNode root, String traversalType) {
        switch (traversalType) {
            case "preorder":
                System.out.print("采用前序遍历方式: [");
                preorder(root);
                System.out.println("]");
                break;
            case "inorder":
                System.out.print("采用中序遍历方式: [");
                inorder(root);
                System.out.println("]");
                break;
            case "postorder":
                System.out.print("采用后序遍历方式: [");
                postorder(root);
                System.out.println("]");
                break;
            default:
                System.out.println("参数traversalType的值只能为：");
                System.out.println("\t1.preorder:前序遍历");
                System.out.println("\t2.inorder:中序遍历");
                System.out.println("\t3.postorder:后序遍历");
                break;
        }
    }


    public static Logger getLogger(String loggerName) {
        return LogManager.getLogger(loggerName);
    }


    public static Scanner getScannerInput() {
        return new Scanner(System.in);
    }


    public static ListNode initListNode(List<Integer> list) {
        System.out.print("初始化链表: ");
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        for (Integer integer : list) {
            temp.next = new ListNode(integer);
            temp = temp.next;
            System.out.print(integer + "->");
        }
        System.out.println("null");
        return dummyHead.next;
    }

    //前序遍历：递归
    public static void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //中序遍历：递归
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    //后序遍历：递归
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}
