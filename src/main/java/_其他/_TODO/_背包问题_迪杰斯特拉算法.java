package _其他._TODO;

import java.util.ArrayList;
import java.util.List;

public class _背包问题_迪杰斯特拉算法 {

    static List<List<Integer>> res = new ArrayList<>();
    static int[] candidates = {2, 3, 6, 7};

    //    回溯法 0/1背包问题 的 全局变量
    static private int n = 2;
    static private int[] x = {0, 0, 0};
    static private int[] v = {45, 25, 25};
    static private int[] w = {16, 15, 15};
    static private int V = 0;
    static private int C = 30;

    public static void main(String[] args) {
//        String s="))))()()))()()((((()(((()())((())(()))))()(((()(()(((())((()((((())((()()))))((()(()()())((()(()))))((())))))))())())((()((()()(()(()()))((";
//        System.out.println(longestValidParentheses(s));
//        List<List<Integer>> res=new ArrayList<>();

//        List<Integer> arr=new ArrayList<>();
//
//        backtrack(arr,0,7);
//
//        System.out.println(res);
//        int[] a={1,6,4,3,9,0,5};
//        quickSort(a,0,a.length-1);
//        print(a);
//        System.out.println(Integer.toBinaryString(2147483647));
//        int tmp;
//        tmp=21^(21>>1);
//        System.out.println(101&1);
        int INF=Integer.MAX_VALUE;
        int vStart=0;
        char[] v={'1','2','3','4','5'};
        int[][] aMatrix={{0,10,INF,30,100},{INF,0,50,INF,INF},{INF,INF,0,INF,10},{INF,INF,20,0,60},{INF,INF,INF,INF,0}};
        dijkstra(vStart,5,v,aMatrix,new int[5],new int[5]);
//        backtrack_01(0);
//        List<List<Integer>> list=new ArrayList<>();
//        int[] a={0,0};
//        String a = "aa";
//        String b = "aa";
//        String c = new String("aa");
//        System.out.println(a == b);
//        System.out.println(a == c);
//        a = "bb";
//        System.out.println(a == b);
    }

    //    回溯法0/1背包问题的算法
    static void backtrack_01(int t) {
        if (t >= n) {
            if (overWeight_01()) return;
            int temp_v = 0;
            for (int i = 0; i < n; i++) {
                temp_v += x[i] * v[i];
                System.out.print(x[i] + " ");
            }
            if (temp_v > V) V = temp_v;
            System.out.print("value：" + temp_v + "\n");
        } else {
            for (int i = 0; i <= 1; i++) {
                x[t] = i;
                backtrack_01(t + 1);
            }
        }
    }

    static boolean overWeight_01() {
        int temp_w = 0;
        for (int i = 0; i < n; i++) {
            temp_w += x[i] * w[i];
            if (temp_w > C) return true;
        }
        return false;
    }

