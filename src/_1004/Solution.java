package _1004;

/**
 *
 * @author zhouye
 * @date 2021/2/19
 *
 *
 * 1004. 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 

 */
public class Solution {
    public int longestOnes(int[] A, int K) {
        int result = 0;
        //当前最大连续1个数
        int len = 0;
        //当前窗口长度
        int cLen = 0;
        int left = 0;
        int right = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                K--;
            }

            while (left < right && K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }


            if (K >= 0) {
                len = Math.max(len,right - left + 1);

            }

        }
        return len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int result = solution.longestOnes(ints, 3);
        System.out.println(result);
    }
}
