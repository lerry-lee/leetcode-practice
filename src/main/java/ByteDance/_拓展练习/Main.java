package ByteDance._拓展练习;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/29 16:09
 * @description 测试主程序
 */
public class Main {
    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {
        log.info("执行测试");
        test_UTF8编码验证();
        log.info("执行结束");
    }

    public static void test_UTF8编码验证() {
        int[] a = {197, 130, 1};
        System.out.println(new _UTF8编码验证().validUtf8(a));
    }

    public static void test_x的平方根() {
        System.out.println(new _x的平方根().mySqrt_Newton(2147483647));
    }
}
