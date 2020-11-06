package Tecent._数组与字符串;

/**
 * Created by lerry_li on 2020/09/26
 */

/**
 * 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class _螺旋矩阵2 {
    /**
     * 解法1：按圈遍历 →↓←↑
     * tips：因为确定为正方形矩阵，因此比螺旋矩阵少了一些判断边界的条件，更简单
     */
    public int[][] generateMatrix(int n) {
        if(n==0) return new int[][]{};
        int[][] matrix=new int[n][n];
        int cnt=1;
        int left=0,right=n-1;
        int top=0,bottom=n-1;
        int i,j;
        while(left<=right&&top<=bottom){
            for(j=left;j<=right;j++){
                matrix[top][j]=cnt++;
            }
            for(i=top+1;i<=bottom;i++){
                matrix[i][right]=cnt++;
            }
            for(j=right-1;j>=left;j--){
                matrix[bottom][j]=cnt++;
            }
            for(i=bottom-1;i>top;i--){
                matrix[i][left]=cnt++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
