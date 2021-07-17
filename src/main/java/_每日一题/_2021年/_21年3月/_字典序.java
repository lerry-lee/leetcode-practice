package _每日一题._2021年._21年3月;

import java.util.Scanner;

/**
 * @ClassName: _字典序
 * @Author: lerry_li
 * @CreateDate: 2021/03/13
 * @Description
 */
public class _字典序 {
    /**
     * 既然是字典序，那么很自然，我们可以考虑使用字典树来实现，但是，这里并不需要真的生成这个字典树，而只需要计算对应分支的节点数就行了。
     * 计算分支节点数，那么很简单，节点数就是上级节点*10，总的节点数= 1 + （1 * 10） + （1 * 10 * 10） + （1 * 10  * 10 * 10） +……，
     * 这里需要注意最后的边界，n以内的节点数，那么，最后相加的时候必须要把n+1 ~ (1 * 10 * 10 *……)这几个数去掉。
     * 既然知道了如何计算字典树分支的节点数，要想知道第m个数是什么，那么也就是找第m个节点，
     * 首先从1开始，如果1分支的节点数>m，那么第m个数肯定是以1开头，进一步搜索其子节点，搜索子节点时不用再搜索1了，所以是搜索1分支的第m-1个节点。
     * 如果1分支的节点数<m， 那么所查找的数肯定不是1开头，那么开始搜索2分支，在2分支中，所要找的数应该是第（m-（1分支节点数））个数。
     * 重复这个过程，要么搜索子节点，要么搜索兄弟节点，知道最终m==0，也就是当前节点就是所要搜索的节点。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(solve(n, m));
        }
    }

    private static long solve(long n, long m) {
        long ans = 1;
        while (m != 0) {
            long cnt = getCntOfPre(ans, n);
            if (cnt >= m) {
                m--;
                if (m == 0)
                    break;
                ans *= 10;//go right
            } else {
                m -= cnt;
                ans++;//go down
            }
        }
        return ans;
    }

    private static long getCntOfPre(long pre, long n) {
        long cnt = 1;
        long p = 10;
        for (; pre * p <= n; p *= 10) {
            if (pre * p - 1 + p < n)
                cnt += p;
            else
                cnt += n - pre * p + 1;
//          cnt += Math.min(n, pre * p - 1 + p) - pre * p + 1;
        }
        return cnt;
    }
}
