package _0658;/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 *
 * https://leetcode-cn.com/problems/find-k-closest-elements/description/
 *
 * algorithms
 * Medium (41.66%)
 * Likes:    44
 * Dislikes: 0
 * Total Accepted:    4.4K
 * Total Submissions: 10.5K
 * Testcase Example:  '[1,2,3,4,5]\n4\n3'
 *
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x
 * 的差值一样，优先选择数值较小的那个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * 
 * 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 10^4
 * 数组里的每个元素与 x 的绝对值不超过 10^4
 * 
 * 
 * 
 * 
 * 更新(2017/9/19):
 * 这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class Solution {
    int left;
    int right;
    int target;
    int[] arr;
    public List<Integer> findClosestElements(final int[] arr, final int k, final int x) {
        this.arr = arr;
        this.target = x;
        final int index = search();
        int count = 1;
        final List<Integer> result  = new ArrayList<Integer>();
        result.add(arr[index]);
        int left = index -1;
        int right = index + 1;
        while(count <arr.length && count < k){
            if(left>=0 && right < arr.length){
                int tempResult = 0;
                tempResult = Math.abs(arr[left] - target) <= Math.abs(arr[right]-target)? arr[left--]:arr[right++];
                result.add(tempResult);
                count ++;
            }else if(left>=0){
                result.add(arr[left--]);
                count++;
            }else if(right < arr.length){
                result.add(arr[right++]);
                count++;
            }
        }
        Collections.sort(result);
        return result;
    }
    public int search(){
        left = 0;
        right = arr.length -1;

        while(left + 1 < right){
            final int mid = (left + right) >> 1;
            if(arr[mid] == target){
            System.out.println(mid);
                return mid;
            }else if(arr[mid] > target){
                 right = mid;
            }else{
                left = mid;
            }
        }
        final int ld =Math.abs(arr[left] - target);
        final int rd = Math.abs(arr[right] - target);
        //System.out.println("left" +(ld <rd? left: right));
        return ld <rd? left: right;
    }
}
// @lc code=end

