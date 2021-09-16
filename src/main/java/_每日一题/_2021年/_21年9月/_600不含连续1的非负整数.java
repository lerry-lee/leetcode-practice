package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/11
 */
public class _600不含连续1的非负整数 {
    /**
     * 解法1：dfs
     */
    public int findIntegers(int n) {
        N = n;
        res = 0;
        dfs(1);
        return res;
    }

    private void dfs(int cur) {
        if (cur > N) return;
        res++;
        //末位是1，下一位只能添加0
        if ((cur & 1) == 1) dfs(cur << 1);
            //否则，末位是0，下一位可以添加0或者1
        else {
            dfs(cur << 1);
            dfs((cur << 1) + 1);
        }
    }

    int N;
    int res;

    /**
     * 解法2：dp
     */
    public int findIntegers2(int num) {
        /*
        dp[i] = dp[i - 1] + dp[i - 2]
        */
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //15  ->  1111
        String numStr = getBinary(num);

        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            //当前位是0，跳过
            if (numStr.charAt(i) == '0') {
                continue;
            }
            //当前位是1，计算后面剩余位数的情况
            res += dp[numStr.length() - i - 1];
            //出现连续的1时，停止计算
            if (i != 0 && numStr.charAt(i - 1) == '1') {
                return res;
            }
        }

        return res + 1;
    }


    //get the binary form of number
    //15  -> 1111
    private String getBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, num & 1);
            num >>= 1;
        }

        return sb.toString();
    }
}
