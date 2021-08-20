package _每日一题._2021年._21年8月;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/20
 */
public class _541反转字符串2 {

    public static void main(String[] args) {
        _541反转字符串2 instance = new _541反转字符串2();
        System.out.println(instance.reverseStr("abcdefg", 2));//bacdfeg
        System.out.println(instance.reverseStr("abcd", 2));//bacd
    }

    /**
     * 解法1：模拟（双指针） 时间O(N) 空间O(1)
     */
    public String reverseStr(String s, int k) {
        //特判
        if (s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int len = arr.length;
        int left = 0, right = left + k - 1, cursor = left + 2 * k;
        while (cursor < len) {
            while (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
            left = cursor;
            right = left + k - 1;
            cursor = left + 2 * k;
        }
        //最终不够2k个的反转前k个或所有
        right=Math.min(len-1,right);
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }

    private void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
