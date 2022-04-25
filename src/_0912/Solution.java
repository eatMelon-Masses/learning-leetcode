package _0912;

import java.util.Arrays;

class Solution {
    //希尔排序
    public int[] sortArray(int[] nums) {
        int dis = nums.length / 2 + 1;
        for (; dis > 0; dis--) {
            sort(nums,1);

        }
       return nums;
    }
    public void sort(int[] nums,int dis){
        for(int i = 1;i * dis <nums.length;i++){
            int idx = i * dis;
            int n = nums[idx];
            for(int j =i-1;j >=0;j--){
                int target = j * dis;
                int insert = (j+1) * dis;
                if(n < nums[target]){
                    nums[insert] = nums[target];
                    if(target == 0) nums[target] = n;
                }else{
                    nums[insert] = n;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sort(new int[]{3,2,5},1);
    }
}