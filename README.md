# 刷题笔记

### 剑指 offer 第二版
offer16 快速幂

offer44 边界条件很多

[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)  
基础：字符串的比较  
解法：  
巧解，自定义排序

[剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)  
解法：  
动态规划

[剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/)  
基础：string 的遍历，map 的遍历  
解法:
1. LinkedHashMap
2. 双 array


[剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)  
解法：   
归并排序  
注意：mergeArrays 时数逆序对数量时规则，遇到相同数字取哪个。

[剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)  
解法：   
双指针遍历两个列表，遍历两遍(目的是对齐)，找到第一个相同的结点。

[剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)  
解法：  
两次二分查找。

[剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)  
解法：  
二分查找，但是要判断好二分查找的终止条件。

[剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)  
解法：  
中序遍历，注意遍历方向和剪枝