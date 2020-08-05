# Leetcode 练习
### 字节跳动推荐题目
##### 字符串
##### 数组与排序
##### 动态或贪心
##### 链表与树

### 力扣每日一题

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
