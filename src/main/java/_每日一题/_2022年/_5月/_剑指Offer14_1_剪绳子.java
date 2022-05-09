package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _剑指Offer14_1_剪绳子 {

    public static void main(String[] args) {
        System.out.println(Math.pow(3,6)*4);
    }

    /**
     * 解法1：尽量分成3
     */
    class Solution {
        public int cuttingRope(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            if (n == 4) return 4;
            return dfs(n);
        }
        private int dfs(int n){
            if(n==2) return 2;
            if(n==3) return 3;
            if (n == 4) return 4;
            return dfs(n-3)*3;
        }
    }
}
