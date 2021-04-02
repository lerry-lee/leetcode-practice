package _其他._笔试题._阿里;

/**
 * @ClassName: Main2
 * @Author: lerry_li
 * @CreateTime: 2021/04/02
 * @Description
 */
public class Main2 {
    /**
     * 输入数字过大的情况，考虑加备忘录（重复子问题计算）+大数先约简（找规律/公式）
     */
    public static void main(String[] args) {
        System.out.println(cal(50, 50));
        System.out.println(cal(100, 100));
    }

    public static double cal(int a, int b) {
        if (a == 0 && b > 0) {
            return 1;
        }
        if (a == 0 && b == 0) {
            return 0.5;
        }
        if (a > 0 && b == 0) {
            return 0;
        }
        double prob = 0;
        //操作1
        prob += 0.25 * cal(Math.max(0, a - 100), b);
        //操作2
        prob += 0.25 * cal(Math.max(0, a - 75), Math.max(0, b - 25));
        //操作3
        prob += 0.25 * cal(Math.max(0, a - 50), Math.max(0, b - 50));
        //操作4
        prob += 0.25 * cal(Math.max(0, a - 25), Math.max(0, b - 75));
        return prob;
    }

}
