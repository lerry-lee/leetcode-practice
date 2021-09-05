package _每日一题;


import _其他._TODO.*;
import _数据结构.ListNode;
import _数据结构.TreeNode;
import _每日一题._2020年._20年10月.*;
import _每日一题._2020年._20年7月._1008先序遍历构造二叉树;
import _每日一题._2020年._20年7月._105从前序与中序遍历序列构造二叉树;
import _每日一题._2020年._20年7月._17dot06数字2出现的次数;
import _每日一题._2020年._20年7月._44通配符匹配;
import _每日一题._2020年._20年8月._43字符串相乘;
import _每日一题._2020年._20年9月.*;
import _腾讯推荐._数组与字符串._最长回文子串;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 21:14
 * @description 测试主程序
 */
public class Main {
    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {
        log.info("开始测试");
        long t1 = System.currentTimeMillis();
        demo1();
        long t2 = System.currentTimeMillis();
        log.info(String.format("测试结束，耗时:%dms", (t2 - t1)));
    }

    public static void demo1() {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n > 0) {
            n = sc.nextInt();
            if (n == 0) break;
            //dp[i][j]表示长度为i的仅有ab组成的字符串(不含aba或bab)，当状态为j时的组合总数
            //      j=0:以aa结尾
            //      j=1:以ab结尾
            //      j=2:以ba结尾
            //      j=3:以bb结尾
            //最终返回dp[n][0:3]求和
            int[][] dp = new int[n + 1][4];
            //初始化
            //n<=2直接返回
            //dp[2][]=1
            if (n <= 2) {
                if (n == 1) System.out.println(2);
                else System.out.println(4);
            } else {
                for (int i = 0; i < 4; i++) {
                    dp[2][i] = 1;
                }
                //状态转移
                for (int i = 3; i <= n; i++) {
                    //当前字符可以为a或者b
                    //当为a时，只能从上一个状态的aa,ba,bb转移得到
                    //  即：aaa,baa,bba
                    //  得到两类j=0:aa和j=2:ba
                    dp[i][0] += dp[i - 1][0] + dp[i - 1][2];//由前一状态的aa,ba得到
                    dp[i][2] += dp[i - 1][3];//由前一状态的bb得到
                    //当为b时，只能从上一个状态的aa,ab,bb转移得到
                    //  即：aab,abb,bbb
                    dp[i][1] += dp[i - 1][0];//ab由前一状态的aa得到
                    dp[i][3] += dp[i - 1][1] + dp[i - 1][3];//bb由前一状态的ab,bb得到
                }
                int res = 0;
                for (int i = 0; i < 4; i++) {
                    res += dp[n][i];
                }
                System.out.println(res);
            }
        }
    }

    public static void test_463() {
        int[][] grid = {{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        System.out.println(new _463岛屿的周长().islandPerimeter(grid));
    }

    public static void test_1207() {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(new _1207独一无二的出现次数().uniqueOccurrences(arr1));
        System.out.println(new _1207独一无二的出现次数().uniqueOccurrences(arr2));
        System.out.println(new _1207独一无二的出现次数().uniqueOccurrences(arr3));
    }

    public static void test_845() {
        int[] A = {4, 2, 9, 8, 0};
        int[] A1 = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(new _845数组中的最长山脉().longestMountain(A1));
    }

    public static void test_1024() {
        int[][] A = {{0, 2}, {4, 8}};
        System.out.println(new _1024视频拼接().videoStitching(A, 5));
    }

    public static void test_243() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(new _243回文链表().isPalindrome(head));
    }

    public static void test_763() {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new _763划分字母区间().partitionLabels(s));
    }

    public static void test_925() {
        while (true) {
            String name = getString();
            String typed = getString();
            System.out.println(new _925长按键入().isLongPressedName(name, typed));
        }
    }

    public static void test_844() {
        while (true) {
            String S = getString(), T = getString();
            System.out.println(new _844比较含退格的字符串().backspaceCompare(S, T));
        }

    }

    public static void test_977() {
        int[] A = {-7, -3, 2, 3, 11};
        display(new _977有序数组的平方().sortedSquares(A));
    }

    public static void test_52() {
        System.out.println(new _52N皇后2().totalNQueens(4));
    }

    public static void test_1002() {
//        String[] A={"cool","lock","cook"};
        String[] A = {"bella", "label", "roller"};
        List<String> r0 = new _1002查找常用字符().commonChars(A);
        System.out.println(r0.size());
        String[] r1 = {"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
        System.out.println(r1.length);
        System.out.println(A.length);
    }

    public static void test_416() {
        int[] nums = {14, 9, 8, 4, 3, 2};
        System.out.println("" + (14 + 9 + 8 + 4 + 3 + 2));
        System.out.println(new _416分割等和子集().canPartition(nums));
    }

    public static void test_75() {
//        int[] nums={2,0,2,1,1,0};
        int[] nums = {2, 0, 1};
        display(nums);
        new _75颜色分类().sortColors_(nums);
        display(nums);
    }

    public static void test_18() {
        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        System.out.println(new _18四数之和().fourSum_2pointer(nums, 0));
    }

    public static void test_19() {
        String s = "rrryyyrryyyrr";
        System.out.println(s);
        new _19秋叶收藏集().minimumOperations(s);
    }

    public static void test_235() {
        TreeNode root = new TreeNode(6);
        insertLeftAndRightChildToTreeNode(root, 2, 8);
        insertLeftAndRightChildToTreeNode(root.left, 0, 4);
        insertLeftAndRightChildToTreeNode(root.left.right, 3, 5);
        insertLeftAndRightChildToTreeNode(root.right, 7, 9);
        System.out.println(new _235二叉搜索树的最近公共祖先().lowestCommonAncestor(root, root.left.right, root.left.left).val);
    }

    public static void test_113() {
        TreeNode root = new TreeNode(5);
        insertLeftAndRightChildToTreeNode(root, 4, 8);
        insertLeftAndRightChildToTreeNode(root.left, 11, 2333);
        insertLeftAndRightChildToTreeNode(root.left.left, 7, 2);
        insertLeftAndRightChildToTreeNode(root.right, 13, 4);
        insertLeftAndRightChildToTreeNode(root.right.right, 5, 1);
        System.out.println(new _113路径总和2().pathSum(root, 22));
    }

    public static void insertLeftAndRightChildToTreeNode(TreeNode root, int leftVal, int rightVal) {
        if (leftVal != 2333) root.left = new TreeNode(leftVal);
        if (rightVal != 2333) root.right = new TreeNode(rightVal);
    }

    public static void tet_106() {
        int[] inorder = {2, 1};
        int[] postorder = {2, 1};
        display(new _106从中序与后续遍历序列构造二叉树().buildTree(inorder, postorder));
    }

    public static void test_501() {
        TreeNode root = new TreeNode(2147483647);
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(2);

        int[] a = new _501二叉搜索树中的众数().findMode(root1);
        display(a);
    }

    public static void test_968() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        System.out.println(new _968监控二叉树().minCameraCover(root));
    }

    public static void test_538() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
