package Others._TODO;

import java.util.Arrays;

/**
 * Created by lerry_li on 2020/10/24
 */

/**
 * 视频拼接
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 *
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 *
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 */
public class _1024视频拼接 {
    /**
     * 解法1：动态规划 时间O(T*N) 空间O(T)
     * 状态定义：dp[i]表示覆盖区间[0,i]所需的最少区间个数
     * 初始化：dp[0]=0，dp[i]为较大数
     * 状态转移：若i在区间[a,b]中，说明[0,i]的后一部分可以有一个[a,b]区间覆盖，只要前一部分[0,a]有区间覆盖即可，
     *          则dp[i]=min(dp[i],dp[a]+1)
     * 最终返回dp[]最后一个元素即可
     */
    public int videoStitching(int[][] clips, int T) {
        if(clips==null|clips.length==0) return -1;
        int[] dp=new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        for (int i = 1; i < T+1; i++) {
            for (int[] clip : clips) {
                if (i > clip[0] && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE-1?-1:dp[T];
    }
    /**
     * 解法2：贪心 时间O(T+N) 空间O(T)
     * TODO
     */
    public int videoStitching2(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
