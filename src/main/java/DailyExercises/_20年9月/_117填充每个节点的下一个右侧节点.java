package DailyExercises._20年9月;

import DataStructure.Node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lerry_li on 2020/09/28
 */

/**
 *  填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class _117填充每个节点的下一个右侧节点 {
    /**
     * 解法1：广度优先遍历 时间复杂度O(n) 空间复杂度O(n)
     * 双端队列Deque
     */
    public Node connect(Node root) {
        if(root==null) return null;
        Deque<Node> deque=new LinkedList<>();
        deque.offerLast(root);
        Node current=null;
        while(!deque.isEmpty()){
            int size=deque.size();
            for(int i=0;i<size;i++){
                Node node=deque.pollFirst();
                if(i==0) current=node;
                else{
                    current.next=node;
                    current=node;
                }
                if(node.left!=null) deque.offerLast(node.left);
                if(node.right!=null) deque.offerLast(node.right);
            }
        }
        return root;
    }
    /**
     * 解法2：指针模拟队列，空间复杂度降到O(1)
     * 利用解法一的思想，我们利用 pre 指针，然后一个一个取节点，把它连起来。解法一为什么没有像解法二那样考虑当前节点为 null 呢？因为我们没有添加为 null 的节点，就是下边的代码的作用。
     * 所以这里是一样的，如果当前节点为null不处理就可以了。
     * cur 指针利用 next 不停的遍历当前层。
     *
     * 如果 cur 的孩子不为 null 就将它接到 tail 后边，然后更新tail。
     *
     * 当 cur 为 null 的时候，再利用 dummy 指针得到新的一层的开始节点。
     *
     * dummy 指针在链表中经常用到，他只是为了处理头结点的情况，它并不属于当前链表。
     *
     */
    public Node connect_pointer(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            Node tail = dummy;
            //遍历 cur 的当前层
            while (cur != null) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            //更新 cur 到下一层
            cur = dummy.next;
        }
        return root;
    }

    /**
     * 解法3：官方题解：使用已建立的next指针
     */
    Node last = null, nextStart = null;

    public Node connect_nextPointer(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }

}
