package _0033;/*
 * @lc app=leetcode.cn id=33 lang=java
 * tag: array
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    int[] nums; 
    int target;
    public int search(final int[] nums, final int target) {
        this.nums = nums;
        final int length = nums.length;
        this.target = target;
        int bound =0;
        if(length == 0){
            return -1;
        } 
        if(length == 1){
            bound =0;    
        }else{
            bound =searchIndex();
        }
        int leftResult = -1;
        int rightResult = -1;
        rightResult = searchTarget(bound + 1,nums.length-1);
        leftResult = searchTarget(0,bound);
        return Math.max(leftResult,rightResult);
    }
    public int searchIndex(){
        int left = 0;
        int right = nums.length-1;
        //if(right == 0 && nums[0]<= nums[1]) return 1;
        while(left<right){
            //System.out.println(mid);
            final int mid = (left + right) >>1;
            //System.out.println("mid:"+mid);
            if(nums[mid + 1] > nums[left]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        //System.out.println("bound:"+left);
        return left;
    }
    public int searchTarget(int start,int end){
        while(start <= end){
            final int mid = (start + end) >>1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}
// @lc code=end

