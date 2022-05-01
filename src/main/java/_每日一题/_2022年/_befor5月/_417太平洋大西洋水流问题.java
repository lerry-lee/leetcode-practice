package _每日一题._2022年._befor5月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/27
 * @Description
 */
public class _417太平洋大西洋水流问题 {
    /**
     * 解法1：问题分解+dfs
     * 思路：
     *      题目要求从某个单元格可以递减的到达矩阵边界，反过来想，可以从矩阵边界递增的找到这些单元格。
     *      题目转化为：
     *          从矩阵上和左边界找到递增的所有单元格，用pacific[][]标记；
     *          从矩阵下和右边界找到递增的所有单元格，用atlantic[][]标记，
     *          然后遍历矩阵，两个标记数组都为true的单元格，即为合法的一个解。
     */
    class Solution {
        List<List<Integer>> res;
        int m,n;
        boolean[][] visited;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            res=new ArrayList();
            if(heights==null||heights.length==0) return res;
            m=heights.length;
            n=heights[0].length;
            visited=new boolean[m][n];
            boolean[][] pacific=new boolean[m][n];
            boolean[][] atlantic=new boolean[m][n];
            for(int i=0;i<m;i++){
                dfs(heights,i,0,pacific);
                dfs(heights,i,n-1,atlantic);
            }
            for(int j=0;j<n;j++){
                dfs(heights,0,j,pacific);
                dfs(heights,m-1,j,atlantic);
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(pacific[i][j]&&atlantic[i][j]){
                        res.add(Arrays.asList(i,j));
                    }
                }
            }
            return res;
        }
        public void dfs(int[][] heights,int i,int j,boolean[][] ocean){
            if(ocean[i][j]) return;
            ocean[i][j]=true;
            if(i>0&&heights[i-1][j]>=heights[i][j]){

                dfs(heights,i-1,j,ocean);

            }
            if(j>0&&heights[i][j-1]>=heights[i][j]){

                dfs(heights,i,j-1,ocean);

            }
            if(i<m-1&&heights[i+1][j]>=heights[i][j]){

                dfs(heights,i+1,j,ocean);

            }
            if(j<n-1&&heights[i][j+1]>=heights[i][j]){

                dfs(heights,i,j+1,ocean);

            }
        }
    }
}
