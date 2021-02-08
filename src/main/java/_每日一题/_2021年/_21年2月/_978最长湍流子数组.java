package _每日一题._2021年._21年2月;

/**
 * @ClassName: _978最长湍流子数组
 * @Author: lerry_li
 * @CreateTime: 2021/02/08
 * @Description
 */
public class _978最长湍流子数组 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i][j]表示，当状态为j时，以元素arr[i]结尾的最大湍流子数组的长度
     *      j=0：末尾是下降的，即arr[i]<arr[i-1]
     *      j=1：末尾是上升的，即arr[i]>arr[i-1]
     * 状态转移：
     *      (1)若arr[i]>arr[i-1],则：
     *      dp[i][1]=dp[i-1][0]+1
     *      dp[i][0]=1
     *      (2)若arr[i]<arr[i-1],则：
     *      dp[i][0]=dp[i-1][1]+1
     *      dp[i][1]=1
     *      (3)否则:
     *      dp[i][0]=1
     *      dp[i][1]=1
     * 初始化：
     *      dp[0][0]=1
     *      dp[0][1]=1
     * 返回：
     *      dp数组最大值
     *
     */
    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[][] dp = new int[len][2];
        dp[0][1] = 1;
        dp[0][0] = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else if (arr[i] < arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

    /**
     * 解法2：双指针 时间O(N) 空间O(1)
     */
    public int maxTurbulenceSize2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        //[left,right]左闭右闭区间
        int left = 0;
        int right = 0;
        //末尾是否为下降
        boolean down = false;
        //最大长度
        int res = 0;
        //滑动窗口的元素个数
        int count = 0;
        while (right < len) {
            //第一个元素直接窗口+1
            if (right == 0) {
                count++;
            }
            //如果滑动窗口内只有一个元素
            else if (count == 1) {
                count++;
                if (arr[right] > arr[right - 1]) {
                    down = false;
                } else if (arr[right] < arr[right - 1]) {
                    down = true;
                } else {
                    count = 1;
                }
            }
            //如果上一段的末尾是下降的
            else if (down) {
                //如果当前元素大于上一个元素，则可以构成摆动序列，长度+1，同时末尾变上升
                if (arr[right] > arr[right - 1]) {
                    down = false;
                    count++;
                }
                //如果当前元素小于上一个元素，则不可以构成摆动序列，长度=2，同时末尾仍未下降，左窗口移动到右窗口前面一位
                else if (arr[right] < arr[right - 1]) {
                    count = 2;
                    left = right - 1;
                }
                //否则，即当前元素=上一个元素，则滑动窗口大小为1，只有当前元素，左窗口移动过来和右窗口一样
                else {
                    count = 1;
                    left = right;
                }
            } else {
                if (arr[right] < arr[right - 1]) {
                    down = true;
                    count++;
                } else if (arr[right] > arr[right - 1]) {
                    count = 2;
                    left = right - 1;
                } else {
                    count = 1;
                    left = right;
                }
            }
            right++;
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        _978最长湍流子数组 instance = new _978最长湍流子数组();
        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(instance.maxTurbulenceSize2(arr));
        int[] arr1 = {4, 8, 12, 16};
        System.out.println(instance.maxTurbulenceSize2(arr1));
        int[] arr2 = {100};
        System.out.println(instance.maxTurbulenceSize2(arr2));
    }
}
