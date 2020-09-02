package _力扣每日一题;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;


/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/01 21:14
 * @description 测试主程序
 */
public class _0_Main {
    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {
        log.info("开始测试");
        long t1 = System.currentTimeMillis();
        System.out.println(t3(35));
        long t2 = System.currentTimeMillis();
        log.info("测试结束，耗时:%dms", (t2 - t1));
    }

    public static int t3(int a){
        int maxVal=0;
        for(int m=1;m<=a/2;m++){
            int n=a-m;
            maxVal=Math.max(maxVal,calVal(m)+calVal(n));
        }
        return maxVal;
    }
    public static int calVal(int num){
        int res=0,wei;
        while(num>0){
            wei=num%10;
            res+=wei;
            num/=10;
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
        res.length();
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
        _先序遍历(res);
        System.out.println();
    }

    public static void test_1008() {
        int[] a = {8, 5, 1, 7, 10, 12};
        TreeNode res = new _1008先序遍历构造二叉树()._用栈(a);
        _先序遍历(res);
        System.out.println();
    }

    public static void _先序遍历(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        _先序遍历(node.left);
        _先序遍历(node.right);
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
