package _0008;
/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * tag: string
 */
public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        boolean sign;
        char fl = str.charAt(0);
        if (isNumber(fl)) {
            sign = true;
        }else if ( fl == '-') {
            sign = false;
        } else if (fl == '+') {
            sign = true;
        } else {
            return 0;
        }
        if (str.charAt(0) < '0' && str.length() > 1 && !isNumber(str.charAt(1))) {
            return 0;
        }
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (char c :
                str.toCharArray()) {
            if (isNumber(c)) {
                sb.append(c);
            }else{
                count++;
            }

            if (sb.length() == 0 && (c == '+' || c == '-')) {
                count--;
            }
            if (count>0) break;
        }

        double temp = sb.toString().isEmpty() ? 0 : Double.parseDouble(sb.toString());
        temp = sign ? temp : -temp;
        return (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, temp));
    }

    public boolean isNumber(char a) {
        if (a=='.') return true;
        return a >= '0' && a <= '9';
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
         System.out.println(solution.myAtoi("0-1"));
    }
}
