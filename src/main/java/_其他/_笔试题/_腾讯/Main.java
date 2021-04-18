package _其他._笔试题._腾讯;

import java.util.Scanner;

/**
 * @ClassName: Main
 * @Author: lerry_li
 * @CreateTime: 2021/04/18
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //草地半径
        double R1 = sc.nextDouble();
        //草地圆心坐标
        double X1 = sc.nextDouble(), Y1 = sc.nextDouble();
        //需要避开的某点坐标
        double X3 = sc.nextDouble(), Y3 = sc.nextDouble();
        //执行处理函数
        func(R1, X1, Y1, X3, Y3);
    }

    //处理函数，找到一个喷灌的圆心点，使得喷灌面积最大，且避开某点（X3,Y3）
    private static void func(double R1, double X1, double Y1, double X3, double Y3) {
        //连接(X1,Y1)和(X3,Y3)的直线y=kx+c

        //特判
        //1）和圆心重合的情况
        //2）斜率不存在的情况
        //3) 斜率为0的情况
        double X2, Y2, R2;
        if (X3 == X1) {
            //1）若和圆心重合
            if (Y3 == Y1) {
                R2 = R1 / 2;
                Y2 = Y1;
                X2 = X1 - R2;
            }
            //2）否则，斜率不存在
            else {
                X2 = X1;
                R2 = (R1 + Math.abs(Y3 - Y1)) / 2;
                if (Y3 > Y1) {
                    Y2 = Y3 - R2;
                } else {
                    Y2 = Y3 + R2;
                }
            }
        }
        //3)斜率为0的情况
        else if (Y3 == Y1) {
            R2 = (R1 + Math.abs(X3 - X1)) / 2;
            Y2 = Y1;
            if (X3 > X1) {
                X2 = X3 - R2;
            } else {
                X2 = X3 + R2;
            }
        }
        //其他情况，需要计算
        else {
            //斜率k
            double k = (Y3 - Y1) / (X3 - X1);
            //偏移b
            double b = Y1 - k * X1;
            //直线y=kx+b和草地圆的交点设为(a1,b1)和(a2,b2)
            //①y=k*x+b
            //②(x-x1)^2+(y-y1)^2=r^2
            //联立①②求解
            double C = X1 * X1 + (b - Y1) * (b - Y1) - R1 * R1;
            double A = 1 + k * k;
            double B = 2 * (k * b - k * Y1 - X1);
            double delta = Math.sqrt(B * B - 4 * A * C);
            double a1 = (-B + delta) / (2 * A);
            double a2 = (-B - delta) / (2 * A);
            double b1 = k * a1 + b;
            double b2 = k * a2 + b;
            //判断(a1,b1)和(a2,b2)两点中，距离(X3,Y3)较远的点
            R2 = (R1 + Math.sqrt((Math.pow(X3 - X1, 2) + Math.pow(Y3 - Y1, 2)))) / 2;
            double dis1 = Math.abs(a1 - X3);
            double dis2 = Math.abs(a2 - X3);
            //返回较远的点和(X3,Y3)的中点(X2,Y2)，半径为(X2,Y2)和(X3,Y3)的距离
            if (dis1 > dis2) {
                if (X3 > a1) {
                    X2 = X3 - R2;
                    Y2 = Y3 - R2;
                } else {
                    X2 = X3 + R2;
                    Y2 = Y3 + R2;
                }
            } else {
                if (X3 > a2) {
                    X2 = X3 - R2;
                    Y2 = Y3 - R2;
                } else {
                    X2 = X3 + R2;
                    Y2 = Y3 + R2;
                }

            }
        }
        System.out.println(X2 + " " + Y2 + " " + R2);
        System.out.println(Math.sqrt(0.25));
    }
}
