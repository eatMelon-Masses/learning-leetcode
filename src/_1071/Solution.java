package _1071;
/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * tag: string
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String temp = str1 + str2;
        if (str1.isEmpty() | str2.isEmpty() | !(temp).equals((str2 + str1))) {
            return "";
        }
        return temp.substring(0,dg(str1.length(),str2.length()));
    }

    public int dg(int a, int b) {
        int temp = a % b;
        if (temp == 0) {
            return b;
        } else {
            return dg(b, temp);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("","1"));
    }
}
