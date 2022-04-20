package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/20
 */
public class _剑指offer_4_二维数组中的查找 {
    /**
     * 解法1：二叉树搜索
     * 数组右上角或左下角的元素作为根节点，他们上方的元素比他们小，下方的元素比他们大，左侧的元素比他们小，右侧的元素比他们大，可以二叉搜索
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int m=matrix.length,n=matrix[0].length;
        int i=0,j=n-1;
        while(i<m&&j>=0){
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]<target) i++;
            else j--;
        }
        return false;
    }
}
