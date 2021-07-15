package _每日一题._2021年._21年7月;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName: _496下一个更大元素1
 * @Author: lerry_li
 * @CreateDate: 2021/07/15
 * @Description
 * 单调栈
 */
public class _496下一个更大元素1 {

    public static void main(String[] args) {
        _496下一个更大元素1 instance = new _496下一个更大元素1();
        System.out.println(Arrays.toString(instance.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    /**
     * 单调栈 时间O(N) 空间O(N)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //特判
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        //单调栈
        Stack<Integer> stack = new Stack<>();
        //结果
        int[] res = new int[nums1.length];
        //map存nums1
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n1 : nums1) hashMap.put(n1, -1);
        //从后往前遍历nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            //只要栈顶元素比nums2当前元素小，栈顶元素就出
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            //当前元素是否在nums1中
            if (hashMap.containsKey(nums2[i])) {
                //只要栈顶元素存在且比nums1当前元素大，就加入结果，否则-1
                //由于前面while把比当前元素小的都push了，因此栈顶元素一定大于它
                if (!stack.isEmpty()) {
                    hashMap.put(nums2[i], stack.peek());
                }
            }
            stack.push(nums2[i]);
        }
        //遍历nums1和map，填充结果
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }
}
