package DataStructure;

import java.util.*;

/**
 * @ClassName: CommonMethod
 * @Signature: Created by lerry_li on 2020/11/07
 * @Description: 封装常用方法的类：打印操作、初始化操作、批量插入操作...
 */
public class CommonMethod {

    /**
     * 获得scanner
     *
     * @return scanner
     */
    public static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    /**
     * 打印一维数组
     *
     * @param arr 一维数组
     */
    public static void display(int[] arr) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (int em : arr) {
                System.out.print(em + " ");
            }
            System.out.println();
        }
    }

    /**
     * 打印一维数组，指定范围
     *
     * @param arr 一维数组
     */
    public static void display(int[] arr, int start, int end) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (int i = start; i <= end; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void display(boolean[] arr) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (boolean em : arr) {
                System.out.print(em + " ");
            }
            System.out.println();
        }
    }

    /**
     * 打印二维数组
     *
     * @param arr 二维数组
     */
    public static void display(int[][] arr) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (int[] em : arr) {
                for (int emi : em) {
                    System.out.print(emi + " ");
                }
                System.out.println();
            }
        }
    }

    public static void display(boolean[][] arr) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (boolean[] em : arr) {
                for (boolean emi : em) {
                    System.out.print(emi + " ");
                }
                System.out.println();
            }
        }
    }

    public static void display(double[][] arr) {
        if (arr == null) {
            System.out.println("数组对象为null");
        } else if (arr.length == 0) {
            System.out.println("数组内容为空");
        } else {
            for (double[] em : arr) {
                for (double emi : em) {
                    System.out.print(emi + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * 打印链表
     *
     * @param head 链表头结点
     */
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

    /**
     * 打印/遍历二叉树
     *
     * @param root          二叉树的根节点
     * @param traversalType 遍历方式:preorder/inorder/postorder
     */
    public static void display(TreeNode root, String traversalType) {
        switch (traversalType) {
            case "preorder":
                System.out.print("采用前序遍历方式: ");
                preorder(root);
                System.out.println();
                break;
            case "inorder":
                System.out.print("采用中序遍历方式: ");
                inorder(root);
                System.out.println();
                break;
            case "postorder":
                System.out.print("采用后序遍历方式: ");
                postorder(root);
                System.out.println();
                break;
            default:
                System.out.println("参数traversalType的值只能为：");
                System.out.println("\t1.preorder:前序遍历");
                System.out.println("\t2.inorder:中序遍历");
                System.out.println("\t3.postorder:后序遍历");
                break;
        }
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

    /**
     * 初始化链表/二叉树
     *
     * @param integerList   用来初始化的整数值list
     * @param dataStructure 数据结构:ListNode/TreeNode
     */
    public static Object initialize(List<Integer> integerList, String dataStructure) {
        switch (dataStructure) {
            case "ListNode":
                System.out.print("初始化链表: ");
                ListNode head = new ListNode(-1);
                ListNode temp = head;
                for (Integer integer : integerList) {
                    temp.next = new ListNode(integer);
                    temp = temp.next;
                    System.out.print(integer+"->");
                }
                System.out.print("null\n");
                return head.next;
            case "TreeNode":
                System.out.println("初始化二叉树");
                //TODO
                Deque<TreeNode> deque = new LinkedList<>();
                TreeNode root = new TreeNode();
                deque.offerLast(root);
                int idx = 0;
                int nodeNums = 0;
                while (idx < integerList.size()) {
                    int size = deque.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = deque.pollFirst();
                        if (integerList.get(idx) == null) {
                            node = null;
                        } else {
                            node.val = integerList.get(idx);
                        }
                        idx++;
                        nodeNums++;
                        if (node != null && nodeNums < integerList.size()) {
                            node.left = new TreeNode();
                            deque.offerLast(node.left);
                            nodeNums++;
                        }

                        if (node != null && nodeNums < integerList.size()) {
                            node.right = new TreeNode();
                            deque.offerLast(node.right);
                            nodeNums++;
                        }

                    }
                }
                return root;
            default:
                System.out.println("参数dataStructure的值只能为：");
                System.out.println("\t1.ListNode:链表");
                System.out.println("\t2.TreeNode:二叉树");
                return null;
        }
    }
}
