package _0088;/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.78%)
 * Likes:    344
 * Dislikes: 0
 * Total Accepted:    84.3K
 * Total Submissions: 184.1K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    public void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
        if(nums2.length == 0) return;
        int p = m-1;
        int q = n-1;
        int curr = m+n-1;
        while(p >= 0 && q >=0){
            if(nums2[q] >= nums1[p]){
                nums1[curr--] = nums2[q--];
            }else{
                nums1[curr--] = nums1[p--];
            }
        }
        while(p >= 0){
            nums1[curr--] = nums1[p--];            
        }
        while(q >= 0){
             nums1[curr--] = nums2[q--];            
        }
    }
}
// @lc code=end

