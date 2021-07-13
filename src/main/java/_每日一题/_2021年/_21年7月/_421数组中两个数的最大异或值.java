package _每日一题._2021年._21年7月;

/**
 * @ClassName: _421数组中两个数的最大异或值
 * @Author: lerry_li
 * @CreateTime: 2021/07/13
 * @Description
 * 解法1：字典树
 */
public class _421数组中两个数的最大异或值 {

    public static void main(String[] args) {
        _421数组中两个数的最大异或值 instance=new _421数组中两个数的最大异或值();
        System.out.println(instance.findMaximumXOR(new int[]{3,10,5,25,2,8}));
        System.out.println(instance.findMaximumXOR(new int[]{0}));
        System.out.println(instance.findMaximumXOR(new int[]{2,4}));
        System.out.println(instance.findMaximumXOR(new int[]{8,10,2}));
        System.out.println(instance.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
    }

    /**
     * 解法1：字典树 时间O(NlogC) 空间O(NlogC)
     */
    public int findMaximumXOR(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        //构造字典树
        root = new Tree();
        for (int num : nums) {
            add(num);
        }
        //遍历元素，找最大异或值
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, check(num));
        }
        return res;
    }

    private int check(int num) {
        Tree cur = root;
        int x = 0;
        for (int i = 31; i >= 0; i--) {
            //取出当前二进制位
            int bit = (num >> i) & 1;
            //当前二进制位是0，则找右子节点
            if (bit == 0) {
                if (cur.right != null) {
                    x = (x << 1) + 1;
                    cur = cur.right;
                } else {
                    x = (x << 1);
                    cur = cur.left;
                }
            }
            //当前二进制位是1，则找左子节点
            else {
                if (cur.left != null) {
                    x = (x << 1) + 1;
                    cur = cur.left;
                } else {
                    x = (x << 1);
                    cur = cur.right;
                }
            }
        }
        return x;
    }

    Tree root;

    //将元素按二进制位从高到低添加到树中
    private void add(int num) {
        Tree cur = root;
        for (int i = 31; i >= 0; i--) {
            //取出当前二进制位
            int bit = (num >> i) & 1;
            //当前二进制位是0，则放入左子结点
            if (bit == 0) {
                if (cur.left == null) cur.left = new Tree();
                cur = cur.left;
            }
            //当前二进制位是1，则放入右子节点
            else {
                if (cur.right == null) cur.right = new Tree();
                cur = cur.right;
            }
        }
    }

    //字典树
    class Tree {
        Tree left;
        Tree right;
    }
}
