package _剑指Offer;

/**
 * @ClassName: _17打印从1到最大的n位数
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _17打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