    static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    /**
     * 单源最短路径算法，求的是，从一个起始点到所有点的最短路径（如果只求一个点到另一个点的最短路径，则需要变化一下）
     * @param vStart 起点
     * @param n 节点个数
     * @param v 节点（从0开始编号，即1～n-1）
     * @param aMatrix 邻接矩阵，aMatrix[i][j]表示节点i到节点j的距离，用INF表示不可达
     * @param dist 最短路径数组，如果已经访问过的节点，那么就是最短路径，否则是初始化的值（邻接矩阵存的距离）
     * @param prev 最短路径上的该节点的前驱节点
     */
    public static void dijkstra(int vStart, int n, char[] v, int[][] aMatrix, int[] dist, int[] prev) {
        //flag数组记录访问过的节点
        boolean[] flag = new boolean[n];
        //初始化，每个节点设置为未访问，每个节点到起始点的距离设置为邻接矩阵的对应的值，INF表示不可达
        for (int i = 0; i < n; i++) {
            flag[i] = false;
            dist[i] = aMatrix[vStart][i];
        }
        //出发点设置为已访问
        flag[vStart] = true;
//        prev[vStart]=vStart;
        //出发点到出发点的距离初始化为0
        dist[vStart] = 0;
        //i表示循环次数，每循环一次，一个节点就被更新了最短路径（即，一个节点加入已访问的集合中），因此循环n-1即可
        for (int i = 1; i < n; i++) {
            //k记录从源点出发，每次搜索时，找到的最短路径的节点
            int k = 0;
            int min = Integer.MAX_VALUE;
            //遍历所有的节点，找到从源点出发到这些节点的最短路径，标记这个节点k
            for (int j = 0; j < n; j++) {
                //条件：1.未访问过 2.源点到该点的距离小于当前最小距离
                if (!flag[j] && dist[j] < min) {
                    min = dist[j];
                    //用k标记该节点
                    k = j;
                }
            }
            //将节点k设置为已经访问
            flag[k] = true;
            //遍历从k出发，所有可达的节点，更新它们的路径（由于节点k的最短路径已经求出，那么从源点到这些节点的路径则可能需要更新）
            for (int j = 0; j < n; j++) {
                //min是源点到节点k的最短路径
                //节点k到其可达节点的距离设置为temp，如果是INF，即不可达的，则temp=INF，否则temp=min+节点k到该节点的距离
                //tmp是源点到k，再到节点j的最短距离，但这个距离可能不是最短的（因为从源点到j可能不会经过k），所以需要和dist记录的距离比较
                int tmp = (aMatrix[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + aMatrix[k][j]));
                //如果该节点未被访问，同时temp<源点到该节点的最短路径
                //否则更新dist，源点到该节点的最短路径
                if (!flag[j] && (tmp < dist[j])) {
                    dist[j] = tmp;
                    //记录前驱节点
                    prev[j] = k;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println("vStart=1,end=" + v[i] + " shortest distance:" + dist[i]);
//            System.out.print(prev[i]+"->");
        }
        System.out.println("前驱节点：");
        for (int i = 0; i < n; i++) {
            System.out.print(prev[i] + " ");
        }
//        System.out.print(v[vStart]);
//        printPath(0, 4, prev, v);
//        System.out.print(v[4]);


    }

    static void printPath(int vStart, int vEnd, int[] prev, char[] v) {
        if (prev[vEnd] == vStart) return;
        printPath(vStart, prev[vEnd], prev, v);
        System.out.print(v[prev[vEnd]]);
    }

    static int partition(int[] a, int l, int r) {
        int p = (l + r) / 2;
        int x = a[p];
        swap(a, p, l);
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[j] >= x) j--;
            while (i < j && a[i] <= x) i++;
            if (i < j) swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void backtrack(List<Integer> arr, int index, int tar) {
        if (tar == 0) {
            System.out.println(res);
            res.add(arr);

        } else {
            for (int i = index; i < candidates.length; i++) {
                if (tar >= candidates[i]) {
                    arr.add(candidates[i]);
                    backtrack(arr, i, tar - candidates[i]);
                    arr.remove(arr.size() - 1);
                } else {
                    break;
                    // arr.remove(arr.size()-1);
                    // backtrack(arr,i+1,tar);
                }
            }
        }
    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        //定义一个List来存放匹配的结果，0表示左括号，1表示左括号被匹配了，只有连续的1才是符合条件的括号组合
        List<Integer> list = new ArrayList<Integer>();
        int flag = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                list.add(0);
            } else {
                if (!list.isEmpty()) {
                    //每次从List末尾开始找0，当然不能找到List头，因为右括号多于左括号时，之前的匹配就不能往后拓展了，所以有个标志位记录多出的右括号的位置
                    int r = list.size() - 1;
                    while (r > flag && list.get(r) == 1) r--;
                    //如果找到0了，则置为1，前提是去找了，而不是直接检查末尾，所以要判断r是不是大于标志位flag
                    if (r >= flag && list.get(r) == 0) {
                        list.set(r, 1);
                    }
                    //如果没找到0,（说明之前的左括号都被匹配了或者是标志位比r大），这个时候List末尾添加0，隔开之前的匹配串，并更新标志位flag
                    else {
                        list.add(0);
                        flag = list.size();
                    }

                }
            }
        }
        //最后检查List中连续为1的序列长度，返回最长的即可
        int count = 0, tmp = 0;
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k) == 1) tmp++;
            else {
                if (count < tmp) count = tmp;
                tmp = 0;
            }
        }
        if (count < tmp) count = tmp;
        //返回的是括号对数，所以需要乘以2
        return count * 2;
    }

    static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    static void print(List<Integer> nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
