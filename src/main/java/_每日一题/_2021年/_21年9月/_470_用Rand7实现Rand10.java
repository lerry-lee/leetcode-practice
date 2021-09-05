package _每日一题._2021年._21年9月;

import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/05
 */
public class _470_用Rand7实现Rand10 {
    /**
     * 思路：
     *  rand7()-1={0,1,2,3,4,5,6}
     *  ①(rand7()-1)*7={0,7,14,21,28,35,42}
     *  ②rand7()={1,2,3,4,5,6,7}
     *  ①+②={1,2,...,49}，且每个数字是等概率的，只需取0~9即可
     */
    public int rand10() {
        int num;
        do {
            num = rand7() + (rand7() - 1) * 7;
        } while (num > 40);
        //+1是为了得到1~10之间的数字
        return num % 10+1;
    }

    //返回[1~7]之间的随机数
    public int rand7() {
        return new Random().nextInt(7)+1;
    }
}
