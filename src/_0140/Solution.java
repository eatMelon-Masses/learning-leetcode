package _0140;

import java.util.*;

public class Solution  {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> result = new HashSet<>();
        dg(s, 0, new ArrayList<>(), new HashSet<>(wordDict), result);

        return new ArrayList<>(result);
    }
    public void dg(String s, int start, List<String> curr, HashSet<String> dic, Set<String> result){
        if (start == s.length()) {
            result.add(String.join(" ", curr));
        }
        for (int i = start + 1; i < s.length() + 1; i++) {
            String temp = s.substring(start, i);
            if (dic.contains(temp)) {
                curr.add(temp);
                dg(s, i, curr, dic, result);
                curr.remove(temp);
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> results = solution.wordBreak("aaaaaa", Arrays.asList("aaaa", "aa", "a"));
        System.out.println(results);
    }
}
