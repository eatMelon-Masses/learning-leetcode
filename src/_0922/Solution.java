package _0922;/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/description/
 *
 * algorithms
 * Easy (65.81%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    19.1K
 * Total Submissions: 29K
 * Testcase Example:  '[4,2,5,7]'
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 
 * 你可以返回任何满足上述条件的数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(final int[] A) {
        final int[] B = new int[A.length];
        final int lastIndex =A.length-1;
        int p = 0;
        int q = 1;
        for(int i =0;i<=lastIndex;i++){
            if((A[i]&1)!=1){
                B[p]=A[i];
                p=p+2;
            }else{
                B[q] = A[i];
                q=q+2;
            }
        }
        return B;
    }
}
// @lc code=end

