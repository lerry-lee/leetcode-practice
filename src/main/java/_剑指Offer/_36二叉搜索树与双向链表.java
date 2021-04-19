package _剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: _36二叉搜索树与双向链表
 * @Author: lerry_li
 * @CreateDate: 2021/04/19
 * @Description
 * 解法1：朴素暴力
 * 解法2：dfs
 */
public class _36二叉搜索树与双向链表 {
    /**
     * 解法1：朴素暴力 时间O(N) 空间O(N)
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        nodeList = new ArrayList<>();
        dfs(root);
        return func(nodeList);
    }

    /**
     * 解法2：dfs 时间O(N) 空间O(1)
     * 思路：
     *      全局变量head表示头结点（值最小的节点） ，全局变量pre表示前驱结点
     */
    Node head, pre;

    public Node treeToDoublyList2(Node root) {
        if (root == null) {
            return null;
        }
        head = null;
        dfs2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs2(Node root) {
        if (root == null) {
            return;
        }
        dfs2(root.left);
        //处理
        //若头结点为空，则设置头结点
        if (head == null) {
            head = root;
            pre = head;
        }
        //否则进行常规处理
        else {
            //前驱节点的right指向当前节点root
            pre.right = root;
            //当前节点root的left指向前驱节点
            root.left = pre;
            //前驱节点pre更新为当前节点root
            pre = root;
        }
        dfs2(root.right);
    }

    private Node func(List<Node> nodeList) {
        int size = nodeList.size();
        Node root = nodeList.get(0);
        if (size <= 1) {
            root.left = root;
            root.right = root;
            return root;
        }
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                nodeList.get(i).left = nodeList.get(size - 1);
                nodeList.get(i).right = nodeList.get(i + 1);
            } else if (i == size - 1) {
                nodeList.get(i).left = nodeList.get(i - 1);
                nodeList.get(i).right = nodeList.get(0);
            } else {
                nodeList.get(i).left = nodeList.get(i - 1);
                nodeList.get(i).right = nodeList.get(i + 1);
            }
        }
        return root;
    }

    List<Node> nodeList;

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nodeList.add(root);
        dfs(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
