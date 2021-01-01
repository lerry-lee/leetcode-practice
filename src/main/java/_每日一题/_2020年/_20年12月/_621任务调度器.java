package _每日一题._2020年._20年12月;


import java.util.*;

/**
 * @ClassName: _621任务调度器
 * @Author: lerry_li
 * @CreateTime: 2020/12/05
 * @Description
 */
public class _621任务调度器 {
    /**
     * 解法1：桶
     *
     * 我们设计桶的大小为 n+1，则相同的任务恰好不能放入同一个桶，最密也只能放入相邻的桶。
     *
     * 对于重复的任务，我们只能将每个都放入不同的桶中，
     * 因此桶的个数就是重复次数最多的任务的个数。
     *
     * 一个桶不管是否放满，其占用的时间均为 n+1，
     * 这是因为后面桶里的任务需要等待冷却时间。
     * 最后一个桶是个特例，由于其后没有其他任务需等待，所以占用的时间为桶中的任务个数。
     *
     * 最终我们得到：
     *
     * 总排队时间 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数
     *
     * 每个桶的长度至少为n+1,当重复率比较低的时候，
     * n+1长度的桶全部装满，此时可以在前面的桶上任一扩展长度，
     * 只要把剩下的任务完全放进去即可，注意，这时候每个桶的长度可能不等，
     * 但是均可以保证间隔不低于n，按桶顺序执行即可，
     * 于是可以得到 任务数即为总的最小耗时
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxCount = 0;
        for (char task : tasks) {
            hashMap.put(task, hashMap.getOrDefault(task, 0) + 1);
            maxCount = Math.max(maxCount, hashMap.get(task));
        }
        int maxCount_nums = 0;
        for (char task : hashMap.keySet()) {
            if (hashMap.get(task) == maxCount) {
                maxCount_nums++;
            }
        }
        return Math.max((maxCount - 1) * (n + 1) + maxCount_nums, tasks.length);
    }

    public static void main(String[] args) {
        _621任务调度器 instance = new _621任务调度器();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] tasks1 = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(instance.leastInterval(tasks, 2));
    }
}
