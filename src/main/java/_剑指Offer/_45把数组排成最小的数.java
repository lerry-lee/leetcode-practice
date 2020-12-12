package _剑指Offer;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @ClassName: _45把数组排成最小的数
 * @Signature: Created by lerry_li on 2020/11/21
 * @Description:
 */
public class _45把数组排成最小的数 {
    /**
     * 解法1：自定义排序 时间O(NlogM) 空间O(N)
     * 思路：
     * 1.将int数组转化为String数组
     * 2.对String数组排序，两个元素s1,s2拼接比较大小：s1s2和s2s1
     */
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] helper = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            helper[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(helper, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String temp1 = s1 + s2;
                String temp2 = s2 + s1;
                for (int i = 0; i < temp1.length(); i++) {
                    char c1 = temp1.charAt(i);
                    char c2 = temp2.charAt(i);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
                return 0;
            }
        });


        StringBuilder stringBuilder = new StringBuilder();
        for (String helperi : helper) {
            stringBuilder.append(helperi);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        _45把数组排成最小的数 instance = new _45把数组排成最小的数();
        int[] nums = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println("1399439856075703697382478249389609");
        System.out.println(instance.minNumber(nums));
    }
}
