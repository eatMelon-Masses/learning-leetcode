package _0139;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * url: https://leetcode-cn.com/problems/word-break/
 * dp
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dg(s, new HashSet<String>(wordDict), 0,dp);
    }
    public boolean dg(String s,HashSet wd,int start,Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start+1; end <= s.length(); end++) {
            if (wd.contains(s.substring(start, end)) && dg(s, wd, end, dp)) {
                return dp[start] = true;

            }
        }
        return dp[start]=false;
    }





    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wd = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        System.out.println(solution.wordBreak(s, wd));
    }
}
