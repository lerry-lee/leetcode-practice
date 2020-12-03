package DailyProblem._20年12月;

import DataStructure.CustomMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _204计算质数
 * @Author: lerry_li
 * @CreateDate: 2020/12/03
 * @Description
 */
public class _204计算质数 {
    /**
     * 解法1：暴力(超时) 时间O(NlogN) 空间O(1)
     */
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        int counts = 1;
        for (int i = 3; i < n; i++) {
            if (i % 2 != 0 && isPrime(i)) {
                counts++;
            }
        }
        return counts;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解法2：埃氏筛 时间O(NloglogN) 空间O(N)
     * 思路：
     *      从2开始，将每个质数的倍数都标记成合数，以达到筛选素数的目的
     * 算法：
     *      1.设置boolean数组，标记是否是质数，初始化全是质数；
     *      2.从2开始遍历，若当前数是质数，则标记其倍数为合数，同时计数器+1，否则跳过；
     */
    public int countPrimes2(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return res;
    }

    /**
     * 解法3：欧几里得筛(线性筛) 时间O(N) 空间O(N)
     * 思路：
     *      1.埃氏筛的缺陷：有些合数可能被筛多次，例如10=2*5,且10=5*2
     *      2.在埃氏筛法的基础上，让每个合数只被它的最小质因子筛选一次，以达到不重复的目的。
     */
    public int countPrimes3(int n) {
        if (n < 3) {
            return 0;
        }
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = false;
                //只通过最小质因子来消除
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }


    public static void main(String[] args) {
        _204计算质数 instance = new _204计算质数();
        while (true) {
            int n = CustomMethod.getScanner().nextInt();
            System.out.println(instance.countPrimes2(n));
        }
    }
}
