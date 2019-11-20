package _0189;/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/description/
 *
 * algorithms
 * Easy (39.32%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    78.6K
 * Total Submissions: 199.8K
 * Testcase Example:  '[1,2,3,4,5,6,7]\n3'
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释: 
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 
 * 说明:
 * 
 * 
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * 
 * 
 */

// @lc code=start
class Solution {
    /**public void rotate(int[] nums, int k) {
        int index=nums.length-1;
        if(nums.length<=1||k==0) return ;
        for(int i=1;i<=(nums.length-1)/k;i++){
           rotateOneTime(nums,k,index);
            
        }
        
    }
    public void rotateOneTime(int[] nums,int k,int index){
        int times = (index)/k;
        int temp = nums[index];
        for(int i=1;i<=times-1;i++){
            nums[index-(i-1)*k]=nums[index-i*k];
        }
        nums[index-times*k]=temp;
    }*/
        public void rotate(final int[] nums, final int k) {
             final int[] result = new int[nums.length];//根据nums数组长度生成和其一样长度的数组
            for (int i = 0; i < nums.length; i++)
            {
                result[(i + k) % nums.length] = nums[i];//这里用到了取余，也是这个方法的核心
            }
            for(int i=0;i<=nums.length-1;i++) nums[i]=result[i];
        }    



}
// @lc code=end

