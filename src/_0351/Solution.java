package _0351;

import java.sql.Struct;
import java.util.Arrays;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/android-unlock-patterns/
 * tag: dp
 */
public class Solution {
    private boolean[] dp= new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int ans = 0;
        for (; m <= n; m++) {
            ans+=dg(-1, m);
            Arrays.fill(dp, false);
        }
        return ans;
    }

    private boolean isValid(int i, int next) {
        if (dp[next]) {
            return false;
        }
        if (i == -1) {
            return true;
        }
        if ((i + next) % 2 == 1) {
            return true;
        }
        int mid = (i + next) >> 1;
        if (mid == 4) {
            return dp[4];
        }
        if (((i + next) & 1) == 1) {
            return true;
        }
        if ((i % 3 != next % 3) && (i / 3 != next / 3)) {
            return true;
        }
        return dp[mid];
    }

    private int dg(int last, int len) {
        if (len == 0) {
            return 1;
        }
        int sum = 0;
        for (int j = 0; j < 9; j++) {
            if (isValid(last, j)) {
                dp[j] = true;
                sum+=dg(j, len - 1);
                dp[j] = false;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPatterns(0,0));
    }
}
