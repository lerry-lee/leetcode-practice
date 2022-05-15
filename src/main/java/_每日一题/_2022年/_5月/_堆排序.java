package _每日一题._2022年._5月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/15
 * @Description
 */
public class _堆排序 {

    public static void main(String[] args) {
        _堆排序 instance = new _堆排序();
        instance.new Solution().heapSort(new int[]{5,1,1,2,0,0});
    }

    /**
     * 堆排序的基本思想是：
     * 将待排序序列构造成一个大顶堆，
     * 此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
     * 此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
     * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
     */
    class Solution {

        public void heapSort(int[] array) {
            // 1.把无序数组构建成二叉堆（构建大顶堆，保证父节点比子节点大）
            // 从最后一个非叶子节点开始（叶子节点自然不用调整）
            for (int i = array.length / 2 - 1; i >= 0; i--) {
                // 从第一个非叶子结点从下至上，从右至左调整结构
                downAdjust(array, i, array.length);
            }
            System.out.println(Arrays.toString(array));
            // 2.循环删除堆顶元素，移到数组尾部，调节堆产生新的堆顶元素
            // 每次操作，[0,n]的数组末尾产生当前堆最大的元素，然后堆的数组范围变为[0,n-1]
            for (int i = array.length - 1; i >= 0; i--) {
                // 堆顶元素与末尾元素进行交换
                swap(array, i, 0);
                // 重新对堆进行调整
                downAdjust(array, 0, i);
            }
        }

        private void downAdjust(int[] array, int parentIndex, int length) {
            // temp保存父节点值，用于最后的赋值
            int temp = array[parentIndex];
            int childIndex = 2 * parentIndex + 1;
            while (childIndex < length) {
                // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
                if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                    childIndex += 1;
                }
                // 如果父节点小于任何一个孩子的值，直接跳出
                if (temp > array[childIndex]) {
                    break;
                }
                // 否则，父节点比孩子节点的值大，父节点下沉
                // 无需真正交换，单向赋值即可
                array[parentIndex] = array[childIndex];
                parentIndex = childIndex;
                childIndex = 2 * childIndex + 1;
            }
            // 最终定位到父节点合理的位置，将父节点值赋值过来即可
            array[parentIndex] = temp;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
