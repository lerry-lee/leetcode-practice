package DailyExercises._20年10月;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lerry_li on 2020/10/15
 */

/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * <p>
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class _116填充每一个节点的下一个右侧节点指针 {
    /**
     * 解法1：dfs层次遍历拿到所有层的节点，然后遍历每一层填充next指针 时间O(n) 空间O(n)
     */
    public Node connect(Node root) {
        if (root == null) return null;
        List<List<Node>> nodesList = new ArrayList<>();
        dfs(nodesList, root, 0);
        for (List<Node> temp : nodesList) {
            Node pre = temp.get(0);
            for (int i = 1; i < temp.size(); i++) {
                Node cnt = temp.get(i);
                pre.next = cnt;
                pre = cnt;
            }
        }
        return root;
    }

    public void dfs(List<List<Node>> nodesList, Node root, int level) {
        if (root == null) return;
        if (nodesList.size() <= level) nodesList.add(new ArrayList<>());
        nodesList.get(level).add(root);
        dfs(nodesList, root.left, level + 1);
        dfs(nodesList, root.right, level + 1);
    }

    /**
     * 解法2：双端队列迭代，同时填充next指针 时间O(n) 空间O(n)
     */
    public Node connect2(Node root) {
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cnt = deque.pollFirst();
                if (pre != null) pre.next = cnt;
                pre = cnt;
                if (cnt.left != null) deque.offerLast(cnt.left);
                if (cnt.right != null) deque.offerLast(cnt.right);
            }
        }
        return root;
    }

    /**
     * 解法3：时间O(n) 空间O(1)
     * 两种情况：
     * 1.同一个父节点：可以连接其左子结点→右子节点
     * 2.node1的右子节点连接下一个node2的左子结点：通过父节点node1的next找到node2，然后连接
     */
    public Node connect3(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node mostLeftNode = root;

        while (mostLeftNode.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node cntNode = mostLeftNode;

            while (cntNode != null) {

                // CONNECTION 1
                cntNode.left.next = cntNode.right;

                // CONNECTION 2
                if (cntNode.next != null) {
                    cntNode.right.next = cntNode.next.left;
                }

                // 指针向后移动
                cntNode = cntNode.next;
            }

            // 去下一层的最左的节点
            mostLeftNode = mostLeftNode.left;
        }

        return root;
    }

}
