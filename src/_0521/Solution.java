package _0521;
/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 * tag: string
 */
class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength("abaa","aba"));
    }
}