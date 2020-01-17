package _0004;
/*
 * @lc app=leetcode.cn id=4 lang=java
 * tag: array
 * [4] 寻找两个有序数组的中位数
 */
public class Solution1 {
    public double findMedianSortedArrays(final int[] nums1, final int[] nums2) {
        int len = nums1.length + nums2.length;

        return dg(nums1,nums2,0,0,len/2);
    }
    public int dg(int[] num1,int[] num2,int start1,int start2,int k){
        int temp =k/2;
        int last1 = num1.length-start1;
        int last2 = num2.length-start2;
        if (last1<=0) return num2[temp];
        if (last2<=0) return num1[temp];
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
        return dg(num1,num2,start1,start2,k-k/2);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Solution1 solution = new Solution1();
            int[] arr1 = {1, 2};
            int[] arr2 = {1, 2, 3, 4};
            System.out.println(solution.findMedianSortedArrays(arr1,arr2));
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

    }
}
