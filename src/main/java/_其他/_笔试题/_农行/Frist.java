package _其他._笔试题._农行;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/06
 */
public class Frist {
    public void gets(Frist f) {
        System.out.println(f.toString());
    }

    public String toString() {
        return "First";
    }

//    public static void main(String[] args) {
//        Frist f = new Second();
//        System.out.println(f);
//    }

    static class Second extends Frist {
        public String toString() {
            return "Second" + super.toString();
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{5, 3, 4, 2, 3}, {1, 5, 2, 2, 3}, {3, 2, 5, 2, 1}, {1, 4, 2, 5, 2}, {1, 2, 3, 1, 5}};
        Frist instance = new Frist();
        String[] m = new String[]{"5,3,4,2,3", "1,5,2,2,3", "3,2,5,2,1", "1,4,2,5,2", "1,2,3,1,5"};
        Float[] data = new Float[]{22.1f, 22.3f, 22.4f, 22.7f, 22.0f, 24.0f, 25.0f, 27.0f, 28.0f, 27.0f, 29.0f, 27.0f,
                26.0f, 25.0f, 24.0f, 24.0f, 23.0f, 21.0f, 20.0f, 22.0f};
        System.out.println(instance.findBestMan(m));
        System.out.println(Arrays.toString(instance.getKAverage(data, 5)));
    }

    public int findBestMan(String[] Rel_Matrix) {
        int maxSum = 0;
        int bestMan = 0;
        int cols = Rel_Matrix[0].split(",").length;
        for (int col = 0; col < cols; col++) {
            int sum = 0;
            for (String matrix : Rel_Matrix) {
                String[] curRow = matrix.split(",");
                sum += Integer.parseInt(curRow[col]);
            }
            if (sum > maxSum) {
                maxSum = sum;
                bestMan = col;
            }
        }
        return bestMan;
    }

    public Float[] getKAverage(Float[] raw_data, int k) {
        int n = raw_data.length;
        Float[] prefixSum = new Float[n];
        prefixSum[0] = raw_data[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + raw_data[i];
        }
        Float[] res = new Float[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            float sumK = i > 0 ? prefixSum[i + k - 1] - prefixSum[i - 1] : prefixSum[i + k - 1];
            res[i] = sumK / k;
        }
        return res;
    }

}
