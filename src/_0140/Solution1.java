package _0140;

import java.math.BigInteger;
import java.util.*;

/**
 * 运行超时
 */
public class Solution1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> memorandum = new HashMap<>();
        return word_Break(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    public List<String> word_Break(String s, Set<String> wordDict, int start, Map<String, List<String>> memorandum) {

        ArrayList<String> suffix = new ArrayList<>();
        if (start == s.length()) {
            suffix.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String temp = s.substring(start, end);
            if (wordDict.contains(temp)) {
                List<String> list;
                String key = s.substring(end);
                if (memorandum.containsKey(key)) {
                    list = memorandum.get(key);
                }else {
                    list = word_Break(s, wordDict, end, memorandum);
                }
                for (String e :
                        list) {
                    suffix.add(s.substring(start, end) + ("".equals(e) ? "" : " ") + e);

                }

            }
        }
        return suffix;
    }

    public static void main(String[] args) {
        BigInteger[] dp = new BigInteger[1];
        Solution solution = new Solution();
        List<String> results = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        System.out.println(results);
    }
}
