package _力扣每日一题._20年8月;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/08/01 12:22
 * @description 顺次数
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 */
public class _1291顺次数 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int num = getNumFromWei(getWei(low));
        while (num <= high) {
            if (num >= low) res.add(num);
            num = getNext(num);
            // System.out.println(num);
        }
        return res;
    }

    public int getNext(int n) {
        int wei = getWei(n);
        int wei_10 = (int) Math.pow(10, wei - 1);
        int nextN = n % wei_10;
        int tail = n % 10;
        // System.out.println("wei_10:"+wei_10+" nextN:"+nextN+" tail:"+tail);
        if (tail == 9) {
            return getNumFromWei(wei + 1);
        }
        return nextN * 10 + tail + 1;
    }

    public int getWei(int n) {
        int wei = 0;
        while (n > 0) {
            n /= 10;
            wei++;
        }
        return wei;
    }

    public int getNumFromWei(int wei) {
        if (wei == 1) wei = 2;
        int n = 1;
        int tail = n % 10;
        while (wei > 1) {
            n = n * 10 + tail + 1;
            tail++;
            wei--;
        }
        return n;
    }
}
