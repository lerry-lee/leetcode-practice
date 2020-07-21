package _力扣每日一题;


import java.util.*;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/11 08:44
 * @description TODO：此题未AC
 */
public class _315计算右侧小于当前元素的个数 {
    /**
     * 思路1：暴力法，超时...
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) cnt++;
            }
            res.add(0, cnt);

        }
        return res;
    }

    /**
     * 思路2：排序+遍历  超时了...
     * 从右往左遍历，维护一个新数组，遍历过的元素排序，这样当前元素只需二分查找到刚好比它小的元素下标即可，从该下标到末尾元素下标都是比它小的元素
     */
    public List<Integer> countSmaller_sort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int len = nums.length;
        int[] sort_array = new int[len];
        for (int i = 0; i < len; i++) sort_array[i] = nums[i];
        for (int i = len - 1; i >= 0; i--) {
            int small_idx = findSmallerIdx(sort_array, i + 1, len - 1, nums[i]);
            if (small_idx == -1) res.add(0, 0);
            else res.add(0, len - small_idx);
            quickSort(sort_array, i, len - 1);
            _0_Main.display(sort_array);
        }
        return res;
    }

    //快速排序，从小到大
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        int p = (l + r) / 2;
        swap(arr, l, p);
        p = l;
        while (l < r) {
            while (l < r && arr[r] <= arr[p]) r--;
            while (l < r && arr[l] >= arr[p]) l++;
            if (l < r) swap(arr, l, r);
        }
        swap(arr, l, p);
        return l;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //二分查找，找刚好比tar小的元素
    public int findSmallerIdx(int[] arr, int l, int r, int tar) {
        if (l > r) return -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > tar) l = mid + 1;
            else r = mid;
        }
        if (arr[l] < tar) return l;
        return -1;
    }

    public int findBiggerIdx(int[] arr, int l, int r, int tar) {
        if (l > r) return -1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < tar) r = mid - 1;
            else l = mid;
        }
        if (arr[l] > tar) return l;
        return -1;
    }

}
