package _每日一题._2020年._20年11月;

import java.util.Arrays;

/**
 * @ClassName: _1356根据数字二进制下1的数目排序
 * @Signature: Created by lerry_li on 2020/11/06
 * @Description: 给你一个整数数组arr。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * <p>
 * 如果存在多个数字二进制中1的数目相同，则必须将它们按照数值大小升序排列。
 * <p>
 * 请你返回排序后的数组。
 */
public class _1356根据数字二进制下1的数目排序 {
    /**
     * 解法1：排序
     * 定义二维数组helper[i][j]，i表示arr[i]，j表示arr[i]的二进制数中1的个数
     * 然后对helper[][]排序，按helper[][j]升序排序，当相等时按helper[i][]升序排序
     */
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[][] helper = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
//            String binaryI = Integer.toBinaryString(arr[i]);
//            int binaryI_1nums = cal1numsByString(binaryI);
            int binaryI_1nums = cal1numsByInt(arr[i]);
            helper[i][0] = arr[i];
            helper[i][1] = binaryI_1nums;
        }
        //lambda表达式
        Arrays.sort(helper, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
//        Arrays.sort(helper, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//                return o1[1] - o2[1];
//            }
//        });

        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = helper[i][0];
        }
        return res;
    }

    //将数字转换成二进制字符串，然后统计1的个数
    public int cal1numsByString(String s) {
        int nums = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                nums++;
            }
        }
        return nums;
    }

    //直接对数字统计1的个数
    public int cal1numsByInt(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        _1356根据数字二进制下1的数目排序 instance = new _1356根据数字二进制下1的数目排序();
        int[] res = instance.sortByBits(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
    }
}
