package _每日一题._2020年._20年10月;

import java.util.*;

/**
 * @ClassName: _大O1时间插入_删除和获取随机元素
 * @Signature: Created by lerry_li on 2020/10/31
 * @Description: 设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 */
public class _大O1时间插入_删除和获取随机元素 {
    Map<Integer, Set<Integer>> hashMap;
    List<Integer> numsList;

    /**
     * 初始化数据结构.
     */
    public void RandomizedCollection() {
        hashMap = new HashMap<Integer, Set<Integer>>();
        numsList = new ArrayList<Integer>();
    }

    /**
     * 将值插入到集合中。
     * 如果集合尚未包含指定元素，则返回true.
     */
    public boolean insert(int val) {
        numsList.add(val);
        Set<Integer> set = null;
        if (hashMap.containsKey(val)) {
            set = hashMap.get(val);
            set.add(numsList.size() - 1);

        } else {
            set = new HashSet<>();
            set.add(numsList.size() - 1);
            hashMap.put(val, set);
        }
        //包含返回false，不包含返回true，插入操作不影响，照常插入
        return set.size() == 1;
    }

    /**
     * 从集合中移除一个值。
     * 如果集合包含指定元素，则返回true.
     */
    public boolean remove(int val) {
        System.out.println(numsList);
        if (!hashMap.containsKey(val)) {
            return false;
        }
        //拿到关键字为val的值set集合，取集合中第一个元素
        Iterator<Integer> it = hashMap.get(val).iterator();
        int i = it.next();
        //numsList最后一个元素
        int lastNum = numsList.get(numsList.size() - 1);

        //numsList交换:set第i个元素的值为lastNum，最后一个元素就可以直接删掉了，因此不用交换了
        numsList.set(i, lastNum);
        //hashMap关键字为val的值set集合，删除元素i
        hashMap.get(val).remove(i);
        //hashMap关键字为lastNum的值set集合，删除元素numsList的最后一个下标索引size-1
        hashMap.get(lastNum).remove(numsList.size() - 1);
        //如果i不是numsList最后一个下标
        if (i < numsList.size() - 1) {
            hashMap.get(lastNum).add(i);
        }

        //如果hashMap中关键字为val的值set集合的size为0（即numsList中不含有val元素了），删除hashMap中关键字为val的表项
        if (hashMap.get(val).size() == 0) {
            hashMap.remove(val);
        }
        //numsList删除最后一个元素（val交换到最后一个元素上了）
        numsList.remove(numsList.size() - 1);
        return true;
    }

    /**
     * 从集合中获取一个随机元素.
     */
    public int getRandom() {
        return numsList.get((int) (Math.random() * numsList.size()));
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 100, 1000, 10000);
        list.set(0, 5);
        System.out.println(list);
        System.out.println(Math.random() * 3);
    }

}
