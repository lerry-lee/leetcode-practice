package _每日一题._2021年._21年2月;

/**
 * @ClassName: _766托普利茨矩阵
 * @Author: lerry_li
 * @CreateTime: 2021/02/22
 * @Description 进阶问题
 * 对于进阶问题一，一次最多只能将矩阵的一行加载到内存中，
 * 我们将每一行复制到一个连续数组中，随后在读取下一行时，就与内存中此前保存的数组进行比较。
 *
 * 对于进阶问题二，一次只能将不完整的一行加载到内存中，
 * 我们将整个矩阵竖直切分成若干子矩阵，并保证两个相邻的矩阵至少有一列或一行是重合的，然后判断每个子矩阵是否符合要求。
 */
public class _766托普利茨矩阵 {
    /**
     * 解法1：模拟（按对角线遍历） 时间O(MN) 空间O(1)
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        //先遍历左下角
        for (int i = rows - 1; i >= 0; i--) {
            int firstNum = matrix[i][0];
            for (int curI = i + 1, curJ = 1; curI < rows && curJ < cols; curI++, curJ++) {
//                int nextNum = matrix[curI][curJ];
                if (matrix[curI][curJ] != firstNum) {
                    return false;
                }
            }
        }
        //再遍历右上角
        for (int j = 1; j < cols; j++) {
            int firstNum = matrix[0][j];
            for (int curI = 1, curJ = j + 1; curI < rows && curJ < cols; curI++, curJ++) {
//                int nextNum = matrix[curI][curJ];
                if (matrix[curI][curJ] != firstNum) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 解法2：一次便利（比较该元素和左上角相邻元素） 时间O(MN) 空间O(1)
     */
    public boolean isToeplitzMatrix2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        //由于第0行、第0列没有左上角，因此从第1行、第1列开始
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 解法3：每次比较矩阵的一行和上一行 时间O(MN) 空间O(N)
     */
    public boolean isToeplitzMatrix3(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int[] oneRow = null;
        for (int[] row : matrix) {
            if (oneRow != null) {
                for (int i = 0; i < cols - 1; i++) {
                    if (oneRow[i] != row[i + 1]) {
                        return false;
                    }
                }
            }
            oneRow = row;
        }
        return true;
    }

    /**
     * 解法4：解法3空间优化 时间O(MN) 空间O(1)
     */
    public boolean isToeplitzMatrix4(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows-1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _766托普利茨矩阵 instance = new _766托普利茨矩阵();
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix2 = {{1, 2}, {2, 2}};
        int[][] matrix3 = {{65, 98, 57}};
        System.out.println(instance.isToeplitzMatrix(matrix1));
        System.out.println(instance.isToeplitzMatrix(matrix2));
        System.out.println(instance.isToeplitzMatrix(matrix3));
    }
}
