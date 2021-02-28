# leetcode 练习

## 剑指Offer

##### 10.2.青蛙跳台阶问题

- 动态规划

##### 32.Ⅲ.从上到下打印二叉树Ⅲ

- 迭代

##### 50.第一个只出现一次的字符

- 两次遍历+计数数组

##### 64.求1到n的和

- 递归+逻辑运算符 <<==>> for循环+if条件判断

##### 58-2.左旋转字符串

##### 63.股票的最大利润

- 一次遍历
- 动态规划

##### 54.二叉搜索树的第k大节点

- 迭代
- 递归

##### 14-1.剪绳子

- 数学推导

##### 68-2.二叉树的最近公共祖先

- 哈希表
- 递归

##### 45.把数组排成最小的数

- 自定义排序

##### 42.连续子数组的最大和

- 一次遍历
- 分治法

##### 62.圆圈中最后剩下的数字

- 约瑟夫环问题
- 模拟循环单链表

##### 12.矩阵中的路径

- 回溯

##### 07.重建二叉树

- 递归

##### 53-2.0~n-1中缺失的数字

##### 68-1.二叉搜索树的最近公共祖先

- 哈希表
- 递归

##### 14-Ⅱ.剪绳子2

- 数学推导

##### 15.二进制中1的个数

- 右移逐位计算
- 每次消去最右边的1：n&(n-1)

##### 13.机器人的运动范围

- 巧算数位和+dfs
- bfs

##### 57-Ⅱ.和为s的连续正数序列

- 暴力
- 滑动窗口

##### 43.整数中1出现的次数

- 技巧型：从各位到最高位的1出现的次数的总和

##### 52.两个链表的第一个公共节点

- 哈希表
- 浪漫遍历

##### 24.反转链表

- 迭代：双指针
- 递归：
  - 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 newHead .
  - 此后，每次函数在返回的过程中，让当前结点的下一个结点的 next指针指向当前节点。
  - 同时让当前结点的 next指针指向 NULL，从而实现从链表尾部开始的局部反转
  - 当递归函数全部出栈后，链表反转完成。

## 力扣每日一题

#### 2021年2月

##### 896.单调队列

##### 395.至少有K个重复字符的最长子串

- 分治递归

##### 1178.猜字谜

- 二进制状态压缩

关键在于如何枚举判断一个二进制状态数字k的子集, 方法就是针对中的二进制为1的位开始进行减法

```java
    int sub=k;
    do{
        sub=(sub-1)&k;
    }while(sub!=k);
```

##### 867.转置矩阵

##### 832.翻转图像

- 双指针逆序+异或反转01

##### 1052.爱生气的书店老板

- 暴力

- 滑动窗口

##### 766.托普利茨矩阵

- 按对角线遍历

- 按行比较

- 比较元素和左上角/右下角相邻元素

##### 1438.绝对差不超过限制的最长连续子数组

- 滑动窗口+大小顶堆+延迟删除

- 滑动窗口+有序集合TreeMap

- 滑动窗口+单调队列

##### 697.数组的度

- 哈希表

##### 　225.用队列实现栈

－ 两个队列

##### 1004.最大连续1的个数3

- 滑动窗口

##### 995.K连续位的最小翻转次数

- 滑动窗口★

- 差分数组★

##### 566.重塑矩阵

##### 561.数组拆分1

##### 485.最大连续1的个数

##### 765.情侣牵手

- 并查集

##### 448.找到所有数组中消失的数字

- 原地修改(利用自身哈希)

##### 119.杨辉三角2

- 模拟

- 只用一个数组（每一行倒着计算）

- 数学公式

##### 703.数据流中的第K大元素

- 优先队列（小顶堆）

##### 567.字符串的排列

- 计数数组+滑动窗口

##### 992.K个不同整数的子数组

- 题意转换+滑动窗口

##### 978.最长湍流子数组

- 动态规划

- 滑动窗口

##### 665.非递减数列

##### 1423.可获得的最大点数

- 贪心

- 滑动窗口

##### 1208.尽可能使字符串相等

- 滑动窗口

##### 643.子数组最大平均数1

- 滑动窗口

##### 480.滑动窗口中位数

- 双优先队列（大顶堆、小顶堆）+延迟删除★

##### 424.替换后的最长重复字符

- 双指针（滑动窗口）

##### 888.公平的糖果棒交换

- 哈希表

#### 2021年1月

##### 839.相似字符串组

- 并查集

##### 778.水位上升的泳池中游泳

- 并查集
- Dijkstra算法★

##### 1319.连通网络的操作次数

- 并查集

##### 989.数组形式的整数加法

- 按位相加

##### 1631.最小体力消耗路径

- 回溯(超时)
- 并查集

##### 628.三个数的最大乘积

- 分情况讨论

##### 724.寻找数组的中心索引

- 一次遍历

##### 1584.连接所有点的最小费用

- 暴力最短路径
- prime？

##### 1579.保证图可完全遍历

- 并查集(2个)

##### 721.账户合并

- 并查集

##### 1232.缀点成线

- 斜率

##### 1128.等价多米诺骨牌对的数量

- 二元组表示+哈希表

##### 803.打砖块

- 并查集(逆序)

##### 947.移除最多的同行或同列石头

- 并查集(区分横纵坐标+节点个数不确定性)

##### 959.由斜杠划分区域

- 并查集

##### 684.冗余连接

- 并查集

##### 674.最长连续递增序列

- 贪心
- 动态规划

##### 207课程表/210课程表2

- 拓扑排序

