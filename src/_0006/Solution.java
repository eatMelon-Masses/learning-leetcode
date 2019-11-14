package _0006;

import java.util.ArrayList;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/zigzag-conversion/
 * tag: string
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows<=1) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        int currRow = 0;
        boolean goingDown = false;

        for (char e :
                s.toCharArray()) {
            rows.get(currRow).append(e);
            if (currRow == 0 ||(currRow == numRows - 1)) {
                goingDown=!goingDown;
            }
            currRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            result.append(rows.get(i).toString());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING",3));
    }
}
