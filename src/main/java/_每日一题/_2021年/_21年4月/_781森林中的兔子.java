package _每日一题._2021年._21年4月;

import java.util.HashMap;

/**
 * @ClassName: _781森林中的兔子
 * @Author: lerry_li
 * @CreateDate: 2021/04/05
 * @Description
 */
public class _781森林中的兔子 {
    /**
     * 解法1：哈希表 时间O(N) 空间O(N)
     */
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        //统计每种数字出现的次数
        for (int answer : answers) {
            hashMap.put(answer, hashMap.getOrDefault(answer, 0) + 1);
        }
        int total = 0;
        //遍历不同种类的数字
        for (int answer : hashMap.keySet()) {
            //当前种类的数字出现次数
            int count = hashMap.get(answer);
            //若当前数字为0，说明该兔子是唯一的，每一个都要统计
            if (answer == 0) {
                total += count;
            }
            //否则，它还有同样颜色的其他兔子
            else {
                //若同样为该数字的个数小于该数字所描述的其他同样颜色兔子的个数
                //则说明这些相同的数字，可以为一类兔子，统计时，加上[该数字+1]即可
                if (count <= answer + 1) {
                    total += answer + 1;
                }
                //否则，说明这些相同的数字，不能被划分到一类兔子中
                else {
                    //尽量将最多数量(answer+1)的兔子分到一类
                    while (count > 0) {
                        total += answer + 1;
                        count -= answer + 1;
                    }
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        _781森林中的兔子 instance = new _781森林中的兔子();
        System.out.println(instance.numRabbits(new int[]{1, 1, 2}));//5
        System.out.println(instance.numRabbits(new int[]{10, 10, 10}));//1
        System.out.println(instance.numRabbits(new int[]{1, 1, 0}));//3
        System.out.println(instance.numRabbits(new int[]{1, 1, 0, 0, 0}));//5
        System.out.println(instance.numRabbits(new int[]{1, 1, 1, 0, 0}));//6
    }
}
