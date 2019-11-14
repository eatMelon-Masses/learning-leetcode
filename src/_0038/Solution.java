package _0038;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/count-and-say/g
 * tag: string
 */
public class Solution {
    private HashMap<String, String> template = new HashMap<>(9);
    private String[] dp = new String[31];

    public Solution() {
        template.put("1", "11");
        template.put("11", "21");
        template.put("111", "31");
        template.put("2", "12");
        template.put("22", "22");
        template.put("222", "32");
        template.put("3", "13");
        template.put("33", "23");
        template.put("333", "33");
        Arrays.fill(dp, "");
    }

    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) return result;
        dp[2] = "11";
        int start = 1;
        for (int i = n; i > start; i--) {
            if (!dp[i].isEmpty()) {
                result = dp[i];
                start = i;
            }
        }


        for (int i = start; i < n; i++) {
            result = say(result, template);
        }
        dp[n] = result;
        return result;
    }

    private String say(String preStr, Map<String, String> template) {
        StringBuilder next = new StringBuilder();
        int count = 1;
        char pre = preStr.charAt(0);
        int len = preStr.length();
        for (int i = 0; i < len; i++) {
            char c = preStr.charAt(i);
            if (i > 0 && pre == c) {
                count++;
            }
            if (pre != c) {
                String temp = preStr.substring(i - count, i);
                next.append(template.get(temp));
                count = 1;

            }
            pre = c;
        }
        next.append(template.get(preStr.substring(len - count, len)));
        return next.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(30));
        System.out.println(solution.countAndSay(29));
    }
}
