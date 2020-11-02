package _其他._笔试题._华为;

import java.util.Scanner;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/09 19:37
 * @description TODO 带记忆的深度优先搜索
 */
public class _第2题最长水沟 {
    static int max_length=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] nums=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                nums[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                dfs(visited,nums,m,n,i,j,0);
            }
        }

        System.out.println(max_length);

    }
    public static void dfs(boolean[][] visited,int[][] nums,int m,int n,int i,int j,int length){
        max_length=Math.max(max_length,length);
        if(i>0&&nums[i][j]>nums[i-1][j]) {
            visited[i][j]=true;
            dfs(visited, nums, m, n, i - 1, j, length + 1);
            visited[i][j]=false;
        }
        if(j>0&&nums[i][j]>nums[i][j-1]) {
            visited[i][j]=true;
            dfs(visited, nums, m, n, i, j - 1, length + 1);
            visited[i][j]=false;
        }
        if(i<m-1&&nums[i][j]>nums[i+1][j]) {
            visited[i][j]=true;
            dfs(visited, nums, m, n, i + 1, j, length + 1);
            visited[i][j]=false;
        }
        if(j<n-1&&nums[i][j]>nums[i][j+1]) {
            visited[i][j]=true;
            dfs(visited, nums, m, n, i, i + 1, length + 1);
            visited[i][j]=false;
        }
    }
}
