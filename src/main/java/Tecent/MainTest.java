package Tecent;

import DataStructure.ListNode;
import Tecent._回溯算法._全排列;
import Tecent._回溯算法._子集;
import Tecent._回溯算法._括号生成;
import Tecent._排序与搜索._数组中的第K个最大元素;
import Tecent._数学与数字._2的幂;
import Tecent._数学与数字._整数反转;
import Tecent._数组与字符串.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/12 11:00
 * @description 测试主程序
 */
public class MainTest {
    private static Scanner sc = new Scanner(System.in);
    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {
        log.info("开始测试");
        long t1 = System.currentTimeMillis();
        test_格雷编码();
        long t2 = System.currentTimeMillis();
        log.info(String.format("测试结束，耗时:%dms", (t2 - t1)));
    }

    public static void test_格雷编码(){
        System.out.println(5^1);
    }

    public static void test_全排列(){
        int[] nums={1,2,3};
        System.out.println(new _全排列().permute(nums));
    }

    public static void test_子集(){
        int[] nums={1,2,3};
        System.out.println(new _子集().subsets(nums));
    }

    public static void test_括号生成(){
        while(true){
            int n=sc.nextInt();
            System.out.println(new _括号生成().generateParenthesis(n));
        }

    }

    public static void test_数组中的第K个最大元素(){
        int[] nums={3,2,1,5,6,4};
        System.out.println(new _数组中的第K个最大元素().findKthLargest2(nums,2));
    }

    public static void test_2的幂(){
        while(true){
            int num=sc.nextInt();
            System.out.println(new _2的幂().isPowerOfTwo(num));
        }
    }

    public static void test_整数反转(){
        int n=1534236469;
        System.out.println(new _整数反转().reverse(n));
    }

    public static void test_旋转链表(){
        ListNode head=new ListNode(1);
        fillListNodeWithArray(new int[]{2},0,head);
        display(head);
//        display(new _旋转链表().rotateRight(head,4));
//        display(new _旋转链表().rotateRight(head,3));
//        display(new _旋转链表().rotateRight(head,2));
//        display(new _旋转链表().rotateRight_cicle(head,1));


    }

    public static void display(ListNode node){
        if(node==null) {
            System.out.println("null");
            return;
        }
        System.out.print(node.val+"->");
        display(node.next);
    }

    public static void fillListNodeWithArray(int[] nums,int t,ListNode node){
        if(t==nums.length) return;
        node.next=new ListNode(nums[t]);
        fillListNodeWithArray(nums,t+1,node.next);
    }

    public static void test_螺旋矩阵() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new _螺旋矩阵().spiralOrder(matrix2));
    }

    public static void test_反转字符串中的单词3() {
        String s = "Let's take LeetCode contest";
        System.out.println(s);
        System.out.println(new _反转字符串中的单词3().reverseWords(s));
    }

    public static void test_字符串相乘() {
        String str1 = getString();
        String str2 = getString();
        System.out.println(new _字符串相乘().multiply(str1, str2));
    }

    public static void test_盛水最多的容器() {
//        int[] nums=getNums();
        int[] nums1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums2 = {1, 10, 2, 7, 8, 9};
        System.out.println(new _盛水最多的容器().maxArea_doublePoint(nums1));
        System.out.println(new _盛水最多的容器().maxArea_doublePoint(nums2));
    }

    public static ListNode getListNode() {
//        Scanner sc=new Scanner(System.in);
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
//        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        String[] str_array = s.split(",");
        int[] nums = new int[str_array.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str_array[i]);
        }
        return nums;
//        int n=sc.nextInt();
//        int[] nums=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]=sc.nextInt();
//        }
//        sc.close();
//        return nums;
    }

    public static void test_有效的括号() {
//        Scanner sc=new Scanner(System.in);
        while (true) {
            String s = sc.next();
            System.out.println(new _有效的括号().isValid(s));
        }
    }

    public static void test_最接近的三数之和() {
        int[] nums = {-1, 2, 1, -4};
        int[] nums1 = {0, 2, 1, -3};
        System.out.println(new _最接近的三数之和().threeSumClosest(nums1, 1));
    }

    public static void test_三数之和() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums1 = {0, 0, 0};
        System.out.println(new _三数之和().threeSum(nums));
    }

    public static void test_最长公共前缀() {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};
        System.out.println(new _最长公共前缀().longestCommonPrefix(strs1));
    }

    public static void test_寻找两个正序数组的中位数() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new _寻找两个正序数组中的中位数().findMedianSortedArrays(nums1, nums2));
    }

    public static void test_字符串转换整数() {
        String str = " - 42";
        System.out.println(new _字符串转换整数().myAtoi(str));
    }

    public static void test_demo() {
//        System.out.println("9223372036854775807");

        System.out.println("20000000000000000000");
        System.out.println(Long.parseLong("20000000000000000000"));
    }
}
