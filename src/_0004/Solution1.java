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
        double sum = dg(nums1,nums2,0,0,n) + dg(nums1,nums2,0,0,m);
        return sum/2.0;
    }
    public int dg(int[] num1,int[] num2,int start1,int start2,int k){
        int temp =k/2;
        if (start1>=num1.length) return num2[start2+k-1];
        if (start2>=num2.length) return num1[start1+k-1];

        if (k==1){
            return Math.min(num1[start1], num2[start2]);
        }
        int last1 = temp==0?start1:start1+temp-1;
        int last2 = temp==0?start2:start2+temp-1;
        //可扩展长度：numx的长度-start的长度
        int currLen1 = num1.length - start1;
        int currLen2 = num2.length - start2;

        int i;
        //int i = currLen1<temp?num1[num1.length-1]:num1[last1];
        if (currLen1<temp){
            i = num1[num1.length-1];
            temp = currLen1;
        }else{
            i = num1[last1];
        }
        int j ;
        //int j = currLen2<temp?num2[num2.length-1]:num2[last2];
        if (currLen2<temp){
            j = num2[num2.length-1];
            temp = currLen2;
        }else {
            j = num2[last2];
        }
        if (i>=j){
            start2 = start2+temp;
        }else {
            start1 = start1+temp;
        }
        return dg(num1,num2,start1,start2,k-temp);
    }
    public static void main(String[] args) {
            Solution1 solution = new Solution1();
            int[] arr1 = {1};
            int[] arr2 = {2,3,4,4,5};
            System.out.println(solution.findMedianSortedArrays(arr1,arr2));

    }
}
