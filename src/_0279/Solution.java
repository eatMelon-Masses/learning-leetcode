package _0279;/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode-cn.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (51.17%)
 * Likes:    235
 * Dislikes: 0
 * Total Accepted:    25.9K
 * Total Submissions: 50.6K
 * Testcase Example:  '12'
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
 * 示例 1:
 * 
 * 输入: n = 12
 * 输出: 3 
 * 解释: 12 = 4 + 4 + 4.
 * 
 * 示例 2:
 * 
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * 
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// @lc code=start
class Solution {
    public int numSquares(final int n) {
      if (n == 1) return 1;
      int sum = 0;
      final LinkedList<Integer> queue = new LinkedList<Integer>();
      final Set<Integer> set = new HashSet<Integer>();
      queue.add(n);
      while (!queue.isEmpty()) {
        final int size = queue.size();
        for (int i = 0; i < size; i++) {
          final int currNum = queue.removeFirst();
          if (currNum == 0) return sum;
          for (int j = 1; j * j <= currNum; j++) {
            final int temp = j * j;
            final int nextNum=currNum-temp;
            if (!set.contains(nextNum)) {
              queue.add(nextNum);
              set.add(nextNum);
            }
          }
        }
        sum++;
      }
      return sum;
    }
  }
// @lc code=end

