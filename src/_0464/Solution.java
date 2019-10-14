package _0464;

import java.util.Arrays;

/**
 * url: https://leetcode-cn.com/problems/can-i-win/
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean[] dp = new boolean[maxChoosableInteger + 1];
        Arrays.fill(dp, true);
        return dfs(maxChoosableInteger,desiredTotal,0,0,dp);
    }
    public Boolean dfs(int counts,int total,int currCount,int currSum,boolean[] dp) {
        if (currCount > counts) {
            System.out.println("满了");
            return false;
        }
        boolean temp = false;
        if (currSum >= total) {
            System.out.println("满足条件");
            if ((currCount & 1) == 1) {
                System.out.println("赢了");
                temp = true;
            }
            return temp;
        }
        for (int i = 1; i <= counts; i++) {
            if (!temp && dp[i]) {
                //boolean[] arr = Arrays.copyOf(dp, dp.length);
                dp[i] = false;
                System.out.println(Arrays.toString(dp));
                temp = temp|dfs(counts,total,currCount+1,currSum+i,dp);
                dp[i] = true;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canIWin(5, 6
        ));
    }
}
