package _每日一题._2021年._21年9月;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/08
 */
public class _502_IPO {
    /**
     * 解法1：优先队列（大顶堆）+贪心 时间(KlogN) 空间O(N)
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (capital == null || capital.length == 0 || k <= 0) return w;
        int n = profits.length;
        //项目按启动资金从小到大排序
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        //大顶堆，存放项目的利润，从大到小排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        int res = w;
        //记录项目下标
        int projectIdx = 0;
        for (int i = 0; i < k; i++) {
            //每次把启动资金<=当前持有资本的项目加入maxHeap
            while (projectIdx < n && projects[projectIdx][0] <= res) {
                maxHeap.offer(projects[projectIdx][1]);
                projectIdx++;
            }
            //从可选项目里挑利润最大的
            if (!maxHeap.isEmpty()) {
                res += maxHeap.poll();
            } else {
                break;
            }
        }
        return res;
    }
}