//        root.left.left=new TreeNode(-4);
//        root.left.right=new TreeNode(1);
        display(new _538把二叉搜索树转换为累加树().convertBST_b(root));

    }

    public static ListNode getListNode() {
        Scanner sc = new Scanner(System.in);
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            listNode = new ListNode(sc.nextInt());
            listNode = listNode.next;
        }
        return head;
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static int[] getNums() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        return nums;
    }

    public static void test_78() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(new _78子集().subsets(nums));
        sc.close();
    }

    public static void test_47() {
        int[] nums = {1, 1, 2,};
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 2, 1, 1};
        System.out.println(new _47全排列2().permuteUnique(nums));
        System.out.println(new _47全排列2().permuteUnique_swap(nums));
        System.out.println();
        System.out.println(new _47全排列2().permuteUnique(nums1));
        System.out.println(new _47全排列2().permuteUnique_swap(nums1));
        System.out.println();
        System.out.println(new _47全排列2().permuteUnique(nums2));
        System.out.println(new _47全排列2().permuteUnique_swap(nums2));
    }

    public static void test_226() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        new _226翻转二叉树().invertTree(root);
        display(root);
    }

    public static void display(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }

    public static void test_最长回文子串() {
        String s = "babad";
        System.out.println(new _最长回文子串().longestPalindrome_dp(s));
    }

    public static void test_79() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board1 = {
                {'a', 'b'}
        };
        String word = "ab";
        System.out.println(new _79单词搜索().exist(board1, word));

    }

    public static void test_216() {
        _216组合总和3 demo = new _216组合总和3();
        System.out.println(demo.combinationSum3(3, 9));
        System.out.println(demo.combinationSum3(3, 7));
    }

    public static int t3(int a) {
        int maxVal = 0;
        for (int m = 1; m <= a / 2; m++) {
            int n = a - m;
            maxVal = Math.max(maxVal, calVal(m) + calVal(n));
        }
        return maxVal;
    }

    public static int calVal(int num) {
        int res = 0, wei;
        while (num > 0) {
            wei = num % 10;
            res += wei;
            num /= 10;
        }
        return res;
    }

    public static void display(ListNode res) {
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println();
    }

    public static ListNode deleteKNode() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        display(node);
        int k = 3;
        ListNode head = node;
        int cnt = 0;
        while (node != null) {
            if (cnt == k) {
                ListNode temp = node.next.next;
                node.next = node.next.next;
//                node.next=temp;
                return head;
            }
            node = node.next;
            cnt++;
        }
        return head;
    }

    public static void test_43() {
        String a = "41", b = "124124";
        System.out.println(new _43字符串相乘().multiply(a, b));
    }

    public static void test_demo() {
        StringBuilder res = new StringBuilder();
        res.append("abc");
        int a = Integer.parseInt("255");
        System.out.println(a);
        Stack<Character> stack = new Stack<>();
        String s = Integer.toBinaryString(4);
        System.out.println(s);
    }

    public static void test_java() {
        double a = 1.2, b = 1.2;
        double c, d, e, f;
        c = a + b;
        d = a - b;
        e = a * b;
        f = a / b;
        double c1 = a + b;
        double d1 = a - b;
        double e1 = a * b;
        double f1 = a / b;
        System.out.format("%f %f\n", c, c1);
        System.out.format("%f %f\n", d, d1);
        System.out.format("%f %f\n", e, e1);
        System.out.format("%f %f\n", f, f1);
    }

    public static void test_315() {
        int[] a = {5, 2, 6, 1};
        int[] a1 = {-1, -1};
        System.out.println(new _315计算右侧小于当前元素的个数().countSmaller_sort(a));
    }

    public static void test_17dot13() {
        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String s = "jesslookedjustliketimherbrother";
        String[] dictionary1 = {"potimzz"};
        String s1 = "potimzzpotimzz";
        String[] dictionary2 = {"qqqqqqqqq", "qqqqq", "qq", "qqq", "qqqqqq", "qqqqqq", "q"};
        String s2 = "qqqq";
        String[] dictionary3 = {"aaysaayayaasyya", "yyas", "yayysaaayasasssy",
                "yaasassssssayaassyaayaayaasssasysssaaayysaaasaysyaasaaaaaasayaayayysasaaaa", "aya", "sya", "ysasasy"
                , "syaaaa", "aaaas", "ysa", "a", "aasyaaassyaayaayaasyayaa", "ssaayayyssyaayyysyayaasaaa", "aya",
                "aaasaay", "aaaa",
                "ayyyayssaasasysaasaaayassasysaaayaassyysyaysaayyasayaaysyyaasasasaayyasasyaaaasysasy", "aaasa",
                "ysayssyasyyaaasyaaaayaaaaaaaaassaaa", "aasayaaaayssayyaayaaaaayaaays", "s"};
        String s3 = "asasayaayaassayyayyyyssyaassasaysaaysaayaaaaysyaaaa";
        System.out.println(new _17dot13恢复空格().respace(dictionary3, s3));
    }

    public static void test_44() {
        String s = "aa";
        String p = "*";
        System.out.println(new _44通配符匹配().isMatch(s, p));
    }

    public static void test_17dot06() {
        int res = new _17dot06数字2出现的次数().numberOf2sInRange(25);
        System.out.println(res);
    }

    public static void test_105() {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        int[] pre1 = {1, 2};
        int[] in1 = {2, 1};
        TreeNode res = new _105从前序与中序遍历序列构造二叉树().buildTree(pre1, in1);
        preOrder(res);
        System.out.println();
    }

    public static void test_1008() {
        int[] a = {8, 5, 1, 7, 10, 12};
        TreeNode res = new _1008先序遍历构造二叉树()._用栈(a);
        preOrder(res);
        System.out.println();
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void display(String[] a) {
        for (String s : a) {
            if (s.equals("")) System.out.print("空字符串 ");
            else System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void display(int[] a) {
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void display(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();
    }

}
