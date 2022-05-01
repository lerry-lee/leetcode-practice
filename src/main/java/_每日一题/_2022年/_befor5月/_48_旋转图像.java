package _每日一题._2022年._befor5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/27
 * @Description
 */
public class _48_旋转图像 {

    public static void main(String[] args) {
        _48_旋转图像 instance=new _48_旋转图像();
        instance.new Solution().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    /**
     * 解法1：原地置换 时间O(N^2) 空间O(1)
     * 思路：
     *      按圈遍历，每次遍历一行，利用坐标关系换数字，圈逐渐缩小
     */
    class Solution {
        public void rotate(int[][] matrix) {
            if(matrix==null||matrix.length==0) return;
            int n=matrix.length;
            //0行~n/2-1行即可
            for(int i=0;i<n/2;i++){
                //圈尾部最后一列是n-1-i，j不用遍历到最后一个元素，因为在置换时，最后一个元素被置换了
                for(int j=i;j<n-1-i;j++){
                    //记录第一个被置换的值，然后用矩阵顺时针90后的该位置的元素替换它
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[n-1-j][i];
                    matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                    matrix[j][n-1-i]=temp;
                }
            }
        }
    }

    /**
     * 解法2：先水平翻转，再按对角线翻转 时间O(N^2) 空间O(1)
     */
    class Solution2 {
        public void rotate(int[][] matrix) {
            if(matrix==null||matrix.length==0) return;
            int n=matrix.length;
            for(int i=0;i<n/2;i++){
                int[] temp=matrix[i];
                matrix[i]=matrix[n-1-i];
                matrix[n-1-i]=temp;
            }
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }
    }
}
