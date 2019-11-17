package _0017;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * tag: string
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        HashSet<String> result = new HashSet<>();
        dg(digits, 0, result, new StringBuilder());
        return new ArrayList<>(result);

    }

    public void dg(String d, int start, Set<String> set,StringBuilder sb) {
        if (d.length() == start) {
            if (!sb.toString().isEmpty())
            set.add(sb.toString());
            return;
        }
        int boardNum = d.charAt(start) - '2';

        int temp = boardNum * 3 + 97;
        if (boardNum>5) temp++;
        int end =3;
        if (boardNum==5||boardNum==7) end = 4;
        for (int i = 0; i < end; i++) {
            sb.append((char) (temp + i));
            dg(d,start+1,set,sb);
            sb.deleteCharAt(start);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(""));
    }
}
