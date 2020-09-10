package _0139;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *  dp[i]为字符串s在前i位可以被空格拆分成多个字典单词
 */
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dic = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j,i);
                if (dic.contains(temp) && dp[j]){
                    dp[i] = true ;

                }
            }
        }
        return dp[s.length()];
    }
/*    public boolean dg(String s, int curr,HashSet<String> dic){
        if (curr >= s.length()) return true;
        boolean result = false;
        int start =curr;
        System.out.println(start);
        for (int i = start+1; i <= s.length(); i++) {
            String temp = s.substring(start,i);
            if (dic.contains(temp) ) {
                result = result|| dg(s, i, dic);
            }
            if (result) break;
        }
        return result;
    }*/
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //boolean result = solution1.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa"));
        boolean result = solution1.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(result);

    }
}
