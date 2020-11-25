package DailyProblem._20年11月;

import DataStructure.CustomMethod;

import java.util.*;

/**
 * @ClassName: _1122数组的相对排序
 * @Signature: Created by lerry_li on 2020/11/14
 * @Description:
 */
public class _1122数组的相对排序 {
    /**
     * 解法1：哈希表+排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return new int[]{};
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int n1 : arr1) {
            hashMap.put(n1, hashMap.getOrDefault(n1, 0) + 1);
        }

        int idx = 0;
        for (int n2 : arr2) {
            int nums = hashMap.get(n2);
            while (nums > 0) {
                arr1[idx] = n2;
                idx++;
                nums--;
                if (nums == 0) {
                    hashMap.remove(n2);
                }
            }
        }
        int start = idx;
        for (Integer n : hashMap.keySet()) {
            int nums = hashMap.get(n);
            while (nums > 0) {
                arr1[idx] = n;
                idx++;
                nums--;
            }
        }
        Arrays.sort(arr1, start, arr1.length);
        return arr1;
    }

    /**
     * 解法2：计数排序 时间O(M+N+n) 空间O(n)
     * 思路与算法
     * 注意到本题中元素的范围为[0,1000]，这个范围不是很大，因此考虑计数排序。
     * 1）定义长度为1001的数组helper[]，helper[i]表示数字i出现的次数；
     * 2）遍历arr1，填充helper[]；
     * 3）遍历arr2，对于每一个元素arr2i，将helper[arr2i]个该元素加入结果集中，最后将helper[arr2i]=0；
     * 4）最后遍历helper[]，若遍历到不为0的helper[i]，将这么多i加入结果集中。
     * 细节
     * 可以对空间进行优化，找出arr1中的最大值n，使用长度为n+1的数组helper[]即可
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return new int[]{};
        }
        int n = 0;
        for (int arr1i : arr1) {
            n = Math.max(n, arr1i);
        }
        int[] helper = new int[n + 1];
        for (int arr1i : arr1) {
            helper[arr1i]++;
        }
        int idx = 0;
        for (int arr2i : arr2) {
            int temp = helper[arr2i];
            while (temp > 0) {
                arr1[idx++] = arr2i;
                temp--;
            }
            helper[arr2i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            int temp = helper[i];
            while (temp > 0) {
                arr1[idx++] = i;
                temp--;
            }
        }
        return arr1;
    }

    /**
     * 解法3：自定义排序
     * 一种容易想到的方法是使用排序并自定义比较函数。
     * 由于数组arr2规定了比较顺序，因此我们可以使用哈希表对该顺序进行映射：hashMap<arr2[i],i>
     * 比较函数的写法有很多种，例如我们可以使用最基础的比较方法，对于元素 x 和 y：
     * 如果 x 和 y 都出现在哈希表中，那么比较它们对应的值 hashMap.get(x),hashMap.get(y)；
     * 如果 x 和 y 都没有出现在哈希表中，那么比较它们本身；
     * 对于剩余的情况，出现在哈希表中的那个元素较小。
     */
    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) list.add(num);
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) arr1[i] = list.get(i);
        return arr1;
    }

    public static void main(String[] args) {
        _1122数组的相对排序 instance = new _1122数组的相对排序();
        int[] arr1 = {2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31};
        int[] arr2 = {2, 42, 38, 0, 43, 21};
        CustomMethod.display(arr1);
        CustomMethod.display(instance.relativeSortArray2(arr1, arr2));
        CustomMethod.display(new int[]{2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48});
    }
}
