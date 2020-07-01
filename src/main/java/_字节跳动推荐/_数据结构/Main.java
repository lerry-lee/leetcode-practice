package _字节跳动推荐._数据结构;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * @author lerry_lee
 * @version 1.0
 * @create 2020/06/24 10:03
 * @description 测试主程序
 */
public class Main {


    static Logger log = LogManager.getLogger("TRACE_ALL");

    public static void main(String[] args) {

        log.info("开始执行测试");
        long t1 = System.currentTimeMillis();
        test_LRUCache();
        long t2 = System.currentTimeMillis();
        log.info("耗时：" + (t2 - t1) + "ms");
    }

    public static void test_LRUCache() {
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1);

        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public static void test_LRUCache2() {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);

        cache.put(2, 2);

        System.out.println(cache.get(1));       // 返回  1

        cache.put(3, 3);    // 该操作会使得关键字 2 作废

        System.out.println(cache.get(2));       // 返回 -1 (未找到)

        cache.put(4, 4);    // 该操作会使得关键字 1 作废

        System.out.println(cache.get(1));       // 返回 -1 (未找到)

        System.out.println(cache.get(3));       // 返回  3

        System.out.println(cache.get(4));       // 返回  4

    }

    public static void test_MinStack() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
