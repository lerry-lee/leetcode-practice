package _腾讯推荐;

import _腾讯推荐._数组与字符串._寻找两个正序数组中的中位数;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/12 11:00
 * @description TODO
 */
public class MainTest {
    static Logger log = LogManager.getLogger("TRACE_ALL");
    public static void main(String[] args) {
        log.info("开始测试");
        long t1 = System.currentTimeMillis();
        test_寻找两个正序数组的中位数();
        long t2 = System.currentTimeMillis();
        log.info("测试结束，耗时:%dms", (t2 - t1));
    }
    public static void test_寻找两个正序数组的中位数(){
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(new _寻找两个正序数组中的中位数().findMedianSortedArrays(nums1,nums2));
    }
}
