package _其他._笔试题._华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Author: lerry_li
 * @CreateTime: 2021/04/14
 * @Description
 */
public class Main2 {
    public static void main(String[] args) {
        //读屏幕输入
        //input:23 0 8 16 24 32 40 48 60 70 60 50 40 30 20 10 0 0 0 0 0 0 5 10
        //output:0 40 48 60 70 60 50 40 30 20 10 0 0 0 0 0
        Scanner sc = new Scanner(System.in);
        //第一行输入为N，代表产生了N次速度数据
        int N = sc.nextInt();
        //保存N次速度数据到数组中
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
        }
        //执行处理函数
        func(v);
    }

    private static void func(int[] v) {
        //动态数组保存输出的速度数据
        List<Integer> outputs = new ArrayList<>();
        //第一个速度数据需要上报
        outputs.add(v[0]);
        //30s周期上报计数器
        int count = 0;//count每0.5s+1
        //标记AEB上报的数据
        boolean[] visited = new boolean[v.length];
        //AEB标记，判断持续时间是否超过2s
        int AEB_count = 0;
        //遍历 速度数据 数组
        for (int i = 1; i < v.length; i++) {
            //判断是否触发AEB流程(速度比上一个减少了9及以上，且持续2s)
            if (v[i - 1] - v[i] >= 9) {
                //触发AEB流程
                AEB_count++;
            }
            //否则，判断是否为AEB流程结束
            else {
                count++;
                //若持续2s以上，则上报数据
                if (AEB_count >= 4) {
                    //3.重新启动周期上报计数器
                    i = record(v, visited, outputs, i, AEB_count);
                    count = 0;
                }
                AEB_count = 0;
            }
            //当count为60时(30s)，当前速度数据需要上报
            if (count == 60) {
                outputs.add(v[i]);
            }
        }
        //若到最后都属于AEB流程，则单独判断一次
        if (AEB_count >= 4) {
            //3.重新启动周期上报计数器
            record(v, visited, outputs, v.length - 1, AEB_count);
        }
        //打印结果
        for (Integer data : outputs) {
            System.out.print(data + " ");
        }
    }

    private static int record(int[] v, boolean[] visited, List<Integer> outputs, int i, int AEB_count) {
        //1.前2s的数据需要上报(并且前2s的数据没有被因上次AEB触发而上报过)
        //记录AEB流程开始的数据下标
        int AEB_start = i - AEB_count;
        int j = AEB_start - 4;
        for (; j < i; j++) {
            if (visited[j]) {
                continue;
            }
            outputs.add(v[j]);
            //标记上因AEB上报的数据
            visited[j] = true;
        }
        //2.后2s的数据需要上报
        for (j = i; j < i + 4 && j < v.length; j++) {
            outputs.add(v[j]);
            //标记上因AEB上报的数据
            visited[j] = true;
        }
        return j;
    }

}
