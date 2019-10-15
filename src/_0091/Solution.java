package _0091;

import java.util.Arrays;

public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        if(s.charAt(0) =='0') return 0;
        int[] dp = new int[2];
        Arrays.fill(dp, 1);
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            int pp = s.charAt(i-1)-'0';
            int qq = s.charAt(i)-'0';
            int temp = dp[1];
            if (qq == 0 && (pp == 1 | pp == 2)) {
                dp[1] = dp[0];
            } else if (qq == 0) {
                return 0;
            }else if (pp == 1) {
                dp[1] = dp[1] + dp[0];
            } else if (pp == 2 && (0<=qq && qq <= 6)) {
                dp[1] = dp[1] + dp[0];
            }
            dp[0] = temp;

        }
        return dp[1];
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("27"));
        //System.out.println((0 <= -2 && -2<=6));
    }




}
