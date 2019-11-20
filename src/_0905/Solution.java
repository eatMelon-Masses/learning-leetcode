package _0905;/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (67.80%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    25.3K
 * Total Submissions: 37.2K
 * Testcase Example:  '[3,1,2,4]'
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 
 * 你可以返回满足此条件的任何数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(final int[] A) {
        int l,h;
        l=0;
        h=A.length-1;
        while (l<h) {

            while (l < h) {

                if (A[l] % 2 == 0) {
                    l++;

                } else {
                    break;
                }
            };


            while (l<h) {
                if (A[h] % 2 != 0){
                h--;
                }else {
                    break;
                }

            };
            if (l<h){
                final int temp=A[l];
                A[l]=A[h];
                A[h]=temp;
                l++;
                h--;
            }

        }
       return A;
    }
}
// @lc code=end

