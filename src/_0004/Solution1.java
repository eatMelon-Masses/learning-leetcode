package _0004;
/*
 * @lc app=leetcode.cn id=4 lang=java
 * tag: array
 * [4] 寻找两个有序数组的中位数
 */
public class Solution1 {
    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
        int len = nums1.length+nums2.length;
        int k =0;
        if ((len&1)==1){

        }
        return dg(nums1,nums2,);
    }
    public int dg(int[] num1,int[] num2,int start1,int start2,int k){
        int temp =k/2-1;
        int last1 = num1.length-1-start1;
        int last2 = num2.length-1-start2;
        if (last1<0) return num2[temp];
        if (last2<0) return num1[temp];
        int i = last1<temp?num1[last1]:num1[temp];
        int j = last2<temp?num2[last2]:num2[temp];
        if (k==1){
            return Math.min(num1[start1], num2[start2]);
        }
        if (i>=j){
            start2 = start2+temp;
        }else {
            start1 = start1+temp;
        }
        return dg(num1,num2,start1,start2,k-k/2)
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println();
    }
}
