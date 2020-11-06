package ByteDance._字符串;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/30 09:52
 * @description 测试主程序
 */
public class Main {

    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {
        log.info("执行测试");
        test_复原IP地址();
        log.info("执行结束");
    }

    public static void test_复原IP地址(){
        String s="25525511135";
//        new _复原IP地址().func();
        System.out.println(new _复原IP地址().run(s));
    }

    public static void test_字符串的排列(){
        String s1 = "ab",s2 = "eidboaoo";
        System.out.println(new _字符串的排列().mtd(s1,s2));
    }

    public static void test_最长公共前缀(){
        String[] s={"flower","flow","flight"};
        String[] s1={"dog","racecar","car"};
        System.out.println(new _最长公共前缀().longestCommonPrefix(s1));
    }

    public static void test_无重复字符的最长子串(){
        String s="abba";
        System.out.println(new _无重复字符的最长子串().lengthOfLongestSubstring(s));
    }
}
