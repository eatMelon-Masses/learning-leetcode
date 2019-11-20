package _0003;/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(final String s) {
        if (s.length()<=1){
            return s.length();
        }
        final int length = s.length();
        final char[] temp = s.toCharArray();
        final int[] dp = new int[temp.length];
        int max = init(temp, dp);

        for (int i = 2; i <= length - 1; i++) {
            for (int j = 0; j + i <= length - 1; j++) {
                //如何子串无重复字母,两边相等
                if (dp[j]==0&& isDiff(j,j+i-1,temp[j+i],temp)){
                    //存储相同长度的子串
                    if (i > max) {
                        max = i;
                    }
                    dp[j] = 0;
                    //如果子串有重复字母
                }else {
                    dp[j] = 1;
                }
            }
        }
        return max+1;
    }

    /**
     *  如果子串中有与 e相同的元素返归false
     * @param start
     * @param end
     * @param e
     * @param tempArray
     * @return
     */
    public static boolean isDiff(int start, final int end, final char e, final char[] tempArray) {
        for (;start<=end;start++) {
            if (tempArray[start] == e) {
                return false;
            }
        }
        return true;
    }

    //初始化长度为2的子串dp
    public static int init(final char[] temp, final int[] dp){
        int max = 0;
        for (int i = 0; i <= temp.length - 2; i++) {
            if(temp[i] == temp[i + 1]){
                dp[i] = 1;
            }else{
                dp[i] = 0;
                max=1;
            }
        }
        return max;
    }
}
// @lc code=end

