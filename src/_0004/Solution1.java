package _0004;
/*
 * @lc app=leetcode.cn id=4 lang=java
 * tag: array
 * [4] 寻找两个有序数组的中位数
 */
public class Solution1 {
    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
        int len = nums1.length + nums2.length;
        //奇数和偶数合并求解，
        int m = (len+1)/2;
        int n = (len+2)/2;
        int sum = dg(nums1,nums2,0,0,n) + dg(nums1,nums2,0,0,m);
        return sum/2;
    }
    public int dg(int[] num1,int[] num2,int start1,int start2,int k){
        int temp =k/2;
        int last1 = start1+temp-1;
        int last2 = start2+temp-1;
        if (last1 >= num1.length) return num2[num1.length-1];
        if (last2 >= num2.length) return num1[num2.length-1];
        int i = num1[last1];
        int j = num2[last2];
        if (k==1){
            return Math.min(num1[start1], num2[start2]);
        }
        if (i>=j){
            start2 = start2+temp;
        }else {
            start1 = start1+temp;
        }
        return dg(num1,num2,start1,start2,k-k/2);
    }
    public static void main(String[] args) {
            Solution1 solution = new Solution1();
            int[] arr1 = {1, 3};
            int[] arr2 = {1, 2, 3, 4};
            System.out.println(solution.findMedianSortedArrays(arr1,arr2));

    }
}
