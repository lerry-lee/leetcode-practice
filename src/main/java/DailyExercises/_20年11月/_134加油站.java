package DailyExercises._20年11月;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: _134加油站
 * @Signature: Created by lerry_li on 2020/11/18
 * @Description:
 */
public class _134加油站 {
    /**
     * 解法1：遍历所有可能的起点 时间O(N^2) 空间O(N)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }
        int gasSum = 0, costSum = 0;
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            if (gas[i] >= cost[i]) {
                starts.add(i);
            }
        }
        if (costSum > gasSum) {
            return -1;
        }
        for (int startIdx : starts) {
            int idx = startIdx;
            gasSum = 0;
            do {
                gasSum += gas[idx] - cost[idx];
                if (gasSum < 0) {
                    break;
                }
                idx++;
                if (idx == gas.length) {
                    idx = 0;
                }
            } while (idx != startIdx);
            if (idx == startIdx) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * 解法2：数学推导 时间O(N) 空间O(1)
     * 思路：推导见官方题解
     *      从第0个加油站开始遍历，如果能环绕一周，则返回0，否则：
     *          从第一个不能到达的加油站开始遍历，看能否环绕一周；
     *          到最后一个加油站为止；
     */
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;

        // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
        while (start < n) {
            int gasRemain = 0;//行驶后剩的油量
            int count = 0;     // 记录能走过几个站点

            while (count < n) {  // 退出循环的条件是走过所有的站点
                int j = (start + count) % n; // 加油站是环形的

                gasRemain += gas[j] - cost[j];

                if (gasRemain < 0) {
                    break;
                }

                count++; // 这个站点满足情况

            }

            if (count == n) {  // 如果能环绕一圈
                return start;
            } else { // 不行的话 从下一个站点开始 检查
                start = start + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;

    }

    /**
     * 解法2的自己理解版
     */
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return -1;
        }

        //起点
        int startIdx = 0;
        //用一个哈希表存遍历过的起点
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(0);
        //遍历所有起点，但不是挨个遍历
        do {
            //剩余油量
            int gasRemain = 0;
            //遍历下标
            int idx = startIdx;
            do {
                gasRemain += gas[idx] - cost[idx];
                if (gasRemain < 0) {
                    break;
                }
                idx++;
                if (idx == gas.length) {
                    idx = 0;
                }
            } while (idx != startIdx);
            if (idx == startIdx) {
                return startIdx;
            }
            startIdx = idx;
            hashSet.add(startIdx);
        } while (!hashSet.contains(startIdx));
        return -1;
    }

    public static void main(String[] args) {
        _134加油站 instance = new _134加油站();

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        System.out.println(instance.canCompleteCircuit3(gas, cost));
    }
}
