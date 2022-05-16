package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/16
 */
public class _907_子数组的最小值之和 {

    public static void main(String[] args) {
        _907_子数组的最小值之和 instance=new _907_子数组的最小值之和();
        instance.new Solution().sumSubarrayMins(new int[]{3,1,2,4});
    }

    /**
     * 解法1：计算每个元素的覆盖范围+单调栈 时间O(N) 空间O(N)
     */
    class Solution {

        int Mod=1000000007;

        public int sumSubarrayMins(int[] arr) {
            if(arr==null||arr.length==0) return 0;
            int len=arr.length;
            // 每个元素覆盖的左右边界，开区间（left,right）
            int[] leftBorder=new int[len];
            int[] rightBorder=new int[len];
            // 单调栈：单调递增
            Deque<Integer> stack=new ArrayDeque<>();
            for(int i=0;i<len;i++){
                // 新元素i入栈前，保证i>栈顶元素，单调递增
                while(!stack.isEmpty()&&arr[i]<=arr[stack.peekLast()]){
                    stack.removeLast();
                }
                // 若栈为空，说明新元素i的左边界为数组最左边
                if(stack.isEmpty()){
                    leftBorder[i]=-1;
                }
                // 否则，新元素i的左边界为栈顶元素（栈单调递增，新元素i加入后，一定作为新的栈顶，因此原栈顶元素就是第一个比它小的）
                else leftBorder[i]=stack.peekLast();
                // 新元素i入栈
                stack.addLast(i);
            }
            // 清空栈
            stack.clear();
            // 右边界同理
            for(int i=len-1;i>=0;i--){
                // 【注意】：leftBorder包含了相同元素，rightBorder就不要了，不然会重复
                while(!stack.isEmpty()&&arr[i]<arr[stack.peekLast()]){
                    stack.removeLast();
                }
                if(stack.isEmpty()){
                    // 右边界最大是数组长度
                    rightBorder[i]=len;
                }
                else rightBorder[i]=stack.peekLast();
                stack.addLast(i);
            }
            // 最后遍历所有元素，计算其覆盖的范围的总和
            long res=0;
            for(int i=0;i<len;i++){
                res=(res+arr[i]*((long) (i - leftBorder[i]) *(rightBorder[i]-i)))%Mod;
            }
            return (int) res;
        }
    }
}
