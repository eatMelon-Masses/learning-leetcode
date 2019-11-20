package _0169;/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (60.61%)
 * Likes:    361
 * Dislikes: 0
 * Total Accepted:    85.1K
 * Total Submissions: 140.4K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int majorityElement(final int[] nums) {
        final int length = nums.length;
        if(length<=2){
            return nums[0];
        }
        //目前出现次数最多的元素值
        int e=0;
        //目前出现次数最多元素出现次数
        int count=0;
        final Map<Integer,Integer> countMap = new HashMap<>();
        for(int i = 0;i<=nums.length-1;i++){
            final int currentE = nums[i];
            //当前元素对应的统计次数
            int currentCount = 0;
            //如果当前map中有该元素统计
            if(countMap.containsKey(currentE)){
                currentCount =countMap.get(currentE)+1;
                countMap.put(currentE,currentCount);                
            }else{
                currentCount =1;
                countMap.put(currentE,1);
            }
            //更新全局统计
            if(currentCount>count){
                count =currentCount;
                e = currentE;
            }
        }
        return e;
    }
}
// @lc code=end

