package _0368;

import java.util.*;

/**
 * url: https://leetcode-cn.com/problems/largest-divisible-subset/
 * dp
 * 思路：i<j<k  如果j%i=0 && k%j==0 则 i,j,k 为满足条件子序列
 * 原题类似：求最长升序子序列
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Queue<Integer>[] dp = new LinkedList[len];
        for (int i = 0; i < len; i++) {
            dp[i] = new LinkedList<>();
            dp[i].add(nums[i]);
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]  % nums[j] == 0) {
                    if (dp[i].size() < dp[j].size() + 1) {
                        dp[i] = new LinkedList<>();
                        dp[i].addAll(dp[j]);
                        dp[i].add(nums[i]);
                    }
                }
            }
        }
        int max = 0;
        for (Queue e:dp) {
            max = max > e.size() ? max : e.size();
        }
        List<Integer> res = new ArrayList();
        for(Queue e:dp){
            if (e.size() == max) {
                res.addAll(e);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestDivisibleSubset(new int[]{}));
    }
}
