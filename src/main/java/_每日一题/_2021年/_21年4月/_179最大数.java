package _每日一题._2021年._21年4月;

import java.util.*;

/**
 * @ClassName: _179最大数
 * @Author: lerry_li
 * @CreateDate: 2021/04/12
 * @Description
 */
public class _179最大数 {
    /**
     * 解法1：自定义排序（手写quickSort） 时间O(NlogNlogM) 空间O(logN)
     * 思路：
     *      自定义排序规则：不是比较a和b的大小，而是比较ab和ba的大小
     *      例如：a=21,b=2； ab=212， ba=221，则ba>ab
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        if (nums[0] == 0) {
            return "0";
        }
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
//        int p = left + new Random().nextInt(right - left);
//        swap(nums, p, left);
        int p = left;
        while (left < right) {
            //right比p小的，跳过；right找大的
            while (left < right && compare(nums[p], nums[right])) {
                right--;
            }
            //left比p大的，跳过；left找小的
            while (left < right && compare(nums[left], nums[p])) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, p, left);
        return left;
    }

    //比较ab和ba的大小，前者大返回true
    private boolean compare(int a, int b) {
        if (a == b) {
            return true;
        }
        if (a == 0) {
            return false;
        }
        if (b == 0) {
            return true;
        }
        long ab = a, ba = b;
        int temp_a = a, temp_b = b;
        while (temp_a > 0) {
            ba *= 10;
            temp_a /= 10;
        }
        ba += a;
        while (temp_b > 0) {
            ab *= 10;
            temp_b /= 10;
        }
        ab += b;
        return ab >= ba;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 解法2：利用API自定义排序 时间O(NlogNlogM) 空间O(logN)
     */
    public String largestNumber2(int[] nums) {
        //转换乘包装类型，以便传入比较器
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, (a, b) -> {
            if (a.equals(b)) {
                return 0;
            }
            if (a == 0) {
                return 1;
            }
            if (b == 0) {
                return -1;
            }
            long ab = a, ba = b;
            int temp_a = a, temp_b = b;
            while (temp_b > 0) {
                ab *= 10;
                temp_b /= 10;
            }
            ab += b;
            while (temp_a > 0) {
                ba *= 10;
                temp_a /= 10;
            }
            ba += a;
            return Long.compare(ba, ab);
        });
        if (numbers[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer num : numbers) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _179最大数 instance = new _179最大数();
        System.out.println(instance.largestNumber2(new int[]{10, 2}));//210
        System.out.println(instance.largestNumber2(new int[]{3, 30, 34, 5, 9}));//9534330
        System.out.println(instance.largestNumber2(new int[]{1}));//1
        System.out.println(instance.largestNumber2(new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
//        System.out.println(instance.largestNumber(new int[]{0, 2, 1}));//210
//        System.out.println(instance.largestNumber(new int[]{25, 2, 21, 0}));//252210
//        System.out.println(instance.largestNumber(new int[]{34323, 3432}));//343234323
//        System.out.println(instance.largestNumber(new int[]{999999998, 999999997, 999999999}));
//        System.out.println(instance.largestNumber(new int[]{0, 0}));
//        System.out.println(instance.largestNumber(new int[]{0}));
//        System.out.println(instance.largestNumber(new int[]{0, 1, 0}));
    }
}
