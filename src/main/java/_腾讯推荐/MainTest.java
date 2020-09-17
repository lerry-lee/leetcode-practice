package _腾讯推荐;

import _腾讯推荐._数组与字符串.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/12 11:00
 * @description 测试主程序
 */
public class MainTest {
    static Logger log = LogManager.getLogger("TRACE_ALL");
    public static void main(String[] args) {
        log.info("开始测试");
        long t1 = System.currentTimeMillis();
        test_最接近的三数之和();
        long t2 = System.currentTimeMillis();
        log.info("测试结束，耗时:%dms", (t2 - t1));
    }

    public static void test_最接近的三数之和(){
        int[] nums={-1,2,1,-4};
        int[] nums1={0,2,1,-3};
        System.out.println(new _最接近的三数之和().threeSumClosest(nums1,1));
    }

    public static void test_三数之和(){
        int[] nums={-1, 0, 1, 2, -1, -4};
        int[] nums1={0,0,0};
        System.out.println(new _三数之和().threeSum(nums));
    }

    public static void test_最长公共前缀(){
        String[] strs={"flower","flow","flight"};
        String[] strs1={"dog","racecar","car"};
        System.out.println(new _最长公共前缀().longestCommonPrefix(strs1));
    }

    public static void test_寻找两个正序数组的中位数(){
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(new _寻找两个正序数组中的中位数().findMedianSortedArrays(nums1,nums2));
    }
    public static void test_字符串转换整数(){
        String str=" - 42";
        System.out.println(new _字符串转换整数().myAtoi(str));
    }

    public static void test_demo(){
//        System.out.println("9223372036854775807");

        System.out.println("20000000000000000000");
        System.out.println(Long.parseLong("20000000000000000000"));
    }
}
