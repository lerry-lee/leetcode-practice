package _每日一题._2021年._21年3月;

import _数据结构.ListNode;


/**
 * @ClassName: _705设计哈希集合
 * @Author: lerry_li
 * @CreateDate: 2021/03/13
 * @Description
 */
public class _705设计哈希集合 {
    private int[] nums;
    private int len;

    /**
     * Initialize your data structure here.
     */
    public _705设计哈希集合() {
        this.len = 1000000;
        this.nums = new int[len];
        for (int i = 0; i < len; i++) {
            //-1表示值为空
            nums[i] = -1;
        }
    }

    public void add(int key) {
        int idx = key % len;
        //如果该值已存在，则直接返回
        if (nums[idx] == key) {
            return;
        }
        //如果hash后的数组下标的元素为空或者为已经标记删除，则直接赋值插入
        if (nums[idx] == -1 || nums[idx] == -2) {
            nums[idx] = key;
        }
        //否则，向后扫描到第一个为空或者为已经标记删除的位置，执行赋值
        else {
            int point = idx + 1;
            while (point != idx) {
                point %= len;
                //如果该值已存在，则直接返回
                if (nums[point] == key) {
                    return;
                }
                if (nums[point] == -1 || nums[idx] == -2) {
                    nums[point] = key;
                    return;
                }
            }
        }
    }

    public void remove(int key) {
        int idx = key % len;
        //如果idx所在的元素恰好为某元素，则直接删除，删除使用标记赋值操作，标记为-2
        if (nums[idx] == key) {
            nums[idx] = -2;
        }
        //否则，想后扫描
        else {
            int point = idx + 1;
            while (point != idx) {
                point %= len;
                //找到则标记删除
                if (nums[point] == key) {
                    nums[point] = -2;
                    return;
                }
                //找不到则返回
                if (nums[point] == -1 || nums[idx] == -2) {
                    return;
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int idx = key % len;
        if (nums[idx] == key) {
            return true;
        }
        int point = idx + 1;
        while (point != idx) {
            point %= len;
            //找不到则返回
            if (nums[point] == -1 || nums[idx] == -2) {
                return false;
            }
            if (nums[point] == key) {
                return true;
            }
        }
        return false;
    }
}

class MyHashSet {
    private ListNode[] nums;
    private int len;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        this.len = 10000;
        this.nums = new ListNode[len];
    }

    public void add(int key) {
        int idx = key % len;
        //找到头指针
        ListNode head = nums[idx];
        //为空，则新建并插入值
        if (head == null) {
            nums[idx] = new ListNode(key);
            return;
        }
        //不为空，则遍历链表，无重复值则尾部插入
        ListNode cur = head;
        while (cur.next != null) {
            //有重复值直接返回
            if (cur.val == key) {
                return;
            }
            cur = cur.next;
        }
        //无重复值则尾部插入
        if (cur.val == key) {
            return;
        }
        cur.next = new ListNode(key);
    }

    public void remove(int key) {
        int idx = key % len;
        //找到头指针
        ListNode head = nums[idx];
        //头指针为空则说明无该元素，直接返回
        if (head == null) {
            return;
        }
        //找到该元素的节点
        ListNode pre = null, cur = head;
        while (cur.next != null) {
            if (cur.val == key) {
                //如果元素在头节点，则删除头节点
                ListNode next = cur.next;
                if (pre == null) {
                    nums[idx] = next;
                } else {
                    pre.next = next;
                }
                cur.next = null;
                return;
            }
            cur = cur.next;
            if (pre == null) {
                pre = head;
            } else {
                pre = pre.next;
            }
        }
        //在尾部找到则删除尾节点,或者在头部
        if (cur.val == key) {
            //如果元素在头节点，则删除头节点
            ListNode next = head.next;
            if (pre == null) {
                nums[idx] = next;
                head.next = null;
            } else {
                pre.next = null;
            }
        }
        //找不到则返回
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int idx = key % len;
        //找到头指针
        ListNode head = nums[idx];
        //头指针为空则说明无该元素，直接返回
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}


