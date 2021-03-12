package _每日一题._2021年._21年3月;

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
        //圆心
        double x0 = x_center - radius;
        double y0 = y_center - radius;

        while (true) {
            double xg = x0 + Math.random() * radius * 2;
            double yg = y0 + Math.random() * radius * 2;
            if (Math.sqrt(Math.pow((xg - x_center), 2) + Math.pow((yg - y_center), 2)) <= radius)
                return new double[]{xg, yg};
        }

    }
}
