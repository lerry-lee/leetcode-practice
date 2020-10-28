# Leetcode 练习

## 腾讯推荐题目

#### 回溯算法

##### 子集

##### 括号生成
- 回溯

#### 排序与搜索

##### 二叉树的最近公共祖先
- 递归
- 哈希表存父节点

##### 二叉搜索树的最近公共祖先
- 一次遍历（要么p、q在root两侧，要么在root左子树，要么在root右子树）

##### 二叉树中的最大路径和
- 递归

##### 二叉树的最大深度
- DFS
- BFS

##### 二叉搜索树中的第k小的元素
- 中序遍历

##### 数组中的第K个最大元素
- 快排（每次排一半）
- 最大堆（优先队列）

##### 搜索旋转排序数组
- 二分查找

##### 排序链表
- 归并排序（递归分治）

#### 数学与数字

##### 2的幂
- 递归

##### 多数元素
- 哈希表
- 排序
- Boyer-Moore投票算法★

##### 只出现一次的数字
- 哈希表
- 异或

##### 回文数
- 反转

##### 整数反转
- 数学

#### 链表

##### 删除链表中的节点
- 往前赋值
- 与下一个节点交换

##### 相交链表
- 哈希表
- 双指针（浪漫）

##### 环形链表Ⅱ
- 哈希表
- 双指针（数学）

##### 环形链表
- 哈希表
- 双指针

##### 旋转链表
- 找到新的头结点

##### 合并K个升序链表
- 分治法

##### 合并两个有序链表
- 递归

##### 两数相加
- 简单模拟竖式

##### 反转链表
- 递归
- 迭代

#### 数组与字符串

##### 合并两个有序数组
- 双指针  
题目要求合并到数组1中，因此使用双指针从后往前遍历

##### 螺旋矩阵Ⅱ
- 按圈遍历

##### 螺旋矩阵
- 按圈遍历（注意边界条件！）

##### 除自身以外数组的乘积
- 左右乘积法
- 优化的左右乘积法

##### 反转字符串中的单词Ⅲ
- 简单遍历

##### 反转字符串
- 简单交换法

##### 字符串相乘
- 硬解
- 优化竖式？

##### 盛水最多的容器
- 双指针法

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

##### 1207.独一无二的出现次数
- 排序+哈希表
- 一次遍历+哈希表

##### 144.二叉树的前序遍历
- 递归
- 迭代

##### 1365.有多少小于当前数字的数字
- 暴力
- 快速排序
- 计数排序

##### 845.数组中的最长山脉
- 中心拓展
- 枚举山顶

##### 1024.视频拼接
- 动态规划
- 贪心

##### 243.回文链表
- 线性表
- 递归
- 双指针+反转一半

##### 763.划分字母区间
- 贪心+双指针

##### 925.长按键入

##### 143.重排链表
- 线性表
- 寻找链表中点 + 链表逆序 + 合并链表

##### 844.比较含退格的字符串
- 用栈
- 双指针（逆序遍历）

##### 19.删除链表的倒数第N个节点
- 预处理链表长度，两次遍历
- 用栈
- 双指针

##### 52.N皇后Ⅱ
- 回溯
- 回溯+位运算（未掌握）

##### 977.有序数组的平方
- 双指针（两头向中间，一次遍历，从后往前填充数组）

##### 116.填充每一个节点的下一个右侧节点指针
- 递归（存储层次遍历的结果）
- 迭代（双端队列）
- 迭代★（利用next指针，一次遍历，不用额外空间）

##### 1002.查找常用字符
- 暴力法

##### 24.两两交换链表中的节点
- 迭代
- 递归

##### 530.二叉搜索树的最小绝对差
- min(当前-左子树最右边节点，当前-右子树最左边节点）
- 中序遍历找相邻

##### 416.分割等和子集
- 递归
- 动态规划（01背包）

##### 75.颜色分类
- 快速排序
- 计数排序
- 利用快排的思想：循环不变量，三个区间

##### 18.四数之和
- 回溯
- 排序+双指针

##### 19.秋叶收藏集
- 动态规划

##### 701.二茬搜索中的插入操作
- 递归
- 迭代

##### 145.二叉树的后序遍历
- 迭代法（用栈）

##### 117.填充每个节点的下一个右侧节点
- 双端队列层次遍历+指针操作
- TODO：空间复杂度O(1)解法

##### 235.二叉搜索树的最近公共祖先
- 利用二叉搜索树的性质，简单递归
- 和二叉树的最近公共祖先解法相同

##### 113.路径总和2
- dfs回溯

##### 106.从中序与后续遍历序列构造二叉树
- 递归
- 后序遍历（后根遍历）数组可确定根节点，根据跟节点去查中序遍历（中根遍历）数组，可确定其左右子树

##### 501.二叉搜索树中的众数
- 遍历出来节点值list，然后在查找众数
- 中序遍历过程中，记录并查找众数

##### 617.合并二叉树
- 简单递归

##### 968.监控二叉树
- 三种状态+递归

##### 538.把二叉搜索树转换为累加树
- 反向中序遍历

##### 78.子集
- 简单递归

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