package _0019;

/**
 * dp[i][0] 第j种状态下，长度为i的字符串合规需要变换多少次
 */
public class Solution {
    public int minimumOperations(String leaves) {
        int len = leaves.length();
        int[] dp = new int[len];
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp[0] = isYellow(leaves.charAt(0));
        //dp1[0] = isYellow(leaves.charAt(0));
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1]+isYellow(leaves.charAt(i));
        }
        dp1[0] = dp[0];
        //dp1[1] = dp[0] + isRed(leaves.charAt(1));
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.min(dp[i-1],dp1[i-1]) + isRed(leaves.charAt(i));
        }
        dp2[1] = dp1[1];
        //dp2[2] = dp1[1] = isYellow(leaves.charAt(2));
        for (int i = 2; i < len; i++) {
            dp2[i] = Math.min(dp1[i - 1], dp2[i - 1]) + isYellow(leaves.charAt(i));
        }
        return dp2[leaves.length() - 1];
    }
    public int isYellow(char e){
        if (e == 'y') {
            return 1;
        }else {
            return 0;
        }
    }
    public int isRed(char e){
        if (e == 'r'){
            return 1;
        }else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations("ryryryyryyryryryryryr"));
    }
}
