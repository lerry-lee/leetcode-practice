package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _274H指数
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：排序
 */
public class _274H指数 {

    public static void main(String[] args) {
        _274H指数 instance = new _274H指数();
        System.out.println(instance.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(instance.hIndex(new int[]{1, 3, 1}));
    }

    /**
     * 解法1：排序
     * 首先我们可以将初始的 H 指数 h 设为 0，然后将引用次数排序，并且对排序后的数组从大到小遍历。
     * 根据 H 指数的定义，如果当前 H 指数为 h 并且在遍历过程中找到当前值citations[i]>h，
     * 则说明我们找到了一篇被引用了至少 h+1 次的论文，所以将现有的 h 值加 1。
     * 继续遍历直到 h 无法继续增大。最后返回 h 作为最终答案。
     */
    public int hIndex(int[] citations) {
        //特判
        if (citations == null || citations.length == 0) return 0;
        //排序
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        int i = n - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

}
