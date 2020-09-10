package _0139;

import java.util.*;

public class Solution2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        HashSet<String> set = new HashSet<>(Arrays.asList("leet", "code"));
        List<String> result = solution2.wordBreak("leetcode", set);
        System.out.println(result);

    }
}
