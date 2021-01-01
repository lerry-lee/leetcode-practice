package _每日一题._2021年._21年1月;

/**
 * @ClassName: _605种花问题
 * @Author: lerry_li
 * @CreateTime: 2021/01/01
 * @Description
 */
public class _605种花问题 {
    /**
     * 解法1：回溯（超时）
     * 解法2：贪心（一次遍历）
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n == 0) {
            return n == 0;
        }
        int count_0 = 0;
        for (int em : flowerbed) {
            if (em == 0) {
                count_0++;
            }
        }
        if (n > count_0) {
            return false;
        }

        return dfs(flowerbed, n, 0);
    }

    public boolean dfs(int[] flowerbed, int n, int k) {
        if (n == 0) {
            return true;
        }
        if (k > flowerbed.length - 1) {
            return false;
        }
        for (int i = k; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    boolean flag = dfs(flowerbed, n - 1, i + 2);
                    if (flag) {
                        return true;
                    }
                    flowerbed[i] = 0;
                }
            }
        }
        return false;
    }

    /**
     * 解法2：贪心 时间O(M) 空间O(1)
     * 思路：
     *      遍历到1，跳一格，遍历到0则看下一格是不是0，若是则种下花
     */
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0 || n == 0) {
            return n == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i]==1){
                i++;//有花了跳两格
            }else{
                if(i==flowerbed.length-1||(i<flowerbed.length-1&&flowerbed[i+1]==0)){
                    flowerbed[i]=1;
                    i++;//种下花之后跳两格
                    n--;
                }
            }
            if(n==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _605种花问题 instance = new _605种花问题();
        int[] flowerbed = {1,0,0,0,0,1};
        System.out.println(instance.canPlaceFlowers2(flowerbed, 2));
        for (int fi : flowerbed) {
            System.out.print(fi + " ");
        }
    }
}
