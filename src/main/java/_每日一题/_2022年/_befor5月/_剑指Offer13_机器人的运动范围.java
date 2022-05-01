package _每日一题._2022年._befor5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _剑指Offer13_机器人的运动范围 {
    /**
     * 解法1：dfs
     */
    class Solution {
        int res;
        int m,n,k;
        boolean[][] visited;
        public int movingCount(int m, int n, int k) {
            if(k<0) return 0;
            res=0;
            this.m=m;
            this.n=n;
            this.k=k;
            visited=new boolean[m][n];
            dfs(0,0);
            return res;
        }
        public void dfs(int i,int j){
            if(i<0||i==m||j<0||j==n) return;
            if(visited[i][j]) return;
            if(isValid(i,j)){
                visited[i][j]=true;
                res++;
                dfs(i+1,j);
                dfs(i-1,j);
                dfs(i,j+1);
                dfs(i,j-1);
            }
        }
        public boolean isValid(int i,int j){
            int digitSum=0;
            while(i>0){
                digitSum+=i%10;
                i/=10;
            }
            while(j>0){
                digitSum+=j%10;
                j/=10;
            }
            return digitSum<=k;
        }
    }
}
