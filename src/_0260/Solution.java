package _0260;/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 *
 * https://leetcode-cn.com/problems/single-number-iii/description/
 *
 * algorithms
 * Medium (67.68%)
 * Likes:    141
 * Dislikes: 0
 * Total Accepted:    10.7K
 * Total Submissions: 15.9K
 * Testcase Example:  '[1,2,1,3,2,5]'
 *
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 
 * 示例 :
 * 
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 
 * 注意：
 * 
 * 
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] singleNumber(final int[] nums) {
        if(nums.length < 3) return nums;
        int temp=0;
        for(int i = 0;i<nums.length;i++){
            temp = temp ^ nums[i];
        }
        final int index = temp &(-temp);
        final int[] res = new int[2];
        
        for(final int e:nums){
            if((e & index) ==0){
                res[0] = res[0]^e;
            }else{
                res[1] = res[1]^e;
            }
        }
        //System.out.println(Integer.toBinaryString(3));
        //System.out.println(Integer.toBinaryString(~3)+1);
        return res;
    }
}
// @lc code=end

