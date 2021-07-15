package _每日一题._2021年._21年7月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _556下一个更大元素3
 * @Author: lerry_li
 * @CreateDate: 2021/07/14
 * @Description
 */
public class _556下一个更大元素3 {

    public static void main(String[] args) {
        _556下一个更大元素3 instance = new _556下一个更大元素3();
        System.out.println(instance.nextGreaterElement(12));
        System.out.println(instance.nextGreaterElement(21));
        System.out.println(instance.nextGreaterElement(101));
    }

    /**
     * 借助下一个排列的解法
     */
    public int nextGreaterElement(int n) {
        //将n的每一位取出来
        List<Integer> nums = new ArrayList<>();
        int n_cp = n;
        while (n_cp > 0) {
            nums.add(n_cp % 10);
            n_cp /= 10;
        }
        //找下一个更大的排列

        //1.copy数组，从高位到低位
        int len = nums.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums.get(len - 1 - i);
        }
        //2.从后往前找第一个降序的数
        int i = len - 2;
        for (; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) break;
        }
        //若没找到，则返回-1
        if (i < 0) return -1;
        //从i开始往后，找比i大的里面最小的数
        int j = i + 1;
        for (; j < len; j++) {
            if (arr[j] <= arr[i]) break;
        }
        //交换
        swap(arr, i, j - 1);
        //对后面的数排序
        Arrays.sort(arr, i+1, len);
        long res = 0;
        for (int k = 0; k < len; k++) {
            res = res * 10 + arr[k];
            if (res > Integer.MAX_VALUE) return -1;
        }
        return (int) res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
