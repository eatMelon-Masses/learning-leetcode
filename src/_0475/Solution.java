package _0475;/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Easy (28.46%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 18.1K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * 
 * 说明:
 * 
 * 
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 
 * 
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int findRadius(final int[] houses, int[] heaters) {
        if(heaters.length ==1){
            final int[] temp = new int[2];
            Arrays.fill(temp,heaters[0]);
            heaters = temp;
        }
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int max =0;
        for(int i = 0;i<houses.length;i++){
            final int left = houses[i]-heaters[search(heaters,houses[i])];
            //System.out.println("left"+search(heaters,houses[i]));
            final int right =  heaters[search(heaters,houses[i])+1]-houses[i];
            //System.out.println(left+","+right);
            max=Math.max(max,Math.min(Math.abs(left),Math.abs(right)));
        }
        return max;
    }
    public int search(final int[] arr, final int target){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while(left+1<right){
            mid =left+(right-left)/2;
            if(arr[mid]<target){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

