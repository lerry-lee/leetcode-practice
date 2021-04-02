package _剑指Offer;

/**
 * @ClassName: _11旋转数组的最小数字
 * @Author: lerry_li
 * @CreateTime: 2021/04/02
 * @Description
 */
public class _11旋转数组的最小数字 {
    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                // [3, 4, 5, 1, 2]，mid 以及 mid 的左边一定不是最小数字
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else if (numbers[mid] == numbers[right]) {
                // 只能把 right 排除掉，下一轮搜索区间是 [left, right - 1]
                right = right - 1;
            } else {
                // 此时 numbers[mid] < numbers[right]
                // mid 的右边一定不是最小数字，mid 有可能是，下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        return numbers[left];
    }

    /**
     * 解法2：暴力 时间O(N) 空间O(1)
     * 思路：找到旋转点，它后面的第一个元素就是最小元素
     */
    public int minArray2(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            //升序数组，如果遇到当前元素比上一个元素要小，那么当前元素就是最小元素
            if(numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        //这种情况是数组的元素都相同
        return numbers[0];
    }


    public static void main(String[] args) {
        _11旋转数组的最小数字 instance=new _11旋转数组的最小数字();
        System.out.println(instance.minArray(new int[]{3,4,5,1,2}));
        System.out.println(instance.minArray(new int[]{4,5,1,2,3}));
        System.out.println(instance.minArray(new int[]{5,1,2,3,4}));

    }
}
