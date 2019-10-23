package _0801;

import java.util.Arrays;

/**
 * @author yiezi
 * url:https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/
 * tag:dp
 */
public class Solution {
    public int minSwap(int[] A, int[] B) {
        // 动态规划，cost[0]代表当前位不换时最小交换次数
        //          cost[1]代表当前位交换时最小交换次数
        int[] cost = new int[]{0, 1};
        for (int i = 1; i < A.length; i++) {
            //如果当前位和上一位递增
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                //当前位交不交换都行
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    int pre = cost[0];
                    cost[0] = Math.min(cost[0], cost[1]);
                    cost[1] = Math.min(pre, cost[1]) + 1;
                //当前位置如果需要交换，那么上一位也需要交换
                } else {
                    cost[1] +=1;
                }
            } else {
                int pre = cost[1];
                cost[1] = cost[0]+1;
                cost[0] = pre;
            }
        }
        return Math.min(cost[0], cost[1]);
    }
    public static void main(String[] args) {
            Solution solution = new Solution();

            System.out.println(solution.minSwap(new int[]{3,4,7},new int[]{6,7,8}));
        }
}
