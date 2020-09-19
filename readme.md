# Leetcode 练习

## 腾讯推荐题目

#### 数组与字符串

##### 删除排序数组中的重复项
- 双指针法

##### 有效的括号
- 栈

##### 三数之和/最接近的三数之和
- 转化为求两数之和  
排序+头尾指针

##### 最长公共前缀
- 简单遍历

##### 两数之和
- 暴力法
- 哈希表法

##### 寻找两个正序数组的中位数
时间复杂度要求O(log(m+n))
- 将该题转化为寻找两个正序数组的第k个数
```
 * tips：两个数组的元素个数之和为奇数时，中位数只有1个；为偶数时，中位数为两个数的平均数
 *      可以分情况讨论，也可以统一为求第(n1+n2+1)/2个数和第(n1+n2)/2+1个数的平均数
 * 如何找第K个数？
 *  首先遍历数组1和数组2分别需要两个指针start1和start2
 *      1）将K/2，数组1和数组2分别找第K/2个数（通过下标访问时需要-1，因为数组下标从0开始）
 *      2）比较两个数的大小（假设分别num1和num2），较小的那个数（假设在数组1中）
 *          那么数组1中的num1之前的数都不会是第k个数（因为数组正序，这部分数都是小于第k个数的）
 *      3）将数组1的num1之前的数（包括num1）丢弃，从num1后开始继续找
 *          此时start1更新，指向num1后一个数的下标
 *          此时k减去丢弃的个数（找第（k-丢弃数）个数字）
 *      4）如果k=1时，那么直接返回数组1和数组2中较小的数即可
 *  注意：下标越界情况、某个数组已经丢弃完的情况
```

##### 最长的回文子串
- 中心扩展法
- 动态规划

## 剑指Offer

##### 24.反转链表
- 迭代：双指针
- 递归：
    - 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 newHead .
    - 此后，每次函数在返回的过程中，让当前结点的下一个结点的 next指针指向当前节点。
    - 同时让当前结点的 next指针指向 NULL，从而实现从链表尾部开始的局部反转
    - 当递归函数全部出栈后，链表反转完成。

## 力扣每日一题

##### 404.左叶子之和
- 简单递归

##### 47.全排列Ⅱ
- 递归+swap交换法
- 递归+visited[]标记法  
tips:避免重复的方法  
1）使用hashset记录打头的元素，遇到重复即跳过  
2）标记法可以使用一条判断语句
```
if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
```

##### 94.二叉树的中序遍历
- 递归
- 迭代

##### 79.单词搜索
- 回溯+剪枝

##### 637.二叉树的层平均值
- 层次遍历+计算平均值
    - dfs用递归
    - bfs迭代（双端队列）

##### 216.组合总和3

##### 40.组合总和2
- 排序+回溯+剪枝

##### 39.组合总和
- 回溯+剪枝

##### 347.前K个高频元素
- 小顶堆
Java的优先队列PriorityQueue对元素采用的是堆排序，头是按指定排序方式的最小元素。堆排序只能保证根是最大（最小），整个堆并不是有序的。
常用方法：
peek()//返回队首元素
poll()//返回队首元素，队首元素出队列
add()//添加元素
size()//返回队列元素个数
isEmpty()//判断队列是否为空，为空返回true,不空返回false

##### 696.计算二进制子串
- 找规律

##### 337.打家劫舍Ⅲ
- 暴力递归
- hashmap缓存，减少重复计算
- 动态规划

##### 95.不同的二叉搜索树Ⅱ
- 思路1：递归  
利用二叉搜索树的性质，左子树的节点的值小于根节点，右子树大于根节点

##### 207.课程表
拓扑排序，入度表，广度优先遍历

##### 08.11.硬币
 * 思路1：动态规划
 * 1.状态定义：
 * （1）coins={1,5,10,25}表示硬币币值数组
 * （2）dp[i]表示面额为i时的不同的硬币币值表示个数
 *      ①那么dp[i]+=dp[i-coin]，表示面额为i的表示个数加等于面额为i-coin的表示个数
 *      ②例如：dp[10]表示面额为10时的表示个数，结果为dp[10]+dp[10-10]+dp[10-5]+dp[10-1]，其中dp[10]为0，dp[0]为1表示用一张币值和面额相同的可以表示；dp[5]和dp[9]由之前的值得到
 * 2.状态转移：
 *      dp[i]+=dp[i-coin],coin∈coins
 * 3.初始化：
 *      dp[0]=1表示面额和币值相同时可以用一枚币值等于面额的硬币表示，此时表示个数为1 
 * Tips：先升序遍历币值可解决重复算数问题

##### 309.买卖股票的最佳时机含冷冻期
- 思路1：动态规划
     * 1.状态定义：
     * dp[i][j]表示第i天状态为j时的最大收益，j的值为{0:不持股,1:持股,2:冷冻期}
     * 2.状态转移：
     * （1）不持股
     *      ①昨天不持股-->今天无操作，仍然不持股；
     *      ②昨天持股-->今天卖出，状态变为不持股；
     * （2）持股
     *      ①昨天持股-->今天无操作，仍然持股；
     *      ②昨天是冷冻期-->今天买入，状态变为持股；
     * （3）冷冻期
     *      持股后卖出，第二天即为冷冻期。因此冷冻期只能由昨天的不持股状态转移得到
     * 3.初始化：
     * （1）dp[0][0]=0，表示第1天不持股的收益为0
     * （2）dp[0][1]=-prices[0]，表示第1天持股的收益为-prices[0]，相当于买入第一天的股票
     * （3）dp[0][2]=0，第一天冷冻期的收益为0，其实第一天也不可能是冷冻期，但初始化为0

- 思路2：动态规划+空间优化  
由于思路1的状态转移只用到了前一天的状态，因此可以用三个变量存储前一天的状态，使空间复杂度降为O(1)

##### 17.13.恢复空格
- 思路1：动态规划（易理解）  
- 思路2：字典树/前缀树（不会）

##### 1008.先序遍历构造二叉树  
思路有3：  
（1）找出中序遍历，然后先序+中序遍历可确定一个二叉树  
（2）用栈  
（3）直接插入

##### 105.从前序与中序遍历序列中构造二叉树  
- 思路1：递归法
 1. 从【先序遍历数组】找root根节点（第一个节点）
 2. 在【中序遍历数组】中找到root根节点对应的下标，  
 (1) 将根节点左侧的数组和其长度拿出来（左子树的中序遍历数组），右侧的数组及其长度拿出来（右子树的中序遍历数组）  
 (2) 根据【中序遍历左右子树数组】的长度可以划分出【先序遍历数组】的左右子树的子数组
 3. 然后递归求解  
 (1) recursive(先序遍历的左子树数组，中序遍历的左子树数组)  
 (2) recursive(先序遍历的左子树数组，中序遍历的左子树数组)
 4. 重复123步骤，直到数组中只有一个元素，直接返回该元素的节点
 
##### 44.通配符问题
- 思路1：贪心算法

##### 898.子数组按位异或操作
- 思路1：暴力法+简单优化（就通过了...）

##### 17.06.数字2出现的次数
- 思路：数位法，从低位到高位，计算每一位的个数，然后加起来
     * 每一位计算时，需要判断，该位上的数字和2的关系，即小于2？等于2？大于2，三种情况的计算方式不同
     * 每次计算时，依赖于该位前的高位上的数、该位上的数、该位后的低位上的数，三部分共同决定

## 字节跳动推荐题目
#### 字符串
#### 数组与排序
#### 动态或贪心
#### 链表与树