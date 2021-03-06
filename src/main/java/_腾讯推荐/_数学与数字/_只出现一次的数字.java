package _腾讯推荐._数学与数字;

/**
 * Created by lerry_li on 2020/10/14
 */

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class _只出现一次的数字 {
    /**
     * 解法1：哈希表
     * 解法2：异或
     */
    public int singleNumber(int[] nums) {
        int em = 0;
        for (int num : nums) {
            em = em ^ num;
        }
        return em;
    }
}
