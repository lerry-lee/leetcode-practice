package _每日一题._2021年._21年3月;

import java.util.Random;

/**
 * @ClassName: _478在圆内随机生成点
 * @Author: lerry_li
 * @CreateDate: 2021/03/12
 * @Description
 */
public class _478在圆内随机生成点 {
    /**
     * 解法1：拒绝采样法：圆外接正方形，然后在正方形内随机生成一个点，若落在圆内则返回
     */
    private double radius;
    private double x_center;
    private double y_center;

    public _478在圆内随机生成点(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        //外接正方形左下角的点（x0,y0）
        double x0 = x_center - radius;
        double y0 = y_center - radius;

        while (true) {
            double xg = x0 + Math.random() * radius * 2;
            double yg = y0 + Math.random() * radius * 2;
            if (Math.sqrt(Math.pow((xg - x_center), 2) + Math.pow((yg - y_center), 2)) <= radius)
                return new double[]{xg, yg};
        }

    }

    public static int random7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    static int[][] seed7 = {
            {1, 2, 3, 4, 5, 6, 7},
            {8, 9, 10, 1, 2, 3, 4},
            {5, 6, 7, 8, 9, 10, 1},
            {2, 3, 4, 5, 6, 7, 8},
            {9, 10, 1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
        //解放1：随机生成1～49，然后选1～40的数，在%10
        for (int i = 0; i < 10; i++) {
            int x = 7 * (random7() - 1) + (random7());
            if (x <= 40) {
                System.out.println(x % 10 + 1);
            }
        }
        //解法2：随机抽seed7中的一行一列，seed7中1～10的元素是均匀的
        int x = seed7[random7() - 1][random7() - 1];
    }
}
