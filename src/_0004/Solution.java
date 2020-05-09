package _0004;/*
 * @lc app=leetcode.cn id=4 lang=java
 * tag: array
 * [4] 寻找两个有序数组的中位数
 */


import java.util.Arrays;

// @lc code=start
class Solution {
    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
        final int left = nums1.length;
        final int right = nums2.length;
        final int[] temp = merge(nums1,nums2);
        double result = 0;
        if((temp.length & 1) ==1){
            final int mid = temp.length >> 1;
            result = temp[mid];
        }else{
            final int mid = temp.length >> 1;
            //System.out.println("mid"+mid+" result"+Double.valueOf((temp[mid] + temp[mid-1]+0.0)/2));
            result =(temp[mid] + temp[mid-1]+0.0)/2 ;
        }
        return result;
    }
    public int[] merge(final int[] nums1, final int[] nums2){
        final int left = nums1.length;
        final int right = nums2.length;
        final int[] result = new int[left+right];
        if(left == 0){
            return nums2;
        }
        if(right == 0){
            return nums1;
        }
        int index = 0;
        int p = 0;
        int q = 0;
        while(p<left && q<right){
            if(nums1[p]<=nums2[q]){
                result[index++]=nums1[p++];
            }else{
                result[index++]=nums2[q++];
            }
        }
        if(p<left){
            for(int i = p;i<left;i++) result[index++]=nums1[p++];
        }
        if(q<right){
            for(int j = q;j<right;j++) result[index++] = nums2[q++];         
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
// @lc code=end