##### 1202.交换字符串中的元素

- 并查集+分组排序(优先队列)

##### 1018.可被5整除的二进制前缀

- 模拟  
  1.由于只需要知道每个二进制数是否可以被5整除，因此在计算过程中只需要保留余数即可  
  2.使用移位运算代替乘法效率更高

##### 228.汇总区间

##### 189.旋转数组

- 辅助数组
- 翻转数组
- 原地交换

##### 123.买卖股票的最佳时机3

- 动态规划

##### 547.省份数量

- 并查集
- dfs

##### 399.除法求值

- 并查集★

##### 830.较大分组的位置

##### 509.斐波那契数

##### 86.分隔链表

- 模拟

##### 239.滑动窗口最大值

- 优先队列
- 双向队列

##### 605.种花问题

- 回溯（超时）
- 贪心

#### 2020年12月

##### 455.分发饼干

- 排序

##### 1046.最后一块石头的重量

- 大顶堆

##### 205.同构字符串

- 哈希表

##### 316.去除重复字母

- 贪心+单调栈

##### 746.使用最小花费爬楼梯

- 动态规划

##### 103.二叉树的锯齿形层序遍历

- 层次遍历的改编版：递归或迭代

##### 387.字符串中的第一个唯一字符

- 计数数组/哈希表+2次遍历

##### 48.旋转图像

- 找左边关系
- 上下翻转+对角线翻转

##### 842.将数组拆分成斐波那契序列

- 回溯+剪枝

##### 860.柠檬水找零

- 简单模拟

##### 217.存在重复元素

- 排序
- 哈希表

##### 714.买卖股票的最佳时机含手续费

- dp

##### 389.找不同

- 计数

##### 290.单词规律

- 哈希表

##### 738.单调递增的数字

- 数学

##### 49.字母异位词分组

- 排序+哈希

##### 376.摆动序列

- 动态规划

##### 62.不同路径

- dp

##### 861.翻转矩阵后的得分

- 贪心

##### 118.杨辉三角

##### 621.任务调度器

- 桶思想

##### 659.分割数组为连续子序列

- 贪心

##### 204.计算质数

- 暴力
- 埃氏筛
- 欧拉晒★

##### 34.在排序数组中查找元素的第一个和最后一个位置

- 二分查找+中心扩展

#### 2020年11月

##### 767.重构字符串

- 基于计数的排序

##### 976.三角形的最大周长

- 排序+三边关系

##### 493.翻转对

- 归并排序

##### 454.四数相加2

- 分组+哈希表

##### 164.最大间距

- 排序

##### 1370.上升下降字符串

- 计数/桶排序

##### 222.完全二叉树的节点个数

- 二分查找+位运算

##### 452.用最少数量的箭引爆气球

- 合并区间取交集
- 排序+贪心

##### 242.有效的字母异位词

- 哈希表
- 计数数组

##### 148.排序链表

- 递归分治+归并排序
- 自底向上迭代的归并排序

##### 147.对链表进行插入排序

- 链表的插入、删除、遍历等操作

##### 1221.分割平衡字符串

- 用栈一次遍历

##### 283.移动零

- 双指针

##### 134.加油站

- 暴力
- 数学推导，一次遍历

##### 1332.删除回文子序列

##### 1030.距离顺序排列矩阵单元格

- bfs
- 桶排序

##### 406.根据身高重建队列

- 排序

##### 402.移掉K位数字

- 贪心+单调栈

##### 1122.数组的相对排序

- 简单暴力
- 计数排序
- 自定义排序

##### 328.奇偶链表

- 双指针

##### 922.按奇偶排序数组2

- 双指针

##### 279.完全平方数

- dp

##### 31.下一个排列

- 从后往前遍历...

##### 973.最接近原点的K个点

- 排序
- 最小堆（优先队列实现）

##### 122.买卖股票的最佳时机Ⅱ

- 动态规划

##### 1356.根据数字二进制下1的数目排序

- 排序，重写Comparator

##### 127.单词接龙

- BFS

##### 941.有效的山脉数组

- 一次遍历

##### 349.两个数组的交集

- 哈希表

##### 140.单词拆分Ⅱ

- 记忆化递归？

#### 2020年10月及以前

##### 381.O(1)时间插入、删除和获取随机元素

- 哈希表

##### 463.岛屿的周长

- 遍历：判断每一格陆地四周的情况

##### 129.求根到叶子节点数字之和

- dfs

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

- 小顶堆 Java的优先队列PriorityQueue对元素采用的是堆排序，头是按指定排序方式的最小元素。堆排序只能保证根是最大（最小），整个堆并不是有序的。 常用方法： peek()//返回队首元素 poll()
  //返回队首元素，队首元素出队列 add()//添加元素 size()//返回队列元素个数 isEmpty()//判断队列是否为空，为空返回true,不空返回false

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

## 腾讯推荐题目

#### 动态规划

##### 子集

- 回溯
- 动态规划

##### 不同路径

- 回溯（超时）
- 动态规划

##### 买卖股票的最佳时机Ⅱ

- 动态规划

##### 买卖股票的最佳时机

- 一次遍历
- 动态规划

##### 最大子序和

- 一次遍历
- 递归分治

##### 爬楼梯

- dp

#### 回溯算法

##### 格雷编码

- 类似动态规划，n位2进制数的结果由n-1推导而来

##### 全排列

- 回溯（交换）
- 回溯（boolean记录）

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
  
## 字节跳动推荐题目

#### 字符串

#### 数组与排序

#### 动态或贪心

#### 链表与树