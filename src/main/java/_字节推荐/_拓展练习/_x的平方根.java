package _字节推荐._拓展练习;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/29 16:09
 * @description X的平方根
 */
public class _x的平方根 {

    //牛顿法？？？
    public int mySqrt_Newton(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }

    //二分查找
    public int mySqrt_binarySearch(int x) {
        if (x == 0) return 0;
        int l = 1, r = x / 2;
        while (l < r) {
            int mid = (l + r) / 2;
            if (x / mid == mid) return mid;
            if (x / mid > mid) l = mid + 1;
            else r = mid - 1;
        }
        if (x / l >= l) return l;
        else return l - 1;
    }

    //直接遍历
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int wei = 0;
        int x_cp = x;
        while (x_cp >= 10) {
            wei++;
            x_cp /= 10;
        }
        wei /= 2;
        int idx = 1;
        while (wei > 0) {
            idx *= 10;
            wei--;
        }
        int res = idx;
        for (int i = idx; i < x; i++) {
            if (x / i == i) {
                res = i;
                break;
            }
            if (x / i < i) {
                res = i - 1;
                break;
            }
        }
        return res;
    }
}
