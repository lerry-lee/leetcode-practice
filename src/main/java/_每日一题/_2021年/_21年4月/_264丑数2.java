package _每日一题._2021年._21年4月;

/**
 * @ClassName: _264丑数2
 * @Author: lerry_li
 * @CreateTime: 2021/04/11
 * @Description
 */
class _264丑数2 {
    /**
     * 解法1：动态规划 时间O(N) 空间O(N)
     * 状态定义：
     *      dp[i]表示第i+1个丑数,i∈[0,n-1]
     * 状态转移：
     *      dp[i]每次取前面[某个丑数_x]x2，[某个丑数_y]x3，[某个丑数_z]x5的最小值
     *      1）[某个丑数_x]使用下标x定位，表示该丑数下次应该x2了，一旦x2后，下标x+1
     *      2）[某个丑数_y]使用下标y定位，表示该丑数下次应该x3了，一旦x3后，下标y+1
     *      3）[某个丑数_z]使用下标z定位，表示该丑数下次应该x5了，一旦x5后，下标z+1
     * 初始化：
     *      dp[0]=1 第1个丑数是1
     *
     * tips:
     *      状态转移1）2）3）不是互斥关系，因为有可能有重复值，凡是符合要求的都要操作，即下标都要+1
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        //初始化
        int[] dp = new int[n];
        dp[0] = 1;
        //相当于x,y,z下标指针
        int index2 = 0, index3 = 0, index5 = 0;
        //状态转移
        for (int i = 1; i < n; i++) {
            //预存x2,x3,x5后的值
            int temp2 = dp[index2] * 2, temp3 = dp[index3] * 3, temp5 = dp[index5] * 5;
            //取最小值
            int minNumber = Math.min(temp2, Math.min(temp3, temp5));
            //若最小的是index2指向的丑数，则index2++
            if (minNumber == temp2) {
                index2++;
            }
            //若最小的是index3指向的丑数，则index3++
            if (minNumber == temp3) {
                index3++;
            }
            //若最小的是index5指向的丑数，则index5++
            if (minNumber == temp5) {
                index5++;
            }
            //赋值，状态转移
            dp[i] = minNumber;
        }
        //返回
        return dp[n - 1];
    }

    public static void main(String[] args) {
        _264丑数2 instance = new _264丑数2();
        System.out.println(instance.nthUglyNumber(10));
    }
}
