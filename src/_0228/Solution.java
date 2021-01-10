package _0228;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int[] temp = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            temp[i] = nums[i] - nums[i - 1];
        }
        int start = 0;
        int end = 0;
        ArrayList<String> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0] + "");
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 1) {
                end = i;
                if (i < temp.length-1){
                    continue;
                }
            }
            if (start == end) {
                result.add(nums[start]+"");
            }else {
                result.add(nums[start] + "->" + nums[end]);
            }

            start = i;
            end = i;
        }
        if (temp.length > 1 && temp[temp.length - 1] != 1) {
            result.add(nums[start]+"");
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String temp: solution.summaryRanges(new int[]{-2147483648,-2147483647,2147483647})
             ) {
            System.out.println(temp);
        }
    }
}
